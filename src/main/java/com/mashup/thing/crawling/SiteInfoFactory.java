package com.mashup.thing.crawling;
import com.mashup.thing.category.CategoryType;

import java.util.ArrayList;
import java.util.List;

public class SiteInfoFactory {
    private SiteInfoFactory () {

    }

    public static List<SiteInfo> initXpath() {
        List<SiteInfo> siteInfos = new ArrayList<>();

        siteInfos.add(createFoodXpath());
        siteInfos.add(createKnowledgeXpath());
        siteInfos.add(createBeautyXpath());
        siteInfos.add(createComicXpath());
        siteInfos.add(createDailyXpath());
        siteInfos.add(createEntertainmentXpath());
        siteInfos.add(createGameXpath());
        siteInfos.add(createKidsXpath());
        siteInfos.add(createMusicXpath());
        siteInfos.add(createSportsXpath());
        siteInfos.add(createTalkXpath());

        return siteInfos;
    }

    private static SiteInfo createFoodXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.FOOD);

        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=1");
        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=2");

        return siteInfo;
    }

    private static SiteInfo createKnowledgeXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.KNOWLEDGE);

        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=5");
        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=13");

        return siteInfo;
    }

    private static SiteInfo createSportsXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.SPORTS);

        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=9");

        return siteInfo;
    }

    private static SiteInfo createBeautyXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.BEAUTY);

        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=10");
        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=11");

        return siteInfo;
    }

    private static SiteInfo createKidsXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.KIDS);

        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=21");

        return siteInfo;
    }

    private static SiteInfo createTalkXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.TALK);

        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=8");

        return siteInfo;
    }

    private static SiteInfo createComicXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.COMIC);

        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=17");

        return siteInfo;
    }

    private static SiteInfo createGameXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.GAME);

        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=19");

        return siteInfo;
    }

    private static SiteInfo createMusicXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.MUSIC);

        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=12");
        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=16");

        return siteInfo;
    }

    private static SiteInfo createDailyXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.DAILY);

        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=15");
        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=6");
        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=7");

        return siteInfo;
    }

    private static SiteInfo createEntertainmentXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.ENTERTAINMENT);

        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=18");
        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=14");
        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=3");
        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=4");
        siteInfo.getUrls().add("https://ladder.kr/api/ranking/channels?categoryId=20");

        return siteInfo;
    }
}

