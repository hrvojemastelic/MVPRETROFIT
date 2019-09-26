package com.example.mvpretrofit.activity.mainactivity.api;



import com.example.mvpretrofit.activity.mainactivity.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();
}
