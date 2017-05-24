package zl.entry_exit_sys.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zl.entry_exit_sys.service.StationService;
import zl.entry_exit_sys.service.Imp.StationServiceImp;
import zl.entry_exit_sys.util.QRUtil;

public class ShowQRServlet extends HttpServlet {

	/**
	 * @author ZHOULI
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String city = request.getParameter("city");
		String region = request.getParameter("region");
		String station = request.getParameter("station");
		
		StationService service = new StationServiceImp();
		String fileId = service.getId(station);
		
		String fileName = fileId + ".png";
	
		
		String path = request.getSession().getServletContext().getRealPath("") + "/img/" + fileName;
		
		String localHostAddr = InetAddress.getLocalHost().getHostAddress();	
		String url = "http://";
		url += localHostAddr + ":8080" + request.getContextPath() + "/login?id=" + fileId;
		
		QRUtil.generateQRtoFile(url, 500, 500, "png", new File(path));
		
		request.setAttribute("filename", fileName);
		request.getRequestDispatcher("/ShowQR.jsp").forward(request, response);
		
		
//		response.getWriter().write(request.getContextPath());
//		response.getWriter().write(request.getRequestURI());
//		response.getWriter().write(request.getServletPath());
//		response.getWriter().write(new File(path).getPath());
//		response.getWriter().write(request.getSession().getServletContext().getRealPath(""));
	}

	/**
	 * @author ZHOULI
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
