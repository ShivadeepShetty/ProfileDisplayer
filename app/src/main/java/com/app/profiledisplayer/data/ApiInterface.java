package com.app.profiledisplayer.data;

import com.app.profiledisplayer.dto.PeopleResponse;
import com.app.profiledisplayer.dto.Root;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("?inc=gender,name,nat,location,picture,email&results=20")
    Call<Root> getUser();
}
