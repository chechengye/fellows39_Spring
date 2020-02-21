package com.weichuang.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.weichuang.aop.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 测试JDBC相关
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/weichuang/jdbc/applicationContext.xml")
public class JdbcDemo {

    @Autowired
    JdbcTemplate jt;
    @Test
    public void testFn(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //JdbcTemplate与DBUtils下面的QueryRunner
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        List<User> userList = jt.query("select * from t_user", new RowMapper<User>() {//参数式匿名内部类
            //while(rs.next)
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        });
        System.out.println(userList);
    }

    @Test
    public void testFn1(){
        int rows = jt.update("update t_user set username = ? where id = ?", "zhaoliu", 1);
        if(rows > 0){
            System.out.println("更新成功！");
        }
    }
}
