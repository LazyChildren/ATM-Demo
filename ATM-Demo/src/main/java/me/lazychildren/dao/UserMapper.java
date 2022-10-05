package me.lazychildren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.lazychildren.pojo.ATM_User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<ATM_User> {
}
