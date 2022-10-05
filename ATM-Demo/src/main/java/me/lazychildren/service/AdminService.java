package me.lazychildren.service;

import me.lazychildren.pojo.ATM_Activity;
import me.lazychildren.pojo.Result;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminService {
    public Result getAllActivities();
    public Result getAllUser();
}
