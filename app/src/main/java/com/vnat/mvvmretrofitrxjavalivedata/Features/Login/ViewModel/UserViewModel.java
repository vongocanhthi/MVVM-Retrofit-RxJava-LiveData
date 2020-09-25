package com.vnat.mvvmretrofitrxjavalivedata.Features.Login.ViewModel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vnat.mvvmretrofitrxjavalivedata.API.ApiService;
import com.vnat.mvvmretrofitrxjavalivedata.API.ClientService;
import com.vnat.mvvmretrofitrxjavalivedata.Features.Login.Model.User;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserViewModel extends ViewModel {
    private ClientService clientService;
    private MutableLiveData<User> userLiveData;
    private MutableLiveData<List<User>> userListLiveData;

    public void init(){
        if (userListLiveData != null){
            return;
        }
        userLiveData = new MutableLiveData<>();
        userListLiveData = new MutableLiveData<>();
        clientService = ApiService.getClientService();
    }

    public void getListUser(){
        clientService.getListUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<User> users) {
                        userListLiveData.setValue(users);
//                        Log.d("zzz", userListLiveData.)
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                });
    }

    public void getUser(int id){
        clientService.getUser(id)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        userLiveData.setValue(user);
                        Log.d("zzz", user.getName());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<List<User>> getUserListLiveData() {
        return userListLiveData;
    }

    public LiveData<User> getUserLiveData() {
        return userLiveData;
    }

}
