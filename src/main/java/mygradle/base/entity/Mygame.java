package mygradle.base.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Created by xiaopeng on 2016/7/9.
 */
@Entity(name="mygame")
public class Mygame {
    @Id
    private Long id;
    // The user email
    private String username;
    // The user name
    private String userpwd;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
    public Mygame() { }
    public Mygame(long  id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
