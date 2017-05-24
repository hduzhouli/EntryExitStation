package zl.entry_exit_sys.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zl.entry_exit_sys.service.EntryExitService;
import zl.entry_exit_sys.service.Imp.EntryExitServiceImp;

public class delEntityServlet extends HttpServlet {

	/**
	 * @author ZHOULI
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//解决乱码问题
		request.setCharacterEncoding("utf-8");
		
		//获取id
		String id = request.getParameter("id");
		
		EntryExitService service = new EntryExitServiceImp();
		service.delete(id);
		
		response.sendRedirect(request.getContextPath()+"/listAllServlet");
	}

	/**
	 * @author ZHOULI
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
