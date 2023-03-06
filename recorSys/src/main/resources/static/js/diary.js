let index = {
	init: function() {
		$("#diary-btn-save").on("click", () => {
			this.save();
		});
		$("#diary-btn-update").on("click", () => {
			this.update();
		});
		$("#diary-btn-delete").on("click", () => {
			this.delete();
		});
	},

	save: function() {

		let data = {
			diaryTitle: $("#diaryTitle").val(),
			diaryContent: $("#diaryContent").val(),
			diaryDate: $("#diaryDate").val()
		};

		$.ajax({
			type: "POST",
			url: "/api/diary",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("글쓰기가 완료되었습니다.");
			location.href = "/diary";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	update: function() {
		let id= $("#diaryid").val();
		let data = {
			diaryTitle: $("#diaryTitle").val(),
			diaryContent: $("#diaryContent").val(),
			diaryDate: $("#diaryDate").val()
		};

		$.ajax({
			type: "PUT",
			url: "/api/diary/"+id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("글수정이 완료되었습니다.");
			location.href = "/diary";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	delete: function() {
		let id= $("#diaryid").val();
		$.ajax({
			type: "DELETE",
			url: "/api/diary/" + id,
			dataType: "json"
		}).done(function(resp) {
			alert("삭제가 완료되었습니다.");
			location.href = "/diary";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
}
index.init();