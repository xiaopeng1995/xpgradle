package mygradle.controller;

import mygradle.base.entity.Serverinfo;
import mygradle.base.entity.Userinfo;

import mygradle.dao.PwdMd5;
import mygradle.dao.ServerDao;
import mygradle.dao.UserDao;
import mygradle.work.Userwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * Created by Cactus on 2016/6/28.
 */
@CrossOrigin
@RestController
public class TestController extends BasicController {
    @Autowired
    UserDao userDao;
    @Autowired
    ServerDao serverDao;
    PwdMd5 pwdMd5 = new PwdMd5();

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public Userinfo adduser(@RequestParam String name, @RequestParam String pwd) {
        Userinfo u = new Userinfo();
        PwdMd5 pwdMd5 = new PwdMd5();
        u.setName(name);
        u.setPwd(pwdMd5.toMD5(pwd));
        u.setMoney(100);
        if (name == null || pwd == null) {
            return null;
        } else if (userDao.findbyname(name).size() != 0) {
            return null;
        } else {
            userDao.save(u);
            return userDao.findbyname(name).get(0);
        }

    }

    @RequestMapping(value = "/findbyname", method = RequestMethod.GET)
    public String findbyname(@RequestParam String name) {
        if (serverDao.findbyname(name).size() != 0)
            return utf(serverDao.findbyname(name).get(0).getServer());
        else
            return null;
    }

    @RequestMapping(value = "/addserver", method = RequestMethod.GET)
    public Serverinfo addserver(@RequestParam String server) {
        Serverinfo serverinfo = new Serverinfo();
        serverinfo.setNametype("xx");
        serverinfo.setServer(server);
        serverDao.save(serverinfo);
        return serverDao.findbyname("xx").get(0);
    }

    private String utf(String str) {
        try {
            byte[] temp = str.getBytes();//这里写原编码方式
            byte[] newtemp = new String(temp).getBytes("utf-8");//这里写转换后的编码方式
            String newStr = new String(newtemp, "utf-8");//这里写转换后的编码方式
            System.out.println(newStr);
            return newStr;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
