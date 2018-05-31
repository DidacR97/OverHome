<?php

echo'
<html>
    <link rel="stylesheet" type="text/css" href="../styles/login.css">
    <head>
        <title>Overhome-Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <img id="logo" src="../images/overtakenOH_logo.svg"/>
        <div id="login_box">
            <form action="validateUser.php" method="POST">
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="uname" required>

                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required>

                <button type="submit">Login</button>
            </form>
        </div>
    </body>
</html>';

?>