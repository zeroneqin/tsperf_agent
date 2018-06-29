package com.qinjun.autotest.tsperfagent.model.bean.gauge.cpu;

import com.codahale.metrics.Gauge;

public class GaugeCpuModel implements Gauge<String> {
    String model;
    public GaugeCpuModel(String model) {this.model=model;}
    @Override
    public String getValue() {
        return model;
    }
}
