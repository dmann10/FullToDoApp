package com.ToDoList.todoList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	private String task;
	private boolean complete;
	private boolean inEdit;
	private String taskCopy;

	public Task() {
		
	}
	
	public Task(String newTask, boolean bool, boolean editMode, String copy) {
		
		task = newTask;
		complete = bool;
		inEdit = editMode;
		taskCopy = copy;
		
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long i) {
		this.taskId = i;
	}
	
	public String getTask() {
		return task; 
	}

	public void setTask(String task) {
		this.task = task;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public boolean isInEdit() {
		return inEdit;
	}

	public void setInEdit(boolean inEdit) {
		this.inEdit = inEdit;
	}

	public String getTaskCopy() {
		return taskCopy;
	}

	public void setTaskCopy(String taskCopy) {
		this.taskCopy = taskCopy;
	}
}
