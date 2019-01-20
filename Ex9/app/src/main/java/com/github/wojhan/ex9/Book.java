package com.github.wojhan.ex9;

import com.google.gson.annotations.SerializedName;

public class Book {
    @SerializedName("title")
    private String title;

    @SerializedName("author_name")
    private String[] authorName;

    @SerializedName("cover_i")
    private int coverId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String[] authorName) {
        this.authorName = authorName;
    }

    public int getCoverId() {
        return coverId;
    }
}
