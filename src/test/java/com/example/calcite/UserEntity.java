package com.example.calcite;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "tbl_user",schema = "db1")
public class UserEntity {
    @TableId("user_id")
    private String id;
    @TableField("user_name")
    private String userName;
}
