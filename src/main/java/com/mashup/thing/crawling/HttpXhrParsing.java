package com.mashup.thing.crawling;

import com.mashup.thing.youtuber.YouTuberMapper;
import com.mashup.thing.youtuber.YouTuberService;
import com.mashup.thing.youtuber.domain.YouTuber;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class HttpXhrParsing {

    private final YouTuberService youTuberService;
    private final YouTuberMapper youTuberMapper;

    public HttpXhrParsing(YouTuberService youTuberService, YouTuberMapper youTuberMapper) {
        this.youTuberService = youTuberService;
        this.youTuberMapper = youTuberMapper;
    }

    public void start() {
        List<SiteInfo> siteInfos = SiteInfoFactory.initXpath();
        siteInfos.forEach(this::startParsing);
    }

    private void startParsing(SiteInfo siteInfo) {
        for (String url : siteInfo.getUrls()) {
            HttpResponse response = httpClientExecute(url);
            JSONArray jsonArray = parsing(response);
            List<YouTuber> youTubers = converting(jsonArray, siteInfo);
            youTuberService.saveYouTubers(youTubers);
        }
    }

    public HttpResponse httpClientExecute(String url) {
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = null;
        try {
            System.out.println(url);
            HttpGet httpGet = new HttpGet(url);
            response = client.execute(httpGet);

        } catch (Exception e) {
            log.error("Http Client 에러");
            e.printStackTrace();
        }
        return response;
    }

    private JSONArray parsing(HttpResponse response) {
        HttpEntity resEntity = response.getEntity();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(EntityUtils.toString(resEntity));
        } catch (Exception e) {
            log.error("Json Parsing 에러");
            e.printStackTrace();
        }
        return jsonArray;
    }

    private List<YouTuber> converting(JSONArray jsonArray, SiteInfo siteInfo) {
        List<YouTuber> youTubers = new ArrayList<>();
        int size = jsonArray.length();
        try {
            for (int i = 0; i < size; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                JSONObject meta = jsonObject.getJSONObject("meta");
                JSONObject ranking = jsonObject.getJSONObject("ranking");

                LocalDateTime publishAt = LocalDateTime.ofInstant(Instant.ofEpochMilli(meta.getLong("publishedAt")), ZoneId.systemDefault());
                YouTuber youTuber = youTuberMapper.toYouTuber(meta.getString("name"), meta.getString("id"), meta.getString("description"),
                        publishAt, meta.getJSONArray("thumbnails").get(0).toString(), ranking.getLong("subscriberCount"),
                        ranking.getLong("viewCount"), siteInfo.getCategoryType().getPrimaryKey());
                youTubers.add(youTuber);
            }
        } catch (Exception e) {
            log.error("Json Converting 에러");
            e.printStackTrace();
        }
        return youTubers;
    }

}
