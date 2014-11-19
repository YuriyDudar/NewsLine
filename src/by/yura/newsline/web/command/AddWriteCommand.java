package by.yura.newsline.web.command;

import by.yura.newsline.dao.beans.News;
import by.yura.newsline.dao.mydao.MyDao;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddWriteCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Logger logger = Logger.getLogger(AddWriteCommand.class);
        MyDao dao = MyDao.getDao();
        News news = new News();
        news.setId(request.getParameter("id"));
        news.setCategory(request.getParameter("category"));
        news.setName(request.getParameter("name"));
        news.setAnnotation(request.getParameter("annotation"));
        news.setAuthor(request.getParameter("author"));
        news.setCreatedate(request.getParameter("createdate"));
        news.setMaintext(request.getParameter("maintext"));
        dao.addNews(news);

        try {
            response.sendRedirect("AdminController");
        } catch (IOException e) {
           logger.error("Problem with AddWriteCommand", e);
        }
    }

}
