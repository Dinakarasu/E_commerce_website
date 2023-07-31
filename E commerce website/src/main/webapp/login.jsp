<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Website \ Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div id="container">
        <div class="form-wrap">
            <h1>Login Account</h1>
            <p>Welcome happy to see you &#128578</p>
            <form action="login" method="post">
                <div class="form-group">
                    <label for="email">Email / Contact</label>
                    <input type="user" name="email" id="email"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                    required title=" use 8 character minimum,1-special character(!@#$%^&*()),1-Capital letter(A-Z),1-Number(0-9)"/>
                </div>
                <button type="submit" class="btn">Login</button>
                <p class="bottom-text"><a href="forgotpassword.jsp">forget-password?</a></p>
            </div>
        </form>
        <div>
            <footer>
                <p>Don't have an account?  <a href="register">create account</a></p>
            </footer>
        </div>
    </div>
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