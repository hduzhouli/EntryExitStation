package zl.entry_exit_sys.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zl.entry_exit_sys.entity.EntryExitRecord;
import zl.entry_exit_sys.service.EntryExitService;
import zl.entry_exit_sys.service.Imp.EntryExitServiceImp;

public class updateRecordServlet extends HttpServlet {

	/**
	 * @author ZHOULI
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//1)���ձ�������
		String id = request.getParameter("id");
		String city = request.getParameter("city");
		String region = request.getParameter("region");
		String station = request.getParameter("station");
		String entry_time = request.getParameter("entry_time");
		String exit_time = request.getParameter("exit_time");
		String reason = request.getParameter("reason");
		String phone = request.getParameter("phone");
		
		//�����ݷ�װ��EntryExitRecord����
		EntryExitRecord record = new EntryExitRecord();
		record.setId(id);
		record.setCity(city);
		record.setRegion(region);
		record.setStation(station);
		record.setEntry_time(entry_time);
		record.setExit_time(exit_time);
		record.setReason(reason);
		record.setPhone(phone);
		
		//2)�����ݱ��浽���ݿ�
		EntryExitService service = new EntryExitServiceImp();
		service.update(record);
		
		//3)��ת����ѯ��ϵ��ҳ��
		response.sendRedirect(request.getContextPath()+"/listAllServlet");
	}

	/**
	 * @author ZHOULI
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
