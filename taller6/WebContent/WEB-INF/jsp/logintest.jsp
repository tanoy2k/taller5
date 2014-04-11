<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">.test{color:#f00;}</style>
<script src="./jquery-1.10.2.js"></script> 
<script type="text/javascript">
//   jQuery.getJSON( "http://localhost:8080/twitter/test.htm",success(data, textStatus, jqXHR)] )

$(document).ready(function(){
  $("form#loginForm").submit(function() { // loginForm is submitted
    var username = $('#username').attr('value'); // get username
    var password = $('#password').attr('value'); // get password

    if (username && password) { // values are not empty
      $.ajax({
        type: "GET",
        url: "/cgi-bin/login.pl", // URL of the Perl script
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        // send username and password as parameters to the Perl script
        data: "username=" + username + "&password=" + password,
        // script call was *not* successful
        error: function(XMLHttpRequest, textStatus, errorThrown) { 
          $('div#loginResult').text("responseText: " + XMLHttpRequest.responseText 
            + ", textStatus: " + textStatus 
            + ", errorThrown: " + errorThrown);
          $('div#loginResult').addClass("error");
        }, // error 
        // script call was successful 
        // data contains the JSON values returned by the Perl script 
        success: function(data){
          if (data.error) { // script returned error
            $('div#loginResult').text("data.error: " + data.error);
            $('div#loginResult').addClass("error");
          } // if
          else { // login was successful
            $('form#loginForm').hide();
            $('div#loginResult').text("data.success: " + data.success 
              + ", data.userid: " + data.userid);
            $('div#loginResult').addClass("success");
          } //else
        } // success
      }); // ajax
    } // if
    else {
      $('div#loginResult').text("enter username and password");
      $('div#loginResult').addClass("error");
    } // else
    $('div#loginResult').fadeIn();
    return false;
  });
});
   
</script>
</head>
<body>

<!-- 
<h1>hola login</h1><div id="indicator"></div><div id="twitts"></div>

<label id="lblUsuario">Usuario</label>
<input id="loginUsuario" name="loginUsuario" type="text"/>
<label id="lblPassword">Contrase�a</label>
<input id="loginPassword" name="loginPassword" type="password"/>
<br><button id="btnIngresar">Ingresar</button>
 -->
 
<fieldset>
    <legend>Enter information</legend>
    <p>
      <label for="username">Username</label>
      <br />
      <input type="text" id="username" name="username" class="text" size="20" />
    </p>
    <p>
      <label for="password">Password</label>
      <br />
      <input type="password" id="password" name="password" class="text" size="20" />
    </p>
    <p>
      <button type="submit" class="button positive">
       <img alt="ok" src=
       "http://www.blueprintcss.org/blueprint/plugins/buttons/icons/tick.png" /> 
       Login
      </button>
    </p>
</fieldset>
</body>
</html> 