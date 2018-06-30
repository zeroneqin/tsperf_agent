package com.qinjun.autotest.tsperfagent.service.impl;

import com.qinjun.autotest.tsperfagent.exception.TSPerfAgentException;
import com.qinjun.autotest.tsperfagent.model.dao.IMemDao;
import com.qinjun.autotest.tsperfagent.service.IMemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemServiceImpl implements IMemService {
    @Autowired
    IMemDao memDao;
    public void recordMem() throws TSPerfAgentException {
        MemServiceImplThread memServiceImplThread = new MemServiceImplThread(memDao);
        Thread thread = new Thread(memServiceImplThread);
        thread.start();
    }
}
