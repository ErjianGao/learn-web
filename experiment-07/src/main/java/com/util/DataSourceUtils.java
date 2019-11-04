package com.util;

import javax.annotation.Resource;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/** 由于数据库操作会贯穿整个应用的生命周期，
 * 因此，数据源对象应与应用生命周期绑定，
 * 因此，创建应用启动监听器获取数据源对象
 */
@WebListener
public class DataSourceUtils implements ServletContextListener {
    // 从JNDI树中自动注入指定名称对象
    @Resource(name = "jdbc/MySQL")
    // 容器自动创建DataSource数据源对象
    private static DataSource dataSource;
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
