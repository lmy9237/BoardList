package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.*;

@WebServlet("/Controller")     
public class ExController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String command = request.getParameter("command");
		Action action = null;
		
		switch(command) {
		case "board_list": action = new BoardListAction(); break;
		case "board_write_form": action = new BoardWriteFormAction(); break;
		case "board_write_action": action = new BoardWriteAction(); break;
		case "board_detail": action = new BoardDetailAction(); break;
		case "board_delete": action = new BoardDeleteAction(); break;
		case "board_modify_form": action = new BoardModifyFormAction(); break;
		case "board_modify_action": action = new BoardModifyAction(); break;
		case "board_login" : action = new BoardLogintAction(); break;
		case "board_logout" : action = new BoardLogoutAction(); break;
		case "board_join" : action = new BoardJoinAction(); break;
		
		}
		action.execute(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}






