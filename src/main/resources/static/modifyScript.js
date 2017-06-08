$(function(){
    $.ajax({
        url: "/api/radar",
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        success: function(resultData) {
            for(var i = 0; i<resultData.length; i++){
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
            $(".cell").sortable({
                containment: "document",
                connectWith: ".cell"
            });
        },
        error : function(jqXHR, textStatus, errorThrown) {
        },
        timeout: 120000,
    });
});

