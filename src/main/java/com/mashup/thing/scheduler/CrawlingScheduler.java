package com.mashup.thing.scheduler;

import com.mashup.thing.crawling.CrawlingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CrawlingScheduler {

    private final CrawlingService crawlingService;

    public CrawlingScheduler(CrawlingService crawlingService) {
        this.crawlingService = crawlingService;
    }


    @Scheduled(cron = "30 * * * * *")
    public void run() {
        crawlingService.start();
    }
}