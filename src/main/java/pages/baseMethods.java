package pages;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.is;

public class baseMethods
{
    public static void waitForElement(WebElement element)
    {
        await("The element is not available within 10 seconds").
                ignoreExceptions().
                pollInterval(1, TimeUnit.SECONDS).
                atMost(10, TimeUnit.SECONDS).
                until(element::isDisplayed, is(true));
    }

    public static String getDataProperties(String path, String keyValue) throws IOException {

        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);

        Properties properties = new Properties();
        properties.load(fileInputStream);

        return properties.getProperty(keyValue);
    }

    public static String readXL(String testCase, String field) throws FilloException {
        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection("src/main/resources/iOSAutomation.TestData/MobileTestData.xlsx");
        String strQuery="Select * from testdata where TestCase='"+testCase+"'";
        Recordset recordset=connection.executeQuery(strQuery);

        while(recordset.next()){
            return recordset.getField(field);
        }

        recordset.close();
        connection.close();

        return null;
    }
}
