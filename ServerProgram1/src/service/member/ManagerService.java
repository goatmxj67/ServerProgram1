package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class ManagerService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		long point = Long.parseLong(request.getParameter("point"));
		HttpSession session = request.getSession();
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("loginDTO");
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setPoint(point);
		dto.setNo(loginDTO.getNo());
		int result = MemberDAO.getInstance().updateMember(dto);
		try {
			PrintWriter out = response.getWriter();
			if (result > 0) {
				loginDTO.setName(name);
				loginDTO.setPoint(point);
				out.println("<script>");
				out.println("alert('회원정보가 수정되었습니다.')");
				out.println("location.href = 'ServerProgram1/manager.do'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('수정할 내용이 없습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}