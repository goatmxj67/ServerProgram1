package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public class LoginPageService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		request.getSession().invalidate();
		ModelAndView mav = new ModelAndView("login.jsp", true);
		return mav;
		
	}

}
