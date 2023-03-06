let index={
	init: function(){
		$("#schedule-btn-save").on("click",()=>{
			//화살표 함수사용 이유: this를 바인딩하기 위해 사용
			this.save();
		});
		$("#schedule-btn-update").on("click",()=>{
			//화살표 함수사용 이유: this를 바인딩하기 위해 사용
			this.update();
		});
		$("#schedule-btn-delete").on("click",()=>{
			//화살표 함수사용 이유: this를 바인딩하기 위해 사용
			this.deleteById();
		});
	},
	save: function(){
		//alert('schedule의 save함수 호출됨');
		let data={
			memo: $("#memo").val(),
			createDate: $("#createDate").val()
		};
		$.ajax({ 
			type:"POST",
			url:"/api/schedule",
			data:JSON.stringify(data), 
			contentType:"application/json; charset=utf-8",
			dataType:"json" 
		}).done(function(resp){
			alert("스케쥴 작성이 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
/*	update: function(){
		let id=$("#id").val();
		
		let data={
			title: $("#title").val(),
			content: $("#content").val()
		};
		console.log(id);
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
	*/
	
	deleteById: function(id){
		console.log(id);
		$.ajax({ 
			type:"DELETE",
			url:"/api/schedule/"+id,
			dataType:"json" 
		}).done(function(resp){
			alert("삭제가 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
}
index.init();