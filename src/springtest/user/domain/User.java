package springtest.user.domain;

/*
 * DB ������ Toby spring�� 1�忡 ���� DB ������ ������. as of 20170828.AM 09:18
 */
public class User {
	private String id;
	private String pw;
	private String name;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}