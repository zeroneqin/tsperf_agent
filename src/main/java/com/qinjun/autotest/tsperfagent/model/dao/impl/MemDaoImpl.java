package com.qinjun.autotest.tsperfagent.model.dao.impl;

import com.qinjun.autotest.tsperfagent.exception.TSPerfAgentException;
import com.qinjun.autotest.tsperfagent.model.bean.MemBean;
import com.qinjun.autotest.tsperfagent.model.bean.MemDetail;
import com.qinjun.autotest.tsperfagent.model.bean.MemUsage;
import com.qinjun.autotest.tsperfagent.model.dao.IMemDao;
import com.qinjun.autotest.tsperfagent.util.SigarUtil;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.Swap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MemDaoImpl implements IMemDao {
    private static Logger logger = LoggerFactory.getLogger(MemDaoImpl.class);

    @Override
    public MemBean getMemInfo() throws TSPerfAgentException {
        MemBean memBean=null;
        Sigar sigar = SigarUtil.getSigar();
        try {
            Mem mem = sigar.getMem();
            long memTotal = mem.getTotal()/1024L;
            long memUsed = mem.getUsed()/1024L;
            long memFree = mem.getFree()/1024L;

            Swap swap = sigar.getSwap();
            long swapTotal = swap.getTotal()/1024L;
            long swapUsed = swap.getUsed()/1024L;
            long swapFree = swap.getFree()/1024L;

            MemDetail memDetail = new MemDetail();
            memDetail.setMemTotal(memTotal);
            memDetail.setSwapTotal(swapTotal);

            MemUsage memUsage = new MemUsage();
            memUsage.setMemUsed(memUsed);
            memUsage.setMemFree(memFree);
            memUsage.setSwapUsed(swapUsed);
            memUsage.setSwapFree(swapFree);
            memBean = new MemBean();
            memBean.setMemDetail(memDetail);
            memBean.setMemUsage(memUsage);

        }
        catch (Exception e) {
            logger.error("Get exception:"+e);
            throw new TSPerfAgentException("Get exception:"+e);
        }
        return memBean;
    }
}
