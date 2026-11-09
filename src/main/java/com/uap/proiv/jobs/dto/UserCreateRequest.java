package com.uap.proiv.jobs.dto;

public class UserCreateRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;
    private Integer jobId;

    public UserCreateRequest() {}

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirst_Name(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLast_Name(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getJobId() {
        return jobId;
    }
    public void setJob_Id(Integer jobId) {
        this.jobId = jobId;
    }

}
