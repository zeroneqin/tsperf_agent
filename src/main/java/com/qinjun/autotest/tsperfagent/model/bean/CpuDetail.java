package com.qinjun.autotest.tsperfagent.model.bean;

public class CpuDetail {
    String model;
    String vendor;
    Integer mhz;
    Long cacheSize;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Integer getMhz() {
        return mhz;
    }

    public void setMhz(Integer mhz) {
        this.mhz = mhz;
    }

    public Long getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(Long cacheSize) {
        this.cacheSize = cacheSize;
    }
}
