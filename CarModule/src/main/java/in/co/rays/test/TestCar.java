package in.co.rays.test;

import java.text.SimpleDateFormat;

import in.co.rays.dto.CarDTO;
import in.co.rays.model.CarModel;

public class TestCar {
public static void main(String[] args)throws Exception {
	testAdd();
}

private static void testAdd() throws Exception {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	CarDTO dto = new CarDTO();
	
	dto.setOwnerName("shubham");
	dto.setCarName("Mahindra");
	dto.setCarModel("thar");
	dto.setPrize(12);
	dto.setPurchaseDate(sdf.parse("2024-03-12"));
	
	CarModel model = new CarModel();
	model.add(dto);

	
}
}
