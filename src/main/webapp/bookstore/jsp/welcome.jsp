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
  
    <title>Joseph's BookStore</title>
    <%
      String path = request.getContextPath();
    %>
    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/bookstore/css/bootstrap.min.css" rel="stylesheet">

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
            <li><a href="<%=path%>/bookstore/jsp/login.jsp">Sign In</a></li>
            <li><a href="<%=path%>/bookstore/jsp/register.jsp">Sign Up</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Homepage<span class="sr-only">(current)</span></a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">Welcome to Joseph's BookStore!</h2>
          <h3>Browsing all books</h3>
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
              </tr>
              </thead>
              <tbody>
              <%
                for (int i = 0; i < bookList.size(); i++) {
                  Book book = bookList.get(i);
              %>
              <tr>
                <td><%=book.getId()%></td>
                <td><%=book.getTitle()%></td>
                <td><%=book.getAuthor()%></td>
                <td><%=book.getPrice()%></td>
                <td><%=book.getPublisher()%></td>
                <td><%=book.getDate()%></td>
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
    <script>window.jQuery || document.write('<script src="../js/jquery.min.js"><\/script>')</script>
    <script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>
  </body>>
</html>