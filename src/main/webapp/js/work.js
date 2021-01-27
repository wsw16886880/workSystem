/**
 * 查看学生是否交作业，如果交了，显示是，未交，显示一个提交文件的input和提交的按钮
 */
function addIssubmit() {
	//获取学生是否交作业
	var issubmits = document.getElementsByClassName("issubmit");
	//遍历是否为空
	for (var i = 0; i < issubmits.length; i++) {
		//为空则添加提交文件的input
		if (issubmits[i].innerHTML.indexOf("否")==0) {
			//创建input文件选择框
			var inputFile = document.createElement("input");
			inputFile.type = "file";
			inputFile.name = "zuoye";
			//创建提交按钮
			var inputSubmit = document.createElement("input");
			inputSubmit.value = "提交作业";
			inputSubmit.type = "submit";
			//将2个按钮添加进单元格中，通过class=issubmit这个条件可以直接获取单元格
			var issubmit = issubmits[i];
			issubmit.style.color = "red";
			// issubmit.innerHTML = "";
			issubmit.appendChild(inputFile);
			issubmit.appendChild(inputSubmit);
		}
	}
}

/**
 * 将选择的周数添加到参数中
 */
function selected(weeks){
	//拿到选项的索引
	var index = weeks.selectedIndex;
	//获取索引所在的option的value
	var value = weeks.options[index].value;
	//获取传参数的对应的input
	var inputWeek = document.getElementById("week");
	//传值
	inputWeek.value = value;
}