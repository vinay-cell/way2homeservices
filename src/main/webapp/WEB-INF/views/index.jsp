<!DOCTYPE html>

<html lang="en" ng-app="way2homeservice" ng-controller="scrollerController" ng-cloak>
<head>
    <meta charset="UTF-8">
	<title>Welcome to way2homeservices</title>
	
	
	<script src="bower_components/angular/angular.js"></script>
	<script src="bower_components/angular-route/angular-route.min.js"></script>
	<script src="lib/ui-bootstrap.js"></script>
	<script src="bower_components/sweetalert/dist/sweetalert.min.js"></script>
	<script src="lib/ui-bootstrap-tpls-1.3.3.min.js"></script>
	<link rel="stylesheet" href="bower_components/sweetalert/dist/sweetalert.css">
	<script src="bower_components/angular-sweetalert/dist/ngSweetAlert.js"></script>
	
	<!-- 
	sweet-alert.css
	sweet-alert.min.js
	ngSweetAlert.js
	 -->
<script src="http://maps.google.com/maps/api/js?sensor=true"></script> 
    <script src="js/app.js"></script>
   <script src="js/controllers/userProductController.js"></script>
    <script src="js/controllers/userProductController.js"></script>
    <script src="js/controllers/scrollerController.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
     <link rel="stylesheet" href="bower_components/sweetalert/dist/sweetalert.css">
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="css/owl.transitions.css">
    <link rel="stylesheet" href="css/prettyPhoto.css">
    <link rel="stylesheet" href="css/responsive-slider.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/app.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="css/stylesheet.css">
  <!--   <link rel="stylesheet" href="css/animate.min.css"> -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->  
    <link rel="shortcut icon" href="http://www.way2homeservices.com/favicon.ico">
    <link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
    <style>
    .highlightedList{
    background-color: #f00;
    }
 
        </style>
</head>
<body id="home" class="homepage">
<header id="header" >
		<div id="ajaxLoaderDiv1" data-ng-if="xhrLoading"> 
				<div id="ajaxLoaderinnerDiv">
				<i class="fa fa-spinner fa-spin" style="color: #fff;font-size: 50px;"></i>
				</div>
			</div>
        <nav id="main-menu" class="navbar navbar-default navbar-fixed-top" role="banner">
        <!--Header Top Start-->
        <div class="container-fluid">
            <div class="row header-top">
                <div class="container">
                    <ul>
                        <!-- <li class="wayToHomeservicemail"><span><i class="fa fa-envelope" aria-hidden="true"></i> way2homeservices@gmail.com </span></li> -->
                       
                        <li class="wayToHomeservicemail"><i class="fa fa-envelope" aria-hidden="true"style="color:#fba816;"></i> <a href="mailto:sway2homeservices@gmail.com" target="_top" style="color:#fba816;">way2homeservices@gmail.com </a></li>
                        <li class="padding-left20"><span><i class="fa fa-phone" aria-hidden="true"></i> +91 9866999422</span></li>
                    </ul>
                </div>
            </div>
        </div>
        <!--Header Top End-->
            <div class="container white">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#/index"><img class="img-responsive" src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right" ng-init="check = 1">
                    <ul class="nav navbar-nav menuList">
                        <li class="scroll home  scrollList" ng-click="check=1" ng-class="{active : check == 1}" data-match-route="/home"><a href ng-click="moveTo('home')">Home</a></li>
                        <li class="scroll aboutus scrollList" ng-click="check=2" ng-class="{active : check == 2}" ><a href="#/"  ng-click="moveTo('aboutus')">About Us</a></li>
                        <li class="scroll ourservices scrollList" ng-click="check=3" ng-class="{active : check == 3}" ><a href="#/" ng-click="moveTo('ourservices')">Our Services</a></li>
                        <li class="scroll testimonials scrollList" ng-click="check=4" ng-class="{active : check == 4}"><a href="#/"  ng-click="moveTo('testimonials')">Testimonials</a></li>
                        <li class="scroll contactus scrollList" ng-click="check=5;" ng-class="{active : check == 5}" ><a href="#/"  ng-click="moveTo('contactus')" ng-click="generateContactPage()">Contact Us</a></li>                             
                      
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
    </header><!--/header-->
	<div class="view-container" >
			<div class="view-frame" ng-view>
		</div>
	</div>
	<footer class="footer-top">
    	<div class="container">
        	<div class="col-md-3">
            	<h2 class="footer-heading">Company</h2>
                <ul>
                	<li><a href ng-click="moveTo('#/aboutus')" ng-click="check=1" ng-click="moveTo('aboutus')" ng-class="{active : check == 1}">About Us</a></li>
                    <li><a href ng-click="moveTo('#/ourservices')" ng-click="moveTo('ourservices')">Our Services</a></li>
                    <li><a href="#/">Privacy Policy</a></li>
                    <li><a href="#/terms" target="_blank">Terms &amp; Conditions</a></li>
                </ul>
            </div>
            <div class="col-md-4">
            	<h2 class="footer-heading">Address</h2>
                
                <p class="pull-left">C145,II Phase,Allwyn Colony, Kukatpally, Hyd-500072</p>
                  
            </div>
            <div class="col-md-4 col-md-offset-1">
            	<h2 class="footer-heading">Follow Us</h2>
                <div class="dark-grey">
                    <ul>
                        <li><a href="#/www.facebook.com" target="_blank"><i class="fa fa-facebook fa-2x" aria-hidden="true"></i></a></li>
                        <li><a href="#" target="_blank"><i class="fa fa-twitter fa-2x" aria-hidden="true"></i></a></li>
                        <li><a href="#" target="_blank"><i class="fa fa-google-plus fa-2x" aria-hidden="true"></i></a></li>
                        <li><a href="#" target="_blank"><i class="fa fa-linkedin fa-2x" aria-hidden="true"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
    <footer class="footer-bottom">
    	<div class="container">
    		<p>Copyright © By Ways 2 Home Services. All Rights Reserved 2016 <span class='pull-right small'><a href='http://www.yksoftwaresolutions.com' target="_blank">Powered By: YK Software Solutions</a></span></p>
            <a class="back-top back-to-top" href="" style="display: inline;" ng-click="moveTo('home')"><i class="fa fa-arrow-circle-up fa-3x orange" aria-hidden="true"></i></a>
	        
        </div>
    </footer>
</body>
</html>
 	