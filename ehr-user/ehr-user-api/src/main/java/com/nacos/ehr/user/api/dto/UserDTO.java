package com.nacos.ehr.user.api.dto;

import com.nacos.ehr.user.api.entity.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author yangbin
 * @date 2019年09月06日
 * <p>
 * ehr
 */
@Data
@ApiModel(value = "系统用户传输对象")
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends SysUser {
    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色id集合")
    private List<Integer> role;
    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Integer deptId;
    /**
     * 新密码
     */
    @ApiModelProperty(value = "新密码")
    private String newpassword1;
}
