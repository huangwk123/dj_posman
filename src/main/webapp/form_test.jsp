<%--
  Created by IntelliJ IDEA.
  User: Huangwk
  Date: 2020/7/11
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src ="<%=request.getContextPath()%>/res/js/jquery-1.12.4.js"></script>
    <script type="text/javascript">

       function test() {
            $.ajax({
                url:"<%=request.getContextPath()%>/users",
                dataType:"json",
                contentType: "application/json;charset=utf-8",
                type:"PUT",
                data: JSON.stringify(
                    {"id": 4,"userName":"khkhsss",

                 }),
                success: function (data) {
                    alert(data.data);
                }
            });
       }
       function add() {
            $.ajax({
                url:"<%=request.getContextPath()%>/users",
                dataType:"json",
                type:"post",
                data: {
                    "_method": "POST", "userName":"kkkkh",

                },
                success: function (data) {
                    alert(data.data);
                }
            });
       }
       function del() {
            $.ajax({
                url:"<%=request.getContextPath()%>/users",
                dataType:"json",
                contentType: "application/json;charset=utf-8",
                type:"DELETE",
                data: JSON.stringify({
                     "id": 25,

                }),
                success: function (data) {
                    alert(data.data);
                }
            });
       }

       function tests(){
           $.post("<%=request.getContextPath()%>/users/show",
               {"url":"http://localhost:8081/user/1"},
               function(data){
               if (data.code == 200) {
                   console.log(data.data);
               } else {
                    alert(data.msg);
               }
               })
       }

    </script>
</head>

<body>
    <input type="button" value="修改" onclick="test()">
    <input type="button" value="增加" onclick="add()">
    <input type="button" value="删除" onclick="del()">
    <input type="button" value="正向代理" onclick="tests()">
</body>
</html>
