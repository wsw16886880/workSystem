function createXMLHttpRequest() {
	try {
		return new XMLHttpRequest();
	} catch (e) {
		try {
			return new ActiveXObject("Msxml2.XMLHttp"); //ie6
		} catch (e) {
			try {
				return new ActiveXObject("Microsoft.XMLHttp"); //ie5 and 以下
			} catch (e) {
				throw e;
			}
		}
	}
}

function ajax(method, url, asyn, params, cellback, type) {
	//创建ajax对象
	var xmlHttp = createXMLHttpRequest();
	//打开连接
	if (!method) {
		method = "GET";
	}
	if (asyn == undefined) {
		asyn = true;
	}
	xmlHttp.open(method, url, asyn);
	//发送请求
	if("POST" == method) {
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	}
	xmlHttp.send(params);
	//设置监听器
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			var data;
			if(!type) {
				date = xmlHttp.responseText;
			} else if (type == "text") {
				data = xmlHttp.responseText;
			} else if (type == "xml") {
				data = xmlHttp.responseXML;
			} else if (type == "json") {
				var text = xmlHttp.responseText;
				data = eval("(" + text + ")");
			}
			cellback(data);
		}
	};
}
