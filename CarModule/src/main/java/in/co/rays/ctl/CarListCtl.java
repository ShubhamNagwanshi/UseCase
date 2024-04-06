package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.dto.CarDTO;
import in.co.rays.model.CarModel;


@WebServlet("/CarListCtl")
public class CarListCtl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	CarDTO dto = new CarDTO();
	CarModel model = new CarModel();
	List list = model.search(dto);
	req.setAttribute("list", list);
	RequestDispatcher rd = req.getRequestDispatcher("CarListView.jsp");
	rd.forward(req, resp);
}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		String[] ids = req.getParameterValues("ids");
		CarDTO dto = new CarDTO();
		CarModel model = new CarModel();
		if (op.equalsIgnoreCase("delete")) {
			if(ids!=null) {
				for(String id:ids) {
					CarDTO deletedto = new CarDTO();
					deletedto.setId(Integer.parseInt(id));
					model.delete(deletedto);
					req.setAttribute("msg","Record delete sucessfully");
//					RequestDispatcher rd = req.getRequestDispatcher("CarListView.jsp");
//					rd.forward(req, resp);
				}
			}else {
				req.setAttribute("msg","Select Atleast one record");
			}
		}
		if(op.equalsIgnoreCase("new")){
			resp.sendRedirect("CarCtl");
			return;
		}
		if(op.equals("search")){
	
			dto.setOwnerName(req.getParameter("name"));
		}
		if(op.equals("Search")){
			
			dto.setId(Integer.parseInt(req.getParameter("id")));
		}
		List list=model.search(dto);
		req.setAttribute("list",list);
		RequestDispatcher rd = req.getRequestDispatcher("CarListView.jsp");
		rd.forward(req, resp);
	}
	}

