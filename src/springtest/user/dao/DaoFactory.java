package springtest.user.dao;


public class DaoFactory {
	public UserDao userDao(){
		UserDao dao = new UserDao();
		dao.setConnectionMaker(connectionMaker());
		return dao;
	}
	
	public ConnectionMaker connectionMaker(){
		return new NConnectionMaker();
	}
}
