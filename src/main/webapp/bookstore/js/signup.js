$(document).ready(function(){
	$("#signup").on('submit', function(){
		var username = $("#username").val();
		var password = $("#password").val();
		var confirmPassword = $("#confirmPassword").val();
		var role = 1;

		if (password !== confirmPassword){
            bootbox.alert({
                message : 'The passwords you entered must be the same!',
                callback : function() {
                    $("input").val("");
                }
            });
            return;
        }

        $(this).ajaxSubmit({
            type: 'POST',
            url : 'registerPro',
            processData : true,
            dataType : 'text',
            data : {
                username : username,
                password : password,
                role : role
            },
            success : function(data) {
                if (data === "success"){
                    bootbox.alert({
                        message : 'Register Complete!',
                        callback : function() {
                            window.location.href = "checkUserPro";
                        }
                    });
                }
                else if (data === "error"){
                    bootbox.alert({
                        message : 'Duplicate Username!',
                        callback : function() {
                            $("input").val("");
                        }
                    });
                }
            }
        })
	});
});