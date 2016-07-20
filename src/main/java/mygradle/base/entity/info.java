package mygradle.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by xiaopeng on 2016/7/13.
 */
@Entity(name="info")
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String systeminfo;
    private String hudinfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSysteminfo() {
        return systeminfo;
    }

    public void setSysteminfo(String systeminfo) {
        this.systeminfo = systeminfo;
    }


    public String getHudinfo() {
        return hudinfo;
    }

    public void setHudinfo(String hudinfo) {
        this.hudinfo = hudinfo;
    }
}
