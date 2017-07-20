$(function() {
    $('#dataTables').dataTable( {
        "pagingType":   "simple_numbers"
    } );

    $("#dataTables").on('click', '.buy',function(e) {
        $('#modalTitle').html("Buy this book");
        var dataset = e.currentTarget.dataset;
        var id = dataset.id;
        $("#titlemodal").text($("#"+id+".title").text());
        $("#authormodal").text($("#"+id+".author").text());
        $("#pricemodal").text("$"+$("#"+id+".price").text());

        jQuery.ajax({
            url : "getBookDetailPro",
            processData : true,
            data : {
                id : id
            },
            success : function (data) {
                $("#desmodal").text(data.description);
                jQuery.ajax({
                    url : "getBookImagePro",
                    data : {
                        id : id
                    },
                    success : function () {
                        var pathName = document.location.pathname;
                        var index = pathName.substr(1).indexOf("/");
                        var result = pathName.substr(0,index+1);
                        date = new Date();
                        $("#cover").attr("src", src=result + "/bookstore/images/tmp.jpg?t=" + date.getSeconds());
                        $("#confirm").attr("data-id", dataset.id);
                        $('#modal').modal('show');
                    }
                });
            }
        });
    });

    $("#confirm").click(function (e) {
        var amount = $("input[name='amount']").val();
        var dataset = e.currentTarget.dataset;
        var id = dataset.id;

        if (amount <= 0 || amount % 1 !== 0) {
            alert("Wrong format!");
            return;
        }
        jQuery.ajax({
            url : 'buyBookPro',
            processData : true,
            dataType : "text",
            data : {
                id : id,
                amount: amount
            },
            success : function() {
                bootbox.alert({
                    message: 'Success!',
                    callback : function() {
                        location.reload();
                    }
                });
            }
        });
    })
});