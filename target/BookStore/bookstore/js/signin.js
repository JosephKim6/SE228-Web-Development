$(document).ready(function(){
    $("#signin").on('submit', function(){
        var username = $("#username").val();
        var password = $("#password").val();

        $(this).ajaxSubmit({
            type: 'POST',
            url : 'loginPro',
            processData : true,
            dataType : 'text',
            data : {
                username : username,
                password : password
            },
            success : function(data) {
                if (data === "success"){
                    bootbox.alert({
                        message : 'Login Complete!',
                        callback : function() {
                            window.location.href = 'checkUserPro';
                        }
                    });
                }
                else if (data === "error"){
                    bootbox.alert({
                        message : 'Wrong Username or Password!'
                    });
                }
            }
        })
    });
});