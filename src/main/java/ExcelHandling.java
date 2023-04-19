import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelHandling
{
    public static void main(String[] args) throws FilloException {

        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection("src/main/resources/iOSAutomation.TestData/MobileTestData.xlsx");
        String strQuery="Select * from testdata where TestCase='TC002'";
        Recordset recordset=connection.executeQuery(strQuery);

        while(recordset.next()){
            System.out.println(recordset.getField("Country"));
        }

        recordset.close();
        connection.close();
    }
}
