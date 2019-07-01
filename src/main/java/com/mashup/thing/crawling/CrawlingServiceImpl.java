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


    private final String SITE_URL = "https://ladder.kr/";
    private final String TOP_ELEMENT_XPATH = "/html/body/div/div/div/div/div[3]/div[4]/div/div[1]/div[*]/div[1]/div[1]/div[2]";
    private final String BOTTOM_ELEMENT_XPATH = "/html/body/div/div/div/div/div[3]/div[4]/div/div[2]/div[*]/div[2]/div";
    private final String SCROLL_EVENT = "window.scrollBy(0,500)";
    private final int MAX_SCROLL_EVENT = 20;
    private final YouTuberService youTuberService;

    public CrawlingServiceImpl(YouTuberService youTuberService) {
        this.youTuberService = youTuberService;
    }

    public void start() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        List<SiteInfo> siteInfos = SiteInfoFactory.initXpath();

        try {
            this.webCrawlingStart(driver, siteInfos);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("thread error");
        }
    }

    private void webCrawlingStart(WebDriver driver, List<SiteInfo> siteInfos) {
        driver.get(SITE_URL);
        siteInfos.forEach(siteInfo -> crawling(driver, siteInfo));
    }

    private void crawling(WebDriver driver, SiteInfo siteInfo) {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;

        for (String xpath : siteInfo.getSiteXpaths()){
            driver.findElement(By.xpath(xpath)).click();
            youTuberElementParsing(driver, jsx, siteInfo);
        }
    }

    private void youTuberElementParsing(WebDriver driver, JavascriptExecutor jsx, SiteInfo siteInfo) {
        for (int i = 1; i <= MAX_SCROLL_EVENT; i++) {
            jsx.executeScript(SCROLL_EVENT, "");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                log.error("thread sleep error");
            }
        }

        List<WebElement> topElements = driver.findElements(By.xpath(TOP_ELEMENT_XPATH));
        List<WebElement> bottomElements = driver.findElements(By.xpath(BOTTOM_ELEMENT_XPATH));

        youTuberService.saveYouTuber(topElements, bottomElements, siteInfo.getCategoryType());

    }
}
