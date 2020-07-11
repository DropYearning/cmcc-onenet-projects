function filter(data, rootData, variables) {
	var stime = Date.parse(new Date(data[data.length-2].at));
	var etime = Date.parse(new Date(data[data.length-1].at));
	      // 两个时间戳相差的毫秒数
	var usedTime = etime - stime;
	      // 计算相差的天数  
	var days = Math.floor(usedTime / (24 * 3600 * 1000));
	      // 计算天数后剩余的毫秒数
	var leave1 = usedTime % (24 * 3600 * 1000);  
	      // 计算出小时数  
	var hours = Math.floor(leave1 / (3600 * 1000));
	if(data[data.length-1].value==0)
	return [{
	    "value": "本次收费:"+(usedTime/60000*1).toFixed(2)+"元"
	}]
	else{
	return[{
	    "value":"车位已占用，开始计费，计费标准1元/分钟"
	      }]
	}
}