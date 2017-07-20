$(function() {
    $('#dataTables').dataTable( {
        "pagingType":   "simple_numbers"
    } );

	$("#save").click(function(e) {
		var orderid = $("#orderid").val();
		var bookid = $("#bookid").val();
        var price = $("input[name='price']").val();
		var amount = $("input[name='amount']").val();
		console.log(orderid, bookid, price, amount);

		var dataset = e.currentTarget.dataset;
		var id = dataset.id;
        if (amount <= 0 || amount % 1 !== 0) {
            alert("Wrong format!");
            return;
        }
		if (id != "") { // Edit
			jQuery.ajax({
				url : 'updateOrderitemPro',
				processData : true,
				dataType : "text",
				data : {
					id : id,
					orderid : orderid,
					bookid : bookid,
					price: price,
					amount : amount
				},
				success : function(data) {
					console.log(id);
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
				url : 'addOrderitemPro',
				processData : true,
				dataType : "text",
				data : {
					orderid : orderid,
					bookid : bookid,
					price: price,
					amount : amount
				},
				success : function(data) {
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
						url : 'deleteOrderitemPro',
						processData : true,
						dataType : "text",
						data : {
							id : id
						},
						success : function(data) {
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

		$("#orderid").val("");
		$("#bookid").val("");
		$("input[name='amount']").val("");

		$("#save").attr("data-id", "");
		$('#modal').modal('show');
	});

    $("#dataTables").on('click', '.edit',function(e) {
		$('#modalTitle').html("Edit");
		var dataset = e.currentTarget.dataset;
		var id = dataset.id;
		console.log(id);

		$("#orderid").val(dataset.orderid);
		$("#bookid").val(dataset.bookid);
        $("input[name='price']").val(dataset.price);
		$("input[name='amount']").val(dataset.amount);

		$("#save").attr("data-id", dataset.id);
		$('#modal').modal('show');
	});

});
