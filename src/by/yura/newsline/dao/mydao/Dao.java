package by.yura.newsline.dao.mydao;

import by.yura.newsline.dao.beans.News;
import by.yura.newsline.dao.beans.Users;

import java.util.List;

public interface Dao {

    int DeleteNews(String id);
    int DeleteUsers(String email);
    List<String> getCategories();
    List<News> getNewsNames(String category);
    List<String> getNamesNews();
    News getNews(String id);
    News getCategory(String category);
    Users getUser(String email);
    int addNews(News n);
    int addUser(Users u);
    int updateNews(News n);
    int updateUsers(Users u);
}
