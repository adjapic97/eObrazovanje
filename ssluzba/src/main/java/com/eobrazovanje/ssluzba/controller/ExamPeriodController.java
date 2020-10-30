package com.eobrazovanje.ssluzba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eobrazovanje.ssluzba.dto.StudentHasSubjectDTO;
import com.eobrazovanje.ssluzba.dto.SubjectDTO;
import com.eobrazovanje.ssluzba.dto.converter.StudentHasSubjectToDTO;
import com.eobrazovanje.ssluzba.dto.converter.SubjectToDTO;
import com.eobrazovanje.ssluzba.entities.ExamPeriod;
import com.eobrazovanje.ssluzba.entities.StudentHasSubject;
import com.eobrazovanje.ssluzba.entities.Subject;
import com.eobrazovanje.ssluzba.repository.ExamPeriodRepository;
import com.eobrazovanje.ssluzba.repository.StudentHasSubjectRepository;

@RestController
@RequestMapping("api/exam-period")
public class ExamPeriodController {

	
	@Autowired
	private StudentHasSubjectRepository studentHasSubjectRepository;
	
	
	@Autowired
	private StudentHasSubjectToDTO subToDTO;
	
	
	@Autowired
	private ExamPeriodRepository examPeriodRepository;
	
	@Autowired
	private SubjectToDTO subjectToDTO;
	
	@GetMapping("/subjects")
	public ResponseEntity<List<StudentHasSubjectDTO>> getAllSubjectsForActiveExamPeriod(@RequestParam("id") Long id){
		
		List<StudentHasSubject> studentSubjects = studentHasSubjectRepository.findByStudentId(id);
		
		
		
		

		return new ResponseEntity<List<StudentHasSubjectDTO>>(subToDTO.convert(studentSubjects), HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/get-subjects")
	public ResponseEntity<List<SubjectDTO>> getSubjects(@RequestParam("id") Long id){
		
		List<Subject> studentSubjects = studentHasSubjectRepository.findSubjects(id);
		
		
		
		

		return new ResponseEntity<List<SubjectDTO>>(subjectToDTO.convert(studentSubjects), HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/get-active-exam-period")
	public ResponseEntity<Optional<List<ExamPeriod>>> getExamPeriod(){
		
		Optional<List<ExamPeriod>> examPeriod = examPeriodRepository.findByIsActiveTrue();
		
		
		return new ResponseEntity<Optional<List<ExamPeriod>>>(examPeriod, HttpStatus.OK);

			
		
	}
	
	
	
	
	
	
	
}
