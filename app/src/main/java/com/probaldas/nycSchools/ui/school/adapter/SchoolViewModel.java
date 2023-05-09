package com.probaldas.nycSchools.ui.school.adapter;

import androidx.lifecycle.ViewModel;

import com.probaldas.nycSchools.NYCApplication;

public class SchoolViewModel extends ViewModel {
    private String schoolName;
    private String totalStudents;
    private String primaryAddressLine1;
    private String city;
    private String stateCode;
    private String zip;

    public SchoolViewModel(String schoolName, String totalStudents, String primaryAddressLine1, String city, String stateCode, String zip) {
        NYCApplication.getApplication().getAppComponent().inject(this);

        this.schoolName = schoolName;
        this.totalStudents = totalStudents;
        this.primaryAddressLine1 = primaryAddressLine1;
        this.city = city;
        this.stateCode = stateCode;
        this.zip = zip;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getTotalStudents() {
        return totalStudents;
    }

    public String getPrimaryAddressLine1() {
        return primaryAddressLine1;
    }

    public String getCity() {
        return city;
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getZip() {
        return zip;
    }
}
