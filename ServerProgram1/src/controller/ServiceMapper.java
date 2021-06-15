package controller;

import service.member.JoinPageService;
import service.member.JoinService;
import service.member.LeaveService;
import service.member.LoginPageService;
import service.member.LoginService;
import service.member.LogoutService;
import service.member.MemberListService;
import service.member.MemberService;
import service.member.UpdateService;

public class ServiceMapper {

	private static ServiceMapper instance = new ServiceMapper();
	private ServiceMapper() {}
	public static ServiceMapper getInstance() {
		if (instance == null) {
			instance = new ServiceMapper();
		}
		return instance;
	}
	
	public MemberService getService(String command) {
		MemberService service = null;
		switch (command) {
		case "list.do":
			service = new MemberListService();
			break;
		case "loginPage.do":
			service = new LoginPageService();
			break;
		case "login.do":
			service = new LoginService();
			break;
		case "logout.do":
			service = new LogoutService();
			break;
		case "joinPage.do":
			service = new JoinPageService();
			break;
		case "join.do":
			service = new JoinService();
			break;
		case "update.do":
			service = new UpdateService();
			break;
		case "delete.do":
			service = new LeaveService();
			break;
		}
		
		return service;
	}
	
}
