package cn.edu.cqut.crmservice.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

/**
 * @author mxw
 * @since 2023/6/6 16:20
 */
public class Generator {
  public static void main(String[] args) {
    FastAutoGenerator.create(
            "jdbc:mysql://localhost:3306/crmdb?serverTimezone=Asia/Shanghai", "root", "hy7631")
        .globalConfig(
            builder -> {
              builder
                  .author("CQUT") // 设置作者
                  .outputDir("D:\\Practice\\CRMService\\src\\main\\java"); // 指定输出目录
            })
        .packageConfig(
            builder -> {
              builder.parent("cn.edu.cqut.crmservice"); // 设置父包名
            })
        .strategyConfig(
            builder -> {
              builder.addInclude("customer_loss"); // 设置需要生成的表名
            })
        .execute();
  }
}
