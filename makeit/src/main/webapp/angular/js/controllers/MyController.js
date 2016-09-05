/**
 * Created by neos on 04.09.2016.
 */

app.controller("myController",function($scope){
    $scope.message="Angular JS Tutorials";
    var employee={
        firstName:"david",
        lastName:"hastings",
        gender:"Male"
    };
    $scope.employee=employee;

    var country={
      name:"ROMANIAAA",
        capital:"Bucharest(tigania)",
        flag:"img/images.jpeg"
    };
    $scope.country=country;

});