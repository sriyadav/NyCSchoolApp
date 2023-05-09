package com.probaldas.nycSchools.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.probaldas.nycSchools.models.SatScores;
import com.probaldas.nycSchools.models.SchoolDetails;
import com.probaldas.nycSchools.services.WebService;
import com.probaldas.nycSchools.utils.ErrorUtils;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {
    private static final String TAG = AppRepository.class.getSimpleName();

    private WebService webService;
    private ErrorUtils errorUtils;
    private ApiDataSourceFactory dataSourceFactory;
    private PagedList.Config config;

    @Inject
    public AppRepository(WebService webService, ErrorUtils errorUtils, ApiDataSourceFactory dataSourceFactory) {
        this.webService = webService;
        this.errorUtils = errorUtils;
        this.dataSourceFactory = dataSourceFactory;

        config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(ApiDataSource.PAGE_SIZE)
                .build();
    }

    public LiveData<PagedList<SchoolDetails>> getSchoolDetailsList() {
        return (LiveData<PagedList<SchoolDetails>>) (new LivePagedListBuilder(dataSourceFactory, config)).build();
    }

    public MutableLiveData<SatScores> getSatScore(String dbn) {
        final MutableLiveData<SatScores> satScore = new MutableLiveData<>();

        Call<List<SatScores>> call = webService.getSatScore(dbn);
        call.enqueue(new Callback<List<SatScores>>() {
            @Override
            public void onResponse(Call<List<SatScores>> call, Response<List<SatScores>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null && response.body().size() > 0) {
                        satScore.setValue(response.body().get(0));
                    } else {
                        satScore.setValue(null);
                    }
                } else {
                    satScore.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<SatScores>> call, Throwable t) {
                Log.i(TAG, t.getMessage());
                satScore.setValue(null);
            }
        });

        return satScore;
    }
}
