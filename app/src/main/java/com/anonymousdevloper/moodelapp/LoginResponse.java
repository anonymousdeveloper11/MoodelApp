package com.anonymousdevloper.moodelapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("emp_id")
    @Expose
    private String empId;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("joined_date")
    @Expose
    private String joinedDate;
    @SerializedName("attendance_id")
    @Expose
    private String attendanceId;
    @SerializedName("branch_id")
    @Expose
    private String branchId;
    @SerializedName("branch_name")
    @Expose
    private String branchName;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("profile_img")
    @Expose
    private String profileImg;

    /**
     * No args constructor for use in serialization
     *
     */
    public LoginResponse() {
    }


    public LoginResponse(String fullName, String username, String empId, String gender, String joinedDate, String attendanceId, String branchId, String branchName, String department, String unit, String designation, String profileImg) {
        super();
        this.fullName = fullName;
        this.username = username;
        this.empId = empId;
        this.gender = gender;
        this.joinedDate = joinedDate;
        this.attendanceId = attendanceId;
        this.branchId = branchId;
        this.branchName = branchName;
        this.department = department;
        this.unit = unit;
        this.designation = designation;
        this.profileImg = profileImg;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }
}
