<%@ include file="../layout/header.jsp"  %>

    <link href='/fullcalendarLib/main.css' rel='stylesheet' />
    <link href='/fullcalendarLib/main.min.css' rel='stylesheet' />
    <script src='/fullcalendarLib/main.js'></script>
    <script src='/fullcalendarLib/main.min.js'></script>
    <style type="text/css">
    html, body {
  margin: 0;
  padding: 0;
  font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
  font-size: 14px;
}

#calendar {
  max-width: 1100px;
  margin: 40px auto;
}
    </style>

    <div id='calendar'></div>
<script>
var jsonData =${Schedulejson};/* 여기만 jsp에있으면 됨 */
</script>

  <script type="text/javascript" src="/js/fullCalendarView.js"></script>

  <%@ include file="../layout/footer.jsp"  %>