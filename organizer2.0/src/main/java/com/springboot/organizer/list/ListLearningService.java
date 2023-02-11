package com.springboot.organizer.list;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ListLearningService {

	private static List<ListLearning> thingslist = new ArrayList<>();
	
	private static int thingsCount = 0;
	

	
	public List<ListLearning> findByUsername(String username){
		Predicate<? super ListLearning> predicate = list -> list.getUsername().equalsIgnoreCase(username);
		return thingslist.stream().filter(predicate).toList();
	}
	
	public void addNewThing(String username, String whatlist, LocalDate targetDate, boolean done) {
		ListLearning list = new ListLearning(++thingsCount,username,whatlist,targetDate,done);
		thingslist.add(list);
	}
	
	public void deleteById(int id) {
		Predicate<? super ListLearning> predicate = list -> list.getId() == id;
		thingslist.removeIf(predicate);
	}

	public ListLearning findById(int id) {
		Predicate<? super ListLearning> predicate = list -> list.getId() == id;
		ListLearning list = thingslist.stream().filter(predicate).findFirst().get();
		return list;
	}	
	
	public void updatelist(@Valid ListLearning list) {
		deleteById(list.getId());
		thingslist.add(list);
	}
}