package com.example.web.dao;

import com.example.web.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    /**
     * 操作SQL的对象
     */
    private final QueryRunner queryRunner = new QueryRunner();

    /**
     * 新增、修改、删除数据
     *
     * @param sql  执行的SQL
     * @param args 绑定的参数
     * @return 返回的受影响的行数
     */
    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return -1;
    }

    /**
     * 查询单条数据
     *
     * @param type 返回的数据类型
     * @param sql  执行的SQL
     * @param args 绑定的参数
     * @param <T>  类型
     * @return 类型
     */
    public <T> T one(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

    /**
     * 查询多条数据
     *
     * @param type 返回的数据类型
     * @param sql  执行的SQL
     * @param args 绑定的参数
     * @param <T>  类型
     * @return 类型
     */
    public <T> List<T> all(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

    /**
     * 查询单个字段数据
     *
     * @param sql  执行的SQL
     * @param args 绑定的参数
     * @return 类型
     */
    public Object value(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }
}
