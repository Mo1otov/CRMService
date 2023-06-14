package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Contact;
import cn.edu.cqut.crmservice.entity.SysUser;
import cn.edu.cqut.crmservice.service.ISysUserService;
import cn.edu.cqut.crmservice.util.Auth;
import cn.edu.cqut.crmservice.util.JWTUtil;
import cn.edu.cqut.crmservice.util.TableResult;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前端控制器
 *
 * @author CQUT
 * @since 2023-06-11
 */
@RestController
@RequestMapping("/sysUser")
@CrossOrigin
public class SysUserController {

    @Autowired private ISysUserService sysUserService;
    @Autowired private JWTUtil jwtUtil;

    @PostMapping("/login")
    public TableResult<SysUser> login(SysUser sysUser) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>(sysUser);
        SysUser user = sysUserService.getOne(wrapper);
        if (user != null) {
            String token = jwtUtil.createJwt(user); // 生成token
            return TableResult.ok(token, user);
        } else {
            return TableResult.error(1, "用户名或密码错误");
        }
    }

    @GetMapping("/getSalesList")
    @Auth(roles = "SUPERVISOR")
    public TableResult<SysUser> getSaleList() {
        // 条件查询
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("su_role", "SALES"); // 第一个参数是字段名
        // wrapper.or().eq() ，wrapper默认是and 需要eq前用or才能使用sql的or
        List<SysUser> userList = sysUserService.list(wrapper);
        // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
        return TableResult.ok("查询成功",userList.size(),userList);
    }
}
