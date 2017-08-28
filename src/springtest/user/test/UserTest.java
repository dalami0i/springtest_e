package springtest.user.test;

import springtest.user.dao.UserDao;
import springtest.user.domain.User;

public class UserTest {
	public static void main (String[] args){
		UserDao dao = new UserDao();
		
		User user = new User();
		
		user.setId("aaa");
		user.setName("Ace");
		user.setPw("aaa");
		
		dao.deleteAll();
		int count = dao.getCount();
		
		dao.insert(user);
		
		User user2 = dao.getUser(user.getId());
		System.out.printf("user id: %s  user2 id: %s\n", user.getId(), user2.getId());
		count = dao.getCount();
		System.out.printf("입력된 item의 수: %d\n", count);
		dao.deleteAll();
		count = dao.getCount();
		System.out.printf("입력된 item의 수: %d\n", count);
	}

}
