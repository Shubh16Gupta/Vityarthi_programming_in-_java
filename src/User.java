package codevault;
import java.io.Serializable;
public class User implements Serializable {
//we make the class called user
    private String username;
    private String password;
    private String name;
    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return name + " (" + username + ")";
    }
}