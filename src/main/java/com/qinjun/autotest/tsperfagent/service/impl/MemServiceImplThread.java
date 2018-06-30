package com.qinjun.autotest.tsperfagent.service.impl;

import com.codahale.metrics.MetricRegistry;
import com.qinjun.autotest.tsperfagent.model.bean.CpuBean;
import com.qinjun.autotest.tsperfagent.model.bean.MemBean;
import com.qinjun.autotest.tsperfagent.model.bean.MemDetail;
import com.qinjun.autotest.tsperfagent.model.bean.gauge.mem.*;
import com.qinjun.autotest.tsperfagent.model.dao.ICpuDao;
import com.qinjun.autotest.tsperfagent.model.dao.IMemDao;
import com.qinjun.autotest.tsperfagent.util.MetricUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemServiceImplThread implements Runnable{
    private static Logger logger = LoggerFactory.getLogger(MemServiceImplThread.class);
    private static MemBean memBean;
    IMemDao memDao;

    public MemServiceImplThread(IMemDao memDao) {this.memDao=memDao;}

    public void run() {
        try {
            MetricRegistry registry = MetricUtil.getMetricRegistry();
            memBean = memDao.getMemInfo();
            final MemDetail memDetail = memBean.getMemDetail();

            Long memTotal = memDetail.getMemTotal();
            GaugeMemUsageTotal gaugeMemUsageTotal = new GaugeMemUsageTotal(memTotal);
            registry.register(MetricRegistry.name("","Mem","total(k)"),gaugeMemUsageTotal);

            GaugeMemUsageUsed gaugeMemUsageUsed= new GaugeMemUsageUsed(memBean);
            registry.register(MetricRegistry.name("","Mem","used(k)"),gaugeMemUsageUsed);

            GaugeMemUsageFree gaugeMemUsageFree = new GaugeMemUsageFree(memBean);
            registry.register(MetricRegistry.name("","Mem","free(k)"),gaugeMemUsageFree);

            Long swapTotal = memDetail.getSwapTotal();
            GaugeSwapUsageTotal gaugeSwapUsageTotal = new GaugeSwapUsageTotal(swapTotal);
            registry.register(MetricRegistry.name("","Swap","total(k)"),gaugeMemUsageTotal);

            GaugeSwapUsageUsed gaugeSwapUsageUsed = new GaugeSwapUsageUsed(memBean);
            registry.register(MetricRegistry.name("","Swap","used(k)"),gaugeSwapUsageUsed);

            GaugeSwapUsageFree gaugeSwapUsageFree = new GaugeSwapUsageFree(memBean);
            registry.register(MetricRegistry.name("","Swap","free(k)"),gaugeSwapUsageFree);

            while(true) {
                memBean = memDao.getMemInfo();
                gaugeMemUsageUsed.setMemBean(memBean);
                gaugeMemUsageFree.setMemBean(memBean);
                gaugeSwapUsageUsed.setMemBean(memBean);
                gaugeSwapUsageFree.setMemBean(memBean);
            }

        }
        catch (Exception e) {
            logger.error("Get exception:"+e);
        }
    }
}
