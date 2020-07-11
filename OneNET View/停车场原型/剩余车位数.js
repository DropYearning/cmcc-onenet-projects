function filter(data, rootData, variables) {
	var sum = 24;
	for(var key in rootData){
	    var space = rootData[key];
	    if(space[space.length-1].value == 1){
	        sum = sum - 1;
	    }
	}
	return [{
	    "value": sum
	}]
}