function generatePage(radarId) {
    $('.modal').modal();
    $('select').material_select();
    $.ajax({
        url: "/api/radar",
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        success: function(resultData) {
            for(i = 0; i<resultData.length; i++){
                if(resultData[i].radar.id.toString() === radarId){
                    group = resultData[i].radar.techGroupRadar.id;
                    switch(resultData[i].category.id){
                        case 1:
                            $("#adopt").append("<li class='collection-item inFocus' id='" + resultData[i].technology.id + "'>" + resultData[i].technology.name + "</li>");
                            break;
                        case 2:
                            $("#incoming").append("<li class='collection-item incoming' id='" + resultData[i].technology.id + "'>" + resultData[i].technology.name + "</li>");
                            break;
                        case 3:
                            $("#assess").append("<li class='collection-item shouldPilot' id='" + resultData[i].technology.id + "'>" + resultData[i].technology.name + "</li>");
                            break;
                        case 4:
                            $("#hold").append("<li class='collection-item outgoing' id='" + resultData[i].technology.id + "'>" + resultData[i].technology.name + "</li>");
                            break;
                    }
                }
            }
            $.ajax({
                url: "/api/technology",
                type: "GET",
                contentType: 'application/json; charset=utf-8',
                success: function(techData) {
                    for(var i = 0; i<techData.length; i++){
                        if(!(document.getElementById(techData[i].id)) && techData[i].techGroup.id === group){
                            $("#unused").append("<li class='collection-item outdated' id='" + techData[i].id + "'>" + techData[i].name + "<i title='Delete' class='material-icons righty deletes' style='cursor: pointer'>delete_forever</i></li>");
                        }
                    }
                    $(".deletes").each(function () {
                        $(this).on("click", function () {
                            var nodeIdToDelete = $(this).parent().attr("id");
                            swal({
                                    title: "Are you sure?",
                                    text: "You will not be able to recover this technology!",
                                    type: "warning",
                                    showCancelButton: true,
                                    confirmButtonColor: "#B8244C",
                                    confirmButtonText: "Yes, delete it!",
                                    closeOnConfirm: false
                                },
                                function(){
                                    $.ajax({
                                        type: "POST",
                                        contentType : 'application/json; charset=utf-8',
                                        url: "/api/delete",
                                        data: JSON.stringify({techId: nodeIdToDelete}), // Note it is important
                                        success :function() {
                                            $(".cell").find("#"+nodeIdToDelete).remove();
                                            swal("Deleted!", "Your technology has been deleted.", "success");
                                        }
                                    });
                                }
                            );
                        })
                    });
                },
                error : function(jqXHR, textStatus, errorThrown) {
                },
                timeout: 120000
            });
            $(".cell").sortable({
                containment: "document",
                connectWith: ".cell"
            });
            $(".cell").find("li").append("<i title='Delete' class='material-icons righty deletes' style='cursor: pointer'>delete_forever</i>");
            $(".deletes").each(function () {
                $(this).on("click", function () {
                    var nodeIdToDelete = $(this).parent().attr("id");
                    swal({
                            title: "Are you sure?",
                            text: "You will not be able to recover this technology!",
                            type: "warning",
                            showCancelButton: true,
                            confirmButtonColor: "#B8244C",
                            confirmButtonText: "Yes, delete it!",
                            closeOnConfirm: false
                        },
                        function(){
                            $.ajax({
                                type: "POST",
                                contentType : 'application/json; charset=utf-8',
                                url: "/api/delete",
                                data: JSON.stringify({techId: nodeIdToDelete}), // Note it is important
                                success :function() {
                                    $(".cell").find("#"+nodeIdToDelete).remove();
                                    swal("Deleted!", "Your technology has been deleted.", "success");
                                }
                            });
                        }
                    );
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
       }
    });
    $.ajax({
        type: "POST",
        contentType : 'application/json; charset=utf-8',
        url: "/api/category-updates",
        data: JSON.stringify(data), // Note it is important
        success :function() {
            swal({
                title: "Good job!",
                text: "You successfully updated this radar!",
                type: "success",
                confirmButtonColor: "#77C4D3"
            },
            function(){
                window.location.href = "/home/" + group;
            });
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



