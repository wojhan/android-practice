package com.github.wojhan.ex9;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenLibraryService {
    String BASE_URL = "http://openlibrary.org/";

    @GET("search.json")
    Call<JsonResponse> getBooks(@Query("q") String query);
}
