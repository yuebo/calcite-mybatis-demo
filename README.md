跨源Join
--------------
该例子提供了一个多源数据通过calcite进行关联查询的例子，calcite的join是基于内存的，join时请限制数据量，否则容易oom。
# 数据源配置
```yaml
spring:
    datasource:
      driver-class-name: org.apache.calcite.jdbc.Driver
      url: "jdbc:calcite:"
      druid:
        connect-properties:
          lex: MYSQL
          model: |-
            inline:
            {
              "defaultSchema": "db1",
              "schemas": [
                {
                  "factory": "org.apache.calcite.adapter.jdbc.JdbcSchema$Factory",
                  "name": "db1",
                  "operand": {
                    "jdbcDriver": "com.mysql.cj.jdbc.Driver",
                    "jdbcPassword": "test",
                    "jdbcUrl": "jdbc:mysql://localhost:3306/user_service",
                    "jdbcUser": "root"
                  },
                  "type": "custom"
                },
                {
                  "name": "db2",
                  "operand": {
                    "jdbcDriver": "oracle.jdbc.OracleDriver",
                    "jdbcPassword": "test",
                    "jdbcUrl": "jdbc:oracle:thin:@//localhost:1521/test",
                    "jdbcUser": "test"
                  },
                  "type": "custom",
                  "factory": "org.apache.calcite.adapter.jdbc.JdbcSchema$Factory"
                }
              ],
              "version": "1.0"
            }
```

通过`model`属性可以设置多个数据源，通过指定数据源name作为schema，剩下的就和普通Mybatis一样使用了。