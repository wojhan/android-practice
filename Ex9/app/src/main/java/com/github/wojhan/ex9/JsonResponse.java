package com.github.wojhan.ex9;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonResponse {
    @SerializedName("docs")
    private List<Book> books;

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();

        for(Book b : this.books) {
            if(b.getCoverId() > -1) {
                books.add(b);
            }
        }

        return books;
    }
}
