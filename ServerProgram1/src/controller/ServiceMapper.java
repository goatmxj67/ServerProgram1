package controller;

import service.member.DeleteService;
import service.member.LoginService;
import service.member.ManagerService;
import service.member.MemberService;
import service.member.SelectListService;

public class ServiceMapper {

	private static ServiceMapper instance = new ServiceMapper();
	private ServiceMapper() {}
	public static ServiceMapper getInstance() {
		if (instance == null) {
			instance = new ServiceMapper();
		}
		return instance;
	}
	
	public MemberService getService(String svc) {
		MemberService service = null;
		switch (svc) {
		case "list.do":
			service = new SelectListService();
			break;
		case "login.do":
			service = new LoginService();
			break;
		case "manager.do":
			service = new ManagerService();
			break;
		case "delete.do":
			service = new DeleteService();
			break;
		}
		
		return service;
	}
	
	
	
	
	
	
	
	
	
	
}