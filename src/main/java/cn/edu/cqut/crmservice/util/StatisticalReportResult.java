package cn.edu.cqut.crmservice.util;

import java.util.List;

/**
 * @author mxw
 * @since 2023/6/11 16:08
 */
public class StatisticalReportResult {
    private List<String> items;
    private List<Long> values;

    public StatisticalReportResult(List<String> items, List<Long> values) {
        this.items = items;
        this.values = values;
    }
    public static StatisticalReportResult ok(List<String>items,List<Long> values){
        return new StatisticalReportResult(items,values);
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<Long> getValues() {
        return values;
    }

    public void setValues(List<Long> values) {
        this.values = values;
    }
}
