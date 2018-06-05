$(document).ready(function () {
    tid = 0;
});

function solve() {
    var receivedEquations = document.getElementById('equations').value;
    equationsArray = receivedEquations.split("\n");

    var data = [];

    for (i = 0; i < equationsArray.length; i++) {
        coefficients = equationsArray[i].split(" ");
        data.push({"coefficients": coefficients});
    }

    $.ajax({
        type: "POST",
        data: JSON.stringify(data),
        url: "solve",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'tid': tid++
        },
        success: pollSolutions()
    })
}

function pollSolutions() {
    $.ajax({
        type: "GET",
        url: "solutions/" + (tid - 1),
        success: function (data) {
            setTimeout(function () {
                pollSolutions();
                // console.log(JSON.stringify(data));
                var toPrint = transformObjectToText(data);
                if (toPrint != "") {
                    document.getElementById('solutions').value = toPrint;
                }
            }, 1000)
        }
    })
}

function transformObjectToText(data) {
    var res = "";
    console.log(JSON.stringify(data));

    if (data != "") {
        for (i = 0; i < data.length; i++) {
            solution = data[i]["roots"];
            /*console.log("solution: " + solution);
            if (solution = "") {
                res = res + "No tiene raíces enteras";
            }*/
            if (solution.length == 0) {
                res = res + "No tiene raíces enteras";
            } else {
                for (j = 0; j < solution.length; j++) {
                    res = res + " " + solution[j];
                }
            }
            res += "\n";
        }
    }

    return res;
}