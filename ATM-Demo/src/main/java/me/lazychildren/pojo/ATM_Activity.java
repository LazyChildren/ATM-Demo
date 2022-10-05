package me.lazychildren.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("atm_activity")
public class ATM_Activity implements Serializable {
    @TableId(type = IdType.AUTO, value = "id")
    private Integer activityid;

    private String username;
    private String activity;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private String time;

    private String value;

    public static ATM_Activity create(ATM_User user, String activity, String value)
    {
        ATM_Activity activity1 = new ATM_Activity();
        activity1.setActivity(activity);
        activity1.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        activity1.setUsername(user.getUsername());
        activity1.setValue(value);
        return activity1;
    }
}
