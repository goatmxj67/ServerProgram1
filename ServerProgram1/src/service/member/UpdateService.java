package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class UpdateService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		int point = Integer.parseInt(request.getParameter("point"));
		MemberDTO loginDTO = (MemberDTO)request.getSession().getAttribute("loginDTO");
		MemberDTO dto = new MemberDTO();
		dto.setNo(loginDTO.getNo());
		dto.setName(name);
		dto.setPoint(point);
		String grade = null;
		if (point < 3000) {
			grade = "bronze";
		} else if (point < 4000) {
			grade = "silver";
		} else if (point < 5000) {
			grade = "gold";
		} else {
			grade = "vip";
		}
		dto.setGrade(grade);
		int result = MemberDAO.getInstance().updateMember(dto);
		try {
			if (result > 0) {
				loginDTO.setName(name);
				loginDTO.setPoint(point);
				loginDTO.setGrade(grade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("manager.jsp", true);
		return mav;
	}

}
