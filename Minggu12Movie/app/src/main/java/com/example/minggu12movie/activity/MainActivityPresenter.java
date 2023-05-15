package com.example.minggu12movie.activity;

public class MainActivityPresenter implements MainActivityInteractor.onAppStartedListener{

    private MainActivityView view;
    private MainActivityInteractor interactor;


    public MainActivityPresenter(MainActivityView view, MainActivityInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void updateMovieData(String category){
        interactor.getApiData(category,this);
    }

    @Override
    public void onApiSuccess() {
        if (view != null){
            view.setAdapter(interactor.getMovieList(),interactor.getCategory());
        }
    }

    @Override
    public void onApiFailed() {
        if (view != null){
            view.setErrorMsg(interactor.getErrorMsg());
        }
    }

}
