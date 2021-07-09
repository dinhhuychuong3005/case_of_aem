<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">

<style>
  .bs-example{
    margin: 20px;
  }
  .a{
    background: greenyellow ;
  }
  .b{
    background: beige;
  }
</style>
</head>
<body>
<center>
  <h1>List Customer</h1>
</center>
<div class="container">
  <br/>
  <div class="row justify-content-center">
    <div class="col-12 col-md-10 col-lg-8">
      <form class="card card-sm">
        <div class="card-body row no-gutters align-items-center">
          <div class="col-auto">
            <i class="fas fa-search h4 text-body"></i>
            <div class="col">
              <input type="hidden" name="action" value="search">
              <input type="text" name="key" class="form-control form-control-lg form-control-borderless" placeholder="Search topics or keywords">
            </div>
            <div class="col-auto">
              <select name="type">
                <option value="name">Tìm theo tên</option>
                <option value="phone">Tìm theo số điện thoại</option>
              </select>
            </div>
          </div>
          <div class="col-auto" align="right">
            <input class="btn btn-lg btn-success" type="submit" value="Search"                                                                                                                                                          >
          </div>
          <div class="col-auto" align="right">
            <input class="btn btn-lg btn-success" type="submit" value="come back"                                                                                                                                                        >
          </div>
        </div>
      </form>
    </div>
  </div>

</div>
<form >
<div>
  <input type="hidden" name="action" value="Back">
  <input class="btn btn-lg btn-success" type="submit" value="Back" >
</div>
</form>
<div class="bs-example">
  <table class="table table-bordered">
    <thead>
    <tr class="a">

      <th>Name</th>
      <th>PhoneNumber</th>
      <th>Email</th>
      <th>UserName</th>
      <th>Password</th>
    </tr>
    <c:forEach items="${customers}" var="cus">
    <tr class="b">
      <th>${cus.customerName} </a></th>
      <th>${cus.customerPhone} </a></th>
      <th>${cus.customerEmail} </a></th>
      <th>${cus.userName} </a></th>
      <th>${cus.password} </a></th>
    </tr>
    </c:forEach>
  </table>
</div>

</body>
</body>
</html>