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

        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[1]/div/div[2]");
        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[2]/div/div[3]");

        return siteInfo;
    }

    private static SiteInfo createKnowledgeXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.KNOWLEDGE);

        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[2]/div/div[10]");
        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[2]/div/div[11]");

        return siteInfo;
    }

    private static SiteInfo createSportsXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.SPORTS);

        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[2]/div/div[5]");

        return siteInfo;
    }

    private static SiteInfo createBeautyXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.BEAUTY);

        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[1]/div/div[3]");
        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[2]/div/div[4]");

        return siteInfo;
    }

    private static SiteInfo createKidsXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.KIDS);

        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[1]/div/div[9]");

        return siteInfo;
    }

    private static SiteInfo createTalkXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.TALK);

        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[1]/div/div[7]");

        return siteInfo;
    }

    private static SiteInfo createComicXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.COMIC);

        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[1]/div/div[6]");

        return siteInfo;
    }

    private static SiteInfo createGameXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.GAME);

        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[1]/div/div[4]");

        return siteInfo;
    }

    private static SiteInfo createMusicXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.MUSIC);

        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[2]/div/div[6]");
        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[2]/div/div[1]");

        return siteInfo;
    }

    private static SiteInfo createDailyXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.DAILY);

        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[1]/div/div[5]");
        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[1]/div/div[8]");
        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[1]/div/div[11]");

        return siteInfo;
    }

    private static SiteInfo createEntertainmentXpath() {
        SiteInfo siteInfo = new SiteInfo();

        siteInfo.setCategoryType(CategoryType.ENTERTAINMENT);

        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[1]/div/div[10]");
        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[2]/div/div[2]");
        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[2]/div/div[8]");
        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[2]/div/div[9]");
        siteInfo.getSiteXpaths().add("/html/body/div/div/div/div/div[3]/div[1]/div/div[2]/div/div[7]");

        return siteInfo;
    }
}

