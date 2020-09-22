package helper.browserConfiguration.config;

import helper.resource.ResourceHelper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader{

    private static FileInputStream file;
    public static Properties pr;
    ResourceHelper rrs;

    public PropertyReader() {
        try {
            rrs = new ResourceHelper();
            String filePath = rrs.getResourcePath("src/main/resources/configfile/config.properties");
            file = new FileInputStream(new File(filePath));
            pr = new Properties();
            pr.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Return an integer value of an implicit wait
     * @return
     */
    public int getImpliciteWait() {
        return Integer.parseInt(pr.getProperty("implicitwait"));
    }


    /**
     * Returns browser type
     * @return
     */
    public String getBrowserType() {
        return String.valueOf(pr.getProperty("browserType"));
    }


    /**
     * Return a String URL
     * @return
     */
    public String getUrl() {
        if(System.getProperty("url")!=null){
            return System.getProperty("url");
        }
        return pr.getProperty("applicationUrl");
    }


    /**
     * Return a username
     * @return
     */
    public String getUserName() {
        if(System.getProperty("userName")!=null){
            return System.getProperty("userName");
        }
        return pr.getProperty("userName");
    }


    /**
     * Return a password
     * @return
     */
    public String getPassword() {
        if(System.getProperty("password")!=null){
            return System.getProperty("password");
        }
        return pr.getProperty("password");
    }

    /**
     * Returns a file path which we want to upload
     * @return
     */
    public String getFilePath() {
        if(System.getProperty("filepath")!=null){
            return System.getProperty("filepath");
        }
        return pr.getProperty("filepath");
    }

    /**
     * Read an integer value of Timeout
     * @return
     */
    public int getTimeOutInSeconds() {
        return Integer.parseInt(pr.getProperty("timeoutinseconds"));
    }


    /**
     * Read an integer value of milliseconds
     * @return
     */
    public int getPollingEveryInMilliSec() {
        return Integer.parseInt(pr.getProperty("pollingeveryinmillisec"));
    }
}
