<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Website | Seller Password Reset </title>
    <link rel="stylesheet" href="css/style1.css">
</head>
<body>
    <div id="container">
        <div class="form-wrap">
            <h1>Seller</h1>
            <h1>Reset Password</h1>
            <p> 1.Enter new password and confirm password <br> 2.It's take only few minutes</p>
            <form action=sellernewPassword method="post">
                <div class="form-group">
                    <label for="password">New Password</label>
                    <input type="password" name="password" id="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                    required title=" use 8 character minimum,1-special character(!@#$%^&*()),1-Capital letter(A-Z),1-Number(0-9)"/>
                </div>
                <div class="form-group">
                    <label for="password2">Confirm Password</label>
                    <input type="password" name="password2" id="password2" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                    required title="Repeat same password"/>
                </div>
                <button type="submit" class="btn">submit</button>
                <p class="bottom-text">
                </p>
            </div>
        </form>
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