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
		}
		if(status == 1){
			// it means ther response containts the results of the search
			resp = xmlhttp.responseText;
			insertResults(resp);
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
	status = 0;
	xmlhttp.open("GET","localhost:8080/foodchow?zip=" + zip,true);
	xmlhttp.send();
	//resp = getZipResp(); // only for testing
	//alert(resp.guid);	 // only for testing
	//insertImages(resp);  // only for testing
	//document.getElementById("startButton").href = "#image1"; // only for testing
	//searchQuery = {"guid":resp.guid,"imageResponses":[]} // only for testing
}

function insertImages(resp){
	// insert a random subset of images on the page
	imgIndices = generateUniqueRandomNumbers(resp.imageURLList.length);
	alert(imgIndices)
	for (var i=1;i<= 5;i++){
		j = imgIndices[i-1];
		var sectionTag = document.getElementById("image"+i);
		//alert("image"+i)
		//sectionTag.style.background = resp.imageURLList[imgIndices(i-1)];
		sectionTag.style.backgroundImage = "url('"+resp.imageURLList[j]+"')";
	}
	document.getElementById("imagesSection").style.display = "block";
	document.getElementById("startButton").href = "#image1";
	//alert(document.getElementById("imagesSection").style.display)
}

function addImage(imageIndex,response){
	i = imgIndices[imageIndex-1];
	searchQuery.imageResponses[imageIndex-1] = {"imageURL":resp.imageURLList[i],"response":response};
	if(imageIndex == 5){
		// done with images - call the service and send searchQuery
		status = 1;
		xmlhttp.open("POST","localhost:8080/foodchow?query",true);
		xmlhttp.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
		xmlhttp.send(JSON.stringify(searchQuery));
		//resp = getResultsResp(); // only for testing
		//insertResults(resp);         // only for testing
	}
}

function generateUniqueRandomNumbers(l){
var limit = 5,
    amount = 5,
    lower_bound = 0,
    upper_bound = l-1,
    unique_random_numbers = [];

if (amount > limit) limit = amount; //Infinite loop if you want more unique
                                    //Natural numbers than existemt in a
                                    // given range
while (unique_random_numbers.length < limit) {
    var random_number = Math.round(Math.random()*(upper_bound - lower_bound) + lower_bound);
    if (unique_random_numbers.indexOf(random_number) == -1) { 
        // Yay! new random number
        unique_random_numbers.push( random_number );
    }
}
return unique_random_numbers;
}

function insertResults(resp){
for(var i=0; i< resp.length; i++){
	j = i+1;
	document.getElementById("r"+j+"name").innerHTML = resp[i].name;
	document.getElementById("p"+j+"info").innerHTML = resp[i].info;
	document.getElementById("a"+j+"link").href = resp[i].yelpURL;
}
document.getElementById("resultsSection").style.display = "block";

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