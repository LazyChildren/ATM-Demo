package me.lazychildren.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class ATM_Customer extends ATM_User implements Serializable {
    private Double amount;

}
