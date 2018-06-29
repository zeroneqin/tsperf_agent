package com.qinjun.autotest.tsperfagent.model.bean.gauge.cpu;

import com.codahale.metrics.Gauge;
import com.qinjun.autotest.tsperfagent.model.bean.CpuBean;

public class GaugeCpuUsageTotal implements Gauge<Long> {
    private Long total;
    public GaugeCpuUsageTotal(Long  total) {this.total=total;}

    @Override
    public Long getValue() {
        return total;
    }
}
