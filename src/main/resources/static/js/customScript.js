/**
 * Created by emil-vid.bacic on 2.6.2017..
 */
$(function () {
   $("#updateButton").hide();

});

function loopOn(){
    var active = $("#collapsibleList").find(".active").attr("id");
    var rects = document.getElementsByTagName("g");
    for(var i = 0; i<rects.length; i++){
        if($(rects[i]).attr("id") !== active){
            $(rects[i]).attr("opacity", 0.5);
        }
    }
}

function loopOff(){
    var rects = document.getElementsByTagName("g");
    for(var i = 0; i<rects.length; i++){
        $(rects[i]).attr("opacity", 1.0);
    }
}
function generatePage(radarId){
    var group_id = parseInt(radarId);
    if(group_id !== 0){
        clearRadar();
        $("#updateButton").show().on("click", function(){
            window.location.href = "/update/"+group_id;
        });
        var cat1 = [];
        var cat2 = [];
        var cat3 = [];
        var cat4 = [];
        $.ajax({
            url: "/api/radar",
            type: "GET",
            contentType: 'application/json; charset=utf-8',
            success: function(resultData) {

                var groupResultData = [];

                for(var i = 0; i < resultData.length; i++){
                    var temp1 = resultData[i];
                    if(temp1.techGroup.id === group_id){
                        groupResultData.push(temp1);
                    } else {

                    }
                }
                for(var x = 0; x < groupResultData.length; x++){
                    var temp = groupResultData[x];
                    switch(temp.category.id){
                        case 1:
                            cat1.push(temp);
                            break;
                        case 2:
                            cat2.push(temp);
                            break;
                        case 3:
                            cat3.push(temp);
                            break;
                        case 4:
                            cat4.push(temp);
                            break;
                    }
                }
                svg = d3.select("svg");
                var offset = -0.2;
                center = 5 + offset;
                if(cat1.length <= 6){
                    populateCircle(0.5, center, cat1);
                }
                else{
                    populateCircle(0.5, center, cat1.slice(0,6));
                    populateCircle(1.5, center, cat1.slice(6));
                }
                populateCircle(2.5, center, cat2);
                populateCircle(3.5, center, cat3);
                populateCircle(4.5, center, cat4);
            },
            error : function(jqXHR, textStatus, errorThrown) {
            },
            timeout: 120000
        });
    }
}
function populateCircle (r, c, items){
    var angle = (2*Math.PI)/items.length;
    for(var i = 1; i<=items.length; i++){
        var xMove = c + r*(Math.cos(i*angle));
        var yMove = c - r*(Math.sin(i*angle));
        addItem(xMove, yMove, items[i-1]);
    }
}
function addItem (x, y, temp){
    var g = svg.append("g")
        .attr("id", temp.id)
        .on("mouseover", function(){
            handleHover(g, temp.id);
        })
        .on("mouseout", function(){
            handleHoverOut(g, temp.id);
        });
    g.append("title")
        .text(temp.name);
    var rect = g.append("rect")
        .attr("x", x)
        .attr("y", y)
        .attr("rx", 0.05)
        .attr("ry", 0.05)
        .attr("width", 0.47)
        .attr("height", 0.4)
        .attr("fill", "#000");
    var txtPos = 0;
    switch(temp.id.toString().length){
        case 1:
            txtPos = 0.175;
            break;
        case 2:
            txtPos = 0.125;
            break;
        case 3:
            txtPos = 0.065;
            break;
    }
    var text = g.append("text")
        .attr("x", x + txtPos)
        .attr("y", y + 0.265)
        .attr("fill", "#fff")
        .text(temp.id)
        .attr("overflow", "visible")
        .attr("font-size", 0.2);
    var listContent = "<li id='"+ temp.id + "'><div class='collapsible-header'>" + temp.id + ": " + temp.name + "</div><div class='collapsible-body'><span>" + temp.description + "</span></div></li>";
    $("#collapsibleList").append(listContent);

}
function handleHover (rect, num){
    rect.attr("cursor", "pointer");
}
function handleHoverOut(rect, num){
    rect.attr("cursor", "auto");
}

function clearRadar(){
    svg = d3.select("svg");
    svg.selectAll("g").remove();
    counter = 1;
    $("#list").empty();
}

