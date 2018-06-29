package com.qinjun.autotest.tsperfagent.model.bean.gauge.cpu;

import com.codahale.metrics.Gauge;
import com.qinjun.autotest.tsperfagent.model.bean.CpuBean;

public class GaugeCpuUsageIdle implements Gauge<Long> {
    private CpuBean cpuBean;
    public GaugeCpuUsageIdle(CpuBean cpuBean) {this.cpuBean=cpuBean;}

    public CpuBean getCpuBean() {
        return cpuBean;
    }

    public void setCpuBean(CpuBean cpuBean) {
        this.cpuBean = cpuBean;
    }

    @Override
    public Long getValue() {
        return cpuBean.getCpuUsage().getIdle();
    }

}
