package zttc.itat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zttc.itat.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cherry on 2016/2/8.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Map<String,User> users = new HashMap<String, User>();

    //构造函数
    public UserController(){
        users.put("Cherry",new User("Cherry","111","123@qq.com","cherry"));
        users.put("Edison",new User("Edison","111","123@qq.com","edison"));
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("users",users);
        return "/user/list";
    }

    //链接到页面时，是GET请求，用该方法处理
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute(new User());
        return "/user/add";
    }

    //当POST请求时，会使用该方法
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public  String add(@Validated User user,BindingResult br){ //BindingResults 参数一定要紧跟@Validated,不然会报错
        if(br.hasErrors()){
            return "/user/add";
        }
        users.put(user.getUsername(),user);
        return "redirect:/user/users";
    }

    //这个show的url是用了新晋的rest表示方法,model.addAttribute()方法的key是User类型的数据
    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public String show(@PathVariable String username, Model model){
        model.addAttribute(users.get(username));
        return "/user/show";
    }

    @RequestMapping(value = "/{username}/update",method = RequestMethod.GET)
    public  String update(@PathVariable String username, Model model){
        model.addAttribute(users.get(username));
        return "/user/update";
    }

    @RequestMapping(value = "/{username}/update",method =RequestMethod.POST)
    public  String update(@PathVariable String username ,@Validated User user, BindingResult br){
            if(br.hasErrors()){
                return "user/update";
            }
            users.put(username,user);
            return "redirect:/user/users";
    }

    @RequestMapping(value = "/{username}/delete",method = RequestMethod.GET)
    public String delete(@PathVariable String username){

        users.remove(username);
        return "redirect:/user/users";
    }
}
