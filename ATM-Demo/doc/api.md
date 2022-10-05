基本实体类图
![img_1.png](img_1.png)


所有请求的返回值皆为Result, Result中有三个值 <br>
code: 状态码    200=成功 400=失败<br>
msg: 状态信息   null=成功 非空=失败<br>
data: 数据       又返回数据的已用"return:"标出<br>
<br>
<br>
用户:<br>
    1.登陆<br>
    url: /ATM/login (post)<br>
    param: username, password<br>
    return: User对象，其中的priority值为"admin"时表示管理员， 值为"cust"时表示顾客<br>
<br>
顾客:<br>
    1.提款<br>
    url: /ATM/drow (post)<br>
    param: count (金额)<br>
    2.存款<br>
    url: /ATM/save (post)<br>
    param: count(金额)<br>
    3.查询余额<br>
    url: /ATM/get (get)<br>
    param: null<br>
    return: Double,值表示余额<br>
<br>
管理员:<br>
    1.显示所有用户<br>
    url: /ATM/admin/users<br>
    param: null<br>
    return: User数组, 当前系统中的所有用户(不包括管理员)<br>

[//]: # (    2.显示当前用户的活动<br>)

[//]: # (    url: /ATM/admin/activity<br>)

[//]: # (    param: username<br>)

[//]: # (    return: Activity集合, 该用户的所有活动记录<br>)

    
    


