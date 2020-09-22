import com.lee.BeanDefinition.dao.impl.OracleUserDaoImpl;
import com.lee.BeanDefinition.dao.impl.UserDaoImpl;
import com.lee.BeanDefinition.service.impl.UserServiceImpl;

public class TestGetUser {

	//IOC
	public static void main(String[] args) {

		UserServiceImpl userService = new UserServiceImpl();
		userService.setUserDao(new UserDaoImpl());
		userService.getUser();

		userService.setUserDao(new OracleUserDaoImpl());
		userService.getUser();
	}
}
