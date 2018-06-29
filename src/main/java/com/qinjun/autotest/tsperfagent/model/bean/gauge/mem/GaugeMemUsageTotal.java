package com.qinjun.autotest.tsperfagent.model.bean.gauge.mem;

import com.codahale.metrics.Gauge;

public class GaugeMemUsageTotal implements Gauge<Long> {
    Long total;

    public GaugeMemUsageTotal(Long total) {
        this.total = total;
    }

    @Override
    public Long getValue() {
        return total;
    }
}
