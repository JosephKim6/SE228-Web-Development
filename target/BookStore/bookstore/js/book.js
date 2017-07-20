$(function() {
    $('#dataTables').dataTable( {
        "pagingType":   "simple_numbers"
    } );

	$("#save").click(function(e) {
		var title = $("input[name='title']").val();
		var author = $("input[name='author']").val();
		var price = $("input[name='price']").val();
		var publisher = $("input[name='publisher']").val();
		var date = $("input[name='date']").val();
        var description = $("input[name='description']").val();
        var file = $("input.fileupload");

        if (file[0].files[0] === undefined) {
            alert("update failed! please remember to upload book image!");
            location.reload();
            return;
        }
		var dataset = e.currentTarget.dataset;
		var id = dataset.id;

        var formData = new FormData();
		formData.append("id", id);
        formData.append("title", title);
        formData.append("author", author);
        formData.append("price", price);
        formData.append("publisher", publisher);
        formData.append("date", date);
        formData.append("description", description);
        formData.append("image", file[0].files[0]);

		if (id != "") { // Edit
			jQuery.ajax({
                type : 'POST',
                url : 'updateBookPro',
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
				url : 'addBookPro',
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
						url : 'deleteBookPro',
						processData : true,
						dataType : "text",
						data : {
							id : id
						},
						success : function() {
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

		$("input[name='title']").val("");
		$("input[name='author']").val("");
		$("input[name='price']").val("");
		$("input[name='publisher']").val("");
		$("input[name='date']").val("");
        $("input[name='description']").val("");

		$("#save").attr("data-id", "");
		$('#modal').modal('show');
	});

    $("#dataTables").on('click', '.edit',function(e) {
		$('#modalTitle').html("Edit");
		var dataset = e.currentTarget.dataset;
		var id = dataset.id;

		$("input[name='title']").val(dataset.title);
		$("input[name='author']").val(dataset.author);
		$("input[name='price']").val(dataset.price);
		$("input[name='publisher']").val(dataset.publisher);
		$("input[name='date']").val(dataset.date);

		jQuery.ajax({
			url : "getBookDetailPro",
            processData : true,
            data : {
                id : id
            },
			success : function (data) {
                $("input[name='description']").val(data.description);
                $("#save").attr("data-id", dataset.id);
                $('#modal').modal('show');
            }
		});
	});

});

