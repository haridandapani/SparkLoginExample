<!DOCTYPE html>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/html5bp.css">
  <head>
    <meta charset="utf-8">
    <title>Reset</title>
    <h1 id ="some-id">RESET</h1>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
    <!-- In real-world webapps, css is usually minified and
         concatenated. Here, separate normalize from our code, and
         avoid minification for clarity. -->
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/html5bp.css">
    <link rel="stylesheet" href="css/main.css">
  </head>
  <body class ="some-class">
       <!-- Again, we're serving up the unminified source for clarity. -->
     <form method = "POST" action = "/reset">
      Username: <input type = "text" name = "username" id = "username"></input><br>
      Old Password: <input type = "password" name = "oldpassword" id = "oldpassword"></input><br>
      New Password: <input type = "password" name = "newpass" id = "newpass"></input><br>
      Verify New Password: <input type = "password" name = "newpassverify" id = "newpassverify"></input><br>
      <input type = "submit" value="Login!"></input>
     </form>
     ${message}
  </body>
  <!-- See http://html5boilerplate.com/ for a good place to start
       dealing with real world issues like old browsers.  -->
</html>
