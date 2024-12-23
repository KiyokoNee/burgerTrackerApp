package com.gearing.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gearing.burgertracker.models.Burger;
import com.gearing.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	@Autowired
	private BurgerRepository burgerRepository;
	
	public List<Burger> allBurgers() {
		return burgerRepository.findAll();
	}
	
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		return optionalBurger.isPresent() ? optionalBurger.get() : null;
	}
	
	public Burger updateBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	public void deleteBurgerById(Long id) {
		burgerRepository.deleteById(id);
	}
}
