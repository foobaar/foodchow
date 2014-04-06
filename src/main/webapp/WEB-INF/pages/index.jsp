<!DOCTYPE HTML>
<!--
	Overflow 1.1 by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>FoodChow</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,300italic" rel="stylesheet" type="text/css" />
		<!--[if lte IE 8]><script src="resources/css/ie/html5shiv.js"></script><![endif]-->
		<script src="resources/js/jquery.min.js"></script>
		<script src="resources/js/jquery.poptrox.min.js"></script>
		<script src="resources/js/skel.min.js"></script>
		<script src="resources/js/init.js"></script>
		<script src="resources/js/foodChow.js"></script>

			<link rel="stylesheet" href="resources/css/skel-noscript.css" />
			<link rel="stylesheet" href="resources/css/style.css" />
	<!--[if lte IE 8]><link rel="stylesheet" href="resources/css/ie/v8.css" /><![endif]-->
	</head>
	<body>
		<!-- Header -->
			<section id="header" >
				<header style="width:50%;align:center">
					<h1>FOOD CHOW</h1>
					<p></p>
					<form>
					<div class="row half">
						<div class="12u">
							<input type="text" id="zipcode" class="text" name="name" placeholder="Zipcode" />
						</div>
						<div style="color:red;display:none" id="zipcodeError">Enter a valid zipcode</div>
					</div>
					<div class = "row half">
						<div class="12u">
							<select name="otherOptions" id="otherOptions">
								<option value="0">Choose Extra Options</option>
								<option value="1">Vegetarian friendly</option>
								<option value="2">Gluten Free</option>
								<option value="3">Both</option>
							</select>
						</div>
					</div>
					
				</form>
				</header>
				<footer>
					<a href="javascript:void(0)" id="startButton" onclick ="start(this)" class="button style2 scrolly scrolly-centered">START</a>
                    <a href = "#image1" id="doneLoadingPics" class="button style2 scrolly scrolly-centered" style="display:none"></a>
				</footer>
			</section>
		<div id="imagesSection" style="display:none">
		<!-- Image carousel -->
			<section id="image1">
				<div id = "banner">
					<header>
						<h2>This is image1</h2>
					</header>
					<footer>
						<div>
						<ul class="actions">
							<li><a href="#image2" onclick=addImage(1,1) class="button style2 scrolly">Like</a></li>
							<li><a href="#image2" onclick=addImage(1,-1) class="button style2 scrolly">Dislike</a></li>
						</ul>
						</div>
					</footer>
				</div>
			</section>
			
			<section id="image2">
				<div id = "banner">
					<header>
						<h2>This is image2</h2>
					</header>
					
					<footer>
						<div>
							<ul class="actions">
								<li><a href="#image3" onclick=addImage(2,1) class="button style2 scrolly">Like</a></li>
								<li><a href="#image3" onclick=addImage(2,-1) class="button style2 scrolly">Dislike</a></li>
							</ul>
						</div>
					</footer>
				</div>
			</section>
			
			<section id="image3">
				<div id = "banner">
					<header>
						<h2>This is image3</h2>
					</header>
					
					<footer>
						<div>
							<ul class="actions">
								<li><a href="#image4" onclick=addImage(3,1) class="button style2 scrolly">Like</a></li>
								<li><a href="#image4" onclick=addImage(3,-1) class="button style2 scrolly">Dislike</a></li>
							</ul>
						</div>
					</footer>
				</div>
			</section>
			
			<section id="image4">
				<div id = "banner">
					<header>
						<h2>This is image4</h2>
					</header>
					
					<footer>
						<div>
							<ul class="actions">
								<li><a href="#image5" onclick=addImage(4,1) class="button style2 scrolly">Like</a></li>
								<li><a href="#image5" onclick=addImage(4,-1) class="button style2 scrolly">Dislike</a></li>
							</ul>
						</div>
					</footer>
				</div>
			</section>
			
			<section id="image5">
				<div id = "banner">
					<header>
						<h2>This is image5</h2>
					</header>
					
					<footer>
						<div>
							<ul class="actions">
								<li><a href="#results" onclick=addImage(5,1) class="button style2 scrolly">Like</a></li>
								<li><a href="#results" onclick=addImage(5,-1) class="button style2 scrolly">Dislike</a></li>
							</ul>
						</div>
					</footer>
				</div>
			</section>
		</div>
		<!-- Results page 			<article id="first" class="container box style1 right">
				<a href="http://ineedchemicalx.deviantart.com/art/Time-goes-by-too-fast-335982438" class="image full"><img src="images/pic01.jpg" alt="" /></a>
				<div class="inner">
					<header>
						<h2>Results Page</h2>
					</header>
					<p>result1</p>
				</div>
			</article> 
			
		
		<!-- Feature 2
			<article class="container box style1 left">
				<a href="http://ineedchemicalx.deviantart.com/art/Kingdom-of-the-Wind-348268044" class="image full"><img src="images/pic02.jpg" alt="" /></a>
				<div class="inner">
					<header>
						<h2>Mollis posuere<br />
						lectus lacus</h2>
					</header>
					<p>Rhoncus mattis egestas sed fusce sodales rutrum et etiam ullamcorper. Etiam egestas scelerisque ac duis magna lorem ipsum dolor.</p>
				</div>
			</article>
		
		<!-- Portfolio -->
		<div id = "resultsSection" style="display:none">
			<article id="results" class="container box style2">
				<header>
					<h2>Result1</h2>
					<p>Some info<br/><a target="new" href="http://www.yelp.com">yelp link</a></p>
				</header>
			</article>
			
			<article class="container box style2">
				<header>
					<h2>Result2</h2>
					<p>Some info<br/><a target="new" href="http://www.yelp.com">yelp link</a></p>
				</header>
			</article>
		</div>
		<!-- Contact 
			<article class="container box style3">
				<header>
					<h2>Nisl sed ultricies</h2>
					<p>Diam dignissim lectus eu ornare volutpat orci.</p>
				</header>
				
			</article>
		
		<!-- Generic -->
		<!--
			<article class="container box style3">
				<header>
					<h2>Generic Box</h2>
					<p>Just a generic box. Nothing to see here.</p>
				</header>
				<section>
					<header>
						<h3>Paragraph</h3>
						<p>This is a byline</p>
					</header>
					<p>Phasellus nisl nisl, varius id <sup>porttitor sed pellentesque</sup> ac orci. Pellentesque 
					habitant <strong>strong</strong> tristique <b>bold</b> et netus <i>italic</i> malesuada <em>emphasized</em> ac turpis egestas. Morbi 
					leo suscipit ut. Praesent <sub>id turpis vitae</sub> turpis pretium ultricies. Vestibulum sit 
					amet risus elit.</p>
				</section>
				<section>
					<header>
						<h3>Blockquote</h3>
					</header>
					<blockquote>Fringilla nisl. Donec accumsan interdum nisi, quis tincidunt felis sagittis eget.
					tempus euismod. Vestibulum ante ipsum primis in faucibus.</blockquote>
				</section>
				<section>
					<header>
						<h3>Divider</h3>
					</header>
					<p>Donec consectetur <a href="#">vestibulum dolor et pulvinar</a>. Etiam vel felis enim, at viverra 
					ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel. Praesent nec orci 
					facilisis leo magna. Cras sit amet urna eros, id egestas urna. Quisque aliquam 
					tempus euismod. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices 
					posuere cubilia.</p>
					<hr />
					<p>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra 
					ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel. Praesent nec orci 
					facilisis leo magna. Cras sit amet urna eros, id egestas urna. Quisque aliquam 
					tempus euismod. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices 
					posuere cubilia.</p>
				</section>
				<section>
					<header>
						<h3>Unordered List</h3>
					</header>
					<ul class="default">
						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>
						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>
						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>
						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>
					</ul>
				</section>
				<section>
					<header>
						<h3>Ordered List</h3>
					</header>
					<ol class="default">
						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>
						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>
						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>
						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>
					</ol>
				</section>
				<section>
					<header>
						<h3>Table</h3>
					</header>
					<div class="table-wrapper">
						<table class="default">
							<thead>
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Description</th>
									<th>Price</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>45815</td>
									<td>Something</td>
									<td>Ut porttitor sagittis lorem quis nisi ornare.</td>
									<td>29.99</td>
								</tr>
								<tr>
									<td>24524</td>
									<td>Nothing</td>
									<td>Ut porttitor sagittis lorem quis nisi ornare.</td>
									<td>19.99</td>
								</tr>
								<tr>
									<td>45815</td>
									<td>Something</td>
									<td>Ut porttitor sagittis lorem quis nisi ornare.</td>
									<td>29.99</td>
								</tr>
								<tr>
									<td>24524</td>
									<td>Nothing</td>
									<td>Ut porttitor sagittis lorem quis nisi ornare.</td>
									<td>19.99</td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="3"></td>
									<td>100.00</td>
								</tr>
							</tfoot>
						</table>
					</div>
				</section>
				<section>
					<header>
						<h3>Form</h3>
					</header>
					<form method="post" action="#">
						<div class="row">
							<div class="6u">
								<input class="text" type="text" name="name" id="name" value="" placeholder="John Doe" />
							</div>
							<div class="6u">
								<input class="text" type="text" name="email" id="email" value="" placeholder="johndoe@domain.tld" />
							</div>
						</div>
						<div class="row">
							<div class="12u">
								<select name="department" id="department">
									<option value="">Choose a department</option>
									<option value="1">Manufacturing</option>
									<option value="2">Administration</option>
									<option value="3">Support</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="12u">
								<input class="text" type="text" name="subject" id="subject" value="" placeholder="Enter your subject" />
							</div>
						</div>
						<div class="row">
							<div class="12u">
								<textarea name="message" id="message" placeholder="Enter your message"></textarea>
							</div>
						</div>
						<div class="row">
							<div class="12u">
								<ul class="actions">
									<li><a href="#" class="button form">Submit</a></li>
									<li><a href="#" class="button style3 form-reset">Clear Form</a></li>
								</ul>
							</div>
						</div>
					</form>
				</section>
			</article>
		-->
		
		<section id="footer">
			<ul class="icons">
				<li><a href="#" class="fa fa-twitter solo"><span>Twitter</span></a></li>
				<li><a href="#" class="fa fa-facebook solo"><span>Facebook</span></a></li>
				<li><a href="#" class="fa fa-google-plus solo"><span>Google+</span></a></li>
				<li><a href="#" class="fa fa-pinterest solo"><span>Pinterest</span></a></li>
				<li><a href="#" class="fa fa-dribbble solo"><span>Dribbble</span></a></li>
				<li><a href="#" class="fa fa-linkedin solo"><span>LinkedIn</span></a></li>
			</ul>
		</section>
		<script type="text/javascript">
					
			if (window.XMLHttpRequest)
			  {// code for IE7+, Firefox, Chrome, Opera, Safari
			  xmlhttp=new XMLHttpRequest();
			  }
			else
			  {// code for IE6, IE5
			  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			  }
			  //alert(xmlhttp);

            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                    if(status == 0){
                        // it means the response contains list of imageURLs
                        resp = xmlhttp.responseText;
                        document.getElementById("guid").value = resp.guid;
                        searchQuery = {"guid":resp.guid,"imageResponses":[]}
                        insertImages(resp);
                    }
                    if(status == 1){
                        // it means ther response containts the results of the search
                        resp = xmlhttp.responseText;
                        insertResults(resp);
                    }
                }
            }
		</script>
		<input type="hidden" id="guid" value="" />
	</body>
</html>