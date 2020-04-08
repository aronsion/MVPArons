package com.arons.mvp.ui.main;

import java.util.List;

public class MainPresenter {

    private MainView mainView;
    private final FindItemsInteractor findItemsInteractor;

    public MainPresenter(MainView mainView, FindItemsInteractor findItemsInteractor) {
        this.mainView = mainView;
        this.findItemsInteractor = findItemsInteractor;
    }

    void onResume(){
        if (mainView != null){
            mainView.showProgress();
        }
        findItemsInteractor.findItems(this::onFinished);
    }

    void onDestory(){
        mainView = null;
    }

    void onItemClicked(String item){
        if (mainView !=null){
            mainView.showMessage(String.format("%s clicked",item));
        }
    }

    public void onFinished(List<String> items) {
        if (mainView != null) {
            mainView.setItems(items);
            mainView.hideProgress();
        }
    }

    public MainView getMainView(){
        return  mainView;
    }
}
