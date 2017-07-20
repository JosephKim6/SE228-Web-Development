<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Order"%>
<%@ page import="model.Orderitem"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="model.Book" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>My Orders</title>

    <%
        String path = request.getContextPath();
    %>

    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/bookstore/css/bootstrap.min.css" rel="stylesheet">

    <!--DataTables and Editor CSS-->
    <link rel="stylesheet" type="text/css" href="<%=path%>/bookstore/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/bookstore/css/buttons.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/bookstore/css/select.dataTables.min.css">

    <!-- Custom styles for this template -->
    <link href="<%=path%>/bookstore/css/style.css" rel="stylesheet">

    <link rel="icon" href="<%=path%>/bookstore/images/favicon.ico">
</head>

<body>
<%
    ArrayList<Order> orderList = new ArrayList<Order>();
    if (request.getAttribute("orders") != null) {
        orderList = (ArrayList<Order>) request.getAttribute("orders");
    }

    ArrayList<Book> bookList = new ArrayList<Book>();
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
                <li><a href="getCartPro">My Cart</a></li>
                <li class="active"><a href="#">My Orders<span class="sr-only">(current)</span></a></li>
                <li><a href="myProfilePro">My Profile</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">My Orders</h2>
            <br>
            <div class="table-responsive dataTable_wrapper">
                <table class="table table-striped table-bordered table-hover" id="dataTables">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Date</th>
                        <th>Books Ordered</th>
                        <th>Total Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (int i = 0; i < orderList.size(); i++) {
                            Order order = orderList.get(i);
                            Set<Orderitem> orderitems = order.getOrderitems();
                            String orderitemStr = "";
                            BigDecimal sum = new BigDecimal(0);
                            String bookName = "";

                            Iterator iterator = orderitems.iterator();
                            while(iterator.hasNext()){
                                Orderitem item = (Orderitem)iterator.next();
                                for (int j = 0; j < bookList.size(); j++){
                                    if (bookList.get(j).getId() == item.getBookid()) {
                                        bookName = bookList.get(j).getTitle();
                                        break;
                                    }
                                }
                                orderitemStr += bookName + ": " + item.getAmount() + " copy " +
                                        " $" + item.getPrice().multiply(new BigDecimal(item.getAmount())) + "<br/>";
                                sum = sum.add(item.getPrice().multiply(new BigDecimal(item.getAmount())));
                            }
                    %>
                    <tr>
                        <td><%=order.getId()%></td>
                        <td><%=order.getDate()%></td>
                        <td><%=orderitemStr%></td>
                        <td>$<%=sum %></td>
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
<script type="text/javascript" charset="utf8" src="<%=path%>/bookstore/js/bootbox.min.js"></script>
</body>
</html>
