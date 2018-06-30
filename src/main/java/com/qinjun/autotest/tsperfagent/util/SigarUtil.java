package com.qinjun.autotest.tsperfagent.util;

import org.hyperic.sigar.Sigar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class SigarUtil {
    private static final Logger logger = LoggerFactory.getLogger(SigarUtil.class);
    private static Sigar sigar;

    public static Sigar getSigar() {
        try {
            if (sigar==null) {
                synchronized (SigarUtil.class) {
                    if (sigar==null) {
                        File classPath= new File("src/main/resources/lib");
                        String path = System.getProperty("java.library.path");
                        if (OSUtil.getOSType()== OSUtil.OSType.WINDOWS) {
                            path+=";"+classPath.getCanonicalPath();
                        }else {
                            path +=":"+classPath.getCanonicalPath();
                        }
                        System.setProperty("java.library.path",path);
                        sigar = new Sigar();
                    }
                }
            }
        }
        catch (Exception e) {
            logger.error("Get exception:"+e);
        }
        return sigar;
    }
}
