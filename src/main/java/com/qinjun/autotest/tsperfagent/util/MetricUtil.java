package com.qinjun.autotest.tsperfagent.util;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class MetricUtil {
    private static MetricRegistry registry;
    private static Slf4jReporter reporter;

    public static Slf4jReporter getReporter(){
        if(reporter==null) {
            if (registry==null) {
                registry = new MetricRegistry();
            }
            reporter = Slf4jReporter.forRegistry(registry)
                    .outputTo(LoggerFactory.getLogger("root"))
                    .convertRatesTo(TimeUnit.SECONDS)
                    .convertDurationsTo(TimeUnit.MILLISECONDS)
                    .build();
        }
        return reporter;

    }

    public static MetricRegistry getMetricRegistry() {
        if (registry==null) {
            registry = new MetricRegistry();
        }
        return registry;
    }

    public static void startReport() {
        if (reporter==null) {
            reporter=getReporter();
        }
        reporter.start(1,TimeUnit.SECONDS);
    }

    public static void stopReport() {
        if (reporter==null) {
            reporter=getReporter();
        }
        reporter.stop();
        reporter=null;
    }
}
