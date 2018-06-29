package com.qinjun.autotest.tsperfagent.model.dao.impl;

import com.qinjun.autotest.tsperfagent.exception.TSPerfAgentException;
import com.qinjun.autotest.tsperfagent.model.bean.CpuBean;
import com.qinjun.autotest.tsperfagent.model.dao.ICpuDao;
import com.qinjun.autotest.tsperfagent.util.SigarUtil;
import org.hyperic.sigar.Sigar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CpuDaoImpl implements ICpuDao {
    private static Logger logger = LoggerFactory.getLogger(CpuDaoImpl.class);
    @Override
    public CpuBean getCpuInfo() throws TSPerfAgentException {
        CpuBean cpuBean=null;
        Sigar sigar = SigarUtil.getSigar();
        try {

        }
        catch (Exception e) {
            logger.error("Get exception:"+e);
            throw new TSPerfAgentException("Get exception:"+e);
        }
        return cpuBean;
    }
}
