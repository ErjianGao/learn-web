package com.service.impl;

import com.entity.User;
import com.mysql.cj.log.Log;
import com.mysql.cj.protocol.Resultset;
import com.service.UserService;
import com.util.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

    @Override
    public List<User> listUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try(Connection connection = DataSourceUtils.getConnection();
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
        ) {
            while(rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getTimestamp("inserttime"));
                users.add(user);
            }
        } catch (SQLException e) {
            LOGGER.warning(e.getMessage());
        }
        return users;
    }

    @Override
    public void addUser(String newName) {
        // 先声明出SQL语句作为字符串方便以后作为参数传递
        // 注意这里如果在数据库中已经把某个键设置成不为空，则必须设置自增（ID）或者是默认值
        String sql = "INSERT INTO user(name) VALUES (?)";
        try(Connection connection = DataSourceUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,newName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warning(e.getMessage());
        }
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE user SET name=? WHERE id=?";
        try (Connection conn = DataSourceUtils.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1,user.getName());
            st.setInt(2,user.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warning(e.getMessage());
        }
    }

    @Override
    public User getUser(int id) {
        User user = null;
        String sql = "SELECT * FROM user WHERE id=?";
        try (//先从JNDI树中获取DS对象，然后从连接池中取连接
            Connection conn = DataSourceUtils.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1,id);
            // 由于try括号内不能执行方法，所以上一行的语句放到括号外面
            // 获取结果应该放到下面的try括号中执行
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    // 根据result对象中的get方法获取值，get后面加的是获取的数据类型
                    user = new User(rs.getInt("id"), rs.getString("name"), rs.getTimestamp("inserttime"));
                }
            }
        } catch (SQLException e) {
            LOGGER.warning(e.getMessage());
        }
        return user;
    }
}
