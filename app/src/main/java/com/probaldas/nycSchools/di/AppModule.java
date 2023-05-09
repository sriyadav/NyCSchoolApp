package com.probaldas.nycSchools.di;

import com.probaldas.nycSchools.repositories.ApiDataSource;
import com.probaldas.nycSchools.repositories.ApiDataSourceFactory;
import com.probaldas.nycSchools.repositories.AppRepository;
import com.probaldas.nycSchools.services.WebService;
import com.probaldas.nycSchools.utils.ErrorUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    private static final String BASE_URL = "https://data.cityofnewyork.us/";

    @Provides
    @Singleton
    final HttpLoggingInterceptor provideInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    final OkHttpClient provideHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Provides
    @Singleton
    final Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    final WebService provideWebService(Retrofit retrofit) {
        return retrofit.create(WebService.class);
    }

    @Provides
    final ErrorUtils provideErrorUtils(Retrofit retrofit) {
        return new ErrorUtils(retrofit);
    }

    @Provides
    final ApiDataSource provideDataSource(WebService webService, ErrorUtils errorUtils) {
        return new ApiDataSource(webService, errorUtils);
    }

    @Provides
    @Singleton
    final ApiDataSourceFactory provideDataSourceFactory(ApiDataSource apiDataSource) {
        return new ApiDataSourceFactory(apiDataSource);
    }

    @Provides
    final AppRepository provideRepository(WebService webService, ErrorUtils errorUtils, ApiDataSourceFactory dataSourceFactory) {
        return new AppRepository(webService, errorUtils, dataSourceFactory);
    }
}
