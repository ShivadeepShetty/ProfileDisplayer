package com.app.profiledisplayer.data;

import com.app.profiledisplayer.dto.PeopleResponse;
import com.app.profiledisplayer.dto.Root;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    ApiInterface apiInterface;

    public DataRepository(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
        showProgressDialog = new MutableLiveData<>();
        peopleResponse = new MutableLiveData<>();
    }

    private MutableLiveData<Boolean> showProgressDialog;
    private MutableLiveData<Root> peopleResponse;

    public MutableLiveData<Root> getUsers() {
        showProgressDialog.postValue(true);
        apiInterface.getUser().enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                showProgressDialog.postValue(false);
                peopleResponse.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                showProgressDialog.postValue(false);

            }
        });
        return peopleResponse;
    }

    public MutableLiveData<Boolean> getShowProgressDialog() {
        return showProgressDialog;
    }
}
