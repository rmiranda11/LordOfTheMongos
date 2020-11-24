package com.mon.mongodb.accessingdata.dal;

import java.util.List;

import com.mon.mongodb.accessingdata.model.Character;

public interface CharacterDal {

	List<Character> getAllCharacters();
	
	Character addNewChar(Character character);
	
	Character getChar(String id);

	Character deleteById(String id);
	
	Character insertChar(Character character);
	
	List<Character> findByRole(String role);

	Character modify(String role, String id);
}
