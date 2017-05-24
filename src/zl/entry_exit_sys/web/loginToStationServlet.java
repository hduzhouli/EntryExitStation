package zl.entry_exit_sys.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zl.entry_exit_sys.service.EntryExitService;
import zl.entry_exit_sys.service.Imp.EntryExitServiceImp;
import zl.entry_exit_sys.entity.EntryExitRecord;;

public class loginToStationServlet extends HttpServlet {

	/**
	 * @author ZHOULI
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决乱码问题
		request.setCharacterEncoding("utf-8");
		
		String city = request.getParameter("city");
		String region = request.getParameter("region");
		String station = request.getParameter("station");
		String reason = request.getParameter("reason");
		String phone = request.getParameter("phone");		

		
		EntryExitRecord record = new EntryExitRecord();
		record.setCity(city);
		record.setRegion(region);
		record.setStation(station);
		record.setReason(reason);
		record.setPhone(phone);
		
		EntryExitService service = new EntryExitServiceImp();
		service.add(record);
		
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
