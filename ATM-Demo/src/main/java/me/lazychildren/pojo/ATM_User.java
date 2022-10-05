package me.lazychildren.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("atm_user")
public class ATM_User implements Serializable {
    @TableId(type = IdType.AUTO,value = "id")
    protected Integer userid;

    @TableField(value = "name")
    protected String username;

    protected String password;

    protected String priority;

    protected Double amount;

}
