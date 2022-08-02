package data;

import utilities.Xls_Reader;

public class DataFile {

	Xls_Reader data = new Xls_Reader("C:\\Program Files\\Java\\Testing\\NikulTestTd.xlsx");
	public String username= data.getCellData("Data1", "UserName", 2);
	public String password= data.getCellData("Data1", "Password", 2);
	public String emailError= data.getCellData("Data1", "Email Error", 7);
	public String passwordError= data.getCellData("Data1", "Password Error", 4);
	public String globalError= data.getCellData("Data1", "globalError", 3);
	
	
}
