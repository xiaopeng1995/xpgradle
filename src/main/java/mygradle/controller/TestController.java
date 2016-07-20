package mygradle.controller;
import mygradle.base.entity.Info;
import mygradle.base.entity.Userinfo;
import mygradle.dao.InfoDao;
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
    @Autowired
    InfoDao infoDao;
    PwdMd5 pwdMd5=new PwdMd5();
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public Userinfo adduser(@RequestParam String name, @RequestParam String pwd) {
        Userinfo u=new Userinfo();
        PwdMd5 pwdMd5=new PwdMd5();
        u.setUsername(name);
        u.setUserpwd(pwdMd5.toMD5(pwd));
        u.setGold(100);
        u.setGrade(1);
        u.setVigour(100);
        u.setToken(64);
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
    @RequestMapping(value = "/findbyname", method = RequestMethod.POST)
    public Userinfo findbyname(@RequestParam String name) {
        System.out.println(userDao.findbyname(name).get(0).getToken());
        if(userDao.findbyname(name).size()!=0)
            return userDao.findbyname(name).get(0);
        else
            return null;
    }
    @RequestMapping(value = "/findbynp", method = RequestMethod.POST)
    public Userinfo findbynp(@RequestParam String name,@RequestParam String pwd) {
        if (userDao.findbynp(name,pwdMd5.toMD5(pwd)).size()!=0) {

            return userDao.findbynp(name,pwdMd5.toMD5(pwd)).get(0);
        }
        else {
            return null;
        }
    }
    @RequestMapping(value = "/findbyid", method = RequestMethod.POST)
    public Userinfo findbyid(@RequestParam int id) {
        Userinfo userinfo = userDao.findOne(id);
        if (userinfo != null) {
            return userinfo;
        }
        return userinfo;
    }
    @RequestMapping(value = "/updatebyid", method = RequestMethod.POST)
    public String updatenamebyid(@RequestParam int id,@RequestParam int buttnid) {
        Userwork userwork=new Userwork();
        Userinfo u=userDao.findOne(id);
        String infoguai=null;
        if(u!=null) {
            if(buttnid==1) {
                u.setGold(u.getGold()-50);
                u.setVigour(u.getVigour()+100);
            }
            if(buttnid==2) {
                u.setGold(u.getGold()-246);
                u.setVigour(u.getVigour()+500);
            }
            if(buttnid==3) {
                u.setGold(u.getGold()-450);
                u.setVigour(u.getVigour()+1000);
            }
            if(buttnid==4) {
                u.setGold(u.getGold()-4100);
                u.setVigour(u.getVigour()+10000);
            }
            if(buttnid==11) {
                u.setGold(u.getGold()-50);
                u.setToken(u.getToken()+300);
            }
            if(buttnid==12) {
                u.setGold(u.getGold()-246);
                u.setToken(u.getToken()+1500);
            }
            if(buttnid==13) {
                u.setGold(u.getGold()-450);
                u.setToken(u.getToken()+3000);
            }
            if(buttnid==14) {
                u.setGold(u.getGold()-4100);
                u.setToken(u.getToken()+30000);
            }
                /*打怪*/
            if(buttnid==15) {//15打怪按钮
                u.setVigour(u.getVigour()-20);
                int luck= (int) (Math.random() * 50)+1;
                int Tup=1;
                if(luck>25&&luck<30)
                {
                    infoguai+="↓↓↓↓↓↓↓↓↓★★★★★Very lucky!★★★★★Very lucky!★★★★★Very lucky!★★★★★↓↓↓↓↓↓↓↓↓ " +
                            "杀死小怪超过★★25只★★！！！★★奖励5倍经验和15金币";
                    u.setGold(u.getGold()+15);
                    Tup=5;
                }

                else if(luck>=30&&luck<45)
                {
                    infoguai+="↓↓↓↓↓↓↓↓↓★★★★★★★★★★★Very lucky!██████████Very lucky!██████████Very lucky!★★★★★★★★★★★↓↓↓↓↓↓↓↓↓" +
                            "杀死小怪超过★★★30只★★★！！！★★★奖励10倍经验和25金币";
                    u.setGold(u.getGold()+25);
                    Tup=10;
                }
                else if(luck>=45)
                {
                    infoguai+="★★★★★★★★★★★★★★★★★Very lucky!██████████超大奖励！██████████Very lucky!★★★★★★★★★★★★★★★★★" +
                            "您杀死小怪超过★★★45只★★★！！！★★★奖励100倍经验和100金币";
                    u.setGold(u.getGold()+100);
                    Tup=100;
                }
                infoguai+="↓↓↓↓↓↓↓↓↓```````````````````````````````````````````系统消息`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓`当前共打了"+(luck-1)+"只小怪兽" +
                        "共获得"+luck*Tup*u.getGrade()+"点经验\n获得"+luck*3+"文钱\n↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑";

                int [] info=userwork.UserworkGrade(u.getExp()+(luck*10*Tup),u.getGrade());
                u.setGrade(info[0]);
                u.setExp(info[1]);
                u.setGamemoney(u.getGamemoney()+luck*3);
            }
            if(u.getGold()>=0&u.getVigour()>=0)
            {
                userDao.save(u);
                return infoguai.equals(null)?"购买成功！":infoguai;
            }
            else
            return infoguai.equals(null)?"金币不够哦去打怪吧！":"活力不够哦！";
        }
        else {
            return "系统出错请联系管理员！";
        }
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
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
