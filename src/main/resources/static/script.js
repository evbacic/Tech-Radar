/**
 * Created by luka.crnjakovic on 6.6.2017..
 */
function generatePage(){
    var cat1 = [];
    var cat2 = [];
    var cat3 = [];
    var cat4 = [];
    $.ajax({
        url: "/api/radar",
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        success: function(resultData) {
            for(var i = 0; i < resultData.length; i++){
                var temp = resultData[i];
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
        .attr("width", 0.4)
        .attr("height", 0.4)
        .attr("fill", "#000");
    var text = g.append("text")
        .attr("x", x + 0.1)
        .attr("y", y + 0.25)
        .attr("fill", "#fff")
        .text(temp.id)
        .attr("overflow", "visible")
        .attr("font-size", 0.2);
    $("ul").append("<li id='" + temp.id + "'>" + temp.name + "</li>");
}
function handleHover (rect, num){
    rect.attr("opacity", 0.75);
    $("#" + num).css("background-color", "green");
}
function handleHoverOut(rect, num){
    rect.attr("opacity", 1.0);
    $("#" + num).css("background-color", "white");
}
