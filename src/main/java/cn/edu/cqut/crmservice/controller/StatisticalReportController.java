package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.StatisticalReport;
import cn.edu.cqut.crmservice.service.ICustomerService;
import cn.edu.cqut.crmservice.util.StatisticalReportResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mxw
 * @since 2023/6/11 16:04
 */
@RestController // 给前端返回JSON数据
@RequestMapping("/statisticalReport")
@CrossOrigin // 允许跨域请求
public class StatisticalReportController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/getCustomerCountByRegion")
    public StatisticalReportResult getCustomerCountByRegion (){
        List<StatisticalReport> statisticalReports = customerService.getCustomerCountByRegion();
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for(StatisticalReport report:statisticalReports){
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return StatisticalReportResult.ok(items,values);
    }
}
