<%--
  Created by IntelliJ IDEA.
  User: venkat
  Date: 23/09/2023
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" required><br><br>

    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="country">Country:</label>
    <select id="country" name="country">
        <option value="India">India</option>
        <option value="USA">USA</option>
    </select><br><br>

    <label>Hobbies:</label><br>
    <input type="checkbox" id="hobby1" name="hobby1" value="Reading">
    <label for="hobby1">Reading</label><br>

    <input type="checkbox" id="hobby2" name="hobby2" value="Traveling">
    <label for="hobby2">Traveling</label><br>

    <input type="checkbox" id="hobby3" name="hobby3" value="Sports">
    <label for="hobby3">Sports</label><br>

    <input type="checkbox" id="hobby4" name="hobby4" value="Music">
    <label for="hobby4">Music</label><br><br>

    <label>Gender:</label><br>
    <input type="radio" id="male" name="gender" value="Male">
    <label for="male">Male</label><br>

    <input type="radio" id="female" name="gender" value="Female">
    <label for="female">Female</label><br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>
