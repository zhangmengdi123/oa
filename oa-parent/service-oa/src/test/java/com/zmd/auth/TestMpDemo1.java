package com.zmd.auth;

import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zmd.auth.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class TestMpDemo1 {

    @Autowired(required=false)
    private SysRoleMapper mapper;
    @Test
    public  void getAll(){
        List<SysRole> list = mapper.selectList(null);
        System.out.println(list);
    }
    @Test

    public void testInsert(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");

        int result = mapper.insert(sysRole);
        System.out.println(result); //影响的行数
        System.out.println(sysRole); //id自动回填
    }
    @Test//修改操作
    public void testUpdateById(){
        SysRole sysRole = mapper.selectById(9);

        sysRole.setRoleName("角色管理员1");

        int result = mapper.updateById(sysRole);
        System.out.println(result);

    }
    /**
     * application-dev.yml 加入配置
     * 此为默认值，如果你的默认值和mp默认的一样，则不需要该配置
     * mybatis-plus:
     *   global-config:
     *     db-config:
     *       logic-delete-value: 1
     *       logic-not-delete-value: 0
     */
    @Test
    public void testDeleteById(){
        int result = mapper.deleteById(9);
        System.out.println(result);
    }
    @Test//批量删除
    public void testDeleteBatchIds() {
        int result = mapper.deleteBatchIds(Arrays.asList(1, 1));
        System.out.println(result);
    }
    //条件查询
    @Test
    public void testSelect1() {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_name", "用户管理员");
        List<SysRole> users = mapper.selectList(queryWrapper);
        System.out.println(users);
    }
    @Test
    public void testSelect2() {
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRole::getRoleCode, "role");
        List<SysRole> users = mapper.selectList(queryWrapper);
        System.out.println(users);
    }

}
