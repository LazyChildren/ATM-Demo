package me.lazychildren.controller;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.AllArgsConstructor;
import me.lazychildren.pojo.ATM_PostForm;
import me.lazychildren.pojo.Result;
import me.lazychildren.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/ATM/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/users")
    public Result getUsers(){
        return adminService.getAllUser();
    }

    @GetMapping("/machine")
    public Result getMachine(){
        return adminService.getMachine();
    }

//    @GetMapping("/activity")
//    public Result getUserAct()
//    {
//        return null;
//    }

    @PostMapping("/add")
    public Result addMoney(@RequestBody ATM_PostForm form){
        return adminService.addMoney(form.getCount());


    }


    @PostMapping("/take")
    public Result takeMoney(@RequestBody ATM_PostForm form){
        return adminService.takeMoney(form.getCount());
    }




}
