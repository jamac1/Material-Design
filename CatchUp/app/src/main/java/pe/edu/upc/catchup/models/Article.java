package pe.edu.upc.catchup.models;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumnos on 9/25/17.
 */

public class Article {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private Source source;

    public Article() {
    }

    public Article(String author, String title, String description, String url, String urlToImage, String publishedAt, Source source) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public Article setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getShortTitle() {
        return title.length() >= 20 ? title.substring(0, 18).concat("...") : title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Article setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Article setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public Article setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
        return this;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public Article setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
        return this;
    }

    public Source getSource() {
        return source;
    }

    public Article setSource(Source source) {
        this.source = source;
        return this;
    }

    public static Article from(JSONObject jsonArticle, Source source) {
        Article article = new Article();
        try {
            article.setSource(source)
                    .setAuthor(jsonArticle.getString("author"))
                    .setTitle(jsonArticle.getString("title"))
                    .setDescription(jsonArticle.getString("description"))
                    .setUrl(jsonArticle.getString("url"))
                    .setUrlToImage(jsonArticle.getString("urlToImage"))
                    .setPublishedAt(jsonArticle.getString("publishedAt"));
            return article;
        } catch(JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Article> from(JSONArray jsonArticles, Source source) {
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i< jsonArticles.length(); i++)
            try {
                articles.add(Article.from(jsonArticles.getJSONObject(i), source));
            } catch(JSONException e) {
                e.printStackTrace();
            }
        return articles;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("author", author);
        bundle.putString("title", title);
        bundle.putString("description", description);
        bundle.putString("url", url);
        bundle.putString("urlToImage", urlToImage);
        bundle.putString("publishedAt", publishedAt);
        return bundle;
    }

    public static Article from(Bundle bundle) {
        Article article = new Article();
        article.setAuthor(bundle.getString("author"))
                .setTitle(bundle.getString("title"))
                .setDescription(bundle.getString("description"))
                .setUrl(bundle.getString("url"))
                .setUrlToImage(bundle.getString("urlToImage"))
                .setPublishedAt(bundle.getString("publishedAt"));
        return article;
    }

}
