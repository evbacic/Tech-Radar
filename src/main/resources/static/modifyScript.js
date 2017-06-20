function generatePage(radarId) {
    $.ajax({
        url: "/api/radar",
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        success: function(resultData) {
            for(i = 0; i<resultData.length; i++){
                if(resultData[i].techGroup.id.toString() === radarId){
                    switch(resultData[i].category.id){
                        case 1:
                            $("#adopt").append("<li class='ui-state-default' id='" + resultData[i].id + "'>" + resultData[i].name + "</li>");
                            break;
                        case 2:
                            $("#incoming").append("<li class='ui-state-default' id='" + resultData[i].id + "'>" + resultData[i].name + "</li>");
                            break;
                        case 3:
                            $("#assess").append("<li class='ui-state-default' id='" + resultData[i].id + "'>" + resultData[i].name + "</li>");
                            break;
                        case 4:
                            $("#hold").append("<li class='ui-state-default' id='" + resultData[i].id + "'>" + resultData[i].name + "</li>");
                            break;
                    }
                }
            }
            $(".cell").sortable({
                containment: "document",
                connectWith: ".cell"
            });
        },
        error : function(jqXHR, textStatus, errorThrown) {
        },
        timeout: 120000
    });
}

function sendData(){
    var data = [];
    var a = [];
    a[0] = 1;
    a[1] = 2;
    $(".cell").find("li").each(function(){
       switch($(this).parent().attr("id")){
           case "adopt":
               data.push(new Object({id: $(this).attr("id"), catId: 1}));
               break;
           case "incoming":
               data.push(new Object({id: $(this).attr("id"), catId: 2}));
               break;
           case "assess":
               data.push(new Object({id: $(this).attr("id"), catId: 3}));
               break;
           case "hold":
               data.push(new Object({id: $(this).attr("id"), catId: 4}));
               break;
       }
    });
    $.ajax({
        type: "POST",
        contentType : 'application/json; charset=utf-8',
        dataType : 'json',
        url: "/api/category-updates",
        data: JSON.stringify(data), // Note it is important
        success :function(result) {
            alert("Update successful!");
        }
    });
}



