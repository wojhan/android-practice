package com.github.wojhan.ex9;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private ArrayList<Book> mBookList;

    public BookAdapter() {

    }

    public BookAdapter(ArrayList<Book> books) {
        mBookList = books;
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitle, mAuthor;
        public ImageView mCover;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.item_title);
            mAuthor = itemView.findViewById(R.id.item_author);
            mCover = itemView.findViewById(R.id.item_image);
        }
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_item, viewGroup, false);
        BookViewHolder bvh = new BookViewHolder(v);
        return bvh;
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder bookViewHolder, int i) {
        Book currentItem = mBookList.get(i);

        bookViewHolder.mTitle.setText(currentItem.getTitle());
        if(currentItem.getAuthorName() != null && currentItem.getAuthorName().length > 0) {
            bookViewHolder.mAuthor.setText(TextUtils.join(",", currentItem.getAuthorName()));
        }

        if(currentItem.getCoverId() > 0) {
            Picasso.get().load("http://covers.openlibrary.org/b/id/" + currentItem.getCoverId() +".jpg").into(bookViewHolder.mCover);
        }
    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }
}
