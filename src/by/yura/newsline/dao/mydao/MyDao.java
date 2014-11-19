package by.yura.newsline.dao.mydao;

import by.yura.newsline.dao.beans.News;
import by.yura.newsline.dao.beans.Users;
import org.apache.log4j.Logger;


import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


/**
 * Class for working with MySQL
 */
public class MyDao implements Dao {
    Connection connect;
    ResourceBundle bundle = ResourceBundle.getBundle("mysql");
    Statement statement;
    Logger logger = Logger.getLogger(MyDao.class);

    /**
     * Singleton constructor for loading driver and connect to MySQL
     */
    private MyDao()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
           logger.error("Problem with loading driver", e);
        }

        try {
            connect = DriverManager.getConnection(bundle.getString("dURL"), bundle.getString("username"), bundle.getString("password"));

        } catch (SQLException e) {
            logger.error("Problem with connect to MySQL",e);
        }

    }

    private static MyDao dao;
    public static MyDao getDao() {
        if(dao==null) {
            dao = new MyDao();
        }
        return dao;
    }


    /**
     * Delete values from table news
     * @param id
     * @return number of deleted rows
     */
    public int DeleteNews(String id) {
        int result = 0;
        try {
            statement = connect.createStatement();
            result = statement.executeUpdate("delete from news where id=" + "'"+ id +"'");
        } catch (SQLException e) {
           logger.error("Problem with DeleteNews",e);
        }
        return result;
    }


    /**
     * Delete values from table users
     * @param email
     * @return number of deleted rows
     */
    public int DeleteUsers(String email) {
        int result = 0;
        try {
            statement = connect.createStatement();
            result = statement.executeUpdate("delete from users where email=" + "'"+ email +"'");
        } catch (SQLException e) {
           logger.error("Problem with DeleteUsers", e);
        }
        return result;
    }


    /** All categories from table news
     * @return List of categories
     */
    public List<String> getCategories() {
        ArrayList<String> categorylist = new ArrayList<String>();
        try {
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("select distinct category from news where category<>" + "'"+"'");
            while(rs.next())
            {
                categorylist.add(rs.getString("category"));
            }
        } catch (SQLException e) {
            logger.error("Problem with getCategories", e);
        }
        return categorylist;
    }


    /**
     * Returns the names of the news belonging to the category
     * @param category
     * @return List of names news
     */
    public List<News> getNewsNames(String category) {
        ArrayList<News> newslist = new ArrayList<News>();
        try {
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from news where category='"+category+"'");
            while(rs.next())
            {
                News news = new News();

                news.setId(rs.getString("id"));
                news.setCategory(rs.getString("category"));
                news.setName(rs.getString("name"));
                news.setAnnotation(rs.getString("annotation"));
                news.setAuthor(rs.getString("author"));
                news.setCreatedate(rs.getString("createdate"));
                news.setMaintext(rs.getString("maintext"));
                newslist.add(news);
            }
        }catch (SQLException e) {
            logger.error("Problem with getNewsNames", e);
        }

        return newslist;
    }


    /**
     * Return all names news
     * @return list names
     */
    public List<String> getNamesNews() {
        ArrayList<String> newslist = new ArrayList<String>();
        try {
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("select name from news");
            while(rs.next())
            {
                newslist.add(rs.getString("name"));
            }
        }catch (SQLException e) {
            logger.error("Problem with getNewsNames", e);
        }

        return newslist;
    }

    /**
     * Return one row from table news where @param=id
     * @return class News
     */
    public News getNews(String id) {
        News news = null;

        try {
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from news where id=" + "'"+id+"'");
            if(rs.next())
            {
                news = new News();
                news.setId(rs.getString("id"));
                news.setCategory(rs.getString("category"));
                news.setName(rs.getString("name"));
                news.setAnnotation(rs.getString("annotation"));
                news.setAuthor(rs.getString("author"));
                news.setCreatedate(rs.getString("createdate"));
                news.setMaintext(rs.getString("maintext"));
            }
            else
                return null;

        } catch (SQLException e) {
           logger.error("Problem with getNews", e);
        }
        return news;

    }


    /**
     * Return one row from table news where @param=category
     * @return class News with values
     */
    public News getCategory(String category) {
        News news = null;

        try {
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from news where category='"+category+"'");
            if(rs.next())
            {
                news = new News();
                news.setId(rs.getString("id"));
                news.setCategory(rs.getString("category"));
                news.setName(rs.getString("name"));
                news.setAnnotation(rs.getString("annotation"));
                news.setAuthor(rs.getString("author"));
                news.setCreatedate(rs.getString("createdate"));
                news.setMaintext(rs.getString("maintext"));
            }
            else
                return null;

        } catch (SQLException e) {
            logger.error("Problem with getCategory", e);
        }
        return news;

    }


    /**
     * Return one row from table news where @param=email
     * @return class Users
     */
    public Users getUser(String email) {
        Users users = null;

        try {
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from users where email='"+email+"'");
            if(rs.next())
            {
                users = new Users();
                users.setEmail(rs.getString("email"));
                users.setName(rs.getString("name"));
                users.setPassword(rs.getString("password"));

            }
            else
                return null;

        } catch (SQLException e) {
            logger.error("Problem with getUser", e);
        }
        return users;
    }


    /**
     * Add new row at table of news
     * @param n
     * @return class News
     */
    public int addNews(News n) {
        int result=0;
        try {
            PreparedStatement pstStatement = connect.prepareStatement("insert into news values(?,?,?,?,?,?,?)");
            pstStatement.setString(1, n.getId());
            pstStatement.setString(2, n.getCategory());
            pstStatement.setString(3, n.getName());
            pstStatement.setString(4, n.getAnnotation());
            pstStatement.setString(5, n.getAuthor());
            pstStatement.setString(6, n.getCreatedate());
            pstStatement.setString(7, n.getMaintext());
            result = pstStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Problem with addNews", e);
        }
        return result;
    }


    /**
     * Add new row at table of users
     * @param u
     * @return class Users
     */
    public int addUser(Users u) {
        int result=0;
        try {
            PreparedStatement pstStatement = connect.prepareStatement("insert into users values(?,?,?)");
            pstStatement.setString(1, u.getEmail());
            pstStatement.setString(2, u.getName());
            pstStatement.setString(3, u.getPassword());
            result = pstStatement.executeUpdate();

        } catch (SQLException e) {
           logger.error("Problem with addUser", e);
        }
        return result;
    }


    /**
     * Update one row from table of news
     * @param n
     * @return class News
     */
    public int updateNews(News n) {
        int result=0;
        try {
            PreparedStatement pstStatement = connect.prepareStatement("update news set category=?, name=?, annotation=?, author=?, createdate=?, maintext=? where id=?");
            pstStatement.setString(1, n.getCategory());
            pstStatement.setString(2, n.getName());
            pstStatement.setString(3, n.getAnnotation());
            pstStatement.setString(4, n.getAuthor());
            pstStatement.setString(5, n.getCreatedate());
            pstStatement.setString(6, n.getMaintext());
            pstStatement.setString(7, n.getId());
            result = pstStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Problem with updateNews", e);
        }
        return result;
    }

    /**
     * Update one row from table of users
     * @param u
     * @return class Users
     */
    public int updateUsers(Users u) {
        int result=0;
        try {
            PreparedStatement pstStatement = connect.prepareStatement("update users set name=?, password=? where email=?");
            pstStatement.setString(1, u.getName());
            pstStatement.setString(2, u.getPassword());
            pstStatement.setString(3, u.getEmail());
            result = pstStatement.executeUpdate();

        } catch (SQLException e) {
           logger.error("Problem with updateUsers", e);
        }
        return result;
    }
}
