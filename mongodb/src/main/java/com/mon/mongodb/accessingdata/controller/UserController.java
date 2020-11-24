package com.mon.mongodb.accessingdata.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mon.mongodb.accessingdata.dal.CharacterDal;
import com.mon.mongodb.accessingdata.dal.FellowshipRepository;
import com.mon.mongodb.accessingdata.model.Character;

@RestController
@RequestMapping(value = "/")
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final FellowshipRepository repo;
	
	private final CharacterDal characterDal;
	
	
	public UserController(FellowshipRepository repo, CharacterDal charDal) {
		this.repo = repo;
		this.characterDal = charDal; 
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Character addNewChar(@RequestBody Character character) {
		logger.info("Saving User");
		return repo.save(character);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Character> getAllCharacters() {
		logger.info("Getting all characters.");
		return repo.findAll();
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public Character getChar(@PathVariable("id") String id) {
//		logger.info("Getting user with ID: {}.", id);
//		return repo.findOne(id);
//	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteByEmpId(@PathVariable("id") String id){
	    this.repo.deleteById(id);
	}

}

//}Hayvan:;<.?Idontcomprendo><JJJJJJJ(#+!:)