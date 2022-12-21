package com.srohter.styper.Logic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HTMLParse {
    public HTMLParse(URL url) {
        this.url = url;
    }

    private URL url;
    public char[] parse(){
        String html = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) html += inputLine;
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document doc = Jsoup.parse(html);
        Element container = doc.select("#row1").first();
        Elements spans = container.select("> span");
        String full = "";
        for (Element span : spans) {
            full= full+span.text()+" ";
        }
        return full.toCharArray();
    }
}
