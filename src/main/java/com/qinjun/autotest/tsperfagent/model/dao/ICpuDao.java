package com.qinjun.autotest.tsperfagent.model.dao;

import com.qinjun.autotest.tsperfagent.exception.TSPerfAgentException;
import com.qinjun.autotest.tsperfagent.model.bean.CpuBean;

public interface ICpuDao {
    public CpuBean getCpuInfo() throws TSPerfAgentException;
}
