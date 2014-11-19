package by.yura.newsline.web.loginfilter;


import by.yura.newsline.dao.beans.Users;
import by.yura.newsline.dao.mydao.MyDao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    private FilterConfig config;
    HttpSession session;
    MyDao dao;
    Users user = null;
    RequestDispatcher dispatcher;

   public void init(FilterConfig config) throws ServletException {
       this.config = config;
       dao = MyDao.getDao();

   }

    public  void doFilter(ServletRequest var1, ServletResponse var2, FilterChain var3) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) var1;
        HttpServletResponse response = (HttpServletResponse) var2;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        session = request.getSession();

        if (session.getAttribute("user") == null) {

            if ((email == null || password == null) || (email == "" || password == "") || (dao.getUser(email) == null)) {
                response.sendRedirect("logpage.jsp");
            } else if (!password.equals(dao.getUser(email).getPassword())) {
                response.sendRedirect("logpage.jsp");
            } else {
                user = dao.getUser(email);
                session.setAttribute("user", user);
                var3.doFilter(request, response);
            }
        } else {
            var3.doFilter(request, response);
        }

    }


    public void destroy() {

    }
}
