function foodChow(){
}

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
			document.getElementById("startButton").href = "#image1";
		}
		if(status == 1){
			// it means ther response containts the results of the search
			
		}
	}
}

function start(aTag){
	// on click of start - validate zipcode and 
	var zipCode = document.getElementById("zipcode").value;
	var zipCodePattern = /^\d{5}$|^\d{5}-\d{4}$/;
	//alert(!zipCodePattern.test(zipcode)+'---------'+zipcode.value);
	if(!zipCodePattern.test(zipcode.value)){
		aTag.href = "#";
		document.getElementById("zipcodeError").style.display = "block";
		return false;
	}
	else{
		sendZipcode(zipcode.value);
		//aTag.href = "#image1";
		return true;
	}
	return false;
}

function sendZipcode(zip){
	// call service with zipcode - GET
	zipSon = {"guid":document.getElementById("guid").value,"zipcode":zip};
	//alert(zipSon)
	//xmlhttp.open("GET","localhost:8080/foodchow?zip" + zip,true);
	//xmlhttp.send();
	status = 0;
	resp = getZipResp(); // only for testing
	alert(resp.guid);	 // only for testing
	insertImages(resp);  // only for testing
	document.getElementById("startButton").href = "#image1"; // only for testing
}

function insertImages(resp){
	// insert a random subset of images on the page
	imgIndices = Math.floor(Math.random()*5);
	for (var i=1;i<= resp.imageURLList.length;i++){
		j = i+1;
		var sectionTag = document.getElementById("image"+i);
		alert(sectionTag)
		//sectionTag.style.background = resp.imageURLList[imgIndices(i-1)];
		sectionTag.style.backgroundImage = "url('"+resp.imageURLList[i-1]+"')";
	}
	document.getElementById("imagesSection").style.display = "block";
	alert(document.getElementById("imagesSection").style.display)
}

function addImage(imageIndex,response){
	searchQuery.imageResponses[imageIndex-1] = {"imageURL":resp.imageURLList[imgIndices(imageIndex-1)],"response":response};
	if(imageIndex == 5){
		// done with images - call the service and send searchQuery
		status = 1;
		resp = getResultsResp(); // only for testing
	}
}


/////////////////////////////////////////////////////////////// testing functions ///////////////////////////////////////////////////////////

function getZipResp(){
	return {
	"guid":"asdfafs12e12",
	"imageURLList":["http://i.imgur.com/J1z6RmU.jpg",
		"http://i.imgur.com/CMlm55G.jpg",
		"http://i.imgur.com/dfBiaXU.jpg",
		"http://i.imgur.com/L92xI9r.jpg",
		"http://i.imgur.com/nHafpWN.jpg",
		"http://i.imgur.com/paiXVav.jpg",
		"http://i.imgur.com/KcKx9uU.jpg",
		"http://i.imgur.com/BcSOopC.jpg",
		"http://i.imgur.com/aYmB3eU.jpg",
		"http://i.imgur.com/aeX8Kr5.jpg",
		"http://i.imgur.com/kce5iiI.jpg",
		"http://i.imgur.com/RJaGjt3.jpg",
		"http://i.imgur.com/61huDTZ.jpg",
		"http://i.imgur.com/0z6FxH8.jpg",
		"http://i.imgur.com/3OwIMcT.jpg"
	]}
}

function getResultsResp(){
 return [{"name":"Restaurant1", "info":"InfoStatement1", "yelpURL":"http://www.yelp.com/biz/big-apple-bagels-cincinnati"}, {"name":"Restaurant2", "info":"InfoStatement2", "yelpURL":"http://www.yelp.com/biz/marx-hot-bagels-cincinnati"}, {"name":"Restaurant3", "info":"InfoStatement3", "yelpURL":"http://www.yelp.com/biz/everything-bagels-cincinnati"}, {"name":"Restaurant4", "info":"InfoStatement4", "yelpURL":"http://www.yelp.com/biz/brueggers-bagels-cincinnati-2"}, {"name":"Restaurant5", "info":"InfoStatement5", "yelpURL":"http://www.yelp.com/biz/bagel-brothers-cincinnati"}, {"name":"Restaurant6", "info":"InfoStatement6", "yelpURL":"http://www.yelp.com/biz/the-coffee-shop-on-wooster-cincinnati"}, {"name":"Restaurant7", "info":"InfoStatement7", "yelpURL":"http://www.yelp.com/biz/martys-hops-and-vines-cincinnati"}, {"name":"Restaurant8", "info":"InfoStatement8", "yelpURL":"http://www.yelp.com/biz/listermann-brewing-company-cincinnati"}, {"name":"Restaurant9", "info":"InfoStatement9", "yelpURL":"http://www.yelp.com/biz/market-wines-cincinnati-2"}, {"name":"Restaurant10", "info":"InfoStatement10", "yelpURL":"http://www.yelp.com/biz/a-bottle-or-two-cincinnati"}]
}