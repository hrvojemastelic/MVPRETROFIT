package com.example.mvpretrofit.activity.mainactivity.contract;

public interface MainCOntract {

    //METHODS IMPLEMENTED IN MAINACTIVITY
    interface MainView {
        void showprogress();
        void hdieprogreess();
        void onSuccess(String message);
        void onFailure(String message);
        void Result(String content);
    }

    //METHODS IN MAINPRESENTER
    interface MainPresenter {
        void retrofit();
    }


}
