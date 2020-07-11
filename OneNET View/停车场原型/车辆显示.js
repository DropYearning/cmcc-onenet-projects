function filter(data, rootData, variables) {
	var ison= data[data.length-1].value;
	if (ison==1){
	    return [{
	    "img": "https://pic-1253509712.cos.ap-shanghai.myqcloud.com/%E5%B0%8F%E8%BD%BF%E8%BD%A6%E8%BD%A6%E7%9A%84%E9%A1%B6%E8%A7%86%E5%9B%BE-51190595.png"
	}] 
	}else{
	    return [{
	    "img": null
	}] 
	}
}