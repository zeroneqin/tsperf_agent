package com.qinjun.autotest.tsperfagent.model.bean;

public class CpuBean {
    private Integer num;
    private CpuDetail cpuDetail;
    private CpuUsage cpuUsage;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public CpuDetail getCpuDetail() {
        return cpuDetail;
    }

    public void setCpuDetail(CpuDetail cpuDetail) {
        this.cpuDetail = cpuDetail;
    }

    public CpuUsage getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(CpuUsage cpuUsage) {
        this.cpuUsage = cpuUsage;
    }
}
