package com.probaldas.nycSchools.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class SchoolDetails implements Parcelable {
    @SerializedName("dbn")
    @Expose
    private String dbn;
    @SerializedName("school_name")
    @Expose
    private String schoolName;
    @SerializedName("boro")
    @Expose
    private String boro;
    @SerializedName("overview_paragraph")
    @Expose
    private String overviewParagraph;
    @SerializedName("academicopportunities1")
    @Expose
    private String academicopportunities1;
    @SerializedName("academicopportunities2")
    @Expose
    private String academicopportunities2;
    @SerializedName("academicopportunities3")
    @Expose
    private String academicopportunities3;
    @SerializedName("academicopportunities4")
    @Expose
    private String academicopportunities4;
    @SerializedName("academicopportunities5")
    @Expose
    private String academicopportunities5;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("fax_number")
    @Expose
    private String faxNumber;
    @SerializedName("school_email")
    @Expose
    private String schoolEmail;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("finalgrades")
    @Expose
    private String finalgrades;
    @SerializedName("total_students")
    @Expose
    private String totalStudents;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("extracurricular_activities")
    @Expose
    private String extracurricularActivities;
    @SerializedName("attendance_rate")
    @Expose
    private String attendanceRate;
    @SerializedName("primary_address_line_1")
    @Expose
    private String primaryAddressLine1;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("zip")
    @Expose
    private String zip;
    @SerializedName("state_code")
    @Expose
    private String stateCode;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;

    private SchoolDetails(Parcel in) {
        dbn = in.readString();
        schoolName = in.readString();
        boro = in.readString();
        overviewParagraph = in.readString();
        academicopportunities1 = in.readString();
        academicopportunities2 = in.readString();
        academicopportunities3 = in.readString();
        academicopportunities4 = in.readString();
        academicopportunities5 = in.readString();
        phoneNumber = in.readString();
        faxNumber = in.readString();
        schoolEmail = in.readString();
        website = in.readString();
        finalgrades = in.readString();
        totalStudents = in.readString();
        startTime = in.readString();
        endTime = in.readString();
        extracurricularActivities = in.readString();
        attendanceRate = in.readString();
        primaryAddressLine1 = in.readString();
        city = in.readString();
        zip = in.readString();
        stateCode = in.readString();
        latitude = in.readString();
        longitude = in.readString();
    }

    public static final Creator<SchoolDetails> CREATOR = new Creator<SchoolDetails>() {
        @Override
        public SchoolDetails createFromParcel(Parcel in) {
            return new SchoolDetails(in);
        }

        @Override
        public SchoolDetails[] newArray(int size) {
            return new SchoolDetails[size];
        }
    };

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getBoro() {
        return boro;
    }

    public void setBoro(String boro) {
        this.boro = boro;
    }

    public String getOverviewParagraph() {
        return overviewParagraph;
    }

    public void setOverviewParagraph(String overviewParagraph) {
        this.overviewParagraph = overviewParagraph;
    }

    public String getAcademicopportunities1() {
        return academicopportunities1;
    }

    public void setAcademicopportunities1(String academicopportunities1) {
        this.academicopportunities1 = academicopportunities1;
    }

    public String getAcademicopportunities2() {
        return academicopportunities2;
    }

    public void setAcademicopportunities2(String academicopportunities2) {
        this.academicopportunities2 = academicopportunities2;
    }

    public String getAcademicopportunities3() {
        return academicopportunities3;
    }

    public void setAcademicopportunities3(String academicopportunities3) {
        this.academicopportunities3 = academicopportunities3;
    }

    public String getAcademicopportunities4() {
        return academicopportunities4;
    }

    public void setAcademicopportunities4(String academicopportunities4) {
        this.academicopportunities4 = academicopportunities4;
    }

    public String getAcademicopportunities5() {
        return academicopportunities5;
    }

    public void setAcademicopportunities5(String academicopportunities5) {
        this.academicopportunities5 = academicopportunities5;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFinalgrades() {
        return finalgrades;
    }

    public void setFinalgrades(String finalgrades) {
        this.finalgrades = finalgrades;
    }

    public String getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(String totalStudents) {
        this.totalStudents = totalStudents;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getExtracurricularActivities() {
        return extracurricularActivities;
    }

    public void setExtracurricularActivities(String extracurricularActivities) {
        this.extracurricularActivities = extracurricularActivities;
    }

    public String getAttendanceRate() {
        return attendanceRate;
    }

    public void setAttendanceRate(String attendanceRate) {
        this.attendanceRate = attendanceRate;
    }

    public String getPrimaryAddressLine1() {
        return primaryAddressLine1;
    }

    public void setPrimaryAddressLine1(String primaryAddressLine1) {
        this.primaryAddressLine1 = primaryAddressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolDetails that = (SchoolDetails) o;
        return dbn.equals(that.dbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dbn);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dbn);
        dest.writeString(schoolName);
        dest.writeString(boro);
        dest.writeString(overviewParagraph);
        dest.writeString(academicopportunities1);
        dest.writeString(academicopportunities2);
        dest.writeString(academicopportunities3);
        dest.writeString(academicopportunities4);
        dest.writeString(academicopportunities5);
        dest.writeString(phoneNumber);
        dest.writeString(faxNumber);
        dest.writeString(schoolEmail);
        dest.writeString(website);
        dest.writeString(finalgrades);
        dest.writeString(totalStudents);
        dest.writeString(startTime);
        dest.writeString(endTime);
        dest.writeString(extracurricularActivities);
        dest.writeString(attendanceRate);
        dest.writeString(primaryAddressLine1);
        dest.writeString(city);
        dest.writeString(zip);
        dest.writeString(stateCode);
        dest.writeString(latitude);
        dest.writeString(longitude);
    }
}
