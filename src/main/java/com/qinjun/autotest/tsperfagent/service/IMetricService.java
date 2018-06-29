package com.qinjun.autotest.tsperfagent.service;

import com.qinjun.autotest.tsperfagent.exception.TSPerfAgentException;

public interface IMetricService {
    public void startMetric() throws TSPerfAgentException;

    public void stopMetric() throws TSPerfAgentException;
}
