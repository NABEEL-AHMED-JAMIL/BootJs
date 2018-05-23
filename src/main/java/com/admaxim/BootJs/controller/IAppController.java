package com.admaxim.BootJs.controller;

import java.util.HashMap;
import java.util.Map;

public interface IAppController {

    public static Map<Integer, UrlMap> menu = new HashMap<Integer, UrlMap>() {{
        System.out.println("PAKISTAN________ZINDABAD");
        put(1, new UrlMap("/", "Home"));
        put(2,new UrlMap("/rtb.2.5","RTB-2.5=>Map"));
        put(3, new UrlMap("/geoMap","Geo-Map"));
        put(4, new UrlMap("/adServer","Ad-Server.1.0"));
        put(5, new UrlMap("/test","Test"));

    }};

    public static class UrlMap {
        private String url;
        private String page;

        public UrlMap(String url, String page) {
            this.url = url;
            this.page = page;
        }

        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }

        public String getPage() { return page; }
        public void setPage(String page) { this.page = page; }

        @Override
        public String toString() {
            return "UrlMap{" + "url='" + url + '\'' + ", page='" + page + '\'' + '}';
        }

    }


}

