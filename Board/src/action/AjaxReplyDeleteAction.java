package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.BoardDao;

public class AjaxReplyDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax reply delete action 들어옴.");
		int rno = Integer.parseInt(request.getParameter("rno"));
		System.out.println("삭제할 rno : " + rno);
		
		BoardDao bDao = new BoardDao();
		boolean result = bDao.replyDeleteByRno(rno);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		if(result) {
			obj.put("result", "OKAY");
		} else {
			obj.put("result", "FAIL");
		}
		out.println(obj);		
	}
}




