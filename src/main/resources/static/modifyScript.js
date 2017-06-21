function generatePage(radarId) {
    $('.modal').modal();
    $('select').material_select();
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
            $("li").append("<i class='material-icons righty deletes' style='cursor: pointer'>clear</i>");
            $(".deletes").each(function () {
                $(this).on("click", function () {
                    $.ajax({
                        type: "POST",
                        contentType : 'application/json; charset=utf-8',
                        dataType : 'json',
                        url: "/api/delete",
                        data: JSON.stringify({techId: $(this).parent().attr("id")}), // Note it is important
                        success :function() {
                            $(this).parent().remove();
                        }
                    });
                })
            });
        },
        error : function(jqXHR, textStatus, errorThrown) {
        },
        timeout: 120000
    });
}

function sendData(){
    var data = [];
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
        success :function() {
            alert("Update successful!");
        }
    });
    window.location.href = "/home";
}

function clearData(){
    $(".cell").find("li").each(function(){
       $(this).appendTo("#unused");
    });
}



