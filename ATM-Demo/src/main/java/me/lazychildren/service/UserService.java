package me.lazychildren.service;

import me.lazychildren.pojo.ATM_User;
import me.lazychildren.pojo.Result;
import org.springframework.session.Session;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


public interface UserService {
    public Result login(HttpSession session, String username, String password);
    public Result changePass(HttpSession session, String oldpass, String newpass); //修改密码
    public Result getAmount(HttpSession session);   //查询余额
    public Result saveMoney(HttpSession session, Integer count); //存钱
    public Result drowMoney(HttpSession session, Integer count); //取钱
    public Result logout(HttpSession session);
    public Result Register(String username, String password);
}
