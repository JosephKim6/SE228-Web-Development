$(function() {
    $('#dataTables').dataTable( {
        "pagingType":   "simple_numbers"
    } );

    $('#pay').click(function(){
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
        jQuery.ajax({
            url: 'payMoneyPro',
            processData : true,
            dataType : "text",
            data : {
                date: currentdate
            },
            success: function () {
                bootbox.alert({
                    message : 'Pay Complete!',
                    callback : function() {
                        location.reload();
                    }
                });
            }
        });
    });

    $(".delete").click(function(e) {
        bootbox.confirm({
            buttons : {
                confirm : {
                    label : 'Delete'
                },
                cancel : {
                    label : 'Cancel'
                }
            },
            message : 'Sure to delete?',
            callback : function(result) {
                if (result) {

                    var dataset = e.currentTarget.dataset;
                    var id = dataset.id;
                    jQuery.ajax({
                        url : 'deleteBuyPro',
                        processData : true,
                        dataType : "text",
                        data : {
                            id : id
                        },
                        success : function() {
                            console.log(id);
                            bootbox.alert({
                                message : 'Delete Successfully!',
                                callback : function() {
                                    location.reload();
                                }
                            });
                        }
                    });

                }
            }
        });
    });
});