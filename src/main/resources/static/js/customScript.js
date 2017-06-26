/**
 * Created by emil-vid.bacic on 2.6.2017..
 */
$(function () {
   $("#updateButton").hide();
});
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

                document.getElementById("radarTitle").innerHTML = ' <span id="toggle" style="font-size:30px;cursor:pointer" onclick="closeNav()">&#10060;</span> ' + groupResultData[1].techGroup.name + " Tech Radar";
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
    var rect = g.append("rect")
        .attr("x", x)
        .attr("y", y)
        .attr("width", 0.47)
        .attr("height", 0.4)
        .attr("fill", "#000");
    var text = g.append("text")
        .attr("x", x + 0.1)
        .attr("y", y + 0.25)
        .attr("fill", "#fff")
        .text(temp.id)
        .attr("overflow", "visible")
        .attr("font-size", 0.2);
    $("#list").append("<li id='" + temp.id + "'>" + " " + temp.id + ": " + temp.name + "</li>");

}
function handleHover (rect, num){
    rect.attr("opacity", 0.75);
    $("#" + num).css("background-color", "green");
}
function handleHoverOut(rect, num){
    rect.attr("opacity", 1.0);
    $("#" + num).css("background-color", "white");
}

function clearRadar(){
    svg = d3.select("svg");
    svg.selectAll("g").remove();
    counter = 1;
    $("#list").empty();
}

function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("page-content-wrapper").style.marginLeft = "250px";
    document.getElementById("toggle").setAttribute("onclick", "closeNav()");
    document.getElementById("toggle").innerHTML = "&#10060;";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("page-content-wrapper").style.marginLeft= "0";
    document.getElementById("toggle").setAttribute("onclick", "openNav()");
    document.getElementById("toggle").innerHTML = "&#9776;";
}
