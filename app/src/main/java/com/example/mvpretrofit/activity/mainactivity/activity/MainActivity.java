package com.example.mvpretrofit.activity.mainactivity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpretrofit.activity.mainactivity.contract.MainCOntract;
import com.example.mvpretrofit.activity.mainactivity.presenter.MainPresenter;
import com.example.mvpretrofit.R;

public class MainActivity extends AppCompatActivity implements MainCOntract.MainView {


    TextView result;
    ProgressDialog progressDialog;

    MainPresenter mainPresentor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog= new ProgressDialog(this);
        result=(TextView)findViewById(R.id.text_view_result);
        //initializing MainPresentor refrencing the context from MainView
        mainPresentor= new MainPresenter(this);
        // method from presentor
        mainPresentor.retrofit();

    }

    //METHODS FROM MAINVUEW

    //PROGRESDIALOG
    @Override
    public void showprogress() {

        progressDialog.show();
    }

    @Override
    public void hdieprogreess() {
        progressDialog.hide();

    }

    //PRINT OUT CODE FOR SUCCESS //200 https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
    @Override
    public void onSuccess(String message) {

        Toast.makeText(this, message,Toast.LENGTH_LONG).show();
    }

    //PRINT OUT CODE FOR FAILURE
    @Override
    public void onFailure(String message) {
        Toast.makeText(this, message,Toast.LENGTH_LONG).show();

    }

    //TEXTVIEW APPENDING RESULT FROM RETROFIT REQUEST
    @Override
    public void Result(String content) {
        result.append(content);

    }
}
