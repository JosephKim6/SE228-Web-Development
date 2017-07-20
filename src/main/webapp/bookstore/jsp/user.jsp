<%@ page import="java.util.ArrayList"%>
<%@ page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  
    <title>BookStore Database - Users Table</title>
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
      if (request.getAttribute("users") != null) {
        userList = (ArrayList<User>) request.getAttribute("users");
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
            <li class="active"><a href="#">Users Table <span class="sr-only">(current)</span></a></li>
            <li><a href="allOrdersPro">Orders Table</a></li>
            <li><a href="allOrderitemsPro">Order Items Table</a></li>
            <li><li><a href="salesPro">Sales Statistics</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">Users Table</h2>
          <div>
            <button class="btn btn-default" type="button" id="add">
              Add User
            </button>
          </div>
          <br>
          <div class="table-responsive  dataTable_wrapper">
            <table class="table table-striped table-bordered table-hover" id="dataTables">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>User Name</th>
                  <th>Password</th>
                  <th>Role</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
              <%
                for (int i = 0; i < userList.size(); i++) {
                  User user = userList.get(i);
              %>
              <tr>
                <td><%=user.getId()%></td>
                <td><%=user.getUsername()%></td>
                <td><%=user.getPassword()%></td>
                <td><%=user.getRole()%></td>
                <td>
                  <button class="btn btn-default delete" type="button"
                          data-id="<%=user.getId()%>">
                    Delete
                  </button>
                  <button class="btn btn-default edit" type="button"
                          data-id="<%=user.getId()%>"
                          data-username="<%=user.getUsername()%>"
                          data-password="<%=user.getPassword()%>"
                          data-role="<%=user.getRole()%>">
                    Edit
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
            <div class="modal-dialog">
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
                      <form role="form">
                        <div class="form-group">
                          <label>Username</label> <input class="form-control" name="username">
                        </div>
                        <div class="form-group">
                          <label>Password</label> <input class="form-control"
                                                         name="password">
                        </div>
                        <div class="form-group">
                          <label>Role</label> <input class="form-control" name="role">
                        </div>
                        <div class="form-group">
                          <label>Description</label> <input class="form-control" name="description">
                        </div>
                        <div class="form-group">
                          <label>Avatar</label>
                          <input type="file" name="image" class="fileupload">
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary" id="save">Save</button>
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
    <script type="text/javascript" charset="utf8" src="<%=path%>/bookstore/js/user.js"></script>
    <script type="text/javascript" charset="utf8" src="<%=path%>/bookstore/js/bootbox.min.js"></script>
  </body>
</html>