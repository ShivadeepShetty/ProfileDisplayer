package com.app.profiledisplayer.di;

import com.app.profiledisplayer.data.ApiInterface;
import com.app.profiledisplayer.data.DataRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
@InstallIn(ActivityComponent.class)
public class ApplicationModule {


    private static final String BASE_URL = "https://randomuser.me/api/";

    @Provides
    String provideBaseUrl() {
        return BASE_URL;
    }

    @Provides
    OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

    }


    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient, String BASE_URL){
       return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())

               .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();
    }

    @Provides
    ApiInterface provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }

    @Provides
    DataRepository provideDataRepository(ApiInterface apiInterface) {
        return new DataRepository(apiInterface);
    }
}
