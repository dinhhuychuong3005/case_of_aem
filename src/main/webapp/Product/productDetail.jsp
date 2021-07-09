<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 08/07/2021
  Time: 11:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Printd T-Shirt - RedStore</title>
    <link rel="stylesheet" href="style.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<div class="container">
    <div class="navbar">
        <div class="logo">
            <a href="index.html"><img src="images/tao-logo-shop-quan-ao-ny.jpg" width="125px"></a>
        </div>
        <nav>
            <ul id="MenuItems">
                <li><a href="/home">Home</a></li>
                <li><a href="/UserProduct">Products</a></li>
                <li ><a href="/home" >Sign Out</a></li>
            </ul>
        </nav>
        <a href="/carts?action=show"><img src="images/cart.png" width="30px" height="30px"></a>
        <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
    </div>
</div>
</div>

<!-- ---------- single Products detail ----------- -->

<div class="small-container single-product">
    <div class="row">
        <div class="col-2">
            <img src="${products.productImage}" width="100%" id="productImg">



        </div>
        <div class="col-2">

            <h1>${products.productName}</h1>
            <h4>${products.productPrice}</h4>
            <select>
                <option>Select Size</option>
                <option>XXL</option>
                <option>XL</option>
                <option>Large</option>
                <option>Medium</option>
                <option>Small</option>
            </select>
            <input type="number" value="1">
            <a href="/carts?action=add" class="btn">Add To Card</a>
            <h3>Product Detail
                <i class="fa fa-indent"></i>
            </h3>
            <br>
            <p>${products.productDescription}</p>
        </div>
    </div>
</div>

<!-- ----- title------------- -->
<div class="small-container">
    <div class="row row2">
        <h2>Relate Products</h2>
        <p>View More</p>
    </div>
</div>

<!-- ---------------Products----------------- -->
<div class="small-container">

    <div class="row">
        <c:forEach items="${productList}" var="p">
        <div class="col-4">
            <img src="${p.productImage}">
            <h4>${p.productName}</h4>
            <div class="rating">
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star-o"></i>
            </div>
            <p>${p.productPrice}</p>
        </div>

        </c:forEach>
    </div>
</div>
<%--        <div class="col-4">--%>
<%--            <img src="images/product-2.jpg">--%>
<%--            <h4>Red Printed T-Shirt</h4>--%>
<%--            <div class="rating">--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star-half-o"></i>--%>
<%--                <i class="fa fa-star-o"></i>--%>
<%--            </div>--%>
<%--            <p>$50.00</p>--%>
<%--        </div>--%>
<%--        <div class="col-4">--%>
<%--            <img src="images/product-3.jpg">--%>
<%--            <h4>Red Printed T-Shirt</h4>--%>
<%--            <div class="rating">--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star-half-o"></i>--%>
<%--            </div>--%>
<%--            <p>$50.00</p>--%>
<%--        </div>--%>
<%--        <div class="col-4">--%>
<%--            <img src="images/product-4.jpg">--%>
<%--            <h4>Red Printed T-Shirt</h4>--%>
<%--            <div class="rating">--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star-o"></i>--%>
<%--            </div>--%>
<%--            <p>$50.00</p>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="row">--%>
<%--        <div class="col-4">--%>
<%--            <img src="images/product-5.jpg">--%>
<%--            <h4>Red Printed T-Shirt</h4>--%>
<%--            <div class="rating">--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star-o"></i>--%>
<%--            </div>--%>
<%--            <p>$50.00</p>--%>
<%--        </div>--%>
<%--        <div class="col-4">--%>
<%--            <img src="images/product-6.jpg">--%>
<%--            <h4>Red Printed T-Shirt</h4>--%>
<%--            <div class="rating">--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star-half-o"></i>--%>
<%--                <i class="fa fa-star-o"></i>--%>
<%--            </div>--%>
<%--            <p>$50.00</p>--%>
<%--        </div>--%>
<%--        <div class="col-4">--%>
<%--            <img src="images/product-7.jpg">--%>
<%--            <h4>Red Printed T-Shirt</h4>--%>
<%--            <div class="rating">--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star-half-o"></i>--%>
<%--            </div>--%>
<%--            <p>$50.00</p>--%>
<%--        </div>--%>
<%--        <div class="col-4">--%>
<%--            <img src="images/product-8.jpg">--%>
<%--            <h4>Red Printed T-Shirt</h4>--%>
<%--            <div class="rating">--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star-o"></i>--%>
<%--            </div>--%>
<%--            <p >$50.00</p>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="row">--%>
<%--        <div class="col-4">--%>
<%--            <img src="images/product-9.jpg">--%>
<%--            <h4>Red Printed T-Shirt</h4>--%>
<%--            <div class="rating">--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star-o"></i>--%>
<%--            </div>--%>
<%--            <p>$50.00</p>--%>
<%--        </div>--%>
<%--        <div class="col-4">--%>
<%--            <img src="images/product-10.jpg">--%>
<%--            <h4>Red Printed T-Shirt</h4>--%>
<%--            <div class="rating">--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star-half-o"></i>--%>
<%--                <i class="fa fa-star-o"></i>--%>
<%--            </div>--%>
<%--            <p>$50.00</p>--%>
<%--        </div>--%>
<%--        <div class="col-4">--%>
<%--            <img src="images/product-11.jpg">--%>
<%--            <h4>Red Printed T-Shirt</h4>--%>
<%--            <div class="rating">--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star-half-o"></i>--%>
<%--            </div>--%>
<%--            <p>$50.00</p>--%>
<%--        </div>--%>
<%--        <div class="col-4">--%>
<%--            <img src="images/product-12.jpg">--%>
<%--            <h4>Red Printed T-Shirt</h4>--%>
<%--            <div class="rating">--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star"></i>--%>
<%--                <i class="fa fa-star-o"></i>--%>
<%--            </div>--%>
<%--            <p >$50.00</p>--%>
<%--        </div>--%>
<%--    </div>--%>
    <div class="page-btn">
        <span>1</span>
        <span>2</span>
        <span>3</span>
        <span>4</span>
        <span>&#8594;</span>
    </div>
</div>
<!-- ------------footer----------- -->

<div class="footer">
    <div class="container">
        <div class="row">
            <div class="footer-col-1">
                <h3>Download Our App</h3>
                <p>Download App for Android and ios mobile phone</p>
                <div class="app-logo">
                    <img src="images/play-store.png">
                    <img src="images/app-store.png">
                </div>
            </div>
            <div class="footer-col-2">
                <img src="images/logo-white.png">
                <p>Our Purpose Is To Sustainably Make the Pleasure and
                    Benefits of Sports Accessible to the Many</p>
            </div>
            <div class="footer-col-3">
                <h3>Useful Links</h3>
                <ul>
                    <li>Coupons</li>
                    <li>Blog Post</li>
                    <li>Return Policy</li>
                    <li>Join Affiliate</li>
                </ul>
            </div>
            <div class="footer-col-4">
                <h3>Follow us</h3>
                <ul>
                    <li>Facebook</li>
                    <li>Twitter</li>
                    <li>Instagram</li>
                    <li>Youtube </li>
                </ul>
            </div>
        </div>
        <hr>
        <p class="Copyright">Copyright 2020 - By QuocHuy</p>
    </div>
    <!-- ------------------- js for toggle menu-------------- -->
    <script>
        var MenuItems = document.getElementById("MenuItems");

        MenuItems.style.maxHeight = "0px";

        function menutoggle() {
            if (MenuItems.style.maxHeight == "0px") {
                MenuItems.style.maxHeight = "200px";
            }
            else {
                MenuItems.style.maxHeight = "0px";
            }
        }

    </script>

    <!-- ------------------- JS for  product gallery------------------------         -->
    <script>
        var ProductImg = document.getElementById("productImg");
        var SmallImg = document.getElementsByClassName("small-img");

        SmallImg[0].onclick = function()
        {
            ProductImg.src = SmallImg[0].src;
        }
        SmallImg[1].onclick = function()
        {
            ProductImg.src = SmallImg[1].src;
        }
        SmallImg[2].onclick = function()
        {
            ProductImg.src = SmallImg[2].src;
        }
        SmallImg[3].onclick = function()
        {
            ProductImg.src = SmallImg[3].src;
        }

        function tinhien(){
            document.getElementById("")
        }
    </script>
</div>
</body>

</html>
