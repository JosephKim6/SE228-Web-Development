<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Book"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>All Books</title>
    <%
        String path = request.getContextPath();
    %>
    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/bookstore/css/bootstrap.min.css" rel="stylesheet">

    <!--DataTables and Editor CSS-->
    <link rel="stylesheet" type="text/css" href="<%=path%>/bookstore/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/bookstore/css/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/bookstore/css/dataTables.responsive.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/bookstore/css/buttons.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/bookstore/css/select.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/bookstore/css/dashboard.css">

    <!-- Custom styles for this template -->
    <link href="<%=path%>/bookstore/css/style.css" rel="stylesheet">

    <link rel="icon" href="<%=path%>/bookstore/images/favicon.ico">
</head>

<body>
<%
    ArrayList<Book> bookList = new ArrayList<>();
    if (request.getAttribute("books") != null) {
        bookList = (ArrayList<Book>) request.getAttribute("books");
    }
%>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Joseph's BookStore</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="logoutPro">Sign Out</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">All Books<span class="sr-only">(current)</span></a></li>
                <li><a href="getCartPro">My Cart</a></li>
                <li><a href="myOrderPro">My Orders</a></li>
                <li><a href="myProfilePro">My Profile</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">All Books</h2>
            <br>
            <div class="table-responsive dataTable_wrapper">
                <table class="table table-striped table-bordered table-hover" id="dataTables">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Price</th>
                        <th>Publisher</th>
                        <th>Date</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (int i = 0; i < bookList.size(); i++) {
                            Book book = bookList.get(i);
                    %>
                    <tr>
                        <td class="id" id="<%=book.getId()%>"><%=book.getId()%></td>
                        <td class="title" id="<%=book.getId()%>"><%=book.getTitle()%></td>
                        <td class="author" id="<%=book.getId()%>"><%=book.getAuthor()%></td>
                        <td class="price" id="<%=book.getId()%>"><%=book.getPrice()%></td>
                        <td class="publisher" id="<%=book.getId()%>"><%=book.getPublisher()%></td>
                        <td class="date" id="<%=book.getId()%>"><%=book.getDate()%></td>
                        <td>
                            <button class="btn btn-default buy" type="button"
                                    data-id="<%=book.getId()%>">
                                Buy
                            </button>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>

            <div class="modal fade" id="modal" tabindex="-1" role="dialog"
                 aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                            </button>
                            <h4 class="modal-title" id="modalTitle"></h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <img src="" alt="image" id="cover" height="300">
                                    <h1 id="titlemodal"></h1>
                                    <h3 id="authormodal"></h3>
                                    <h3 id="pricemodal"></h3>
                                    <br/>
                                    <h4>Description:</h4>
                                    <p id="desmodal"></p>
                                    <form role="form">
                                        <div class="form-group">
                                            <label>Amount</label> <input class="form-control" name="amount" type="number" min="1">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="confirm">Confirm</button>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript and DataTables Editor JavaScript -->

<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
<script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>

<script type="text/javascript" charset="utf8" src="<%=path%>/bookstore/js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf8" src="<%=path%>/bookstore/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" charset="utf8" src="<%=path%>/bookstore/js/dataTables.select.min.js"></script>
<script type="text/javascript" charset="utf8" src="<%=path%>/bookstore/js/bookstore.js"></script>
<script type="text/javascript" charset="utf8" src="<%=path%>/bookstore/js/bootbox.min.js"></script>
<script type="text/javascript" charset="utf8" src="<%=path%>/bookstore/js/buybook.js"></script>
</body>
</html>
