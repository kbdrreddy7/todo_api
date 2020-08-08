package com.uttara.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uttara.beans.Todo;
import com.uttara.services.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	
	
	@RequestMapping(value = {"","/"}) // get all
	public List<Todo> getTodos() {
		
		System.out.println(" whs");
	  return	todoService.getTodos();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET) // get one by id
	public Todo getTodo(@PathVariable("id") Long id) {
		
	  return	todoService.getTodo(id);
	}
	
	
	@RequestMapping(value={"/"} ,method=RequestMethod.POST) // add one
	public Object addTodo(@RequestBody Todo bean) {
	
	 Map<String,Object>respoonse=new HashMap<String, Object>();
		
	 Map<String, String>errors=	bean.validate();
	 
		 if(errors==null)
		 {
			 System.out.println("success--------");
			 bean= todoService.createTodo(bean);
			 respoonse.put("status", "success");
			 respoonse.put("data", bean);
			 
			 
		 }
		 else {
			 System.out.println("---------fail"+errors);
			 respoonse.put("status", "fail");
			 respoonse.put("errors", errors);
		}
		   
		 return respoonse;
		
	} 
	
	@RequestMapping(value={"/{id}"} ,method=RequestMethod.PUT) // edit one
	public Object editTodo(@PathVariable("id") Long id, @RequestBody Todo bean) {
	
	 Map<String,Object>respoonse=new HashMap<String, Object>();
		
	 Map<String, String>errors=	bean.validate();
	 
		 if(errors==null)
		 {
			 
			 
			 if(todoService.isExists(id)) {
				 
				 bean= todoService.updateTodo(id, bean);
				 respoonse.put("status", "success");
				 respoonse.put("data", bean);
				 
			 }
			 else {
				 respoonse.put("status", "fail");
				 respoonse.put("message", "id not exists");
			}
			 
		 }
		 else {
			 respoonse.put("status", "fail");
			 respoonse.put("errors", errors);
		}
		   
		 return respoonse;
		
	}
	
	

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE) // delete one by id
	public boolean deleteTodo(@PathVariable("id") Long id) {
		
	  return	todoService.deleteTodo(id);
	}
	
	
	
	
}
