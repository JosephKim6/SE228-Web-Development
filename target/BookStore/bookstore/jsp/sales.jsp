<%@ page import="java.util.ArrayList"%>
<%@ page import="model.User"%>
<%@ page import="model.Book"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>BookStore Database - Orders Table</title>

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
    ArrayList<User> userList = new ArrayList<User>();
    if(request.getAttribute("users") != null) {
        userList = (ArrayList<User>) request.getAttribute("users");
    }
    ArrayList<Book> bookList = new ArrayList<Book>();
    if(request.getAttribute("books") != null) {
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
                <li><a href="allBooksPro">Books Table</a></li>
                <li><a href="allUsersPro">Users Table</a></li>
                <li><a href="allOrdersPro">Orders Table</a></li>
                <li><a href="allOrderitemsPro">Order Items Table</a></li>
                <li class="active"><a href="#">Sales Statistics <span class="sr-only">(current)</span></a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">Sales Statistics</h2>
            <div id="chart" style="width: 600px;height:400px;"></div>
            <h3>By User</h3>
            <div>
                <label>User:</label>
                <select id="user">
                    <%
                        for (int i = 0; i < userList.size(); i++) {
                            User user = userList.get(i);
                    %>
                    <option value="<%=user.getId()%>"><%=user.getId()%>. <%=user.getUsername()%></option>
                    <%
                        }
                    %>
                </select>
                <br/>
                <button class="btn btn-default" type="button" id="searchUser">Search</button>
                <table class="table">
                    <thead>
                        <tr>
                            <th>BookID</th>
                            <th>Book Title</th>
                            <th>Amount</th>
                            <th>Price</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody id="salesUserBody">
                    </tbody>
                </table>
                <h3 style="text-align: right;">Sales Volume: $<span id="userVolume">0</span></h3>
            </div>
            <h3>By Book</h3>
            <div>
                <label>Book:</label>
                <select id="book">
                    <%
                        for (int i = 0; i < bookList.size(); i++) {
                            Book book = bookList.get(i);
                    %>
                    <option value="<%=book.getId()%>"><%=book.getId()%>. <%=book.getTitle()%></option>
                    <%
                        }
                    %>
                </select>
                <br/>
                <button class="btn btn-default" type="button" id="searchBook">Search</button>
                <table class="table">
                    <thead>
                    <tr>
                        <th>UserID</th>
                        <th>User Name</th>
                        <th>Amount</th>
                        <th>Price</th>
                        <th>Date</th>
                    </tr>
                    </thead>
                    <tbody id="salesBookBody">
                    </tbody>
                </table>
                <h3 style="text-align: right;">Sales Volume: $<span id="bookVolume">0</span></h3>
            </div>
            <h3>By Date</h3>
            <div>
                <label>Start Date:</label>
                <input type="date" id="startDate"/>
                <label>End Date:</label>
                <input type="date" id="endDate"/>
                <br/>
                <button class="btn btn-default" type="button" id="searchDate">Search</button>
                <table class="table">
                    <thead>
                    <tr>
                        <th>User Name</th>
                        <th>Book Title</th>
                        <th>Amount</th>
                        <th>Price</th>
                        <th>Date</th>
                    </tr>
                    </thead>
                    <tbody id="salesDateBody">
                    </tbody>
                </table>
                <h3 style="text-align: right;">Sales Volume: $<span id="dateVolume">0</span></h3>
            </div>

            <div>

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
<script type="text/javascript" charset="utf8" src="<%=path%>/bookstore/js/echarts.common.min.js"></script>
<script type="text/javascript" charset="utf8" src="<%=path%>/bookstore/js/sales.js"></script>
</body>
</html>