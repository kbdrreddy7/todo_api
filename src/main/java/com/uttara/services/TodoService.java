package com.uttara.services;

import java.util.List;

import com.uttara.beans.Todo;


public interface TodoService {

	public List<Todo> getTodos();
	public Todo getTodo(Long sl);
	public Todo createTodo(Todo todo);
	public Todo updateTodo(Long sl, Todo todo);
	public boolean deleteTodo(Long sl);
	public boolean isExists(Long sl);
	
}
