package com.crudoperations.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudoperations.model.Employes;

@Repository
public interface EmployeRepo extends JpaRepository<Employes, Integer>{

	Employes findByName(String name);
	void deleteByName(String name);
	
	int countByName(String name);
}
