package testpackage;

import java.io.IOException;
import org.testng.annotations.Test;
import basepackage.BaseClassThom;
import pagepackage.ThomasCook;
import utilitiespackage.Excelutils;


public class ThomasCookTest extends BaseClassThom {
	
@Test
	
	public void testThomasCook() throws IOException, InterruptedException
	{
		ThomasCook ob=new ThomasCook(driver);
				
		ob.titleVerification();
		ob.pageSource();
		ob.linkCountTC();
		ob.screenShot();
		ob.windowHandle();
		ob.moveToElement();
		ob.copyPaste();
		
		String xl = "C:\\Users\\Inspiron\\Downloads\\Book2.xlsx";
		String sheet = "Sheet1";
		int rowCount = Excelutils.getRowCount(xl, sheet);
		System.out.println("Row Count is " + rowCount);
		for(int i=1;i<=rowCount;i++)
		{
			String FN = Excelutils.getCellValue(xl, sheet, i, 0);
			System.out.println("First Name ----" + FN);
			String LN = Excelutils.getCellValue(xl, sheet, i, 1);
			System.out.println("Last Name ----" + LN);
			String MI = Excelutils.getCellValue(xl, sheet, i, 2);
			System.out.println("Last Name ----" + MI);
			String PW = Excelutils.getCellValue(xl, sheet, i, 3);
			System.out.println("Email Id ----" + PW);
			String CP = Excelutils.getCellValue(xl, sheet, i, 4);
			System.out.println("Confirm Password ----" + CP);
			String MN = Excelutils.getCellValue(xl, sheet, i, 5);
			System.out.println("Mobile No. ----" + MN);
			ob.setValues(FN,LN,MI,PW,CP,MN);
		}
		
	}
 
}
