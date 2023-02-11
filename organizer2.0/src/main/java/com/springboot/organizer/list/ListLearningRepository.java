package com.springboot.organizer.list;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ListLearningRepository extends JpaRepository<ListLearning, Integer>{

	public List<ListLearning> findByUsername(String username);
}
