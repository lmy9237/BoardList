package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;

public class BoardWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		BoardDao bDao = new BoardDao();
		bDao.write(title, content, writer);
		
		request.setAttribute("msg", "등록되었습니다");
		request.getRequestDispatcher("Controller?command=board_list").forward(request, response);
	}

}
