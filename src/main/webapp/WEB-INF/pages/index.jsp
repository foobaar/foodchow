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
    <header style="width:50%;align:center;padding-bottom:192px">
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
<div id="imagesSection" style="display:none; background-position:inherit">
    <!-- Image carousel -->
    <section id="image1" style="background-position:inherit; background-repeat:no-repeat">
        <div id = "banner">
            <header>
                <h2></h2>
            </header>
            <footer>
                <div>
                    <ul class="actions">
                        <li><a href="#image2" onclick=addImage(1,1) class="button style2 scrolly">Yes</a></li>
                        <li><a href="#image2" onclick=addImage(1,-1) class="button style2 scrolly">No</a></li>
                    </ul>
                </div>
            </footer>
        </div>
    </section>

    <section id="image2" style="background-position:inherit; background-repeat:no-repeat">
        <div id = "banner">
            <header>
                <h2></h2>
            </header>

            <footer>
                <div>
                    <ul class="actions">
                        <li><a href="#image3" onclick=addImage(2,1) class="button style2 scrolly">Yes</a></li>
                        <li><a href="#image3" onclick=addImage(2,-1) class="button style2 scrolly">No</a></li>
                    </ul>
                </div>
            </footer>
        </div>
    </section>

    <section id="image3" style="background-position:inherit; background-repeat:no-repeat">
        <div id = "banner">
            <header>
                <h2></h2>
            </header>

            <footer>
                <div>
                    <ul class="actions">
                        <li><a href="#image4" onclick=addImage(3,1) class="button style2 scrolly">Yes</a></li>
                        <li><a href="#image4" onclick=addImage(3,-1) class="button style2 scrolly">No</a></li>
                    </ul>
                </div>
            </footer>
        </div>
    </section>

    <section id="image4" style="background-position:inherit; background-repeat:no-repeat">
        <div id = "banner">
            <header>
                <h2></h2>
            </header>

            <footer>
                <div>
                    <ul class="actions">
                        <li><a href="#image5" onclick=addImage(4,1) class="button style2 scrolly">Yes</a></li>
                        <li><a href="#image5" onclick=addImage(4,-1) class="button style2 scrolly">No</a></li>
                    </ul>
                </div>
            </footer>
        </div>
    </section>

    <section id="image5" style="background-position:inherit; background-repeat:no-repeat">
        <div id = "banner">
            <header>
                <h2></h2>
            </header>

            <footer>
                <div>
                    <ul class="actions">
                        <li><a href="#results1" id="lastImageLike" onclick=addImage(5,1) class="button style2 scrolly">Yes</a></li>
                        <li><a href="#results1" id = "lastImageUnlike" onclick=addImage(5,-1) class="button style2 scrolly">No</a></li>
                    </ul>
                </div>
            </footer>
        </div>
    </section>
</div>

<!-- Portfolio -->
<div id = "resultsSection" style="display:none">
    <article id="results1" class="container box style2">
        <header>
            <h2 id="r1name">Result1</h2>
            <p id="p1info">Some info</p><p ><br/><a id="a1link" target="new" href="http://www.yelp.com">Yelp it!</a></p>
        </header>
    </article>

    <article id="results2" class="container box style2">
        <header>
            <h2 id="r2name">Result1</h2>
            <p id="p2info">Some info</p><p ><br/><a id="a2link" target="new" href="http://www.yelp.com">Yelp it!</a></p>
        </header>
    </article>

    <article id="results3" class="container box style2">
        <header>
            <h2 id="r3name">Result1</h2>
            <p id="p3info">Some info</p><p ><br/><a id="a3link" target="new" href="http://www.yelp.com">Yelp it!</a></p>
        </header>
    </article>

    <article id="results4" class="container box style2">
        <header>
            <h2 id="r4name">Result1</h2>
            <p id="p4info">Some info</p><p ><br/><a id="a4link" target="new" href="http://www.yelp.com">Yelp it!</a></p>
        </header>
    </article>

    <article id="results5" class="container box style2">
        <header>
            <h2 id="r5name">Result1</h2>
            <p id="p5info">Some info</p><p ><br/><a id="a5link" target="new" href="http://www.yelp.com">Yelp it!</a></p>
        </header>
    </article>

</div>

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
                resp = JSON.parse(resp);
                document.getElementById("guid").value = resp.guid;
                searchQuery = {"guid":resp.guid,"imageResponses":[]}
                insertImages(resp);
            }
            if(status == 1){
                // it means ther response containts the results of the search
                resp = xmlhttp.responseText;
                resp = JSON.parse(resp);
                insertResults(resp);
            }
        }
    }
</script>
<input type="hidden" id="guid" value="" />
</body>
</html>