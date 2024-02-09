package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

public class BoardLogintAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDao dao = new MemberDao();// dao 객체생성
		boolean result = dao.loginCheck(id, pw);
		
		request.setAttribute("result", result); 
		request.getSession().setAttribute("id", id);
		request.getSession().setAttribute("pw", pw);
		request.getRequestDispatcher("LoginResult.jsp").forward(request, response); //result jsp로보냄
		
	}

}
