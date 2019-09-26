package com.example.mvpretrofit.activity.mainactivity.presenter;

import com.example.mvpretrofit.activity.mainactivity.api.JsonPlaceHolderApi;
import com.example.mvpretrofit.activity.mainactivity.model.Post;
import com.example.mvpretrofit.activity.mainactivity.contract.MainCOntract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPresenter implements MainCOntract.MainPresenter {

    //MAINVUEW INSTANCE SO WE CAN PASS IT THE CONTEXT FROM PRESENTERS METHODS
    MainCOntract.MainView mainView;

    //WE NEED CONSTRUCTOR SO PRESENTER CAN COMMUNICATE WITH VIEW IN BOTH DIRECTIONS
    public MainPresenter(MainCOntract.MainView mainView) {
        this.mainView = mainView;
    }


    public void retrofit() {

        mainView.showprogress();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {


                if (response.isSuccessful()) {

                    mainView.onSuccess("Code: " + response.code());

                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserid() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";


                    mainView.Result(content);
                    mainView.hdieprogreess();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                mainView.onFailure(t.getMessage());
                mainView.hdieprogreess();

            }
        });
    }


}
