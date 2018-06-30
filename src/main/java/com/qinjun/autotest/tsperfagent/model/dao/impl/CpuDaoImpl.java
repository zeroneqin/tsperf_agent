package com.qinjun.autotest.tsperfagent.model.dao.impl;

import com.qinjun.autotest.tsperfagent.exception.TSPerfAgentException;
import com.qinjun.autotest.tsperfagent.model.bean.CpuBean;
import com.qinjun.autotest.tsperfagent.model.bean.CpuDetail;
import com.qinjun.autotest.tsperfagent.model.bean.CpuUsage;
import com.qinjun.autotest.tsperfagent.model.dao.ICpuDao;
import com.qinjun.autotest.tsperfagent.util.SigarUtil;
import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.Sigar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CpuDaoImpl implements ICpuDao {
    private static Logger logger = LoggerFactory.getLogger(CpuDaoImpl.class);
    @Override
    public CpuBean getCpuInfo() throws TSPerfAgentException {
        CpuBean cpuBean=null;
        Sigar sigar = SigarUtil.getSigar();
        try {
            CpuInfo[] cpuInfos = sigar.getCpuInfoList();
            int num = cpuInfos.length;
            cpuBean = new CpuBean();
            cpuBean.setNum(num);

            CpuInfo cpuInfo = cpuInfos[0];
            String model =cpuInfo.getModel();
            String vendor = cpuInfo.getVendor();
            int mhz = cpuInfo.getMhz();
            long cacheSize = cpuInfo.getCacheSize();

            CpuDetail cpuDetail = new CpuDetail();
            cpuDetail.setModel(model);
            cpuDetail.setVendor(vendor);
            cpuDetail.setMhz(mhz);
            cpuDetail.setCacheSize(cacheSize);

            cpuBean.setCpuDetail(cpuDetail);

            Cpu cpu = sigar.getCpu();
            Long total = cpu.getTotal();
            Long idle = cpu.getIdle();

            CpuUsage cpuUsage = new CpuUsage();
            cpuUsage.setTotal(total);
            cpuUsage.setIdle(idle);

            cpuBean.setCpuUsage(cpuUsage);
        }
        catch (Exception e) {
            logger.error("Get exception:"+e);
            throw new TSPerfAgentException("Get exception:"+e);
        }
        return cpuBean;
    }
}
