package com.qinjun.autotest.tsperfagent.service.impl;

import com.qinjun.autotest.tsperfagent.exception.TSPerfAgentException;
import com.qinjun.autotest.tsperfagent.model.dao.ICpuDao;
import com.qinjun.autotest.tsperfagent.service.ICpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CpuServiceImpl implements ICpuService {
        @Autowired
        ICpuDao cpuDao;

    @Override
    public void recordCpu() throws TSPerfAgentException {
        CpuServiceImplThread cpuServiceImplThread = new CpuServiceImplThread(cpuDao);
        Thread thread = new Thread(cpuServiceImplThread);
        thread.start();
    }
}
