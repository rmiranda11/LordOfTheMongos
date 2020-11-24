package com.mon.mongodb.accessingdata.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mon.mongodb.accessingdata.model.Character;


@Repository
public class CharacterImpl implements CharacterDal {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	// Find All
	@Override
	public List<Character> getAllCharacters(){
		return mongoTemplate.findAll(Character.class);
	}

	// Add new character
	@Override
	public Character addNewChar(Character character) {
		mongoTemplate.save(character);
		return character;
	}

	// Get character by id
	@Override
	public Character getChar(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, Character.class);
	}
	
	// Get Character by role
	@Override
	public List<Character> findByRole(String role) {
		Query query = new Query();
		query.addCriteria(Criteria.where("role").is(role));
		return mongoTemplate.find(query, Character.class);
	}
	
	//Find Character by ID and Modify Characters Role
	@Override 
	public Character modify(String id, String role) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("role", role);
		return mongoTemplate.findAndModify(query, update, Character.class);
	}
	
	// Delete Character by ID
	@Override 
	public Character deleteById(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return mongoTemplate.findAndRemove(query, Character.class);
	}
	
	// Insert New Character
	@Override
	public Character insertChar(Character character) {
	mongoTemplate.insert(character);
	return character;
	}

	

}
