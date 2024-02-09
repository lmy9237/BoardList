package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import vo.BoardVo;

public class BoardModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardVo vo = new BoardVo(bno, title, content, null, null, 0);   // 0 --> nor(무의미)
		BoardDao bDao = new BoardDao();
		bDao.update(vo);
		
		request.setAttribute("msg", "수정되었습니다.");
		request.getRequestDispatcher("Controller?command=board_list").forward(request, response);
	}

}
