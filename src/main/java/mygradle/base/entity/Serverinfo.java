package mygradle.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by xiaopeng on 2017/11/27.
 */
@Entity(name="server")
public class Serverinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nametype;
    private String server;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getNametype() {
        return nametype;
    }

    public void setNametype(String nametype) {
        this.nametype = nametype;
    }
}
