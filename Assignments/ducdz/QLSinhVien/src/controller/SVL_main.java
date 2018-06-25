package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.SinhVien;
import model.SinhVienDAO;

/**
 * Servlet implementation class SVL_main
 */
public class SVL_main extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String  UPLOAD_DIR = "images";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SVL_main() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		String action = request.getPathInfo();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertSV(request, response);
				break;
			case "/delete":
				deleteSV(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateSV(request,response);
				break;
			case"/pagination":
				allSV(request,response);
				break;
			default:
				listSV(request, response);
				break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void allSV(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String pageid = request.getParameter("pid");
		int pid = Integer.parseInt(pageid);
		int total = 5;
		int sodu = (SinhVienDAO.soTrang()%total);
		int soTrang = 0;
		if(sodu == 0) {
			soTrang = (SinhVienDAO.soTrang()/total);
		}
		else {
			soTrang = (SinhVienDAO.soTrang()/total+1);
		}
		if(pid == 1) {
		}
		else {
			pid = pid - 1;
			pid = (pid * total) + 1;
		}
		List<SinhVien> listSV = SinhVienDAO.getRecord(pid, total);
		RequestDispatcher dpc = request.getRequestDispatcher("/index.jsp");
		request.setAttribute("soTrang", soTrang);
		request.setAttribute("sv", listSV);
		request.setAttribute("pageid", pageid);
		try {
			dpc.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void updateSV(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String ten = request.getParameter("ten");
		String ngaysinh = request.getParameter("ngaysinh");
		String quequan = request.getParameter("quequan");
		String gioitinh = request.getParameter("gioitinh");
		String lop = request.getParameter("lop");
		String photo = uploadFile(request, response);
		SinhVien sv = new SinhVien(id,ten,ngaysinh,quequan,gioitinh,lop,photo);
		SinhVienDAO.updateSV(sv);
		response.sendRedirect("list");
	}

	private void listSV(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<SinhVien> listSV = SinhVienDAO.listAllSV();
		request.setAttribute("sv", listSV);
		RequestDispatcher dpc = request.getRequestDispatcher("/quanlysv.jsp");
		try {
			dpc.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = request.getParameter("sid");
		SinhVien extSV = SinhVienDAO.getSV(id);
		RequestDispatcher dpc = request.getRequestDispatcher("/editform.jsp");
		request.setAttribute("sv", extSV);
		try {
			dpc.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteSV(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String id = request.getParameter("sid");
		SinhVien sv = new SinhVien(id);
		SinhVienDAO.deleteSV(sv);
		response.sendRedirect("list");
	}

	private void insertSV(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String ten = request.getParameter("ten");
		String ngaysinh = request.getParameter("ngaysinh");
		String quequan = request.getParameter("quequan");
		String gioitinh = request.getParameter("gioitinh");
		String lop = request.getParameter("lop");
		String photo = uploadFile(request, response);
		SinhVien sv = new SinhVien(id, ten, ngaysinh, quequan, gioitinh, lop,photo);
		SinhVienDAO.insertSV(sv);
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dpc = request.getRequestDispatcher("/newform.jsp");
		try {
			dpc.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @throws ServletException 
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public String uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String fileName ="";
		try {
			Part filePart = request.getPart("photo");
			fileName = (String) getFileName(filePart);
			String appPath = request.getServletContext().getRealPath("");
		    String basePath = appPath + File.separator + UPLOAD_DIR + File.separator;
			InputStream inputStream = null;
		    OutputStream outputStream = null;
		    try {
		    	File outputFilePath = new File(basePath+fileName);
		    	inputStream = filePart.getInputStream();
		    	outputStream = new FileOutputStream(outputFilePath);
		    	int read = 0;
		    	final byte[] bytes = new byte[1024];
		    	while((read=inputStream.read(bytes))!=-1) {
		    		outputStream.write(bytes, 0, read);
		    	}
		    }
		    catch(Exception e){
		    	e.printStackTrace();
		    	fileName = "";
		    } finally {
		    	if(inputStream != null) {
		    		inputStream.close();
		    	}
		    	if(outputStream != null) {
		    		outputStream.close();
		    	}
		    }
		}catch(Exception e) {
			fileName="";
		}
		return fileName;
	}
	public String getFileName(Part part) {
		final String partHeader = part.getHeader("content-disposition");
		for(String content : partHeader.split(";")) {
			if(content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=')+1).trim().replace("\"", "" );
			}
		}
		return null;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
