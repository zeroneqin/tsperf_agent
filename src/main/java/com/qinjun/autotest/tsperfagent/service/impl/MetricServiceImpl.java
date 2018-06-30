package com.qinjun.autotest.tsperfagent.service.impl;

import com.qinjun.autotest.tsperfagent.exception.TSPerfAgentException;
import com.qinjun.autotest.tsperfagent.service.ICpuService;
import com.qinjun.autotest.tsperfagent.service.IMemService;
import com.qinjun.autotest.tsperfagent.service.IMetricService;
import com.qinjun.autotest.tsperfagent.util.MetricUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricServiceImpl implements IMetricService {
    @Autowired
    private ICpuService cpuService;
    @Autowired
    private IMemService memService;
    @Override
    public void startMetric() throws TSPerfAgentException {
        MetricUtil.startReport();
        cpuService.recordCpu();
        memService.recordMem();
    }

    @Override
    public void stopMetric() throws TSPerfAgentException {
        MetricUtil.stopReport();

    }
}
