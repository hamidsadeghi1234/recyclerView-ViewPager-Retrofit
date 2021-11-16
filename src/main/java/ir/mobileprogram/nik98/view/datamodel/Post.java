package ir.mobileprogram.nik98.view.datamodel;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("id")
    private  int id;
    @SerializedName("image_url")
    private String image_url;
    @SerializedName("title")
    private  String title;
    @SerializedName("content")
    private  String content;
    @SerializedName("date")
    private  String date;


    public int    getId()
    {
        return id;
    }
    public void   setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void   setTitle(String title) {
        this.title = title;
    }
    public String getContent() { return content;}
    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
