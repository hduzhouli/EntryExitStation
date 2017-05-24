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

public class addStationServlet extends HttpServlet {

	/**
	 * @author ZHOULI
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决乱码问题
		request.setCharacterEncoding("utf-8");
		
		//获取网页信息
		String city = request.getParameter("city");
		String region = request.getParameter("region");
		String station = request.getParameter("station");
		
		//封装StationEntity实体
		StationEntity stationEntity = new StationEntity();		
		stationEntity.setCity(city);
		stationEntity.setRegion(region);
		stationEntity.setStation(station);
		
		//添加站点
		StationService service = new StationServiceImp();
		service.add(stationEntity);
		
		response.sendRedirect(request.getContextPath()+"/listAllStation");
	}

	/**
	 * @author ZHOULI
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
