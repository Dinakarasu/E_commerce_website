<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Website \Enter the OTP</title>
    
        <link rel="apple-touch-icon" sizes="180x180" href="images/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="images/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="images/favicon-16x16.png">
<link rel="manifest" href="/site.webmanifest">
    
    <link rel="stylesheet" href="css/style1.css">
</head>
<body>
    <div id="container">
        <div class="form-wrap">
            <h1>Seller</h1>
            <h1>Enter OTP</h1>
            <p> OTP send to your given email</p>

            <c:if test="${not empty failedMsg }">
               <p class="text-center text-danger">${failedMsg}</p>
               <c:remove var="failedMsg" scope="session" />            
            </c:if>
            
            <form action="sellerValidateOtp" method="post">
                <div class="form-group">
                    <label for="otp">Enter the OTP</label>
                    <input type="otp" name="otp" id="otp"/>
                </div>
                <button type="submit" class="btn">submit</button>
            </div>
        </form>
    </div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div>
        <footer>
            <p1>	&#xA9 Copyright - 2023</p1>
        </footer>
    </div>
    <br>
</div>
</body>
</html>