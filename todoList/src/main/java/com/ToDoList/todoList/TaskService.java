package com.ToDoList.todoList;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList<>();
		taskRepository.findAll().forEach(tasks::add);
		return tasks;
	}
	
	public Task getTask(Long taskId) {
		return taskRepository.findOne(taskId);
	}
	
	public Task addTask(Task task) {
		return taskRepository.save(task);
	}
	
	public void updateTask(Task task) {
		taskRepository.save(task);
	}
	
	public void deleteTask(Long taskId) {
		taskRepository.delete(taskId);
	}
}
