package springtest.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
	 Connection connectionMaker() throws SQLException;
}
