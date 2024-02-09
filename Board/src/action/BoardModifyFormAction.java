package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import vo.BoardVo;

public class BoardModifyFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		BoardDao bDao = new BoardDao();
		BoardVo vo = bDao.getBoardVOByBno(bno);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("board_modify.jsp").forward(request, response);
	}
}
