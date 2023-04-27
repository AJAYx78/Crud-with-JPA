package com.example.crud1.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.utils.StatusResponse;

@RestController
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
	
		this.studentService = studentService;
	}
	
	
	@PostMapping("/student")
	public ResponseEntity<StatusResponse> saveStudent(@RequestBody StudentModel studentModel) {
//		studentService.save(studentModel);
//		return "Data successfully inserted";

		StatusResponse statusResp=new StatusResponse();
		try {
			  StudentModel save = studentService.save(studentModel);
			  if (save!=null) 
			  {
				  statusResp.setStatusCode(201);
				  statusResp.setTotalCount((long) 1);
				  
				  statusResp.setStatusMessage("Record created succesfully");
				  statusResp.setSuccess(true);
				  
				  return new ResponseEntity<>(statusResp , HttpStatus.CREATED);
			  }
			  else {
				  statusResp.setStatusCode(404);
//				  statusResp.setTotalCount((long) 1);
				  statusResp.setStatusMessage("something went wrong");
				  statusResp.setSuccess(false);
				  
				  return new ResponseEntity<>(statusResp , HttpStatus.NOT_FOUND);
				  
			  }
				
			
		} catch (Exception e) {
			statusResp.setStatusMessage("Internal servor_error"); 
			statusResp.setStatusCode(500);
//			  statusResp.setTotalCount((long) 1);
			 statusResp.setSuccess(false);
			 return new ResponseEntity<>(statusResp , HttpStatus.INTERNAL_SERVER_ERROR);
			 
			
		}
	
	
	
	
	
	}
	
	@GetMapping("/student/{emailId}")
	public ResponseEntity<StatusResponse> findStudentByEmail(@PathVariable String emailId) 
	{
		StatusResponse<StudentModel> statusResp = new StatusResponse<>();
		
		
		
		try {
			StudentModel model = studentService.getByEmail(emailId);
			List<StudentModel> studentList = new ArrayList<>();
			studentList.add(model);
			
			if (model != null) 
			{
				statusResp.setData(studentList);
				statusResp.setStatusCode(201);
				statusResp.setTotalCount((long) 1);
				statusResp.setStatusMessage("Record fetched succesfully");
				statusResp.setSuccess(true);
				

				return new ResponseEntity<>(statusResp, HttpStatus.OK);
			} else {
				statusResp.setStatusCode(404); // statusResp.setTotalCount((long) 1);
				statusResp.setStatusMessage("something went wrong");
				statusResp.setSuccess(false);

				return new ResponseEntity<>(statusResp, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			statusResp.setStatusMessage("Internal servor_error");
			statusResp.setStatusCode(500); // statusResp.setTotalCount((long) 1);
			statusResp.setSuccess(false);
			return new ResponseEntity<>(statusResp, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		
	}

	
	
	

	@PostMapping("/update")
	public ResponseEntity<StatusResponse> updateStudent(@RequestBody StudentModel studentModel)
	{
//		studentService.updateStudent(studentModel);
//		return null;
	         

	StatusResponse<StudentModel> statusResp=new StatusResponse();
	 try {
		 StudentModel update = studentService.updateStudent(studentModel);
		 if(update!=null) {
			 statusResp.setStatusCode(200);
			 statusResp.setTotalCount((long) 1);
			 statusResp.setStatusMessage("Record updated succesfully");
			 statusResp.setSuccess(true);
			  return new  ResponseEntity<> (statusResp , HttpStatus.OK);
			 
			 
			 
		 }else
			{

				statusResp.setStatusCode(404);
				statusResp.setStatusMessage("Something went wrong while creating data");
				statusResp.setSuccess(false);
				return new ResponseEntity<>(statusResp, HttpStatus.NOT_FOUND);
				
			}
		 
		
	} catch (Exception e) {
		statusResp.setStatusMessage("INTERNAL_SERVER_ERROR");
		statusResp.setSuccess(false);
		statusResp.setStatusCode(500);
		return new ResponseEntity(statusResp, HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	
	
	
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<StatusResponse> deleteStudent(@PathVariable("id") int id) {
//		studentService.deleteStudent(id);
 //		return"deleted!!!";
		
		StatusResponse<StudentModel> statusResp=new StatusResponse();
		
		try {
			 String delete = studentService.deleteStudent(id);
			 if(delete!=null) {
				 statusResp.setStatusCode(200);
				 statusResp.setTotalCount((long) 1);
				 statusResp.setStatusMessage("Student record of id " +""+ id +"" + " deleted succesfully");
				 statusResp.setSuccess(true);
				  return new  ResponseEntity<> (statusResp , HttpStatus.OK);	
				 
				 
				 
			 }else
				{

					statusResp.setStatusCode(404);
					statusResp.setStatusMessage("Something went wrong while deleting data");
					statusResp.setSuccess(false);
					return new ResponseEntity<>(statusResp, HttpStatus.NOT_FOUND);
					
				}
			 
			
		} catch (Exception e) {
			statusResp.setStatusMessage("INTERNAL_SERVER_ERROR");
			statusResp.setSuccess(false);
			statusResp.setStatusCode(500);
			return new ResponseEntity(statusResp, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		
		
		
		}
		
		
		
	
	

	@GetMapping("/students")
	public ResponseEntity<StatusResponse> getAllStudents(@RequestParam(value = "pageNumber" , defaultValue = "1",required = false) Integer pageNumber ,@RequestParam(value = "pageSize" , defaultValue = "5" , required = false) Integer pageSize) 
	{
		StatusResponse<StudentModel> statusResp = new StatusResponse<>();
		
		try {
			
			List<StudentModel> allStudent = studentService.getAllStudent(pageNumber , pageSize);
			
			
			if (allStudent.size()>0) 
			{
				statusResp.setData(allStudent);
				statusResp.setStatusCode(201);
				statusResp.setTotalCount((long) allStudent.size());
				statusResp.setStatusMessage("Record fetched succesfully");
				statusResp.setSuccess(true);
				

				return new ResponseEntity<>(statusResp, HttpStatus.OK);
			} else {
				statusResp.setStatusCode(404); // statusResp.setTotalCount((long) 1);
				statusResp.setStatusMessage("something went wrong");
				statusResp.setSuccess(false);

				return new ResponseEntity<>(statusResp, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			statusResp.setStatusMessage("Internal servor_error");
			statusResp.setStatusCode(500); // statusResp.setTotalCount((long) 1);
			statusResp.setSuccess(false);
			return new ResponseEntity<>(statusResp, HttpStatus.INTERNAL_SERVER_ERROR);

		}


	}
	
	
	
	
	
	
	
	}
	
	
	
	


