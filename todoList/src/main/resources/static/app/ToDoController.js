(function() {

angular.module('toDoList')

.controller("ToDoListController", ['$scope', 'ToDoServices', function($scope, ToDoServices) {
	
	$scope.tasks = [];	
	
	//GET all tasks from server
	$scope.getTasks = function(){
		ToDoServices.getTasks().then(function(response) {
			$scope.tasks = response.data;
		}, 
		function(err) {
			console.log("Error: " , err);
		});
	}
	
	//Initialize task list
	$scope.getTasks();
	
	//Sets new task to empty
	$scope.emptyTask = function(){
		$scope.newTask = {task: "", complete: false, inEdit: false, taskCopy: ""};
	};

	$scope.emptyTask();

	// POST new task
	$scope.addTask = function() {
		ToDoServices.addTask($scope.newTask).then(function(response) {
			$scope.tasks.push(response.data);
			$scope.emptyTask();
		},
		function(err) {
			alert("Error: ", err);
		});
	};
	
	//DELETE task
	$scope.deleteTask = function(task) {

		var index = $scope.tasks.indexOf(task);
		
		ToDoServices.deleteTask(task).then(function(response) { 
			
			$scope.tasks.splice(index, 1);
		});
		
	};

	//PUT task as complete and check item off
	$scope.toggleCheck = function(task) {
		task.complete = !task.complete;
		
		ToDoServices.updateTask(task).then(function(response) {
			
		});
	};

	//Enable edit mode
	$scope.editTask = function(task) {
		
		task.inEdit = !task.inEdit;
		task.taskCopy = task.task;	
	};

	//Update task in the server
	$scope.updateTask = function(task) {
		task.inEdit = !task.inEdit;
		
		ToDoServices.updateTask(task).then(function(response) {
			
		});
	};	
	
	//Cancel edit mode
	$scope.cancelUpdate = function(task) {
		task.inEdit = !task.inEdit;
		task.task = task.taskCopy;
	};

}]);

})();