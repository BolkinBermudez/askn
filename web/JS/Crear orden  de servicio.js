


function exportJSON(formTable, control)
{
    if(!control)
    {
        //if control is not defined then used the debugger
        control = $("#debugSerialization");
    }
    
    var ret = [];
    $("tbody tr", formTable).not(".hidden").each(function (index) {
        var item = {};
        var tr = $(this);
        tr.find(":input").not("button").each(function (j) {
            var curInput = $(this);
            item[curInput.data("name")] = curInput.val();
        });

        ret.push(item);
    });
    var json = JSON.stringify(ret);
    console.log(json);

    control.val(json);
}


function initSortable(formTable)
{
        // Sortable Code
    var fixHelperModified = function(e, tr) {
        var $originals = tr.children();
        var $helper = tr.clone();
    
        $helper.children().each(function(index) {
            //alert(index);
            $(this).width($originals.eq(index).width());
        });
    return $helper;
    };
  
    $("tbody", formTable).sortable({
        helper: fixHelperModified,
        handle: "td:first",
        update: function () { exportJSON(formTable); }
    }).disableSelection();

    $("thead", formTable).disableSelection();
}


function hydrateFormTable(formTable, data)
{
   if (data) {
       try {
            var parsedJSON = JSON.parse(data);
           
            console.log("parsed data is:", parsedJSON);
           
            $.each(parsedJSON, function(k, v) {
                //display the key and value pair
                //console.log(k, v);
                addRow(formTable, v);
               
            });
        } catch(e) {
            console.log("error parsing the JSON",e);
        }
   }
   
}

function clearFormTable(formTable){
    //remove any current rows
    $("tbody tr", formTable).not(".hidden").remove();
}

 function addRow(formTable, formData)
 {
    // Dynamic Rows Code

    // Get max row id and set new id
    var newid = 0;
    $.each($("tr", formTable), function () {
        if (parseInt($(this).data("id")) > newid) {
            newid = parseInt($(this).data("id"));
        }
    });
    newid++;

    var tr = $("<tr></tr>", {
        id: "attr" + newid,
        "data-id": newid
    });

    // loop through each td and create new elements with name of newid
    $.each($("tbody tr:nth(0) td", formTable), function () {
        var cur_td = $(this);

        var children = cur_td.children();

        // add new td and element if it has a nane
        if ($(this).data("name") !== undefined) {
            var td = $("<td></td>", {
                "data-name": $(cur_td).data("name")
            });

            var c = $(cur_td).find($(children[0]).prop('tagName')).clone().val("");
            c.attr("name", $(cur_td).data("name") + '[' + newid + ']');
            c.data("name", $(cur_td).data("name"));
            c.appendTo($(td));
            td.appendTo($(tr));
        } else {
            var td = $("<td></td>", {
                'text': $('tr', formTable).length
            }).appendTo($(tr));
        }
    });
    
    //hydrate fields if there's data
    if(formData !== undefined)
    {
         $.each(formData, function(i, j) {
            console.log("adding input data:", i, j, $("[data-label]", tr));
            $("td[data-name="+ i +"] :input", tr).val(j);
        });
        
    }

    $(tr).appendTo(formTable);

    $(tr).find("td button.row-remove").on("click", function () {
        $(this).closest("tr").remove();
        exportJSON(formTable);
    });
          
}


function initTable(formTable){
    initSortable(formTable);
    addRow(formTable);
    
    //  $(":input", formTable).change(function () {
    //      console.log("there is an update");
    //      exportJSON(formTable, $("#debugSerialization"));
    //   });
    
    //setup auto-hydrating
    formTable.on('input', function () {
              exportJSON(formTable);
           });
}

$(document).ready(function() {
    
    var formTable = $("#tab_logic");
    var hiddenSerializedData = $("#serializedData");
    
    $("#rehydrateBtn").click(function(){
        clearFormTable(formTable);
        //add rows with JSON data
        hydrateFormTable(formTable, debugDataField.val());
    });
    
    initTable(formTable);
    
    $("#add_row").on("click", function() {
        addRow(formTable);
    });

    
});

$(document).ready(function () {
    var counter = 0;

    $("#addrow").on("click", function () {
        var newRow = $("<tr>");
        var cols = "";

        cols += '<td><input type="text" class="form-control" name="name' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control" name="mail' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control" name="phone' + counter + '"/></td>';

        cols += '<td><input type="button" class="ibtnDel btn btn-md btn-danger "  value="Delete"></td>';
        newRow.append(cols);
        $("table.order-list").append(newRow);
        counter++;
    });



    $("table.order-list").on("click", ".ibtnDel", function (event) {
        $(this).closest("tr").remove();       
        counter -= 1
    });


});



function calculateRow(row) {
    var price = +row.find('input[name^="price"]').val();

}

function calculateGrandTotal() {
    var grandTotal = 0;
    $("table.order-list").find('input[name^="price"]').each(function () {
        grandTotal += +$(this).val();
    });
    $("#grandtotal").text(grandTotal.toFixed(2));
}