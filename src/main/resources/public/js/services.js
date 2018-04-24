angular.module('app.services', []).factory('Student', function($resource) {
  return $resource('/api/v1/student/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
