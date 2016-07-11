package mygradle.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by xiaopeng on 2016/7/10.
 */
@Entity(name="userinfo")
public class Userinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String userpwd;
    private int grade;
    private int exp;
    private int  gamemoney;
    private int gold;
    private int vigour;
    public Userinfo() { }
    public Userinfo(int  id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGamemoney() {
        return gamemoney;
    }

    public void setGamemoney(int gamemoney) {
        this.gamemoney = gamemoney;
    }

    public int getVigour() {
        return vigour;
    }

    public void setVigour(int vigour) {
        this.vigour = vigour;
    }

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

}
