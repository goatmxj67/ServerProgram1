package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class JoinService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setName(name);
		int result = MemberDAO.getInstance().insertMember(dto);
		try {
			if (result > 0) {
				PrintWriter out = response.getWriter();
				out.write("<h1>가입되었습니다.</h1>");
				out.write("<a href=\"loginPage.do\">로그인</a>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
