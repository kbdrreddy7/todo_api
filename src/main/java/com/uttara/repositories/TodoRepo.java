package com.uttara.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uttara.beans.Todo;

public interface TodoRepo extends  JpaRepository<Todo,Long> {

	
}





