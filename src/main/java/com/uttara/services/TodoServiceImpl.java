package com.uttara.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uttara.beans.Todo;
import com.uttara.repositories.TodoRepo;


@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepo todoRepo;
	
	@Override
	public List<Todo> getTodos() {
		
			return todoRepo.findAll();
	}

	@Override
	public Todo getTodo(Long sl) {
		
		if(!isExists(sl))
			return null;
		
		return todoRepo.findById(sl).get();
		
	  //	return todoRepo.getOne(sl);   // it was giving error
	}

	@Override
	public Todo createTodo(Todo todo) {
		
		return todoRepo.save(todo);
	}

	@Override
	public Todo updateTodo(Long sl, Todo todo) {
		
		todo.setSl(sl);
		return todoRepo.save(todo);
		
	}

	@Override
	public boolean deleteTodo(Long sl) {
		
		if(isExists(sl)) {
			
			todoRepo.deleteById(sl);
			return true;
		}
		
		return false;
	}


	@Override
	public boolean isExists(Long sl) {
		
		return todoRepo.existsById(sl);
	}

}
