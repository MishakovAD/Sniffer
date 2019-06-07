package BookAbouNetworkJava.Utils;

import com.sun.tools.javac.util.StringUtils;

public class FormaterUtils {
    public static boolean isIP (String hostName) {
        if (hostName != null && hostName.contains("/")) {
            hostName = hostName.substring(0, hostName.indexOf("/"));
        } else if (hostName != null && hostName.contains("\\"))    {
            hostName = hostName.substring(0, hostName.indexOf("\\"));
        }
        return hostName.matches("\\d*.\\d*.\\d*.\\d*");
    }

}
