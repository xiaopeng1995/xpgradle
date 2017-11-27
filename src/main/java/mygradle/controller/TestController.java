package mygradle.controller;
import mygradle.base.entity.Userinfo;

import mygradle.dao.PwdMd5;
import mygradle.dao.UserDao;
import mygradle.work.Userwork;
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
    PwdMd5 pwdMd5=new PwdMd5();
    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public Userinfo adduser(@RequestParam String name, @RequestParam String pwd) {
        Userinfo u=new Userinfo();
        PwdMd5 pwdMd5=new PwdMd5();
        u.setName(name);
        u.setPwd(pwdMd5.toMD5(pwd));
        u.setMoney(100);
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
    public String findbyname(@RequestParam String name) {
        if(userDao.findbyname(name).size()!=0)
            return userDao.findbyname(name).get(0).getPwd();
        else
            return null;
    }

}
