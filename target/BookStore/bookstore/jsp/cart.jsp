<%@ page import="java.util.Map"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Book"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>My Cart</title>
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
    Map<Integer, Integer> cart = new HashMap<>();
    if (request.getAttribute("cart") != null) {
        cart = (Map<Integer, Integer>) request.getAttribute("cart");
    }
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
                <li><a href="buyListPro">All Books</a></li>
                <li class="active"><a href="#">My Cart<span class="sr-only">(current)</span></a></li>
                <li><a href="myOrderPro">My Orders</a></li>
                <li><a href="myProfilePro">My Profile</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">My Cart</h2>
            <div>
                <button class="btn btn-default" type="button" id="pay">
                    Pay Money
                </button>
            </div>
            <br>
            <div class="table-responsive dataTable_wrapper">
                <table class="table table-striped table-bordered table-hover" id="dataTables">
                    <thead>
                    <tr>
                        <th>Book ID</th>
                        <th>Book Name</th>
                        <th>Amount</th>
                        <th>Total Price</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (Map.Entry<Integer, Integer> entry : cart.entrySet()){
                            int bookid = entry.getKey();
                            int amount = entry.getValue();
                            String name = "";
                            BigDecimal totalprice;
                            BigDecimal price = new BigDecimal(1);
                            for (Book book : bookList){
                                if (book.getId() == bookid){
                                    name = book.getTitle();
                                    price = book.getPrice();
                                    break;
                                }
                            }
                            totalprice = price.multiply(new BigDecimal(amount));
                    %>
                    <tr>
                        <td><%=bookid%></td>
                        <td><%=name%></td>
                        <td><%=amount%></td>
                        <td><%=totalprice%></td>
                        <td>
                            <button class="btn btn-default delete" type="button"
                                    data-id="<%=bookid%>">
                                Delete
                            </button>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
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
<script type="text/javascript" charset="utf8" src="<%=path%>/bookstore/js/cart.js"></script>
</body>
</html>
