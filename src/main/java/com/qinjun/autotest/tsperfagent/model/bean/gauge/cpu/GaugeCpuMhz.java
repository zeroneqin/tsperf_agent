package com.qinjun.autotest.tsperfagent.model.bean.gauge.cpu;

import com.codahale.metrics.Gauge;

public class GaugeCpuMhz implements Gauge<Integer> {
    Integer mhz;
    public GaugeCpuMhz(Integer mhz) {this.mhz=mhz;}
    @Override
    public Integer getValue() {
        return mhz;
    }
}
