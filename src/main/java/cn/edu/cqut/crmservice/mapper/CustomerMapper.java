package cn.edu.cqut.crmservice.mapper;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.StatisticalReport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    @Select("SELECT COUNT(*) value,cus_region item FROM customer GROUP BY cus_region;")
    List<StatisticalReport> getCustomerCountByRegion();

}
