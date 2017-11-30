package mygradle.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by xiaopeng on 2017/11/29.
 */
@Entity(name="token")
public class Tokeninfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String token;
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
