package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.service.ICustomerService;
import cn.edu.cqut.crmservice.util.Auth;
import cn.edu.cqut.crmservice.util.TableResult;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

/**
 * 前端控制器
 *
 * @author CQUT
 * @since 2023-06-09
 */
@RestController // 给前端返回JSON数据
@RequestMapping("/customer")
@CrossOrigin // 允许跨域请求
public class CustomerController {
    @Autowired // 自动从Spring容器中获取对象给变量赋值
    private ICustomerService customerService;

    /**
     * @param limit 每页行数
     * @param page 显示第几页
     * @return TableResult
     */
    @GetMapping("/getCustomerList")
    @Auth(roles = "SALES")
    public TableResult<Customer> getCustomerList(
            Integer limit, Integer page, HttpServletRequest request) {
        System.out.println(request.getAttribute("suId"));
        System.out.println(request.getAttribute("suName"));
        System.out.println(request.getAttribute("suRole"));
        Page<Customer> customerPage = new Page<>(page, limit);
        Page<Customer> page1 = customerService.page(customerPage); // 调用service层的page方法,返回分页
        // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
        return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
    }

    @Auth(roles = "SALES")
    @PostMapping("/updateCustomer")
    public TableResult<Customer> updateCustomer(Customer customer) {
        customerService.updateById(customer);
        return TableResult.ok("修改客户信息成功");
    }

    @Auth(roles = "SALES")
    @PostMapping("/addCustomer")
    public TableResult<Customer> addCustomer(Customer customer) {
        customerService.save(customer);
        return TableResult.ok("新增客户信息成功");
    }

    @Auth(roles = "SALES")
    @PostMapping("/deleteCustomer")
    public TableResult<Customer> deleteCustomer(Integer[] ids) { // 参数名要和前端ajax方法中data参数的属性名要一致
        customerService.removeByIds(Arrays.asList(ids)); // asList方法把数组转成list
        return TableResult.ok("删除客户信息成功");
    }
}
