package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.StatisticalReport;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 服务类
 *
 * @author CQUT
 * @since 2023-06-09
 */
public interface ICustomerService extends IService<Customer> {
    List<StatisticalReport> getCustomerCountByRegion();

}
