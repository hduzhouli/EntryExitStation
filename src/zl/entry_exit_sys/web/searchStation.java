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

public class searchStation extends HttpServlet {

	/**
	 * @author ZHOULI
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1)接收需要修改的id
		String id = request.getParameter("id");
		
		//2)查询对应的联系人
		StationService service = new StationServiceImp();
		StationEntity stationEntity = service.findById(id);
		
		//3)把数据转发到jsp页面
		request.setAttribute("stationEntity", stationEntity);
		request.getRequestDispatcher("/editStation.jsp").forward(request, response);
	}

	/**
	 * @author ZHOULI
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
