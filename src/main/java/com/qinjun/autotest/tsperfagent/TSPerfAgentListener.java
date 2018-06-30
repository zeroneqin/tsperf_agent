package com.qinjun.autotest.tsperfagent;

import com.qinjun.autotest.tsperfagent.util.SigarUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class TSPerfAgentListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        SigarUtil.getSigar();
    }
}
