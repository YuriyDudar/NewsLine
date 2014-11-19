package by.yura.newsline.web.sitemenu;

import by.yura.newsline.dao.beans.News;
import by.yura.newsline.dao.mydao.MyDao;

import java.util.Iterator;
import java.util.List;

/**
 * Created by HP on 17.11.2014.
 */
public class ShowMenu extends Menu {

    public String showmenu(MyDao dao) {
        StringBuffer sb = new StringBuffer();
        List<String> listcategory = dao.getCategories();
        Iterator iterator = listcategory.iterator();

        while (iterator.hasNext()) {
            String category = (String) iterator.next();
            List<News> listnews = dao.getNewsNames(category);

            sb.append("<ul>" +  "<strong>" + category.toUpperCase() + ":</strong><br>");
            for(int i = 0; i<listnews.size(); i++) {
                sb.append("<li>" + "<a href=\"SiteController?id=" + listnews.get(i).getId() + "\">" + listnews.get(i).getName() +  "</a>"  + "</li>");
            }
            sb.append("</ul>");
        }

        return sb.toString();
    }

}
