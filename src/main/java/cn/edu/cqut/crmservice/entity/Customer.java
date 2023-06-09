package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户编号
     */
    @TableId(value = "cus_id", type = IdType.AUTO)
    private Integer cusId;

    /**
     * 客户名称
     */
    private String cusName;

    /**
     * 客户地区： 东北、西北、华北、华中、西南、华东
     */
    private String cusRegion;

    /**
     * 客户行业：教育、医疗、金融、制造、服务
     */
    private String cusIndustry;

    /**
     * 客户等级：大客户、普通客户、VIP客户
     */
    private String cusLevel;

    /**
     * 客户评分：1，2，3，4，5
     */
    private Integer cusRate;

    /**
     * 信用等级：1，2，3，4，5
     */
    private Integer cusCredit;

    /**
     * 客户地址
     */
    private String cusAddr;

    /**
     * 客户邮编
     */
    private String cusPostcode;

    /**
     * 客户电话
     */
    private String cusPhone;

    /**
     * 客户网址
     */
    private String cusUrl;

    /**
     * 客户传真
     */
    private String cusFax;

    /**
     * 客户的销售员
     */
    private String cusSalesman;

    /**
     * 客户状态：正常、流失
     */
    private String cusState;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusRegion() {
        return cusRegion;
    }

    public void setCusRegion(String cusRegion) {
        this.cusRegion = cusRegion;
    }

    public String getCusIndustry() {
        return cusIndustry;
    }

    public void setCusIndustry(String cusIndustry) {
        this.cusIndustry = cusIndustry;
    }

    public String getCusLevel() {
        return cusLevel;
    }

    public void setCusLevel(String cusLevel) {
        this.cusLevel = cusLevel;
    }

    public Integer getCusRate() {
        return cusRate;
    }

    public void setCusRate(Integer cusRate) {
        this.cusRate = cusRate;
    }

    public Integer getCusCredit() {
        return cusCredit;
    }

    public void setCusCredit(Integer cusCredit) {
        this.cusCredit = cusCredit;
    }

    public String getCusAddr() {
        return cusAddr;
    }

    public void setCusAddr(String cusAddr) {
        this.cusAddr = cusAddr;
    }

    public String getCusPostcode() {
        return cusPostcode;
    }

    public void setCusPostcode(String cusPostcode) {
        this.cusPostcode = cusPostcode;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusUrl() {
        return cusUrl;
    }

    public void setCusUrl(String cusUrl) {
        this.cusUrl = cusUrl;
    }

    public String getCusFax() {
        return cusFax;
    }

    public void setCusFax(String cusFax) {
        this.cusFax = cusFax;
    }

    public String getCusSalesman() {
        return cusSalesman;
    }

    public void setCusSalesman(String cusSalesman) {
        this.cusSalesman = cusSalesman;
    }

    public String getCusState() {
        return cusState;
    }

    public void setCusState(String cusState) {
        this.cusState = cusState;
    }

    @Override
    public String toString() {
        return "Customer{" +
        "cusId = " + cusId +
        ", cusName = " + cusName +
        ", cusRegion = " + cusRegion +
        ", cusIndustry = " + cusIndustry +
        ", cusLevel = " + cusLevel +
        ", cusRate = " + cusRate +
        ", cusCredit = " + cusCredit +
        ", cusAddr = " + cusAddr +
        ", cusPostcode = " + cusPostcode +
        ", cusPhone = " + cusPhone +
        ", cusUrl = " + cusUrl +
        ", cusFax = " + cusFax +
        ", cusSalesman = " + cusSalesman +
        ", cusState = " + cusState +
        "}";
    }
}
