<!DOCTYPE html>
<html lang="en">
  <head>
    <%
      String path = request.getContextPath();
    %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<%=path%>/bookstore/images/favicon.ico">

    <title>Signup</title>


    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/bookstore/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=path%>/bookstore/css/signup.css" rel="stylesheet">
  </head>

  <body>

  <div class="container">

    <form class="form-signin" id="signup" target="id_iframe">
      <h2 class="form-signin-heading">Please sign up</h2>
      <label class="sr-only">User Name</label>
      <input id="username" class="form-control" placeholder="User Name" required autofocus>
      <label class="sr-only">Password</label>
      <input type="password" id="password" class="form-control" placeholder="Password" required>
      <input type="password" id="confirmPassword" class="form-control" placeholder="Confirm Password" required>
      <br>
      <button class="btn btn-lg btn-primary btn-block" id="submitButton">Sign up</button>
    </form>

    <iframe id="id_iframe" name="id_iframe" style="display:none;"></iframe>

  </div> <!-- /container -->
    
    
    <script src="<%=path%>/bookstore/js/jquery.min.js"></script>
  	<script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>
  	<script src="<%=path%>/bookstore/js/signup.js"></script>
    <script src="<%=path%>/bookstore/js/bootbox.min.js"></script>
  <script src="<%=path%>/bookstore/js/jquery.form.js"></script>
  	
  </body>
</html>
