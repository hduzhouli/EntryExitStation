package zl.entry_exit_sys.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zl.entry_exit_sys.entity.EntryExitRecord;
import zl.entry_exit_sys.entity.StationEntity;
import zl.entry_exit_sys.service.EntryExitService;
import zl.entry_exit_sys.service.Imp.EntryExitServiceImp;

public class loginOutStationServlet extends HttpServlet {

	/**
	 * @author ZHOULI
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取手机号码
		String phone = request.getParameter("phone");
		
		//获取基站信息
		StationEntity stationEntity = (StationEntity)request.getSession().getAttribute("stationEntity");
		
		//根据手机号查询对应基站的进站记录
		EntryExitService service = new EntryExitServiceImp();
		EntryExitRecord record = service.findByStationPhone(stationEntity, phone);
		
		//出站登记
		service.logout(record);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("OK!");
	}

	/**
	 * @author ZHOULI
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
