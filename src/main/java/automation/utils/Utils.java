package automation.utils;

import automation.drivers.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;
import java.util.Random;

public class Utils{

    private String result = "";
    private InputStream inputStream;

    public String getProperty(String key){
        try {
            Properties properties = new Properties();
            String propFileName = Constants.PROP_FILE_NAME;

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if ( inputStream != null )
                properties.load(inputStream);
            else
                throw new FileNotFoundException(Constants.FILE_NOT_FOUND_EXCEPTION_MESSAGE);

            String propertyValue = properties.getProperty(key);
            this.result = propertyValue;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String decode64(String encodedStr){
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(encodedStr.getBytes()));
    }

    public static boolean takeScreenshot(){
        File file = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(file, new File(Constants.SCREENSHOTS_FOLDER + generateRandomString(Constants.SCREENSHOT_NAME_LENGTH) + Constants.SCREENSHOT_EXTENSION));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static String generateRandomString(int length){
        String seedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Random random = new Random();
        while(i < length){
            sb.append(seedChars.charAt(random.nextInt(seedChars.length())));
            i++;
        }
        return sb.toString();
    }
}
