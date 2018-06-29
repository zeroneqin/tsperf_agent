package com.qinjun.autotest.tsperfagent.model.bean.gauge.cpu;

import com.codahale.metrics.Gauge;

public class GaugeCpuNum implements Gauge<Integer> {
    Integer num;
    public GaugeCpuNum(Integer num) {this.num=num;}
    @Override
    public Integer getValue() {
        return num;
    }
}
