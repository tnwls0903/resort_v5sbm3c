package dev.mvc.pilot;
public class PathUtil {

    public static synchronized String getUploadDir() {
        String osName = System.getProperty("os.name").toLowerCase();
        String path = "";

        if (osName.contains("win")) { // Windows
            path = "C:\\kd\\deploy\\resort_v4sbm3c\\contents\\storage\\";
            // System.out.println("Windows: " + path);
        } else if (osName.contains("mac")) { // MacOS
            path = "/Users/yourusername/deploy/resort_v4sbm3c/contents/storage/";
            // System.out.println("MacOS: " + path);
        } else { // Linux
            path = "/home/ubuntu/deploy/resort_v4sbm3c/contents/storage/";
            // System.out.println("Linux: " + path);
        }

        return path;
    }

    public static void main(String[] args) {
        System.out.println(getUploadDir());
    }
}
