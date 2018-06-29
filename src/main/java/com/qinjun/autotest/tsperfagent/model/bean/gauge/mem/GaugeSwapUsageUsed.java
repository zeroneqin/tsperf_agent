package com.qinjun.autotest.tsperfagent.model.bean.gauge.mem;

import com.codahale.metrics.Gauge;
import com.qinjun.autotest.tsperfagent.model.bean.MemBean;

public class GaugeSwapUsageUsed implements Gauge<Long> {
    private MemBean memBean;

    public GaugeSwapUsageUsed(MemBean memBean) {
        this.memBean = memBean;
    }

    public MemBean getMemBean() {
        return memBean;
    }

    public void setMemBean(MemBean memBean) {
        this.memBean = memBean;
    }

    @Override
    public Long getValue() {
        return memBean.getMemUsage().getSwapUsed();
    }
}
