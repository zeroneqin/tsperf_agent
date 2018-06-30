package com.qinjun.autotest.tsperfagent.util;

public class OSUtil {
    public enum OSType{
        WINDOWS,MACOS,LINUX,OTHER;
    }

    protected static OSType osType;

    public static OSType getOSType() {
        if (osType==null) {
            String os = System.getProperty("os.name","generic").toLowerCase();
            if (os.indexOf("win")>=0) {
                osType=OSType.WINDOWS;
            }
            else if (os.indexOf("mac")>=0 || os.indexOf("darwin")>=0) {
                osType = OSType.MACOS;
            }
            else if (os.indexOf("linux")>=0)  {
                osType=OSType.LINUX;
            }else {
                osType=OSType.OTHER;
            }
            }
            return osType;
    }
}
