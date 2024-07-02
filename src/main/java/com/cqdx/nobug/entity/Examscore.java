package com.cqdx.nobug.entity;

import java.io.Serializable;

/**
 * examscore
 * @author 
 */
import lombok.Data;
@Data
public class Examscore  {
    private Integer examscoreid;

    private Integer studentid;

    private Integer courseid;

    private Integer score;

    private Integer credit;

    private static final long serialVersionUID = 1L;

    public Integer getExamscoreid() {
        return examscoreid;
    }

    public void setExamscoreid(Integer examscoreid) {
        this.examscoreid = examscoreid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
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
        Examscore other = (Examscore) that;
        return (this.getExamscoreid() == null ? other.getExamscoreid() == null : this.getExamscoreid().equals(other.getExamscoreid()))
            && (this.getStudentid() == null ? other.getStudentid() == null : this.getStudentid().equals(other.getStudentid()))
            && (this.getCourseid() == null ? other.getCourseid() == null : this.getCourseid().equals(other.getCourseid()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getCredit() == null ? other.getCredit() == null : this.getCredit().equals(other.getCredit()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExamscoreid() == null) ? 0 : getExamscoreid().hashCode());
        result = prime * result + ((getStudentid() == null) ? 0 : getStudentid().hashCode());
        result = prime * result + ((getCourseid() == null) ? 0 : getCourseid().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getCredit() == null) ? 0 : getCredit().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", examscoreid=").append(examscoreid);
        sb.append(", studentid=").append(studentid);
        sb.append(", courseid=").append(courseid);
        sb.append(", score=").append(score);
        sb.append(", credit=").append(credit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}