
let index={
	init: function(){
		$("#income-btn-save").on("click",()=>{
			//화살표 함수사용 이유: this를 바인딩하기 위해 사용
			this.save();
		});
		$("#income-btn-update").on("click",()=>{
			//화살표 함수사용 이유: this를 바인딩하기 위해 사용
			this.update();
		});
		$("#income-btn-delete").on("click",()=>{
			//화살표 함수사용 이유: this를 바인딩하기 위해 사용
			this.delete();
		});
	},
	save: function(){
		//alert('schedule의 save함수 호출됨');
		
		let data={
			income: $("#income").val(),
			createDate: $("#incomeDate").val(),
			
		};
		$.ajax({ 
			type:"POST",
			url:"/api/income",
			data:JSON.stringify(data), 
			contentType:"application/json; charset=utf-8",
			dataType:"json" 
		}).done(function(resp){
			alert("소득 작성이 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert("날짜를 입력해주세요");
			alert(JSON.stringify(error));
		});
	},
/*	update: function(){
		let id=$("#id").val();
		
		let data={
			income: $("#income").val(),
			createDate: $("#incomeDate").val()
		};
		console.log(income);
		console.log(data);
		$.ajax({ 
			type:"PUT",
			url:"/api/board/"+id,
			data:JSON.stringify(data), 
			contentType:"application/json; charset=utf-8",
			dataType:"json" 
		}).done(function(resp){
			alert("수정이 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	
	deleteById: function(){
		let id=$("#id").text();
		console.log(id);
		$.ajax({ 
			type:"DELETE",
			url:"/api/board/"+id,
			dataType:"json" 
		}).done(function(resp){
			alert("삭제가 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},*/

	
}
index.init();