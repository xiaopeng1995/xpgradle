package mygradle.controller;
import mygradle.base.entity.Userinfo;
import mygradle.dao.Mygamedao;
import mygradle.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Cactus on 2016/6/28.
 */
@RestController
public class TestController extends BasicController {
    @Autowired
    UserDao userDao;
    @RequestMapping("/adduser")
    @ResponseBody
    public String adduser(String name,String pwd) {
        Userinfo u=new Userinfo();
        u.setUsername(name);
        u.setUserpwd(pwd);
        userDao.save(u);
      //  Mygame mygame = mygamedao.findByusername(username);
        /*if (mygame != null) {
            userpwd = String.valueOf(mygame.getUserpwd());
            return "The user id is: " + userpwd;
        }*/
        return "chengg";
    }
    @RequestMapping("/finduserbyname")
    @ResponseBody
    public Userinfo finduserbyname(int id) {
        Userinfo userinfo = userDao.findOne(id);
        if (userinfo != null) {
            return userinfo;
        }
        return userinfo;
    }
}
