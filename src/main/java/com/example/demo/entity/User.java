package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
/**
 * <p>
 * 用户表
 * </p>
 *
 * @author tanpenggood
 * @since 2025-02-18
 */
@Getter
@Setter
@ToString
@TableName("T_USER")
@Accessors(chain = true)
@Schema(name = "User", description = "用户表")
public class User {

    @TableId(value = "ID", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 姓名
     */
    @Schema(description = "姓名")
    private String username;

    /**
     * 昵称
     */
    @Schema(description = "昵称")
    private String nickname;

    /**
     * 年龄
     */
    @Schema(description = "年龄")
    private Integer age;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

    /**
     * 逻辑删除标识
     */
    @Schema(description = "逻辑删除标识")
    private Boolean delFlag;
}
