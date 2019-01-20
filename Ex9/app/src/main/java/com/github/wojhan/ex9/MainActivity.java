package com.github.wojhan.ex9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private BookAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Book> mBookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new BookAdapter(mBookList);
        mLayoutManager = new GridLayoutManager(this, 2);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }

    public void search(View view) {
        String query = ((EditText)findViewById(R.id.searchET)).getText().toString();

        if(!query.isEmpty()) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit retrofit = new Retrofit.Builder().baseUrl(OpenLibraryService.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
            OpenLibraryService service = retrofit.create(OpenLibraryService.class);
            Call<JsonResponse> call =  service.getBooks(query);

            call.enqueue(new Callback<JsonResponse>() {
                @Override
                public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                    JsonResponse jsonResponse = response.body();

                    mBookList = (ArrayList<Book>)jsonResponse.getBooks();
                    mAdapter = new BookAdapter(mBookList);
                    mRecyclerView.setAdapter(mAdapter);

                }

                @Override
                public void onFailure(Call<JsonResponse> call, Throwable t) {
                    Log.d("Error",t.getMessage());
                }
            });
        }
    }
}
