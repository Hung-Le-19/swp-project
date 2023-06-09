/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author HaGau
 */
public class Post {

    public int postid;
    public String thumbnail;
    public String title;
    public String brief;
    public String detail;
    public String post_cate;
    public int author;
    public String featured;
    public Date time;
    public String status;

    public Post() {
    }

    public Post(int postid, String thumbnail, String title, String brief, String detail, String post_cate, int author, String featured, Date time, String status) {
        this.postid = postid;
        this.thumbnail = thumbnail;
        this.title = title;
        this.brief = brief;
        this.detail = detail;
        this.post_cate = post_cate;
        this.author = author;
        this.featured = featured;
        this.time = time;
        this.status = status;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPost_cate() {
        return post_cate;
    }

    public void setPost_cate(String post_cate) {
        this.post_cate = post_cate;
    }

    

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getFeatured() {
        return featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


}
