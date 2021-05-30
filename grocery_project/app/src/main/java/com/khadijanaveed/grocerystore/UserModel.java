package com.khadijanaveed.grocerystore;

public class UserModel {
    private int userID;
    private String emailID;
    private String userName;
    private String paswd;
    private long mobileNo;
    private String userType;


    public UserModel(String emailID, String userName, String paswd, long mobileNo, String userType) {
        this.emailID = emailID;
        this.userName = userName;
        this.paswd = paswd;
        this.mobileNo = mobileNo;
        this.userType=userType;
    }
    public UserModel(int userId,String emailID, String userName, String paswd, long mobileNo,String userType) {
        this.userID = userId;
        this.emailID = emailID;
        this.userName = userName;
        this.paswd = paswd;
        this.mobileNo = mobileNo;
        this.userType=userType;
    }

    public UserModel(String userName, String emailID, int mobileNo) {
        this.emailID = emailID;
        this.userName = userName;
        this.mobileNo = mobileNo;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getUserType() {
        return userType;
    }
    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPaswd() {
        return paswd;
    }

    public void setPaswd(String paswd) {
        this.paswd = paswd;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "UserModel{" +
               // "userID=" + userID +
                ", emailID='" + emailID + '\'' +
                ", userName='" + userName + '\'' +
                ", paswd='" + paswd + '\'' +
                ", mobileNo=" + mobileNo +
                '}';
    }
}
