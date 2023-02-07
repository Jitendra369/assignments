package com.crudoperations.service;

import java.util.List;
import java.util.Optional;

import com.crudoperations.model.Employes;

public interface EmployeService {
	
//	save the employe details
	Employes saveEmploye(Employes employes);
	
//	getEmploye By id
	Employes getEmployes(String empName);
	
//	get all employee
	List<Employes> getAllEmploye();
	
//	save all employee, get data in collections 
	List<Employes> saveAllEmploye();
	
//	get the employee by name
	Optional<Employes> getEmployesById(int empId);
	
//	delete userby name 
	void deleteEmploye(String empName);
	
//	delete All employee
	void deleteAllEmploye();
	
//	check weather user present or not in db
	boolean isUserPresentInDB(int userid);
	
	int countOfEmployes(String name);
	
	Employes findByuserNameOrPassword(String empName, int empId);
	
}
