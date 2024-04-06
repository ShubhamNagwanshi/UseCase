package in.co.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.protobuf.TextFormat.ParseException;

import in.co.rays.dto.CarDTO;
import in.co.rays.model.CarModel;
@WebServlet("/CarCtl")
public class CarCtl extends HttpServlet {
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CarDTO dto = new CarDTO();
		CarModel model = new CarModel();
		if (id != null) {
			dto = model.findByPk(Long.parseLong(id));
			req.setAttribute("dto", dto);
		}
		RequestDispatcher rd = req.getRequestDispatcher("CarView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CarDTO dto = new CarDTO();
		String id = req.getParameter("id");
		String op = req.getParameter("operation");
		CarModel model = new CarModel();
		
		dto.setOwnerName(req.getParameter("name"));
		dto.setCarName(req.getParameter("carName"));
		dto.setCarModel(req.getParameter("carModel"));
		dto.setPrize(Integer.parseInt(req.getParameter("prize")));
		try {
			dto.setPurchaseDate(sdf.parse(req.getParameter("date")));
		} catch (java.text.ParseException e) {
			
			e.printStackTrace();
		}
		
		
		if (op.equalsIgnoreCase("update")) {
			dto.setId(Integer.parseInt(id));
			model.update(dto);
			req.setAttribute("dto", dto);
			req.setAttribute("msg", "progress record updated successfully");
		}
		if (op.equalsIgnoreCase("save")) {
			req.setAttribute("dto", dto);
			model.add(dto);
			req.setAttribute("msg", "Progress record added successfully");

		}if (op.equalsIgnoreCase("reset")) {
//			req.setAttribute("dto", dto);
			RequestDispatcher rd = req.getRequestDispatcher("CarView.jsp");
			rd.forward(req, resp);

		}
		RequestDispatcher rd = req.getRequestDispatcher("CarView.jsp");
		rd.forward(req, resp);

	}
}
