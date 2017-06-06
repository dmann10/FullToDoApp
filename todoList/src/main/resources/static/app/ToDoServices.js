(function() {

angular.module('toDoList')

.factory('ToDoServices', ['$http', function($http) {
		return {
			getTasks: function(){
				return $http.get('/tasks');			
			},
			addTask: function(task){
				return $http.post('/tasks', task);
			},
			updateTask: function(task) {
				return $http.put('/tasks', task);
			},
			deleteTask: function(task) {
				return $http.delete('/tasks/' + task.taskId);
			}
			
		};

}]);

})();