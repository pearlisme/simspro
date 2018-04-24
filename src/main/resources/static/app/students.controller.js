(function () {
    'use strict';

    angular.module('app')
        .constructor('StudentController', StudentController);

    StudentController.$inject = [$http];

    function StudentController($http) {
        var vm = this;

        vm.students = [];
        vm.getAll = getAll;
        vm.getStudent = getStudent;
        vm.deleteStudent = deleteStudent;
        ''

        init();

        function init() {
            getAll();
        }

        function getAll(){
            // var url = "/api/v1/students/all";
            var url = "/mock/students";
            var studentHandler = $http.get(url);

            studentHandler.then(function (value) {
                vm.students = value.data;
            });
        }

        function getStudent(){
            var url = "/api/v1/students/find/" + 101;
            var studentHandler = $http.get(url);

            studentHandler.then(function (value) {
                vm.students = value.data;
            });
        }

        function deleteStudent() {
            var url = "/api/v1/students/delete/" + id;
            $http.get(url).then(function (value) {
                vm.students = value.data;
            });
        }
    }

})();