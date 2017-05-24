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

public class updateStation extends HttpServlet {

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
		
		//�����ݷ�װ��EntryExitRecord����
		StationEntity sationEntity = new StationEntity();
		sationEntity.setId(id);
		sationEntity.setCity(city);
		sationEntity.setRegion(region);
		sationEntity.setStation(station);
		
		//2)�����ݱ��浽���ݿ�
		StationService service = new StationServiceImp();
		service.update(sationEntity);
		
		//3)��ת����ѯ��ϵ��ҳ��
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
