package xianming.shop.model;

public class SystemContext {
	private static ThreadLocal<User> loginUser = new ThreadLocal<User>();
	
	public static User getLoginUser() {
		return loginUser.get();
	}
	public static void setLoginUser(User _loginUser) {
		loginUser.set(_loginUser);
	}
	public static void removeLoginUser(){
		loginUser.remove();
	}
}
