package com.qinjun.autotest.tsperfagent.model.bean.gauge.cpu;

import com.codahale.metrics.Gauge;

public class GaugeCpuVendor implements Gauge<String> {
    String vendor;
    public GaugeCpuVendor(String vendor) {this.vendor=vendor;}

    @Override
    public String getValue() {
        return vendor;
    }
}
