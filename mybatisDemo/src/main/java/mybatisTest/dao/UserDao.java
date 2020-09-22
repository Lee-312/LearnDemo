package mybatisTest.dao;

import mybatisTest.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

	@Select("select * from sys_user where user_id = #{id}")
	public User findById(int id);
}
