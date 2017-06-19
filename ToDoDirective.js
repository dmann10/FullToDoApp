(function() {
	angular.module('toDoList')
		.directive('taskItem', function() {
			return {
				restrict: 'E',
				scope: {
					task: '='
				},
				templateUrl: '/partials/task-item.html',
				controller: 'ToDoListController'
			};
		});
})();