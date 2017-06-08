$(function(){
    $.ajax({
        url: "/api/radar",
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        success: function(resultData) {
            for(var i = 0; i<resultData.length; i++){
                $("#sortable").append("<li class='ui-state-default draggable' id='" + resultData[i].id + "'>" + resultData[i].name + "</li>");
            }
            $("#sortable").sortable({
                containment: "document",
                connectWith: ".cont"
            });
            $(".cont").sortable({
                containment: "document",
                connectWith: ["#sortable", ".cont"]
            })
        },
        error : function(jqXHR, textStatus, errorThrown) {
        },
        timeout: 120000,
    });
});

