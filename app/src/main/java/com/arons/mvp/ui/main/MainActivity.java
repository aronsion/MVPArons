package com.arons.mvp.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arons.mvp.R;
import com.arons.mvp.ui.main.MainView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView mRecyleView;
    private ProgressBar progressBar;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyleView = findViewById(R.id.recyleview);
        progressBar = findViewById(R.id.progress);
        mMainPresenter = new MainPresenter(this, new FindItemsInteractor());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.onDestory();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        mRecyleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        mRecyleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<String> items) {
        mRecyleView.setAdapter(new MainAdapter(items,mMainPresenter::onItemClicked));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
