package zttc.itat.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2016/2/8.
 */
public class User {
    private  String username;

    public User(String username, String password, String email, String nickname) {  //用constructor实现的
        super();
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.username = username;
    }

    private  String password;
    private String email;
    private String nickname;

    public User(){}

    @Email(message = "邮箱格式不正确")
    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Size(max = 10,min = 1,message = "密码长度在1到10之间")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty(message = "用户名不能为空")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
