package mygradle.controller;
import mygradle.base.entity.Info;
import mygradle.base.entity.Userinfo;
import mygradle.dao.InfoDao;
import mygradle.dao.PwdMd5;
import mygradle.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Cactus on 2016/6/28.
 */
@CrossOrigin
@RestController
public class TestController extends BasicController {
    @Autowired
    UserDao userDao;
    @Autowired
    InfoDao infoDao;
    PwdMd5 pwdMd5=new PwdMd5();
    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public Userinfo adduser(@RequestParam String name, @RequestParam String pwd) {
        Userinfo u=new Userinfo();
        PwdMd5 pwdMd5=new PwdMd5();
        u.setUsername(name);
        u.setUserpwd(pwdMd5.toMD5(pwd));
        u.setGold(100);
        u.setGrade(1);
        if(name==null||pwd==null)
        {
            return null;
        }
        else  if (userDao.findbyname(name).size()!=0)
        {
            return null;
        }
        else
        {
            userDao.save(u);
            return userDao.findbyname(name).get(0);
        }

    }
    @RequestMapping(value = "/findbyname", method = RequestMethod.GET)
    public Userinfo findbyname(@RequestParam String name) {
        if(userDao.findbyname(name).size()!=0)
            return userDao.findbyname(name).get(0);
        else
            return null;
    }
    @RequestMapping(value = "/findbynp", method = RequestMethod.GET)
    public Userinfo findbynp(@RequestParam String name,@RequestParam String pwd) {
        if (userDao.findbynp(name,pwdMd5.toMD5(pwd)).size()!=0) {

            return userDao.findbynp(name,pwdMd5.toMD5(pwd)).get(0);
        }
        else {
            return null;
        }
    }
    @RequestMapping(value = "/findbyid", method = RequestMethod.GET)
    public Userinfo findbyid(@RequestParam int id) {
        Userinfo userinfo = userDao.findOne(id);
        if (userinfo != null) {
            return userinfo;
        }
        return userinfo;
    }
    @RequestMapping(value = "/updatenamebyid", method = RequestMethod.GET)
    public String updatenamebyid(@RequestParam int id,@RequestParam String name) {
        Userinfo u=userDao.findOne(id);
        if(u!=null) {
            u.setUsername(name);
            userDao.save(u);
            return "updatese";
        }
        else {
            return "er_null";
        }
    }
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Info info(int id) {
        Info u=infoDao.findOne(id);
        if(u!=null) {

            return u;
        }
        else {
            return null;
        }
    }
}
