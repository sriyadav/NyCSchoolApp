package com.probaldas.nycSchools.ui.school;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.probaldas.nycSchools.NYCApplication;
import com.probaldas.nycSchools.models.SchoolDetails;
import com.probaldas.nycSchools.repositories.AppRepository;

import javax.inject.Inject;

public class SchoolListViewModel extends ViewModel {

    @Inject
    AppRepository appRepository;

    public SchoolListViewModel() {
        NYCApplication.getApplication().getAppComponent().inject(this);
    }

    public LiveData<PagedList<SchoolDetails>> getSchoolDetailsList() {
        return appRepository.getSchoolDetailsList();
    }
}
