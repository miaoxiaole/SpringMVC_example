package zttc.itat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/2/7.
 */
@Controller
public class HelloController {

    //RequestMapping这个注解代表类中方法与哪一个URL对应
    @RequestMapping("/login")
    public String hell0(String username , String password, Model model){
        if (username.equals(password)){
            model.addAttribute("username",username);
            return "yep";
        }
        else
            return "no";
    }

}
