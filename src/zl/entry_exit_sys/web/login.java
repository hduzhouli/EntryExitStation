package zl.entry_exit_sys.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zl.entry_exit_sys.entity.StationEntity;
import zl.entry_exit_sys.service.StationService;
import zl.entry_exit_sys.service.Imp.StationServiceImp;

public class login extends HttpServlet {

	/**
	 * @author ZHOULI
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决乱码问题
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		//获取基站信息
		StationService service = new StationServiceImp();
		StationEntity stationEntity = service.findById(id);
		
		request.getSession().setAttribute("stationEntity", stationEntity);
		response.sendRedirect(request.getContextPath()+"/login.jsp");
//		request.setAttribute("stationEntity", stationEntity);
//		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @author ZHOULI
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
