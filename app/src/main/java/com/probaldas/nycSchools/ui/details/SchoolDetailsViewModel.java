package com.probaldas.nycSchools.ui.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.probaldas.nycSchools.NYCApplication;
import com.probaldas.nycSchools.models.SatScores;
import com.probaldas.nycSchools.models.SchoolDetails;
import com.probaldas.nycSchools.repositories.AppRepository;

import javax.inject.Inject;

public class SchoolDetailsViewModel extends ViewModel {

    @Inject
    AppRepository appRepository;
    private SchoolDetails schoolDetails;

    public SchoolDetailsViewModel() {
        NYCApplication.getApplication().getAppComponent().inject(this);
    }

    public LiveData<SatScores> getSatScore(String dbn) {
        return appRepository.getSatScore(dbn);
    }

    public SchoolDetails getSchoolDetails() {
        return schoolDetails;
    }

    public void setSchoolDetails(SchoolDetails schoolDetails) {
        this.schoolDetails = schoolDetails;
    }

}
