package by.yura.newsline.web.command;


import by.yura.newsline.dao.beans.News;
import by.yura.newsline.dao.mydao.MyDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Show all menu command
 */
public class ShowCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        Logger logger = Logger.getLogger(ShowCommand.class);
        MyDao dao = MyDao.getDao();
        StringBuffer sb = new StringBuffer();
        List<String> listcategory = dao.getCategories();
        Iterator iterator = listcategory.iterator();

        while (iterator.hasNext()) {
            String category = (String) iterator.next();
            List<News> listnews = dao.getNewsNames(category);

            sb.append("<ul>" + "<strong>" + "<a href=\"AdminController?operation=cat&category=" + category + "\">" + category.toUpperCase() + ":</strong></a><br>");
            for (int i = 0; i < listnews.size(); i++) {
                sb.append("<li>");
                sb.append("<a href=\"AdminController?operation=edit&id=" + listnews.get(i).getId() + "\">" + listnews.get(i).getName() + "</a>" + "</li>" + " ");
                sb.append("<a href=\"AdminController?operation=delete&id=" + listnews.get(i).getId() + "\">" + "<button>" + "Delete" + "</button>" + "</a>" + " ");
            }
            sb.append("</ul>");
        }
        sb.append("<br><a href=\"AdminController?operation=add\">" + "<button>" + "Add Page" + "</button>" + "</a>");

        request.setAttribute("commandmenu", sb.toString());

        RequestDispatcher dispatcher = request.getRequestDispatcher("adminpanel.jsp");
        try {
            dispatcher.forward(request, response);

        } catch (IOException e) {
            logger.error("Problem with ShowCommand IOException", e);
        } catch (ServletException e) {
            logger.error("Problem with ShowCommand ServletException", e);
        }
    }

}
