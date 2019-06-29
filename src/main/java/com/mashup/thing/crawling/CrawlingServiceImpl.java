package com.mashup.thing.crawling;

import com.mashup.thing.youtuber.YouTuberService;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class CrawlingServiceImpl implements CrawlingService {
    private final YouTuberService youTuberService;

    public CrawlingServiceImpl(YouTuberService youTuberService) {
        this.youTuberService = youTuberService;
    }


    public void start() {
        try {
            this.webCrawling();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("thread error");
        }
    }

    private void webCrawling() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://ladder.kr/");

        List<SiteInfo> siteInfos = SiteInfoFactory.createXpath();

        siteInfos.forEach(siteInfo -> crawling(driver, siteInfo));
    }

    private void crawling(WebDriver driver, SiteInfo siteInfo) {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        for (String xpath : siteInfo.getSiteXpaths()){
            driver.findElement(By.xpath(xpath)).click();

            for (int i = 1; i <= 20; i++) {
                jsx.executeScript("window.scrollBy(0,500)", "");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    log.error("thread sleep error");
                }
            }

            List<WebElement> topElements = driver.findElements(By.xpath("/html/body/div/div/div/div/div[3]/div[4]/div/div[1]/div[*]/div[1]/div[1]/div[2]"));
            List<WebElement> bottomElements = driver.findElements(By.xpath("/html/body/div/div/div/div/div[3]/div[4]/div/div[2]/div[*]/div[2]/div"));
            youTuberService.saveYouTuber(topElements, bottomElements, siteInfo.getCategoryType());

        }
    }
}
