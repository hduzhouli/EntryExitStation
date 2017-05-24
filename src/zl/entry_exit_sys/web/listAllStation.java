package zl.entry_exit_sys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zl.entry_exit_sys.entity.StationEntity;
import zl.entry_exit_sys.service.StationService;
import zl.entry_exit_sys.service.Imp.StationServiceImp;

public class listAllStation extends HttpServlet {

	/**
	 * @author ZHOULI
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1)读取所有基站信息
		StationService service = new StationServiceImp();
		List<StationEntity> StationList = service.findAll();
		
		//2)把数据放入域对象中
		request.setAttribute("stationList", StationList);
		
		//3)转发到jsp页面中
		request.getRequestDispatcher("/listStation.jsp").forward(request, response);
	}

	/**
	 * @author ZHOULI
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
