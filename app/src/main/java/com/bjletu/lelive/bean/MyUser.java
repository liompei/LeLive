package com.bjletu.lelive.bean;

import com.bjletu.lelive.util.SharedPreferencesUtils;

import java.io.Serializable;

/**
 * Created by Liompei
 * Time 2017/10/5 11:15
 * 1137694912@qq.com
 * remark:
 */

public class MyUser implements Serializable {

    /**
     * accid : 130277853311497851562579
     * addressBookType :
     * attestation : 2
     * birthday : 2017-06-19
     * company :
     * companyAssress :
     * connectionnumber : 38791026
     * createTime : 1497851563000
     * educationBg :
     * headPortrait : https://www.bjletu.com/cdn/userHead/e62f9804-4e87-407f-aafa-eb017bc90cd1.jpg
     * homeadress :
     * level : 1级
     * location :
     * loginToken : 652228cc31c14f09bedc13cc5943d8b4
     * major :
     * password : b8bbb92613abfb092d9f8752434a36b9
     * position :
     * profession :
     * realname :
     * school :
     * schoolAddress :
     * sex : 1
     * sign :
     * telnumber : 13027785331
     * token : f31b70c4ecbd3393eb4105695fb6e2e8
     * unionid :
     * userId : 82cf1db754b311e7bbe700163e1038f9
     * username : 测试小号
     * wechat :
     */

    private String accid;
    private String addressBookType;
    private int attestation;
    private String birthday;
    private String company;
    private String companyAssress;
    private String connectionnumber;
    private long createTime;
    private String educationBg;
    private String headPortrait;
    private String homeadress;
    private String level;
    private String location;
    private String loginToken;
    private String major;
    private String password;
    private String position;
    private String profession;
    private String realname;
    private String school;
    private String schoolAddress;
    private int sex;
    private String sign;
    private String telnumber;
    private String token;
    private String unionid;
    private String userId;
    private String username;
    private String wechat;


    public static void save(MyUser myUser) {
        SharedPreferencesUtils.put("accid", myUser.getAccid());
        SharedPreferencesUtils.put("addressBookType", myUser.getAddressBookType());
        SharedPreferencesUtils.put("attestation", myUser.getAttestation());
        SharedPreferencesUtils.put("birthday", myUser.getBirthday());
        SharedPreferencesUtils.put("company", myUser.getCompany());
        SharedPreferencesUtils.put("companyAssress", myUser.getCompanyAssress());
        SharedPreferencesUtils.put("connectionnumber", myUser.getConnectionnumber());
        SharedPreferencesUtils.put("createTime", myUser.getCreateTime());
        SharedPreferencesUtils.put("educationBg", myUser.getEducationBg());
        SharedPreferencesUtils.put("headPortrait", myUser.getHeadPortrait());
        SharedPreferencesUtils.put("homeadress", myUser.getHomeadress());
        SharedPreferencesUtils.put("level", myUser.getLevel());
        SharedPreferencesUtils.put("location", myUser.getLocation());
        SharedPreferencesUtils.put("loginToken", myUser.getLoginToken());
        SharedPreferencesUtils.put("major", myUser.getMajor());
        SharedPreferencesUtils.put("password", myUser.getPassword());
        SharedPreferencesUtils.put("position", myUser.getPosition());
        SharedPreferencesUtils.put("profession", myUser.getProfession());
        SharedPreferencesUtils.put("realname", myUser.getRealname());
        SharedPreferencesUtils.put("school", myUser.getSchool());
        SharedPreferencesUtils.put("schoolAddress", myUser.getSchoolAddress());
        SharedPreferencesUtils.put("sex", myUser.getSex());
        SharedPreferencesUtils.put("sign", myUser.getSign());
        SharedPreferencesUtils.put("telnumber", myUser.getTelnumber());
        SharedPreferencesUtils.put("token", myUser.getToken());
        SharedPreferencesUtils.put("unionid", myUser.getUnionid());
        SharedPreferencesUtils.put("userId", myUser.getUserId());
        SharedPreferencesUtils.put("username", myUser.getUsername());
        SharedPreferencesUtils.put("wechat", myUser.getWechat());
        SharedPreferencesUtils.put("liompei", true);
    }




    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getAddressBookType() {
        return addressBookType;
    }

    public void setAddressBookType(String addressBookType) {
        this.addressBookType = addressBookType;
    }

    public int getAttestation() {
        return attestation;
    }

    public void setAttestation(int attestation) {
        this.attestation = attestation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyAssress() {
        return companyAssress;
    }

    public void setCompanyAssress(String companyAssress) {
        this.companyAssress = companyAssress;
    }

    public String getConnectionnumber() {
        return connectionnumber;
    }

    public void setConnectionnumber(String connectionnumber) {
        this.connectionnumber = connectionnumber;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getEducationBg() {
        return educationBg;
    }

    public void setEducationBg(String educationBg) {
        this.educationBg = educationBg;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getHomeadress() {
        return homeadress;
    }

    public void setHomeadress(String homeadress) {
        this.homeadress = homeadress;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
}
