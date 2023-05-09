package com.probaldas.nycSchools.services;

import com.probaldas.nycSchools.models.SatScores;
import com.probaldas.nycSchools.models.SchoolDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {
    @GET("resource/s3k6-pzi2.json")
    Call<List<SchoolDetails>> getSchoolDetails(@Query("$limit") int pageSize, @Query("$offset") int startIndex);

    @GET("resource/f9bf-2cp4.json")
    Call<List<SatScores>> getSatScore(@Query("dbn") String dbn);
}
