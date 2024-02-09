package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import vo.BoardVo;

public class BoardListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = new BoardDao();
		ArrayList<BoardVo> listBoard = null;
		
		int pageNum = 1;
		try {
			pageNum = Integer.parseInt(request.getParameter("page"));
		} catch(NumberFormatException e) { }
		
		listBoard = boardDao.getAllList(pageNum);
		
		int p = (pageNum/5)*5 - (pageNum%5==0 ? 5 : 0);
		int startPNum = p + 1; // 1;  ////
		int endPNum = p + 5; // 5; //////
		int lastPageNum = boardDao.getLastPageNum();
		
		request.setAttribute("listBoard", listBoard);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPNum", startPNum);
		request.setAttribute("endPNum", endPNum);
		request.setAttribute("lastPageNum", lastPageNum);
		
		RequestDispatcher rd = request.getRequestDispatcher("board_list.jsp");
		rd.forward(request, response);
	}
}
