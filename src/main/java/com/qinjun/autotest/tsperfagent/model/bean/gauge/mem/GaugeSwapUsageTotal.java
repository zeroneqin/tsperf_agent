package com.qinjun.autotest.tsperfagent.model.bean.gauge.mem;

import com.codahale.metrics.Gauge;

public class GaugeSwapUsageTotal implements Gauge<Long> {
    Long total;

    public GaugeSwapUsageTotal(Long total) {
        this.total = total;
    }

    @Override
    public Long getValue() {
        return total;
    }
}
