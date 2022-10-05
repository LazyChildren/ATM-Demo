package me.lazychildren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.lazychildren.pojo.ATM_Activity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActivityMapper extends BaseMapper<ATM_Activity> {
}
