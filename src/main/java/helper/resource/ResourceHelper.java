package helper.resource;

public class ResourceHelper {

    /**
     * Reads a relative path of the project folder structure
     * @param path
     * @return
     */
    public String getResourcePath(String path) {
        String basePath = System.getProperty("user.dir");
        System.out.println(basePath +"/"+ path);
        return basePath +"/"+ path;
    }
}
