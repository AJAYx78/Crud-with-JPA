package com.example.crud1.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service 
public class StudentServiceImplementation implements StudentService {
	@Autowired
	private StudentRepositry studentRepositry;
	@Override
	public StudentModel save(StudentModel studentModel) {
		// TODO Auto-generated method stub
		return studentRepositry.save(studentModel);
	}
	@Override
	public StudentModel getByEmail(String emailId) {
		// TODO Auto-generated method stub
		return studentRepositry.findByEmail(emailId);
		
	}
	

	@Override
	public String deleteStudent(int id) {
		if(studentRepositry.existsById(id)) {
		studentRepositry.deleteById(id);
		return "Record Deleted  succesfully";
	}else
	{
		return null;
	}
	}
	
	
	@Override
	public StudentModel updateStudent(StudentModel studentModel) {
		
		Integer id2 = studentModel.getId();
		StudentModel std = studentRepositry.findById(id2).get();
		
		std.setName(studentModel.getName());
		std.setAddress(studentModel.getAddress());
		std.setCourse(studentModel.getCourse());
		return studentRepositry.save(std);
	}
	
	@Override
	public List<StudentModel> getAllStudent(Integer pageNumber, Integer pageSize) {
		

		Pageable p = PageRequest.of(pageNumber, pageSize);  

		Page<StudentModel> pagePost = studentRepositry.findAll(p);
		List<StudentModel> content = pagePost.getContent();

		return (List<StudentModel>) content;
		
	}
	
	
	
	
	
		
	
	/*
	 * @Override public List<StudentModel> getAllStudent() {
	 * 
	 * int pageSize=5; int pageNumber=1;
	 * 
	 * Pageable p=PageRequest.of(pageNumber, pageSize);
	 * 
	 * 
	 * 
	 * 
	 * List<StudentModel> allStudent=studentRepositry.findAll();
	 * 
	 * 
	 * List<StudentModel> getAll=allStudent.stream().map((studentModel) ->
	 * modelMapper.map());
	 * 
	 * 
	 * return null; }
	 */
		
	
	
	
	
	

	
}
