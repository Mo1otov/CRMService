package cn.edu.cqut.crmservice.entity;

import java.io.Serializable;

/**
 * @author mxw
 * @since 2023/6/11 15:48
 */
public class StatisticalReport implements Serializable {
    private String item;
    private Long value;

    public StatisticalReport(String item, Long value) {
        this.item = item;
        this.value = value;
    }

    public StatisticalReport() {
    }

    @Override
    public String toString() {
        return "StatisticalReport{" + "item='" + item + '\'' + ", value=" + value + '}';
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
