package net.therap.hyperbee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static net.therap.hyperbee.utils.constant.DomainConstant.DATE_TIME_FIELD;

/**
 * @author bashir
 * @author rayed
 * @author duity
 * @author azim
 * @author zoha
 * @since 11/21/16
 */
@Entity
@Table(name = "profile")
public class Profile implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    private int id;

    @Column(columnDefinition = DATE_TIME_FIELD)
    private Calendar dateOfBirth;

    private String address;

    private String contactNo;

    private String skills;

    private String workHistory;

    private String designation;

    private String school;

    private String college;

    private String university;

    private int jobExperienceYears;

    private Calendar joiningDate;

    private String gender;

    private String imagePath;

    public Profile() {
        this.dateOfBirth = new GregorianCalendar();
        this.joiningDate = new GregorianCalendar();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getWorkHistory() {
        return workHistory;
    }

    public void setWorkHistory(String workHistory) {
        this.workHistory = workHistory;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getJobExperienceYears() {
        return jobExperienceYears;
    }

    public void setJobExperienceYears(int jobExperienceYears) {
        this.jobExperienceYears = jobExperienceYears;
    }

    public Calendar getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Calendar joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
