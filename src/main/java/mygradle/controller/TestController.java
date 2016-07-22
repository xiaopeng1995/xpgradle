package mygradle.controller;
import mygradle.base.entity.Info;
import mygradle.base.entity.Userinfo;
import mygradle.dao.Cdk;
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
        System.out.println("账户"+name+"来注册：");
        System.out.println(pwd);
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
            System.out.println("注册失败密码空！返回null");
            return null;
        }
        else  if (userDao.findbyname(name).size()!=0)
        {
            System.out.println("注册失账户存在！返回null");
            return null;
        }
        else
        {
            System.out.println("注册成功");
            userDao.save(u);
            return userDao.findbyname(name).get(0);
        }

    }
    @RequestMapping(value = "/findbyname", method = RequestMethod.POST)
    public Userinfo findbyname(@RequestParam String name) {
        if(userDao.findbyname(name).size()!=0)
            return userDao.findbyname(name).get(0);
        else
            return null;
    }
    @RequestMapping(value = "/findbynp", method = RequestMethod.POST)
    public Userinfo findbynp(@RequestParam String name,@RequestParam String pwd) {
        System.out.println("账户"+name+"来验证：");
        if (userDao.findbynp(name,pwdMd5.toMD5(pwd)).size()!=0) {
            System.out.println("验证成功返回信息");
            return userDao.findbynp(name,pwdMd5.toMD5(pwd)).get(0);
        }
        else {
            System.out.println("验证失败返回null");
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
    @RequestMapping(value = "/choubyid", method = RequestMethod.POST)
    public String choubyid(@RequestParam int id) {
        Userinfo u=userDao.findOne(id);
        Userwork userwork=new Userwork();
        Cdk cdk=new Cdk();
        String chouinfo="";
        System.out.println("<br>欢迎来到抽奖系统");
        System.out.println("<br>每次抽奖消耗100金币");
        if(u.getGold()<100)
        {
            chouinfo="<br>" +
                    "<br>" +
                    "↓↓↓↓↓↓↓↓↓```````````````````````````````````````````系统消息`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓<br><br>" +
                    "金币不够去耍怪吧！能获得金币哦！或者充值！<br>" +
                    "" +
                    "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑<br>";
        }else
        {
            u.setGold(u.getGold()-100);
            int lucky=cdk.RandomNum();
            System.out.println(lucky);
            if(lucky<9)
            {
                if(lucky<3)
                {
                    int [] info=userwork.UserworkGrade(u.getExp()+1000*u.getGrade(),u.getGrade());
                    u.setGrade(info[0]);
                    u.setExp(info[1]);
                    chouinfo="<br>" +
                            "↓↓↓↓↓↓↓↓↓``````````````````````````````````````````★★★二等奖★★★`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓<br><br>" +
                            "您获得"+1000*u.getGrade()+"点经验！<br>" +
                            "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑";
                }
                if(lucky>=3&&lucky<7)
                {
                    u.setGamemoney(u.getGamemoney()+1000);
                    chouinfo="<br>" +
                            "<br>" +
                            "↓↓↓↓↓↓↓↓↓```````````````````````````````````````````三等奖`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓<br><br>" +
                            "您获得1,000文钱！<br>" +
                            "" +
                            "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑<br>";
                }
                if(lucky==7)
                {
                    u.setGold(u.getGold()+500);
                    chouinfo="<br><span style=\"color:red\">" +
                            "↓↓↓↓↓↓↓↓↓★★★★★★★★★★★Very lucky!██████████一等奖██████████Very lucky!★★★★★★★★★★★↓↓↓↓↓↓↓↓↓<br>" +
                            "您获得500金币！<br>" +
                            "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑</span>";

                }
                if(lucky==8)
                {
                    u.setVigour(u.getVigour()+300);
                    chouinfo="<br>" +
                            "↓↓↓↓↓↓↓↓↓```````````````````````````````````````````安慰奖`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓<br>" +
                            "您获得100体力！<br>" +
                            "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑";

                }

            }
            else
            {
                chouinfo="<br><span style=\"color:red\">" +
                        "↓↓↓↓↓↓↓↓↓★★★★★★★★★★★Very lucky!██████████特等奖！██████████Very lucky!★★★★★★★★★★★↓↓↓↓↓↓↓↓↓ <br>Very lucky!";
                chouinfo+="<br>中";
                chouinfo+="<br>奖";
                chouinfo+="<br>了";
                chouinfo+="<br>！";
                chouinfo+="<br><br>" +
                        "恭喜您获得10元移动充值卡";
                chouinfo+="<br>" +
                        "卡号是："+cdk.getCdk();
                chouinfo+="<br>" +
                        "密码是："+cdk.getCdkpwd();
                chouinfo+="<br>|<br><br>" +
                        "↑↑↑↑↑↑↑↑↑```````````````````````````````````↑↑↑↑`````````````````````````````````````````````````````````````````↑↑↑↑↑↑↑↑↑</span>";
            }
            userDao.save(u);
        }
        return chouinfo;
    }

    @RequestMapping(value = "/updatebyid", method = RequestMethod.POST)
    public String updatenamebyid(@RequestParam int id,@RequestParam int buttnid) {
        Userwork userwork=new Userwork();
        Userinfo u=userDao.findOne(id);
        String infoguai="信息提示:<br/>";
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
                u.setVigour(u.getVigour()-10);
                int luck= (int) (Math.random() * 50)+1;
                int Tup=1;
                if(luck>25&&luck<30)
                {
                    infoguai="↓↓↓↓↓↓↓↓↓★★★★★Very lucky!★★★★★Very lucky!★★★★★Very lucky!★★★★★↓↓↓↓↓↓↓↓↓<br/> " +
                            "杀死小怪超过★★25只★★！！！★★奖励5倍经验和2金币<br/>";
                    u.setGold(u.getGold()+2);
                    Tup=5;
                }

                else if(luck>=30&&luck<45)
                {
                    infoguai="↓↓↓↓↓↓↓↓↓★★★★★★★★★★★Very lucky!██████████Very lucky!██████████Very lucky!★★★★★★★★★★★↓↓↓↓↓↓↓↓↓<br/>" +
                            "杀死小怪超过★★★30只★★★！！！★★★奖励10倍经验和5金币<br/>";
                    u.setGold(u.getGold()+5);
                    Tup=10;
                }
                else if(luck>=45)
                {
                    infoguai="★★★★★★★★★★★★★★★★★Very lucky!██████████超大奖励！██████████Very lucky!★★★★★★★★★★★★★★★★★<br/>" +
                            "您杀死小怪超过★★★45只★★★！！！★★★奖励100倍经验和20金币<br/>";
                    u.setGold(u.getGold()+20);
                    Tup=100;
                }
                infoguai+="↓↓↓↓↓↓↓↓↓```````````````````````````````````````````系统消息`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓<br/>`当前共打了"+(luck-1)+"只小怪兽<br/>" +
                        "共获得"+luck*Tup*u.getGrade()+"点经验<br/>获得"+luck*3+"文钱<br/>↑↑↑↑↑↑↑↑↑<br/>您的战斗力为:"+u.getToken()+"获得经验加成："+u.getToken()+"点<br>```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑";
                int [] info=userwork.UserworkGrade(u.getExp()+(luck*u.getGrade()*Tup+u.getToken()),u.getGrade());
                u.setGrade(info[0]);
                u.setExp(info[1]);
                u.setGamemoney(u.getGamemoney()+luck*3);
            }
            if(u.getGold()>=0&u.getVigour()>=0)
            {
                userDao.save(u);
                return infoguai.length()<30?("购买成功"):infoguai;
            }
            else
            return infoguai.length()<30?("金币不够哦去打怪吧！"):("活力不够哦！");
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
