package by.yura.newsline.dao.beans;

import java.io.Serializable;


public class News implements Serializable {

    public News() {

    }

    private String id;
    private String category;
    private String name;
    private String annotation;
    private String author;
    private String createdate;
    private String maintext;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAnnotation() {
        return annotation;
    }
    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCreatedate() {
        return createdate;
    }
    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }
    public String getMaintext() {
        return maintext;
    }
    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof News)
        {
            News nl = (News)obj;
            if(id.equals(nl.id) && category.equals(nl.category)
                    && name.equals(nl.name) && annotation.equals(nl.annotation)
                    && author.equals(nl.author) && createdate.equals(nl.createdate) && maintext.equals(nl.maintext))
                return true;
            else
                return false;
        }
        else
            return false;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id.hashCode();
        result = prime * result + category.hashCode();
        result = prime * result + name.hashCode();
        result = prime * result + annotation.hashCode();
        result = prime * result + author.hashCode();
        result = prime * result + createdate.hashCode();
        result = prime * result + maintext.hashCode();

        return result;
    }

}
