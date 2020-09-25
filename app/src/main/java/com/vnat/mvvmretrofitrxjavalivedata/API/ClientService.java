package com.vnat.mvvmretrofitrxjavalivedata.API;

import com.vnat.mvvmretrofitrxjavalivedata.Constant.Constant;
import com.vnat.mvvmretrofitrxjavalivedata.Features.Login.Model.User;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ClientService {
    @GET("users/{id}")
    Flowable<User> getUser(@Path("id") int id);

    @GET("users")
    Single<List<User>> getListUser();
}
