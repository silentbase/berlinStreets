package com.example.berlinstreets.presenter;

import android.content.Context;

import com.example.berlinstreets.modul.User;
import com.example.berlinstreets.view.ILoginRegisterView;

public class LoginPresenter implements IPresenter {

    private User user;

    private ILoginRegisterView loginView;
    private Context loginContext;

    public LoginPresenter(ILoginRegisterView loginView, Context loginContext) {
        this.loginView = loginView;
        this.loginContext = loginContext;
    }

    @Override
    public void setData(String... data) {
        user = new User(data[0], data[1], loginContext);

        if(!user.isLoginDataValid()){
            loginView.loginFailedAlert("Daten nicht korrekt\nBitte versuche es nochmal");
        } else {
            user.sendLoginRequest();
        }
    }
}
