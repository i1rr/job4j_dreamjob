package ru.job4j.dream.servlet;

import org.apache.commons.io.FileUtils;
import ru.job4j.dream.service.Path;
import ru.job4j.dream.store.Store;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Store.instOf().deleteCandidate(id);
        FileUtils.deleteQuietly(new File(Path.candidatePic() + id + ".jpg"));
    }
}
