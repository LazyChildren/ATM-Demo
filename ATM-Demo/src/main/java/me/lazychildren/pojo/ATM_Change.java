package me.lazychildren.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ATM_Change {
    private String oldpassword;
    private String newpassword;
    private String againpassword;
}
