package zl.entry_exit_sys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zl.entry_exit_sys.entity.EntryExitRecord;
import zl.entry_exit_sys.service.EntryExitService;
import zl.entry_exit_sys.service.Imp.EntryExitServiceImp;

public class listAllServlet extends HttpServlet {

	/**
	 * @author ZHOULI
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1)��ȡ���н�����վ��¼
		EntryExitService service = new EntryExitServiceImp();
		List<EntryExitRecord> recordList = service.findAll();
		
		//2)�����ݷ����������
		request.setAttribute("recordList", recordList);
		
		//3)ת����jspҳ����
		request.getRequestDispatcher("/listCon.jsp").forward(request, response);
	}

	/**
	 * @author ZHOULI
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request,response);
	}

}
