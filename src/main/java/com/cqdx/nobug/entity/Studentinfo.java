package com.cqdx.nobug.entity;

import java.io.Serializable;

/**
 * studentinfo
 * @author 
 */
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class Studentinfo  {
    @TableId
    private Integer studentid;

    private String name;

    private  String grade;

    private String gender;

    private String ethnicity;

    private String phone;

    private String idnumber;

    private Integer teacherid;

    private String dormitory;

    private String major;

    private String college;

    private static final long serialVersionUID = 1L;

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Studentinfo other = (Studentinfo) that;
        return (this.getStudentid() == null ? other.getStudentid() == null : this.getStudentid().equals(other.getStudentid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getEthnicity() == null ? other.getEthnicity() == null : this.getEthnicity().equals(other.getEthnicity()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getIdnumber() == null ? other.getIdnumber() == null : this.getIdnumber().equals(other.getIdnumber()))
            && (this.getTeacherid() == null ? other.getTeacherid() == null : this.getTeacherid().equals(other.getTeacherid()))
            && (this.getDormitory() == null ? other.getDormitory() == null : this.getDormitory().equals(other.getDormitory()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()))
            && (this.getCollege() == null ? other.getCollege() == null : this.getCollege().equals(other.getCollege()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStudentid() == null) ? 0 : getStudentid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getEthnicity() == null) ? 0 : getEthnicity().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getIdnumber() == null) ? 0 : getIdnumber().hashCode());
        result = prime * result + ((getTeacherid() == null) ? 0 : getTeacherid().hashCode());
        result = prime * result + ((getDormitory() == null) ? 0 : getDormitory().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        result = prime * result + ((getCollege() == null) ? 0 : getCollege().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentid=").append(studentid);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", ethnicity=").append(ethnicity);
        sb.append(", phone=").append(phone);
        sb.append(", idnumber=").append(idnumber);
        sb.append(", teacherid=").append(teacherid);
        sb.append(", dormitory=").append(dormitory);
        sb.append(", major=").append(major);
        sb.append(", college=").append(college);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}