package com.qinjun.autotest.tsperfagent.model.bean.gauge.cpu;

import com.codahale.metrics.Gauge;

public class GaugeCpuCacheSize implements Gauge<Long> {
    Long cacheSize;
    public GaugeCpuCacheSize(Long cacheSize) {this.cacheSize=cacheSize;}
    @Override
    public Long getValue() {
        return cacheSize;
    }
}
