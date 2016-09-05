/**
 * Created by neos on 05.09.2016.
 */

app.controller("restController",function($scope,$http){

    $http({
        method:'GET',
        url:'http://localhost:8080/makeit/haha'})
        .then(function(response){
            $scope.haha=response.data;
        });

});