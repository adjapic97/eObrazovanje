package com.eobrazovanje.ssluzba.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import com.eobrazovanje.ssluzba.entities.enumerations.STUDENT_STATUS;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "student")
@Table(name = "student")
@Getter
@Setter
@DynamicUpdate
public class Student extends Person {

	

	
	@NotBlank
	@Column(name = "index_name", nullable = false, unique = true)
	@Getter
	@Setter
	private String indexNumber;
	
	@Column(name = "high_school", nullable = false)
	@Getter
	@Setter
	private String highSchool;
	
	@Column(name = "hs_finish_year")
	@Getter
	@Setter
	private String hsFinishYear;
	
	@Column(name = "parent_name")
	@Getter
	@Setter
	private String parentName;
	
	@Column(name = "current_year", nullable = false)
	@Getter
	@Setter
	private int currentYear;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	@Getter
	@Setter
	private Course course;
	
	
	@Column(name = "avg_grade")
	@Getter
	@Setter
	private Double avgGrade;
	
	
	@Enumerated(EnumType.STRING)
	private STUDENT_STATUS studentStatus;
	
 
	
	
	@OneToMany(mappedBy = "student")
	@Getter
	@Setter
	private Set<StudentHasSubject> studentHasSubject;
	
	@OneToMany(mappedBy = "student")
	@Getter
	@Setter
	private Set<StudentHasColloqium> studentHasColloqium;
	

	public Student() {
		
	}
	
	
	
	

	public Student( @NotBlank String indexNumber,
			String highSchool, String hsFinishYear, String parentName, int currentYear, Double avgGrade,
			Set<StudentHasSubject> studentHasSubject) {
		super();

		this.indexNumber = indexNumber;
		this.highSchool = highSchool;
		this.hsFinishYear = hsFinishYear;
		this.parentName = parentName;
		this.currentYear = currentYear;
		this.avgGrade = avgGrade;
		this.studentHasSubject = studentHasSubject;
	}





	@Override
	public String toString() {
		return "Student [indexNumber=" + indexNumber + ", highSchool=" + highSchool + ", hsFinishYear=" + hsFinishYear
				+ ", parentName=" + parentName + ", currentYear=" + currentYear + ", avgGrade=" + avgGrade
				+ ", studentStatus=" + studentStatus + ", studentHasSubject=" + studentHasSubject
				+ ", studentHasColloqium=" + studentHasColloqium + "]";
	}





	public Student(@NotBlank String indexNumber, String highSchool, String hsFinishYear, String parentName,
			int currentYear, Course course, Double avgGrade, STUDENT_STATUS studentStatus,
			Set<StudentHasSubject> studentHasSubject, Set<StudentHasColloqium> studentHasColloqium) {
		super();
		this.indexNumber = indexNumber;
		this.highSchool = highSchool;
		this.hsFinishYear = hsFinishYear;
		this.parentName = parentName;
		this.currentYear = currentYear;
		this.course = course;
		this.avgGrade = avgGrade;
		this.studentStatus = studentStatus;
		this.studentHasSubject = studentHasSubject;
		this.studentHasColloqium = studentHasColloqium;
	}


	
	
	
	
	
	
	
	
	
}
