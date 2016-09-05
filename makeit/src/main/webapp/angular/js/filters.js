/**
 * Created by neos on 04.09.2016.
 */

app.filter("gender",function(){
    return function(gender){
        switch (gender){
            case 1:
                return "Male";
            case 2:
                return "Female";
            case 3:
                return "Not disclosed";
        }
    }
});