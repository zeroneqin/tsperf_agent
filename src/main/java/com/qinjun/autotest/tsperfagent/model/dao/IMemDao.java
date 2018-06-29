package com.qinjun.autotest.tsperfagent.model.dao;

import com.qinjun.autotest.tsperfagent.exception.TSPerfAgentException;
import com.qinjun.autotest.tsperfagent.model.bean.MemBean;

public interface IMemDao {
    public MemBean getMemInfo() throws TSPerfAgentException;
}
