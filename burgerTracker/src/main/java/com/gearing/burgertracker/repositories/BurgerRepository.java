package com.gearing.burgertracker.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gearing.burgertracker.models.Burger;


@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {
	// retrieve all burgers
	List<Burger> findAll();
	
	// find burger by given id **
	Optional<Burger> findById(Long id);
	
	// delete burger by given id **
	void deleteById(Long id);
	
	// ** these methods may not need to be included, due to how the CrudRepo is set up
}
