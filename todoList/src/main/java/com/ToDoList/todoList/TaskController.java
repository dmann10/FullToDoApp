package com.ToDoList.todoList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/tasks")
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();			 
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/tasks/{taskId}")
	public Task getTask(@PathVariable Long taskId) {
		return taskService.getTask(taskId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/tasks")
	public Task addTask(@RequestBody Task task) {
		return taskService.addTask(task);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/tasks")
	public void updateTask(@RequestBody Task task) {
		taskService.updateTask(task);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/tasks/{taskId}")
	public void deleteTask(@PathVariable Long taskId) {
		taskService.deleteTask(taskId);
	}
}
	
	
	
	
	
	
			

