package com.mashup.thing.scheduler;

import com.mashup.thing.crawling.HttpXhrParsing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CrawlingScheduler {

    private final HttpXhrParsing httpXhrParsing;

    public CrawlingScheduler(HttpXhrParsing httpXhrParsing) {
        this.httpXhrParsing = httpXhrParsing;
    }


    @Scheduled(cron = "00 00 01 * * *")
    public void run() {
        httpXhrParsing.start();
    }
}