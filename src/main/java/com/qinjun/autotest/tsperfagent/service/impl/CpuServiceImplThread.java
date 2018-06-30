package com.qinjun.autotest.tsperfagent.service.impl;

import com.codahale.metrics.MetricRegistry;
import com.qinjun.autotest.tsperfagent.model.bean.CpuBean;
import com.qinjun.autotest.tsperfagent.model.bean.CpuDetail;
import com.qinjun.autotest.tsperfagent.model.bean.CpuUsage;
import com.qinjun.autotest.tsperfagent.model.bean.gauge.cpu.*;
import com.qinjun.autotest.tsperfagent.model.dao.ICpuDao;
import com.qinjun.autotest.tsperfagent.util.MetricUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CpuServiceImplThread implements Runnable{
    private Logger logger = LoggerFactory.getLogger(MemServiceImplThread.class);
    private static CpuBean cpuBean;
    ICpuDao cpuDao;

    public CpuServiceImplThread(ICpuDao cpuDao) {this.cpuDao=cpuDao;}

    public void run() {
        try {
            MetricRegistry registry = MetricUtil.getMetricRegistry();
            cpuBean = cpuDao.getCpuInfo();
            Integer num = cpuBean.getNum();
            GaugeCpuNum gaugeCpuNum = new GaugeCpuNum(num);
            registry.register(MetricRegistry.name("","CPU","core num"),gaugeCpuNum);

            CpuDetail cpuDetail = cpuBean.getCpuDetail();

            String model = cpuDetail.getModel();
            GaugeCpuModel gaugeCpuModel = new GaugeCpuModel(model);
            registry.register(MetricRegistry.name("","CPU","model"),gaugeCpuModel);

            String vendor = cpuDetail.getVendor();
            GaugeCpuVendor gaugeCpuVendor = new GaugeCpuVendor(vendor);
            registry.register(MetricRegistry.name("","CPU","vendor"),gaugeCpuVendor);

            Integer mhz = cpuDetail.getMhz();
            GaugeCpuMhz gaugeCpuMhz = new GaugeCpuMhz(mhz);
            registry.register(MetricRegistry.name("","CPU","mhz"),gaugeCpuMhz);

            Long cacheSize = cpuDetail.getCacheSize();
            GaugeCpuCacheSize gaugeCpuCacheSize = new GaugeCpuCacheSize(cacheSize);
            registry.register(MetricRegistry.name("","CPU","cache size"),gaugeCpuCacheSize);

            CpuUsage cpuUsage = cpuBean.getCpuUsage();
            Long total = cpuUsage.getTotal();
            GaugeCpuUsageTotal gaugeCpuUsageTotal = new GaugeCpuUsageTotal(total);
            registry.register(MetricRegistry.name("","CPU","total"),gaugeCpuUsageTotal);


            GaugeCpuUsageIdle gaugeCpuUsageIdle = new GaugeCpuUsageIdle(cpuBean);
            registry.register(MetricRegistry.name("","CPU","idle"),gaugeCpuUsageIdle);

            while(true) {
                cpuBean = cpuDao.getCpuInfo();
                gaugeCpuUsageIdle.setCpuBean(cpuBean);
            }

        }
        catch (Exception e) {
            logger.error("Get exception:+e");

        }
    }
}
