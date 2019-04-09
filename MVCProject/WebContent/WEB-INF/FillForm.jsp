<%@ page language="java" contentType="text/html; "
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; ">
<title>Insert title here</title>
</head>
<body>
 <h1> Hi How are you</h1>
 <form:form action="./sbmit1" method="post" modelAttribute="student1">
 Please Enter Your Name : 
								<form:input  path="name"/>
  <input type="submit" value="click">
 </form:form>
</body>
</html>


			









<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
         <p>  Please Fill the form </p>
         
         <form:errors path="student1.*"/>         
         
         <form action="/MVCProject/sbmit" method="post">
         <table>
         <tr>
         <td>Please Fill your Name : </td> <td><input type="text" name="name"> </td>
         </tr>
         <tr>
         <td>Please Fill your City : </td> <td><input type="text" name="hobby"></td>
         </tr>
        <tr>
         <td>Please Fill Phone Number : </td> <td><input type="text" name="studMob"></td>
         </tr>
         <tr>
         <td>Please Fill DOB : </td> <td><input type="text" name="studDOB"></td>
         </tr>
         <tr>
         <td>Please Fill Your Skills : </td> <td><select name="skills" multiple="multiple" >
                                                 <option value="Java"> Java </option>
                                                 <option value="Python"> Python </option>
                                                 <option value="Android"> Android </option>
                                                 </select>
                                            </td>
         </tr>
         <table>
         <tr> <td>Student Address :</td> </tr>
         <tr>
           <td> country : <input type="text" name="address.country"/> </td>
           <td> city : <input type="text"    name="address.city"/> </td>
           <td> street : <input type="text"    name="address.street"/> </td>
           <td> pincode : <input type="text"    name="address.pincode"/> </td>
         
         </tr>
         </table>
         
         
         <tr>
        <td>  Submit Button : </td> <td><input type="submit" value="Click"></td>
        </tr>
           </table>
         </form>
</body>
</html> --%>