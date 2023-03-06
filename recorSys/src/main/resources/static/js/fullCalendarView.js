document.addEventListener('DOMContentLoaded', function() {
	
var	jsonObject = JSON.stringify(jsonData);
var jData = JSON.parse(jsonObject);


		
	  var calendarEl = document.getElementById('calendar');

	  var calendar = new FullCalendar.Calendar(calendarEl, {
		timeZone: 'UTC',//local
	    selectable: false,
	     nowIndicator: true, 
	    headerToolbar: {
	      left: 'prev,next today',
	      center: 'title',
	      right: 'dayGridMonth,timeGridWeek,timeGridDay'
	    },
	    dateClick: function(info) {
		
		var title = prompt('일정제목을 입력해주세요.');
 			if(title){
		let data={
			memo:title,
			createDate: info.date
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
	      alert('clicked ' + info.date);
	    	}	   
	    },
	    /*select와 schedule의 기간검색이 겹침. */
	   /* select: function (arg) { // 캘린더에서 이벤트를 생성할 수 있다.
	        var title = prompt('일정을 입력해주세요.');
	        if (title) {
	            calendar.addEvent({
	                title: title,
	                start: arg.start,
	                end: arg.end,
	                allDay: arg.allDay,
	            })
	        }
	        var allEvent = calendar.getEvents(); // .getEvents() 함수로 모든 이벤트를 Array 형식으로 가져온다. (FullCalendar 기능 참조)
	 
	        var events = new Array(); // Json 데이터를 받기 위한 배열 선언
	         for (var i = 0; i < allEvent.length; i++) {
	          var obj = new Object();     // Json 을 담기 위해 Object 선언
	          // alert(allEvent[i]._def.title); // 이벤트 명칭 알람
	          obj.title = allEvent[i]._def.title; // 이벤트 명칭  ConsoleLog 로 확인 가능.
	          obj.start = allEvent[i]._instance.range.start; // 시작
	          obj.end = allEvent[i]._instance.range.end; // 끝
	          events.push(obj);
	           }
	           var jsondata = JSON.stringify(events);
	             console.log(jsondata);
	            // saveData(jsondata);
	 
	           $(function saveData(jsondata) {
	             $.ajax({
	             url: "/api/schedule",
	              method: "POST",
	               dataType: "json",
	              data: JSON.stringify(events),
	              contentType: 'application/json',
	               })
	               .done(function (result) {
	                 // alert(result);
	                })
	               .fail(function (request, status, error) {
	                // alert("에러 발생" + error);
	                });
	                calendar.unselect()
	            });
	        },*/
	    eventClick: function(info) {
		 var eventObj = info.event;
		 alert('Clicked ' + eventObj.title);
		 
		  if(confirm("'"+ info.event.title +"' 일정을 삭제하시겠습니까 ?")){
                                // 확인 클릭 시
                                info.event.remove();
                            }
 
                            console.log(info.event);
                            var events = new Array(); // Json 데이터를 받기 위한 배열 선언
                            var obj = new Object();
                                obj.title = info.event._def.title;
                                obj.start = info.event._instance.range.start;
                                obj.id=info.event.id;
                                events.push(obj);
 
                            console.log(events+" : events 확인");
                            $(function deleteData(){
							let id=info.event.id;
                                $.ajax({
                                    url: "/api/schedule/"+id,
                                    method: "DELETE", 
                                    contentType: 'application/json',
                                })
                            })
		 },
	    /*select: function(info) {
	      alert('selected ' + info.startStr + ' to ' + info.endStr);
	    },*/
	    
    	events: jData
	  });

	  calendar.render();
	});