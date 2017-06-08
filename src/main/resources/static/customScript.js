/**
 * Created by emil-vid.bacic on 2.6.2017..
 */

$("#menu-toggle").click(function(e) {
    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
});

var counter = 1;
function populateCircle (r, c, items){
    var angle = (2*Math.PI)/items.length;
    for(var i = 1; i<=items.length; i++){
        var xMove = c + r*(Math.cos(i*angle));
        var yMove = c - r*(Math.sin(i*angle));
        addItem(xMove, yMove, items[i-1]);
        //counter++;
    }
}

function generatePage(){
    var cat1 = [];
    var cat2 = [];
    var cat3 = [];
    var cat4 = [];
    clearRadar();
    $.ajax({
        url: "/api/radar",
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        success: function(resultData) {
            for(var i = 0; i < resultData.length; i++){
                var temp = resultData[i];
                switch(temp.category.id){
                    case 1:
                        cat1.push(temp)
                        break;
                    case 2:
                        cat2.push(temp)
                        break;
                    case 3:
                        cat3.push(temp)
                        break;
                    case 4:
                        cat4.push(temp)
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
        timeout: 120000,
    });

}

/**
function populateOutCircle(items){
    populateCircle(4.5, 4.8, items);
}

function populateMidCircle(items){
    populateCircle(3.5, 4.8, items);
}

function populateInCircle(items){
    populateCircle(2.5, 4.8, items);
}

function populateBullCircle(items){
    if(items > 6){
        populateCircle(1.5, 4.8, 6);
        populateCircle(0.5, 4.8, items-6);
    } else {
        populateCircle(0.5, 4.8, items);
    }
}
*/
function clearRadar(){
    svg = d3.select("svg");
    svg.selectAll("g").remove();
    counter = 1;
    $("#list").empty();
}

// function populateRadar(id) {
//     svg = d3.select("svg");
//     clearRadar();
//
//     // ID ce se tu mijenjat i vuc podatke iz baze ovisno o tech koji user oce vidjet
//     if(id == 1){
//         var c3 = 7;
//         var c2 = 6;
//         var c1 = 5;
//         var cBull = 7;
//     }
//
//     if(id == 2){
//         var c3 = 5;
//         var c2 = 7;
//         var c1 = 6;
//         var cBull = 1;
//     }
//
//     if(id == 3){
//         var c3 = 2;
//         var c2 = 9;
//         var c1 = 1;
//         var cBull = 10;
//     }
//
//     if(id == 4){
//         var c3 = 1;
//         var c2 = 2;
//         var c1 = 1;
//         var cBull = 0;
//     }
//
//     populateOutCircle(c3);
//     populateMidCircle(c2);
//     populateInCircle(c1);
//     populateBullCircle(cBull);
// }
function addItem (x, y, item){
    var g = svg.append("g")
        .on("mouseover", function(){
            handleHover(g, item.id);
        })
        .on("mouseout", function(){
            handleHoverOut(g, item.id);
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
        .text(item.id)
        .attr("overflow", "visible")
        .attr("font-size", 0.2);
    $("#list").append("<li id='"+ item.id + "'>" + item.name + "</li>");
}
function handleHover (rect, num){
    rect.attr("opacity", 0.75);
    $("#" + num).css("background-color", "#cecece");
}
function handleHoverOut(rect, num){
    rect.attr("opacity", 1.0);
    $("#" + num).css("background-color", "white");
}