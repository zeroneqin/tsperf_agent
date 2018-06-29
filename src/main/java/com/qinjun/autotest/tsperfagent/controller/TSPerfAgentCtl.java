package com.qinjun.autotest.tsperfagent.controller;

import com.qinjun.autotest.tsperfagent.service.IMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/job")
public class TSPerfAgentCtl {
    @Autowired
    private IMetricService metricService;

    public Response start() {
        Response response = new Response();
        response.setSuccess(true);
        response.setMsg("Success");

        try {
            metricService.startMetric();
        }
        catch (Exception e) {
            response.setSuccess(false);
            response.setMsg(e.toString());
        }
        return response;
    }

}
