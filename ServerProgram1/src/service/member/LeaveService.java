package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class LeaveService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		int no = ((MemberDTO)request.getSession().getAttribute("loginDTO")).getNo();
		int result = MemberDAO.getInstance().deleteMember(no);
		try {
			PrintWriter out = response.getWriter();
			if (result > 0) {
				request.getSession().invalidate();
				out.println("<h1>탈퇴되었습니다.</h1>");
				out.println("<a href=\'joinPage.do\'>회원가입</a>");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
