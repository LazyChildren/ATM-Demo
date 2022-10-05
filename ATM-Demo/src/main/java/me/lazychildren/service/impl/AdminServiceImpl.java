package me.lazychildren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import me.lazychildren.dao.UserMapper;
import me.lazychildren.pojo.ATM_Activity;
import me.lazychildren.pojo.ATM_User;
import me.lazychildren.pojo.Result;
import me.lazychildren.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Result getAllActivities() {
        return null;
    }

    @Override
    public Result getAllUser() {
        QueryWrapper<ATM_User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("priority", "cust");
        List<ATM_User> list = userMapper.selectList(queryWrapper);
        return Result.success(list);
    }
}
