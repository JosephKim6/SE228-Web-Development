$(function () {
    $('#changeDes').click(function () {
        jQuery.ajax({
            url : "getUserDescriptionPro",
            processData : true,
            success : function (data) {
                $("input[name='description']").val(data);
                $('#modalTitleDes').html("Change Profile");
                $('#modalDes').modal('show');
            }
        });

    });

    $('#chgAvatar').click(function () {
        $('#modalTitleAva').html("Upload Avatar");
        $('#modalAva').modal('show');
    });
    
    $('#chgPassword').click(function () {
        $('#modalTitlePassword').html("Change Password");
        $('#modalPassword').modal('show');
    });

    $('#saveDes').click(function () {
        var description = $("input[name='description']").val();
        var formData = new FormData();
        formData.append("description", description);
        jQuery.ajax({
            type : 'POST',
            url : 'changeProfilePro',
            processData : false,
            contentType : false,
            data : formData,
            success : function() {
                bootbox.alert({
                    message : 'Success!',
                    callback : function() {
                        location.reload();
                    }
                });
            }
        });

        $('#modalDes').modal('hide');
    });

    $('#saveAva').click(function () {
        var file = $("input.fileupload");
        var formData = new FormData();

        if (file[0].files[0] === undefined) {
            alert("upload failed!");
            return;
        }

        formData.append("image", file[0].files[0]);

        jQuery.ajax({
            type : 'POST',
            url : 'uploadAvatarPro',
            processData : false,
            contentType : false,
            data : formData,
            success : function() {
                bootbox.alert({
                    message : 'Success!',
                    callback : function() {
                        location.reload();
                    }
                });
            }
        });
    });

    $('#savePassword').click(function () {
        var password = $("input[name='newPassword']").val();
        var conPassword = $("input[name='confirmPassword']").val();
        if (password === "" || conPassword === "" || password !== conPassword) {
            alert("Error! Please check your input!");
            return;
        }
        jQuery.ajax({
            url : "changePasswordPro",
            data: {
                password: password
            },
            success : function () {
                alert("success!");
                location.reload();
            }
        });
    });
});