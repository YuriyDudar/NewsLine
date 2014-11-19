package by.yura.newsline.web.command;


import by.yura.newsline.dao.mydao.MyDao;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCommand extends Command {

    String id;

    public DeleteCommand(String id) {
        this.id = id;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Logger logger = Logger.getLogger(DeleteCommand.class);
        MyDao dao = MyDao.getDao();
        dao.DeleteNews(id);
        try {
            response.sendRedirect("AdminController");
        } catch (IOException e) {
            logger.error("Problem with AddWriteCommand", e);
        }
    }
}
