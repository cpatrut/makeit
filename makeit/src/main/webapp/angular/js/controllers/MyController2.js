/**
 * Created by neos on 04.09.2016.
 */

app.controller("myController2",function($scope){
    var technologies=[
        {
            name:"C#",like:0,dislikes:0
        },
        {
           name:"Asp.net",like:0,dislikes:0
         },
         {
           name:"Sql server",like:0,dislikes:0
      },
        {
            name:"Angular js",like:0,dislikes:0
      }
         ];
    $scope.technologies=technologies;

    $scope.incrementLikes=function(technology){
        technology.like++;
    }
    $scope.incrementDislikes=function(technology){
        technology.dislikes++;
    }


    var employees = [
        {
            name: "Ben", dateOfBirth: new Date("November 23, 1980"),
            gender: "Male", salary: 55000.788
        },
        {
            name: "Sara", dateOfBirth: new Date("May 05, 1970"),
            gender: "Female", salary: 68000
        },
        {
            name: "Mark", dateOfBirth: new Date("August 15, 1974"),
            gender: "Male", salary: 57000
        },
        {
            name: "Pam", dateOfBirth: new Date("October 27, 1979"),
            gender: "Female", salary: 53000
        },
        {
            name: "Todd", dateOfBirth: new Date("December 30, 1983"),
            gender: "Male", salary: 60000
        }
    ];
});