package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

public class BoardJoinAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("UTF-8");
	   String id = request.getParameter("id");
       String password = request.getParameter("pw");
       String name = request.getParameter("name");
       
       MemberDao dao = new MemberDao();
       dao.join(id,password,name); // insert로 새회원등록
       request.getRequestDispatcher("login.jsp").forward(request, response);		
	}

}
