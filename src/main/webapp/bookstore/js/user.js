$(function() {
    $('#dataTables').dataTable( {
        "pagingType":   "simple_numbers"
    } );

	$("#save").click(function(e) {
		var username = $("input[name='username']").val();
		var password = $("input[name='password']").val();
		var role = $("input[name='role']").val();
        var description = $("input[name='description']").val();
        var file = $("input.fileupload");

        if (file[0].files[0] === undefined) {
            alert("update failed! please remember to upload user avatar!");
            location.reload();
            return;
        }

		var dataset = e.currentTarget.dataset;
		var id = dataset.id;

        var formData = new FormData();
        formData.append("id", id);
        formData.append("username", username);
        formData.append("password", password);
        formData.append("role", role);
        formData.append("description", description);
        formData.append("image", file[0].files[0]);

		if (id != "") { // Edit
			jQuery.ajax({
				type : 'POST',
				url : 'updateUserPro',
                processData : false,
                contentType : false,
				data : formData,
				success : function() {
					bootbox.alert({
						message : 'Modify Successfully! '
							+ 'PS: No change if foreign key does not exist!',
						callback : function() {
							location.reload();
						}
					});
				}
			});
		} else { // Add
			jQuery.ajax({
				type : 'POST',
				url : 'addUserPro',
                processData : false,
                contentType : false,
				data : formData,
				success : function() {
					bootbox.alert({
						message : 'Add Successfully! '
							+ 'PS: No change if foreign key does not exist!',
						callback : function() {
							location.reload();
						}
					});
				}
			})
		}

		$('#modal').modal('hide');
	});

    $("#dataTables").on('click', '.delete',function(e) {
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
						url : 'deleteUserPro',
						processData : true,
						dataType : "text",
						data : {
							id : id
						},
						success : function() {
							console.log(id);
							bootbox.alert({
								message : 'Delete Successfully! '
									+ 'PS: No change if foreign key does not exist!',
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

	$("#add").click(function(e) {
		$('#modalTitle').html("Add");

		$("input[name='username']").val("");
		$("input[name='password']").val("");
		$("input[name='role']").val("");

		$("#save").attr("data-id", "");
		$('#modal').modal('show');
	});

    $("#dataTables").on('click', '.edit',function(e) {
		$('#modalTitle').html("Edit");
		var dataset = e.currentTarget.dataset;
		var id = dataset.id;

		$("input[name='username']").val(dataset.username);
		$("input[name='password']").val(dataset.password);
		$("input[name='role']").val(dataset.role);

        jQuery.ajax({
            url : "getUserDescriptionByIdPro",
            processData : true,
            data : {
                id : id
            },
            success : function (data) {
                $("input[name='description']").val(data);
                $("#save").attr("data-id", dataset.id);
                $('#modal').modal('show');
            }
        });
	});

});
