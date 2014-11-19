package by.yura.newsline.dao.beans;


import java.io.Serializable;

public class Users implements Serializable {

    public Users() {

    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    private String email;
    private String name;
    private String password;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Users)
        {
            Users users = (Users)obj;
            if(email.equals(users.email) && name.equals(users.name) && password.equals(users.password))
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
        result = prime * result + email.hashCode();
        result = prime * result + name.hashCode();
        result = prime * result + password.hashCode();

        return result;
    }

}