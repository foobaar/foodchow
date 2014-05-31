function foodChow(){
}

function start(aTag){
    var zipCode = document.getElementById("zipcode").value;
    var categories = document.getElementById("otherOptions").value;
    var zipCodePattern = /^\d{5}$|^\d{5}-\d{4}$/;
    if(!zipCodePattern.test(zipcode.value)){
        aTag.href = "#";
        document.getElementById("zipcodeError").style.display = "block";
        return false;
    }
    else{
        sendInputFilters(zipcode.value,categories);
        return true;
    }
    return false;
}

function sendInputFilters(zip,categories){
    status = 0;
  xmlhttp.open("GET","http://quickpickapp.herokuapp.com/initialize?zip=" + zip,true+"&categories="+categories);
  xmlhttp.send();
}

function insertImages(resp){
    var imgList = resp.imageURLList;
    imgIndices = generateUniqueRandomNumbers(imgList.length);
    for (var i=1;i<= 5;i++){
        j = imgIndices[i-1];
        var sectionTag = document.getElementById("image"+i);
        sectionTag.style.backgroundImage = "url('"+resp.imageURLList[j]+"')";
    }
    document.getElementById("imagesSection").style.display = "block";
    document.getElementById("startButton").href = "#image1";
    document.getElementById("doneLoadingPics").click();
}

function addImage(imageIndex,response){
    i = imgIndices[imageIndex-1];
    searchQuery['imageResponses'].push({"imageURL":resp.imageURLList[i],"response":response});

    if(imageIndex == 5){
        status = 1;
        searchQuery.zipcode = document.getElementById('zipcode').value;
        xmlhttp.open("POST","http://quickpickapp.herokuapp.com/recommmend",true);
        xmlhttp.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        xmlhttp.send(JSON.stringify(searchQuery));
    }
}

function generateUniqueRandomNumbers(l){
    var limit = 5,
        amount = 5,
        lower_bound = 0,
        upper_bound = l-1,
        unique_random_numbers = [];

    if (amount > limit) limit = amount; //Infinite loop if you want more unique
    while (unique_random_numbers.length < limit) {
        var random_number = Math.round(Math.random()*(upper_bound - lower_bound) + lower_bound);
        if (unique_random_numbers.indexOf(random_number) == -1) {
            unique_random_numbers.push( random_number );
        }
    }
    return unique_random_numbers;
}

function insertResults(resp){
    for(var i=0; i< resp.length; i++){
        j = i+1;
        document.getElementById("r"+j+"name").innerHTML = resp[i].name;
        document.getElementById("p"+j+"info").innerHTML = "Address: "+resp[i].address1;
        document.getElementById("a"+j+"link").href = resp[i].url;
    }
    document.getElementById("resultsSection").style.display = "block";
    document.getElementById("doneLoadingResults").click();
}