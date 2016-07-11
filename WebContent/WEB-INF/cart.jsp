<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="shortcut icon" href="pic/favicon.ico" type="image/x-icon" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="odin.css" rel="stylesheet" type="text/css">
<link href="cart.css" rel="stylesheet" type="text/css">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Odin Security: view my cart</title>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

</head><body style="padding-top: 70px">



<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#topFixedNavbar1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
      <a href="log in.html"><img src="pic/logo.jpg" height="50"></a></div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="topFixedNavbar1">
      <ul class="nav navbar-nav">

        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Product<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Business</a></li>

            <li><a href="#">Personal</a></li>

          </ul>
        </li>
        <li><a href="#">About</a></li>
        <li><a href="contact.html">Contact Us</a></li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="log in.html">Login</a></li>  
        <li><a href="view my cart.html">View my cart</a></li> 
      </ul>
    </div>
    <!-- /.navbar-collapse -->
  </div>
  <!-- /.container-fluid -->
</nav>
<script src="js/jquery-1.11.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>






<div class="gwc" style=" margin:auto;">
	<table cellpadding="0" cellspacing="0" class="gwc_tb1">
		<tr>
			<td class="tb1_td1"><input id="Checkbox1" type="checkbox"  class="allselect"></td>
			<td class="tb1_td1">Select all</td>
			<td class="tb1_td3">Product name</td>
			<td class="tb1_td4">Product detail</td>
			<td class="tb1_td5">Month</td>
			<td class="tb1_td6">Price</td>
			<td class="tb1_td7">Action</td>
		</tr>
	</table>
		   
	
	
	
	<table cellpadding="0" cellspacing="0" class="gwc_tb2">
		<tr>
			<td class="tb2_td1"><input type="checkbox" value="1" name="newslist" id="newslist-1" /></td>
			<td class="tb2_td2"><a href="#"><img src="pic/box_TS_EN.png"></a></td>
			<td class="tb2_td3"><a href="#">Product name</a></td>
			<td class="tb1_td4">feature</td>
			<td class="tb1_td5">
				<input id="min1" name=""  style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="-" />
				<input id="text_box1" name="" type="text" value="1" style=" width:30px; text-align:center; border:1px solid #ccc;" />
				<input id="add1" name="" style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="+" />
			</td>
			<td class="tb1_td6"><label id="total1" class="tot" style="color:#ff5500;font-size:14px; font-weight:bold;"></label></td>
			<td class="tb1_td7"><a href="#">Delete</a></td>
		</tr>
	</table>
	
	
	
	<table cellpadding="0" cellspacing="0" class="gwc_tb2">
		<tr>
			<td class="tb2_td1"><input type="checkbox" value="1" name="newslist" id="newslist-2" /></td>
			<td class="tb2_td2"><a href="#"><img src="pic/box_TS_EN.png"></a></td>
			<td class="tb2_td3"><a href="#">Product name</a></td>
			<td class="tb1_td4">feature</td>
			<td class="tb1_td5">
				<input id="min2" name=""  style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="-" />
				<input id="text_box2" name="" type="text" value="1" style=" width:30px; text-align:center; border:1px solid #ccc;" />
				<input id="add2" name="" style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="+" />
			</td>
			<td class="tb1_td6"><label id="total2" class="tot" style="color:#ff5500;font-size:14px; font-weight:bold;"></label></td>
			<td class="tb1_td7"><a href="#">Delete</a></td>
		</tr>
	</table>
	
	
	
	<table cellpadding="0" cellspacing="0" class="gwc_tb3">
		<tr>
			<td class="tb1_td1"><input id="checkAll" class="allselect" type="checkbox" /></td>
			<td class="tb1_td1">Select all</td>
			<td class="tb3_td1">
				<input id="invert" type="checkbox" />Invert
				<input id="cancel" type="checkbox" />Cancel
			</td>
			<td class="tb3_td2">Select<label id="shuliang" style="color:#ff5500;font-size:14px; font-weight:bold;">0</label> </td>
			<td class="tb3_td3">Total:<span>$</span><span style=" color:#ff5500;"><label id="zong1" style="color:#ff5500;font-size:14px; font-weight:bold;"></label></span></td>
			<td class="tb3_td4"><span id="jz1">Check out</span><a href="#" style=" display:none;"  class="jz2" id="jz2">check out</a></td>
		</tr>
	</table>

</div>

<script src="js/jq.js"></script>


<footer>Copyright © 2016 Odin Security Company<br>
All Rights Reserved
</footer>
</body>
</html>
