package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class SelectListService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		long no = Long.parseLong(request.getParameter("no"));
		
		MemberDTO dto = MemberDAO.getInstance().selectListByNo(no);
		
		request.setAttribute("dto", dto);
	
		ModelAndView mav = new ModelAndView("list.jsp", false);
		return mav;
		
	}

}