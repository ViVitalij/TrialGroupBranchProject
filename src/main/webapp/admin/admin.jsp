<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8"/>
    <title>Correct login</title>
</head>
<body>
    <%
    String username = request.getRemoteUser();
    %>
    <span>Congratulations! <%=username%> - you have logged in correctly :-)</span>
    <br />
    <br />

    <script type="text/javascript">
    var tday=new Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday");
    var tmonth=new Array("January","February","March","April","May","June","July","August","September","October","November","December");

    function GetClock(){
    var d=new Date();
    var nday=d.getDay(),nmonth=d.getMonth(),ndate=d.getDate();
    var nhour=d.getHours(),nmin=d.getMinutes(),nsec=d.getSeconds();
    if(nmin<=9) nmin="0"+nmin
    if(nsec<=9) nsec="0"+nsec;

    document.getElementById('clockbox').innerHTML=""+tday[nday]+", "+tmonth[nmonth]+" "+ndate+" "+nhour+":"+nmin+":"+nsec+"";
    }

    window.onload=function(){
    GetClock();
    setInterval(GetClock,1000);
    }
    </script>
    <span>Today is: </span>
    <div id="clockbox"></div>



</body>
</html>