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
 * 角色表
 * </p>
 *
 * @author tanpenggood
 * @since 2025-02-18
 */
@Getter
@Setter
@ToString
@TableName("T_ROLE")
@Accessors(chain = true)
@Schema(name = "Role", description = "角色表")
public class Role {

    @TableId(value = "ID", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 角色名称
     */
    @Schema(description = "角色名称")
    private String name;

    /**
     * 角色编码
     */
    @Schema(description = "角色编码")
    private String code;

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
