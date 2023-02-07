package com.crudoperations.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudoperations.model.Employes;
import com.crudoperations.repo.EmployeRepo;
import com.crudoperations.service.EmployeService;

@Service
public class EmployeServImple implements EmployeService{
	
	@Autowired
	private EmployeRepo employeRepo;

	@Override
	public Employes saveEmploye(Employes employes) {
		return this.employeRepo.save(employes);
		
	}

	@Override
	public Employes getEmployes(String empName) {
		Employes emp = this.employeRepo.findByName(empName);
//		System.out.println("Employe name " +emp.getName());
		return emp;
	}

	@Override
	public List<Employes> getAllEmploye() {
		List<Employes> allEmployes = this.employeRepo.findAll();
		return allEmployes;
	}

	@Override
	public List<Employes> saveAllEmploye() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteEmploye(String empName) {
		this.employeRepo.deleteByName(empName);
		
	}

	@Override
	public void deleteAllEmploye() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Employes> getEmployesById(int empId) {
		return this.employeRepo.findById(empId);
	}

	@Override
	public boolean isUserPresentInDB(int userid) {
		boolean value = this.employeRepo.existsById(userid);
		return value;
	}

	@Override
	public Employes findByuserNameOrPassword(String empName, int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countOfEmployes(String name) {
		int countByName = this.employeRepo.countByName(name);
		return countByName;
	}

	

}
