package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class LoginService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		MemberDTO loginDTO = MemberDAO.getInstance().login(id, name);
		if (loginDTO != null) {
			request.getSession().setAttribute("loginDTO", loginDTO);
			mav = new ModelAndView("manager.jsp", true);
		} else {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('아이디와 비밀번호를 확인하세요')");
				out.println("history.back()");
				out.println("</script>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mav;
	}

}
