var jsonObject = JSON.stringify(jsonData);
let jData = JSON.parse(jsonObject);
console.log("jsonData"+jsonData);		
console.log("jDATA"+jData);		
console.log("jsonOBJECT"+jsonObject);	
function chartView(){
	if(jsonData==null){alert("JSON EMPTY")}else{
	
	var dailyIncomeLabelList = new Array();
	var dailyIncomeValueList = new Array();
	var colorList = new Array();
			
	for(var i = 0; i<jData.length; i++) {
		var d = jData[i];
		dailyIncomeLabelList.push(d.createDate);
		dailyIncomeValueList.push(d.income);
		colorList.push(colorize());
	}
			
			
	var data = {
					labels: dailyIncomeLabelList,
					datasets: [{
						 	label: '날짜별 소득',
							backgroundColor: colorList,
							data : dailyIncomeValueList
					}],
					options : {
							title : {
							display : true,
							text: '유저별 접속 횟수'
							}
					}
	};
			
	var ctx1 = document.getElementById('dailyIncomeChart').getContext('2d');
	new Chart(ctx1, {
		      type: 'bar',
			  data: data
	});


	function colorize() {
		var r = Math.floor(Math.random()*200);
		var g = Math.floor(Math.random()*200);
		var b = Math.floor(Math.random()*200);
		var color = 'rgba(' + r + ', ' + g + ', ' + b + ', 0.7)';
		return color;
	}

/*[출처] Spring에서 DB데이터를 Chart.js 로 시각화하기|작성자 파스텔군*/
	}
}
chartView();