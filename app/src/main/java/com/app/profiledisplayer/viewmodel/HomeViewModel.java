package com.app.profiledisplayer.viewmodel;

import android.app.Application;
import android.util.AndroidRuntimeException;

import com.app.profiledisplayer.data.DataRepository;
import com.app.profiledisplayer.dto.PeopleResponse;
import com.app.profiledisplayer.dto.Root;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class HomeViewModel  extends ViewModel {
    public  final DataRepository dataRepository;
    private MutableLiveData<Root> peopleResponse;


    @ViewModelInject
   public HomeViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void init(){
        peopleResponse =   dataRepository.getUsers();
    }

    public MutableLiveData<Boolean> getShowProgressDialog() {
        return dataRepository.getShowProgressDialog();
    }

    public MutableLiveData<Root> getPeopleResponse() {
        return peopleResponse;
    }
}
