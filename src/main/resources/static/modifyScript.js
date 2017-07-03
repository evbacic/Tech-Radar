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
                            $("#adopt").append("<li class='collection-item' id='" + resultData[i].id + "'>" + resultData[i].name + "</li>");
                            break;
                        case 2:
                            $("#incoming").append("<li class='collection-item' id='" + resultData[i].id + "'>" + resultData[i].name + "</li>");
                            break;
                        case 3:
                            $("#assess").append("<li class='collection-item' id='" + resultData[i].id + "'>" + resultData[i].name + "</li>");
                            break;
                        case 4:
                            $("#hold").append("<li class='collection-item' id='" + resultData[i].id + "'>" + resultData[i].name + "</li>");
                            break;
                        case 5:
                            $("#unused").append("<li class='collection-item' id='" + resultData[i].id + "'>" + resultData[i].name + "</li>");
                            break;
                    }
                }
            }
            $(".cell").sortable({
                containment: "document",
                connectWith: ".cell"
            });
            $(".cell").find("li").append("<i title='Delete' class='material-icons righty deletes' style='cursor: pointer'>delete_forever</i>");
            $(".deletes").each(function () {
                $(this).on("click", function () {
                    var nodeIdToDelete = $(this).parent().attr("id");
                    $.ajax({
                        type: "POST",
                        contentType : 'application/json; charset=utf-8',
                        url: "/api/delete",
                        data: JSON.stringify({techId: nodeIdToDelete}), // Note it is important
                        success :function() {
                            $(".cell").find("#"+nodeIdToDelete).remove();
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

function sendData(radarId){
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
           case "unused":
               data.push(new Object({id: $(this).attr("id"), catId: 5}));
       }
    });
    $.ajax({
        type: "POST",
        contentType : 'application/json; charset=utf-8',
        url: "/api/category-updates",
        data: JSON.stringify(data), // Note it is important
        success :function() {
            alert("Update successful!");
            window.location.href = "/home/" + radarId;
        }
    });
}

function clearData(){
    $(".cell").find("li").each(function(){
       $(this).appendTo("#unused");
    });
}

function clearForm(form){
    form.reset();
}

function submitForm() {
    var form = document.getElementById("myForm");
    form.submit();
    form.reset();
    return false;
}

$("#myForm").submit(function(e){
    e.preventDefault();
    this.submit();

    setTimeout(function() {
        $('#formName').val('');
        $('#formDesc').val('');
    },100);
});



