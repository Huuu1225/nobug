package com.cqdx.nobug.entity;

import java.io.Serializable;

/**
 * leaveform
 * @author 
 */
import lombok.Data;
@Data
public class Leaveform  {
    private Integer leaveformid;

    private Integer studentid;

    private Integer teacherid;

    private String starttime;

    private String endtime;

    private String leavereason;

    private Integer approval;

    private static final long serialVersionUID = 1L;

    public Integer getLeaveformid() {
        return leaveformid;
    }

    public void setLeaveformid(Integer leaveformid) {
        this.leaveformid = leaveformid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getLeavereason() {
        return leavereason;
    }

    public void setLeavereason(String leavereason) {
        this.leavereason = leavereason;
    }

    public Integer getApproval() {
        return approval;
    }

    public void setApproval(Integer approval) {
        this.approval = approval;
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
        Leaveform other = (Leaveform) that;
        return (this.getLeaveformid() == null ? other.getLeaveformid() == null : this.getLeaveformid().equals(other.getLeaveformid()))
            && (this.getStudentid() == null ? other.getStudentid() == null : this.getStudentid().equals(other.getStudentid()))
            && (this.getTeacherid() == null ? other.getTeacherid() == null : this.getTeacherid().equals(other.getTeacherid()))
            && (this.getStarttime() == null ? other.getStarttime() == null : this.getStarttime().equals(other.getStarttime()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()))
            && (this.getLeavereason() == null ? other.getLeavereason() == null : this.getLeavereason().equals(other.getLeavereason()))
            && (this.getApproval() == null ? other.getApproval() == null : this.getApproval().equals(other.getApproval()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLeaveformid() == null) ? 0 : getLeaveformid().hashCode());
        result = prime * result + ((getStudentid() == null) ? 0 : getStudentid().hashCode());
        result = prime * result + ((getTeacherid() == null) ? 0 : getTeacherid().hashCode());
        result = prime * result + ((getStarttime() == null) ? 0 : getStarttime().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getLeavereason() == null) ? 0 : getLeavereason().hashCode());
        result = prime * result + ((getApproval() == null) ? 0 : getApproval().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", leaveformid=").append(leaveformid);
        sb.append(", studentid=").append(studentid);
        sb.append(", teacherid=").append(teacherid);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", leavereason=").append(leavereason);
        sb.append(", approval=").append(approval);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}