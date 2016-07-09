package mygradle.controller;
import mygradle.base.entity.Mygame;
import mygradle.dao.Mygamedao;
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
    Mygamedao mygamedao;

    @RequestMapping("/test")
    @ResponseBody
    public String test(String username) {
        String userpwd;
        Mygame mygame = mygamedao.findByusername(username);
        if (mygame != null) {
            userpwd = String.valueOf(mygame.getUserpwd());
            return "The user id is: " + userpwd;
        }
        return "mygame " + username + " is not exist.";
    }

}
