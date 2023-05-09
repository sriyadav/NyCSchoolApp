package com.probaldas.nycSchools.repositories;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.probaldas.nycSchools.NYCApplication;
import com.probaldas.nycSchools.models.ApiError;
import com.probaldas.nycSchools.models.SchoolDetails;
import com.probaldas.nycSchools.services.WebService;
import com.probaldas.nycSchools.utils.ErrorUtils;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiDataSource extends PageKeyedDataSource<Integer, SchoolDetails> {

    private static final String TAG = ApiDataSource.class.getSimpleName();
    private static final int FIRST_PAGE = 1;
    private static final int PAGE_START_INDEX = 0;
    public static final int PAGE_SIZE = 10;

    private WebService webService;
    private ErrorUtils errorUtils;

    @Inject
    public ApiDataSource(WebService webService, ErrorUtils errorUtils) {
        this.webService = webService;
        this.errorUtils = errorUtils;
    }

    /*
     * Loading initial set of data (first 10 commits)
     * */
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, SchoolDetails> callback) {
        webService.getSchoolDetails(PAGE_SIZE, PAGE_START_INDEX)
                .enqueue(new Callback<List<SchoolDetails>>() {
                    @Override
                    public void onResponse(Call<List<SchoolDetails>> call, Response<List<SchoolDetails>> response) {
                        Log.i(TAG, "loadInitial called for " + FIRST_PAGE + " page");
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                callback.onResult(response.body(), null, PAGE_START_INDEX + PAGE_SIZE);
                            }
                        } else {
                            ApiError error = errorUtils.parseError(response);
                            showErrorToast(error.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<SchoolDetails>> call, Throwable t) {
                        showErrorToast("Error - " + t.getMessage());
                    }
                });
    }

    /*
     * Loading previous data set (previous 10 commits)
     * */
    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, SchoolDetails> callback) {
        webService.getSchoolDetails(PAGE_SIZE, params.key)
                .enqueue(new Callback<List<SchoolDetails>>() {
                    @Override
                    public void onResponse(Call<List<SchoolDetails>> call, Response<List<SchoolDetails>> response) {
                        Log.i(TAG, "loadInitial called for " + params.key + " page");
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                Integer key = (params.key > PAGE_SIZE) ? params.key - PAGE_SIZE : null;
                                callback.onResult(response.body(), key);
                            }
                        } else {
                            ApiError error = errorUtils.parseError(response);
                            showErrorToast(error.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<SchoolDetails>> call, Throwable t) {
                        showErrorToast("Error - " + t.getMessage());
                    }
                });
    }

    /*
     * Loading next set of data (next 10 commits)
     * */
    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, SchoolDetails> callback) {
        webService.getSchoolDetails(PAGE_SIZE, params.key)
                .enqueue(new Callback<List<SchoolDetails>>() {
                    @Override
                    public void onResponse(Call<List<SchoolDetails>> call, Response<List<SchoolDetails>> response) {
                        Log.i(TAG, "loadInitial called for " + params.key + " page");
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                Integer key = response.body().size() != 0 ? params.key + PAGE_SIZE : null;
                                callback.onResult(response.body(), key);
                            }
                        } else {
                            ApiError error = errorUtils.parseError(response);
                            showErrorToast(error.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<SchoolDetails>> call, Throwable t) {
                        showErrorToast("Error - " + t.getMessage());
                    }
                });
    }

    /*
     * Helper method for Error Toast
     * */
    private void showErrorToast(String error) {
        Toast.makeText(NYCApplication.getApplication().getApplicationContext(), error, Toast.LENGTH_LONG).show();
    }
}
