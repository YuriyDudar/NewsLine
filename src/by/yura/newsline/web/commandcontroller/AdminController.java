package by.yura.newsline.web.commandcontroller;

import by.yura.newsline.dao.mydao.MyDao;
import by.yura.newsline.web.command.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/AdminController")
public class AdminController  extends HttpServlet {

    MyDao dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = MyDao.getDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String id = request.getParameter("id");
            String operation = request.getParameter("operation");

            Command com = null;

            if (operation == null) {

                com = new ShowCommand();

            } else if (operation.equals("delete")) {

                com = new DeleteCommand(id);

            } else if (operation.equals("add")) {

                com = new AddCommand();

            } else if (operation.equals("addwrite")) {

                com = new AddWriteCommand();

            } else if (operation.equals("edit")) {

                com = new EditCommand(id);

            } else if (operation.equals("addedit")) {

                com = new AddEditCommand();

            }

            com.execute(request, response);

        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }


}
