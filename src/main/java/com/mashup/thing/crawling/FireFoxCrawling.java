package com.mashup.thing.crawling;

import com.mashup.thing.youtuber.YouTuberService;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class FireFoxCrawling implements Crawling {

    private final static String SITE_URL = "https://ladder.kr/";
    private final static String TOP_ELEMENT_XPATH = "/html/body/div/div/div/div/div[3]/div[4]/div/div[1]/div[*]/div[1]/div[1]/div[2]";
    private final static String BOTTOM_ELEMENT_XPATH = "/html/body/div/div/div/div/div[3]/div[4]/div/div[2]/div[*]/div[2]/div";
    private final static String SCROLL_EVENT = "window.scrollBy(0,500)";
    private final static int MAX_SCROLL_EVENT = 20;
    private final static int WAIT_TIME = 15;
    private WebDriver webDriver;
    private final YouTuberService youTuberService;

    public FireFoxCrawling(YouTuberService youTuberService) {
        this.youTuberService = youTuberService;
    }

    public void start() {
        webBrowserInit();
        List<SiteInfo> siteInfos = SiteInfoFactory.initXpath();
        webCrawlingStart(siteInfos);
    }

    private void webBrowserInit() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
    }

    private void webCrawlingStart(List<SiteInfo> siteInfos) {
        webDriver.get(SITE_URL);
        siteInfos.forEach(this::crawling);
    }

    private void crawling(SiteInfo siteInfo) {
        for (String xpath : siteInfo.getSiteXpaths()){
            webDriver.findElement(By.xpath(xpath)).click();
            moveScroll();
            parsingByCategory(siteInfo);
        }
    }

    private void moveScroll() {
        JavascriptExecutor jsx = (JavascriptExecutor) webDriver;
        for (int i = 1; i <= MAX_SCROLL_EVENT; i++) {
            jsx.executeScript(SCROLL_EVENT, "");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                log.error("thread sleep error");
            }
        }
    }

    private void parsingByCategory(SiteInfo siteInfo) {
        List<WebElement> elements = parsingElement();
        elementSave(elements, siteInfo);
    }

    private List<WebElement> parsingElement() {
        List<WebElement> elements = webDriver.findElements(By.xpath(TOP_ELEMENT_XPATH));
        elements.addAll(webDriver.findElements(By.xpath(BOTTOM_ELEMENT_XPATH)));
        return elements;
    }

    private void elementSave(List<WebElement> elements, SiteInfo siteInfo) {
        youTuberService.saveYouTuber(elements, siteInfo.getCategoryType());
    }
}
