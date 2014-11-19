package by.yura.newsline.web.sitecontroller;

import by.yura.newsline.dao.beans.News;
import by.yura.newsline.dao.mydao.MyDao;
import by.yura.newsline.web.sitemenu.Menu;
import by.yura.newsline.web.sitemenu.ShowMenu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet("/SiteController")
public class SiteController extends HttpServlet {
    MyDao dao;
    RequestDispatcher dispatcher;

    public void init(){

        dao = MyDao.getDao();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String id = request.getParameter("id");

        if (id == null) {
            id = "main";
        }

        News news = dao.getNews(id);
        Menu menu = new ShowMenu();
        request.setAttribute("news", news);
        request.setAttribute("menu", menu.showmenu(dao));
        dispatcher = request.getRequestDispatcher("newsline.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
