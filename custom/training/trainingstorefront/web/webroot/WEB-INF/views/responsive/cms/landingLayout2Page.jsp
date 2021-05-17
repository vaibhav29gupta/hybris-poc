<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<cms:pageSlot position="SummerOffersSlotName" var="feature" element="div" class="span-24 section5 cms_disp-img_slot">
<cms:component component="${feature}" />
</cms:pageSlot>

</body>
</html>