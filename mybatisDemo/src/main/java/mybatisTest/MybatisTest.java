package mybatisTest;

import mybatisTest.bean.User;
import mybatisTest.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
	private static SqlSessionFactory sqlSessionFactory;

	static {
		// 指定全局配置文件
		String resource = "mybatis-config.xml";
		// 读取配置文件
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			// 构建sqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// 获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
		// 第二个参数：指定传入sql的参数：这里是用户id
		User user = sqlSession.selectOne("MyMapper.selectUser");
		System.out.println(user.toString());
	}

	@Test
	public void findById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao dao = sqlSession.getMapper(UserDao.class);
		User user = dao.findById(2);
		System.out.println(user);
	}

}
