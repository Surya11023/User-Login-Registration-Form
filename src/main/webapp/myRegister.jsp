<head>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 400px;
            width: 100%;
        }

        h1 {
            color: #0033cc;
            margin-bottom: 20px;
            font-size: 2.2em;
        }

        h3 {
            color: #333;
            margin-bottom: 10px;
            font-size: 1.2em;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #0033cc;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #002080;
        }

        .login-link {
            margin-top: 20px;
            font-size: 1em;
        }

        a {
            color: #0033cc;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

    </style>
</head>

<body>
    <div class="container">
        <h1>Register here</h1>

        <form name="f1" action="myRegister" method="post" onsubmit="return validate()">
            <h3>First Name</h3>
            <input type="text" name="fname">

            <h3>Last Name</h3>
            <input type="text" name="sname">

            <h3>Username</h3>
            <input type="text" name="username">

            <h3>Password</h3>
            <input type="password" name="password">

            <h3>Retype Password</h3>
            <input type="password" name="retypepassword">

            <h3>Mobile Number</h3>
            <input type="text" name="pnumber">

            <input type="submit" value="Register">
            <div class="login-link" >
           Already have an account? <a href="myLogin.jsp">Login here</a>
            </div>
        </form>
    </div>

    <script>
        function validate() {
            var fname = document.f1.fname.value;
            var sname = document.f1.sname.value;
            var username = document.f1.username.value;
            var password = document.f1.password.value;
            var retypepassword = document.f1.retypepassword.value;
            var pnumber = document.f1.pnumber.value;

            if (fname === "") {
                alert("First Name cannot be empty");
                return false;
            }

            if (sname === "") {
                alert("Last Name cannot be empty");
                return false;
            }

            if (username === "") {
                alert("Username cannot be empty");
                return false;
            }

            if (password === "") {
                alert("Password cannot be empty");
                return false;
            }

            if (password !== retypepassword) {
                alert("Passwords do not match");
                return false;
            }

            if (pnumber === "") {
                alert("Mobile Number cannot be empty");
                return false;
            }

            return true;
        }
    </script>
</body>
