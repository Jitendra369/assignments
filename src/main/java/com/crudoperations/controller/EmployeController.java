package com.crudoperations.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crudoperations.impl.EmployeServImple;
import com.crudoperations.model.Employes;
import com.crudoperations.model.ErrorResponse;
import com.crudoperations.model.ServerResponse;

import jakarta.transaction.Transactional;
import lombok.experimental.SuperBuilder;

@RestController
@RequestMapping("employe")
public class EmployeController {
	
	@Autowired
	private EmployeServImple employeServImple;

//	save employee handler
	@PostMapping("/")
	public ResponseEntity<Employes> saveEmploye(@RequestBody Employes employes){
		Employes emp = this.employeServImple.saveEmploye(employes);
		
		return new ResponseEntity<Employes>(emp, HttpStatus.OK);
	}
	
//	get All Employee
	@GetMapping("/alluser")
	public ResponseEntity<List<Employes>> getAllEmploye(){
		List<Employes> allEmploye = this.employeServImple.getAllEmploye();
		return new ResponseEntity<List<Employes>>(allEmploye, HttpStatus.OK);
	}
	
//	get single employe
	@GetMapping("/user")
	public ResponseEntity<?> getEmployeByName(
			@RequestParam(value = "name", defaultValue = "emp" , required = false) String name){
				
		Employes emp = this.employeServImple.getEmployes(name);
		if(emp== null) {
//			return new ResponseEntity<ErrorResponse>( new ErrorResponse("no data found", HttpStatus.INTERNAL_SERVER_ERROR) , HttpStatus.INTERNAL_SERVER_ERROR);
			return ResponseEntity.ok( 
					new ServerResponse(HttpStatus.INTERNAL_SERVER_ERROR, "", "name is not present"));
		}
//		return new ResponseEntity<Employes>(emp, HttpStatus.OK);
		return ResponseEntity.ok( 
				new ServerResponse(HttpStatus.OK, "", "single employe", Map.of("server-response", emp)));
	}
	
//	delete Employe Handler 
	@DeleteMapping("/user")
	@Transactional
	public ResponseEntity<?> deleteEmploye(
			@RequestParam(value="name", defaultValue = "emp", required = false) String name) {
		
		this.employeServImple.deleteEmploye(name);  // handle the error in this line
		
		return ResponseEntity.ok(
				new ServerResponse(HttpStatus.OK,"","employe deleted"));
	}
	
//	get the employee with id 
	@GetMapping("/user/{userid}")
	public ResponseEntity<?> getEmployeByid(@PathVariable("userid") int userId){
		Optional<Employes> emp = this.employeServImple.getEmployesById(userId);
		if (emp.isEmpty()) {
//			value not present
			return ResponseEntity.ok(new ServerResponse(HttpStatus.INTERNAL_SERVER_ERROR, "", "user with id "+ userId+" is not present"));
		}
//		value present
		return ResponseEntity.ok(new ServerResponse(HttpStatus.OK, "","user present", Map.of("server-response", emp)));
	}
	
//	check weather user present or not 
	@GetMapping("/user/check")
	public ResponseEntity<?> checkUser(@RequestParam(value="id", defaultValue = "0", required = false) int userid ){
		boolean isPresent = this.employeServImple.isUserPresentInDB(userid);
//		 .message(server.getStatus() == Status.SERVER_UP ? "ping sucess" : "ping fail")
		return ResponseEntity.ok(new ServerResponse(HttpStatus.OK,"","user present stataus",Map.of("server-response",
				isPresent ? "user-present" : "user not present"
				)));
	}
	
	@GetMapping("/user/count")
	public ResponseEntity<?> countOfEmploye(@RequestParam(value = "name", defaultValue = "name", required = false) String name ){
		int countOfEmployes = this.employeServImple.countOfEmployes(name);
		return ResponseEntity.ok(Map.of("server-response", countOfEmployes));
	}
	
	
}
