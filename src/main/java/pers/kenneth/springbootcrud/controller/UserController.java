//控制器（Controller）：处理HTTP请求。
package pers.kenneth.springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.kenneth.springbootcrud.entity.User;
import pers.kenneth.springbootcrud.service.UserService;

@Controller
@RequestMapping("/users")
//访问：http://localhost:8080/users
public class UserController {
    //controller层调用业务逻辑层
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 获取全部数据
    @GetMapping
    public String listUsers(Model model) {
        // model对象设置属性名称以及属性值
        model.addAttribute("users", userService.getAllUsers());  // 调用服务类（Service）的方法
        System.out.println(model.getAttribute("users"));
        return "users";  // users对应静态文件users.html
    }

    //通过ID查找，点击进入更新数据界面
    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id).orElse(null));
        return "update-user";
    }

    //点击进入添加数据界面（并传递一个初始化的user对象）
    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    //更改之后保存数据
    @PostMapping
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    //删除之后保存数据
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
