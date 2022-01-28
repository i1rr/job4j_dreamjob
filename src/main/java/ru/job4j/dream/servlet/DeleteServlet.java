package ru.job4j.dream.servlet;

import org.apache.commons.io.FileUtils;
import ru.job4j.dream.service.Path;
import ru.job4j.dream.store.MemStore;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MemStore.instOf().deleteCandidate(id);
        FileUtils.deleteQuietly(new File(Path.candidatePic() + id + ".png"));
        response.sendRedirect(request.getContextPath() + "/candidates.do");
    }
}
