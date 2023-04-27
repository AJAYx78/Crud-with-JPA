package com.example.crud1.student;

import java.util.List;

public interface StudentService {
	
	 	public StudentModel save(StudentModel studentModel);
	
	 	public StudentModel getByEmail(String emailId);
	
	 	 StudentModel updateStudent(StudentModel studentModel);
	 	
	    public String deleteStudent(int id);
	    
	    List<StudentModel> getAllStudent(Integer pageNumber , Integer pageSize);
				
	
	

}
