package com.qinjun.autotest.tsperfagent.model.bean.gauge.mem;

import com.codahale.metrics.Gauge;
import com.qinjun.autotest.tsperfagent.model.bean.MemBean;

public class GaugeMemUsageFree implements Gauge<Long> {
    private MemBean memBean;

    public GaugeMemUsageFree(MemBean memBean) {
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
        return memBean.getMemUsage().getMemFree();
    }
}
