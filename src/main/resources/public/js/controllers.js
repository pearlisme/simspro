angular.module('app.controllers', []).controller('StudentListController', function($scope, $state, popupService, $window, Student) {
  $scope.student = Student.query(); //fetch all students. Issues a GET to /api/vi/students

  $scope.deleteStudent = function(student) { // Delete a Shipwreck. Issues a DELETE to /api/v1/students/:id
    if (popupService.showPopup('Really delete this?')) {
      student.$delete(function() {
        $scope.students = Student.query();
        $state.go('students');
      });
    }
  };
}).controller('StudentViewController', function($scope, $stateParams, Student) {
  $scope.student = Student.get({ id: $stateParams.id }); //Get a single student.Issues a GET to /api/v1/students/:id
}).controller('StudentCreateController', function($scope, $state, $stateParams, Student) {
  $scope.student = new Student();  //create new student instance. Properties will be set via ng-model on UI

  $scope.addStudent = function() { //create a new student. Issues a POST to /api/v1/students
    $scope.student.$save(function() {
      $state.go('students'); // on success go back to the list i.e. students state.
    });
  };
}).controller('StudentEditController', function($scope, $state, $stateParams, student) {
  $scope.updateStudent = function() { //Update the edited student. Issues a PUT to /api/v1/students/:id
    $scope.student.$update(function() {
      $state.go('students'); // on success go back to the list i.e. students state.
    });
  };

  $scope.loadStudent = function() { //Issues a GET request to /api/v1/students/:id to get a student to update
    $scope.student = Student.get({ id: $stateParams.id });
  };

  $scope.loadStudent(); // Load a student which can be edited on UI
});
