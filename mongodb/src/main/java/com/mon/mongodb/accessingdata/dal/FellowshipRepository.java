package com.mon.mongodb.accessingdata.dal;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mon.mongodb.accessingdata.model.Character;


@Repository
public interface FellowshipRepository extends MongoRepository<Character, Object> {

//	Character findOne(String id);
	
}


