package me.lazychildren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import me.lazychildren.dao.ActivityMapper;
import me.lazychildren.dao.UserMapper;
import me.lazychildren.pojo.*;
import me.lazychildren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ActivityMapper activityMapper;
    @Override
    public Result login(HttpSession session, String username, String password) {
        QueryWrapper<ATM_User> wrapper = new QueryWrapper<>();
        wrapper.eq("name",username);
        ATM_User user = userMapper.selectOne(wrapper);
        if(user == null)
            return Result.fail("用户不存在");
        if(user.getPassword().equals(password))
        {
            session.setAttribute("user", user);

            activityMapper.insert(ATM_Activity.create(user, "online", "success"));
            return Result.success(user);

        }
        return Result.fail("密码错误");
    }

    @Override
    public Result changePass(HttpSession session, String oldpass, String newpass) {
        ATM_User user = (ATM_User) session.getAttribute("user");
        if(!user.getPassword().equals(oldpass))
        {
            activityMapper.insert(ATM_Activity.create(user, "change_pass", "Change-Failed"));


            return Result.fail("密码错误, 无法修改密码");

        }
        session.removeAttribute("user");
        UpdateWrapper<ATM_User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", user.getUserid());
        wrapper.set("password", newpass);
        userMapper.update(null, wrapper);
        user.setPassword(newpass);
        session.setAttribute("user", user);
        activityMapper.insert(ATM_Activity.create(user, "change_pass", newpass));

        return Result.success(user);
    }

    @Override
    public Result saveMoney(HttpSession session, Integer count) {
        ATM_User user = (ATM_User) session.getAttribute("user");
        session.removeAttribute("user");
        UpdateWrapper<ATM_User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", user.getUserid());
        wrapper.set("amount", user.getAmount() + count);
        userMapper.update(null, wrapper);
        user.setAmount(count + user.getAmount());
        session.setAttribute("user", user);
        activityMapper.insert(ATM_Activity.create(user, "save_money", count.toString()));
        ATM_Machine.getInstance().addAmount(count);
        return Result.success(user);
    }

    @Override
    public Result drowMoney(HttpSession session, Integer count) {
        ATM_User user = (ATM_User) session.getAttribute("user");
        if(user.getAmount() < count)
        {
            activityMapper.insert(ATM_Activity.create(user, "drow_money", "Drow-Failed"));

            return Result.fail("余额不足");

        }
        if(!ATM_Machine.getInstance().takeAmount(count))
        {
            activityMapper.insert(ATM_Activity.create(user, "drow_money", "Drow-Failed"));

            return Result.fail("当前机器没有足够现金,请联系管理人员!");
        }
        session.removeAttribute("user");
        UpdateWrapper<ATM_User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", user.getUserid());
        wrapper.set("amount", user.getAmount() - count);
        userMapper.update(null, wrapper);
        user.setAmount(user.getAmount() - count);
        session.setAttribute("user", user);
        activityMapper.insert(ATM_Activity.create(user, "drow_money", count.toString()));

        return Result.success(user);
    }

    @Override
    public Result getAmount(HttpSession session) {
        ATM_User user = (ATM_User) session.getAttribute("user");
        activityMapper.insert(ATM_Activity.create(user, "get_account", user.getAmount().toString()));

        return Result.success(user);
    }



    @Override
    public Result logout(HttpSession session) {
        ATM_User user = (ATM_User) session.getAttribute("user");
        session.removeAttribute("user");
        activityMapper.insert(ATM_Activity.create(user, "offline", "success"));

        return Result.success(null);
    }


    @Override
    public Result Register(String username, String password) {
        ATM_User newuser = new ATM_User();
        newuser.setAmount(0.0);
        newuser.setPassword(password);
        newuser.setUsername(username);
        newuser.setPriority("cust");
        int res = userMapper.insert(newuser);
        if(res == 1)
            return Result.success(newuser);
        else
            return Result.fail("创建失败,用户名已被使用");

    }
}
