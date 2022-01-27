package ru.job4j.dream.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.job4j.dream.service.Path;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/upload.jsp");
//        dispatcher.forward(req, resp);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> items = upload.parseRequest(req);
            File folder = new File(Path.candidatePic());
            if (!folder.exists()) {
                folder.mkdir();
            }
            for (FileItem item : items) {
                System.out.println(item.toString());
                if (!item.isFormField()) {
                    File file = new File(folder + File.separator + req.getParameter("id") + ".png");
                    try (FileOutputStream out = new FileOutputStream(file)) {
                        out.write(item.getInputStream().readAllBytes());
                    }
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
//        doGet(req, resp);
    }
}