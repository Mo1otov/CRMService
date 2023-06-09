package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Services;
import cn.edu.cqut.crmservice.service.IServicesService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQUT
 * @since 2023-06-08
 */
@RestController // 给前端返回JSON数据
@RequestMapping("/services")
@CrossOrigin // 允许跨域请求
public class ServicesController {
    @Autowired // 自动从Spring容器中获取对象给变量赋值
    private IServicesService servicesService;

    /**
     *
     * @param limit 每页行数
     * @param page 显示第几页
     * @return TableResult
     */
    @GetMapping("/getServiceList")
    public TableResult<Services> getServicesList(Integer limit, Integer page) {
        Page<Services> servicesPage = new Page<>(page, limit);
        Page<Services> page1 = servicesService.page(servicesPage); // 调用service层的page方法,返回分页
        // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
        return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
    }

    @PostMapping("/updateService")
    public TableResult<Services> updateService(Services service) {
        servicesService.updateById(service);
        return TableResult.ok("修改服务信息成功");
    }

    @PostMapping("/addService")
    public TableResult<Services> addService(Services service) {
        service.setSerState("新创建");
        servicesService.save(service);
        return TableResult.ok("新增服务信息成功");
    }

    @PostMapping("/deleteServices")
    public TableResult<Services> deleteService(Integer[] ids) { // 参数名要和前端ajax方法中data参数的属性名要一致
        servicesService.removeByIds(Arrays.asList(ids)); // asList方法把数组转成list
        return TableResult.ok("删除服务信息成功");
    }
}
