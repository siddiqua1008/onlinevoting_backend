package com.example.ovsback.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ovsback.model.Registration;

@Repository
@Qualifier("regRepo")
public interface RegistrationRepository extends JpaRepository<Registration, Integer>{

	List<Registration> findAllByEmailAndPassword(String email,String password);
	
}
