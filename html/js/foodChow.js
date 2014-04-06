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
	zipSon = {zipcode:zip};
	xmlhttp.open("GET","localhost:8080/foodchow?zip" + zip,true);
	xmlhttp.send();
	status = 0;
}

function insertImages(resp){
	// insert a random subset of images on the page
	imgIndices = Math.floor(Math.random()*5);
	for (var i=1;i<=5;i++){
		var sectionTag = document.getElementById("image"+i);
		sectionTag.style.background = resp.imageURLList[imgIndices(i-1)];
	}
	document.getElementById("imagesSection").style.display = "block";
}

function addImage(imageIndex,response){
	searchQuery.imageResponses[imageIndex-1] = {"imageURL":resp.imageURLList[imgIndices(imageIndex-1)],"response":response};
	if(imageIndex == 5){
		// done with images - call the service and send searchQuery
		status = 1;
	}
}



