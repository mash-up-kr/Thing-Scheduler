package com.mashup.thing.scheduler;

import com.mashup.thing.crawling.Crawling;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CrawlingScheduler {

    private final Crawling crawling;

    public CrawlingScheduler(Crawling crawling) {
        this.crawling = crawling;
    }


    @Scheduled(cron = "30 * * * * *")
    public void run() {
        crawling.start();
    }
}