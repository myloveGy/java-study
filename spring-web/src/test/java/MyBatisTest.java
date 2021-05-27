import com.study.my.domain.BookUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {

    @Test
    public void findOne() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行SQL语句
        BookUser user = sqlSession.selectOne("userMapper.findOne", 5);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void findAll() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行SQL语句
        List<BookUser> userList = sqlSession.selectList("userMapper.findAll");
        System.out.println(userList);
        sqlSession.close();
    }

    @Test
    public void insert() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookUser bookUser = new BookUser();
        bookUser.setUsername("jinxing.liu@qq.com");
        bookUser.setEmail("jinxing.liu@qq.com");
        bookUser.setPassword("123456");
        bookUser.setStatus(1);
        bookUser.setCreatedAt(new Date());
        int insert = sqlSession.insert("userMapper.insert", bookUser);
        sqlSession.commit();

        // 执行SQL语句
        System.out.println(insert);
    }

    @Test
    public void update() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookUser bookUser = new BookUser();
        bookUser.setUsername("jinxing-test");
        bookUser.setPassword("456789");
        bookUser.setId(5);
        int insert = sqlSession.update("userMapper.update", bookUser);
        sqlSession.commit();

        // 执行SQL语句
        System.out.println(insert);
    }

    @Test
    public void delete() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int insert = sqlSession.delete("userMapper.delete", 3);
        sqlSession.commit();

        // 执行SQL语句
        System.out.println(insert);
    }
}
