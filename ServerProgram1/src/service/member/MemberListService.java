package service.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class MemberListService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
				
		List<MemberDTO> list = MemberDAO.getInstance().selectAll();
		request.setAttribute("list", list);
		ModelAndView mav = new ModelAndView("list.jsp", false);
		return mav;
		
	}

}