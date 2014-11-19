package by.yura.newsline.web.command;

import by.yura.newsline.dao.mydao.MyDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class EditCommand extends Command {
    String id;

    public EditCommand(String id) {
        this.id = id;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Logger logger = Logger.getLogger(EditCommand.class);
        MyDao dao = MyDao.getDao();
        request.setAttribute("pagenews", dao.getNews(id) );


        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(request, response);

        } catch (IOException e) {
            logger.error("Problem with EditCommand IOException");
        } catch (ServletException e) {
            logger.error("Problem with EditCommand ServletException");
        }

    }
}
