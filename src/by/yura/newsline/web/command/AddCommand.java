package by.yura.newsline.web.command;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class AddCommand extends Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Logger logger = Logger.getLogger(AddCommand.class);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
        try {
            dispatcher.forward(request, response);

        } catch (IOException e) {
           logger.error("Problem with AddCommand IOException", e);
        } catch (ServletException e) {
            logger.error("Problem with AddCommand ServletException",e);
        }
    }
}
