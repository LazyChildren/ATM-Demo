package me.lazychildren.controller;

import lombok.AllArgsConstructor;
import me.lazychildren.pojo.Result;
import me.lazychildren.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    @GetMapping("/activity")
//    public Result getUserAct()
//    {
//        return null;
//    }


}
