package com.qinjun.autotest.tsperfagent.service;

import com.qinjun.autotest.tsperfagent.exception.TSPerfAgentException;

public interface ICpuService {
    public void recordCpu() throws TSPerfAgentException;
}
