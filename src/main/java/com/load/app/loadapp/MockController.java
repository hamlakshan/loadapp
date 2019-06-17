package com.load.app.loadapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MockController {

    @GetMapping(path = "/mock/get")
    public String getService() {
        System.out.println("Here");
        return "hello";
    }

    @GetMapping(path = "/mock/errors")
    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "video not found")
    public String getError() {
        return "hello";
    }

    @PostMapping(path = "/mock/largepayload", produces = MediaType.APPLICATION_JSON_VALUE)
    public String postLargePayload() {
        return LoadApplication.payload;
    }

    @PostMapping(path = "/mock/normalpayload", produces = MediaType.APPLICATION_JSON_VALUE)
    public String postNormalPayload() {
        String smallPyalod = "{ \"poNumber\": \"5500018304\", \"poItemNumber\": \"00010\", \"approvalStatus\": \"Small payload\" }";
        return smallPyalod;
    }

    @GetMapping(path = "/mock/delay", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getDelayPayload() {
        String smallPyalod = "{ \"poNumber\": \"5500018304\", \"poItemNumber\": \"00010\", \"approvalStatus\": \"Small payload\" }";
        try {
            Thread.sleep(65000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return smallPyalod;
    }

    @PostMapping(path = "/mock/mixpayload", produces = MediaType.APPLICATION_JSON_VALUE)
    public String postMixPayload() {
        String smallPyalod = "{ \"poNumber\": \"5500018304\", \"poItemNumber\": \"00010\", \"approvalStatus\": \"Small payload\" }";
        if (LoadApplication.count > 1020) {
            LoadApplication.count = 0;
        }
        LoadApplication.count++;
        if (LoadApplication.count % 100 == 0) {
            return LoadApplication.payload;
        } else {
            return smallPyalod;
        }
    }

    @GetMapping(path = "/mock/get/{mobile}/charge")
    public String getPathParam(@PathVariable("mobile") String mobile) {
        System.out.println("Here");
        return mobile;
    }


}

