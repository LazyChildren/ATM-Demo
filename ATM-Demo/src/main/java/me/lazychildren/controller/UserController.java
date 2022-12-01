package me.lazychildren.controller;

import me.lazychildren.pojo.*;
import me.lazychildren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("/ATM")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result login(HttpServletRequest request,
                        @RequestBody ATM_TempUser user)
    {

       return userService.login(request.getSession(),user.getUsername(),user.getPassword());

    }

    @PostMapping("/drow")
    public Result drowMoney(HttpServletRequest request, @RequestBody ATM_PostForm form){
        return userService.drowMoney(request.getSession() , form.getCount());


    }

    @PostMapping("/save")
    public Result saveMoney(HttpServletRequest request, @RequestBody ATM_PostForm form){
        return userService.saveMoney(request.getSession(), form.getCount());

    }

    @PostMapping("/change")
    public Result changePass(HttpServletRequest request,@RequestBody ATM_Change change)
    {
        return userService.changePass(request.getSession(), change.getOldpassword(), change.getNewpassword());
    }

    @GetMapping("/get")
    public Result getAmount(HttpServletRequest request)
    {
        return userService.getAmount(request.getSession());
    }


    @GetMapping("/logout")
    public Result logout(HttpServletRequest request)
    {
        return userService.logout(request.getSession());
    }

    @PostMapping("/register")
    public Result register( @RequestBody ATM_TempUser user)
    {
        return userService.Register(user.getUsername(),user.getPassword());
    }


    @GetMapping("/machine")
    public Result getMachine(){
        return Result.success(ATM_Machine.getInstance());
    }


}
