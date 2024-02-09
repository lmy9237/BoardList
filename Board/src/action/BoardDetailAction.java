package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import vo.BoardVo;
import vo.ReplyVo;

public class BoardDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = new BoardDao();
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardVo boardVO = boardDao.getBoardVOByBno(bno);
		ArrayList<ReplyVo> listReply = boardDao.getReplyListByBno(bno);
		
		request.setAttribute("boardVO", boardVO);
		request.setAttribute("listReply", listReply);
		RequestDispatcher rd = request.getRequestDispatcher("board_detail.jsp");
		rd.forward(request, response);

	}

}
