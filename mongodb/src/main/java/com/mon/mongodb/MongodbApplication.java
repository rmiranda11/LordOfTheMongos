package com.mon.mongodb;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mon.mongodb.accessingdata.model.Character;
import com.mon.mongodb.accessingdata.dal.CharacterImpl;

@SpringBootApplication
public class MongodbApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired 
	public CharacterImpl impl;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}
	
	
	@Override
	  public void run(String... args) throws Exception {
		logger.info("New character -> {}", impl.addNewChar(new Character("0", "Gandalf", 2019, "Wizard")));
		logger.info("New character -> {}", impl.addNewChar(new Character("1","Frodo", 51, "Hobbit")));
		logger.info("New character -> {}", impl.addNewChar(new Character("2","Bilbo", 129, "Hobbit")));
		logger.info("New character -> {}", impl.addNewChar(new Character("3","Gimli", 140, "Dwarf")));
		logger.info("New character -> {}", impl.addNewChar(new Character("4","Aragorn", 88, "Human")));
		logger.info("New character -> {}", impl.addNewChar(new Character("5", "Smeagol", 589, "Hobbit")));

		logger.info("Finding Character -> {}", impl.getChar("2"));
				
		logger.info("Deleting -> {}", impl.deleteById("2"));
		
		logger.info("Inserting -> {}", impl.insertChar(new Character("2", "Legolas", 500, "Elf")));
		
		logger.info("Finding -> {}", impl.findByRole("Hobbit"));
		
		logger.info("Modifying -> {}", impl.modify("4", "King"));

		logger.info("All characters -> {}", impl.getAllCharacters());
	}
	
	
}
