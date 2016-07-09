package controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by Cactus on 2016/6/28.
 */
@RestController
public class TestController extends BasicController {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "hello world!";
    }
}
