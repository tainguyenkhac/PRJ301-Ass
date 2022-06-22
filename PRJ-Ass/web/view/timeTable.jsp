<%-- 
    Document   : timeTable
    Created on : Jun 22, 2022, 8:07:30 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weekly Timetable</title>
        <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.0/main.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.0/main.min.css"/>
        <style>
            #calendar{
                width: 70%;
                height: 100vh;
                margin: auto;
            }
            
        </style>
    </head>
    <body>
        <div id='calendar'></div>
    </body>
    <script>
            document.addEventListener('DOMContentLoaded', function () {
                var calendarEl = document.getElementById('calendar');
                fetch('/PRJ-Ass/lectureStudentController')
                .then(response => response.text())
                .then(lectureStudentsText => {
                    var lectureStudents = lectureStudentsText.length !== 0 ? JSON.parse(lectureStudentsText) : [];
                    var calendar = new FullCalendar.Calendar(calendarEl, {
                    initialView: 'timeGridWeek',
                    inititalDate : new Date() ,
                    headerToolbar : {
                        left : 'prev,next',
                        center : 'title',
                        right : 'timeGridWeek'
                    },events : lectureStudents.map(lectureStudent => {
                        var title = lectureStudent.course.courseName 
                                + "  at  " 
                                + lectureStudent.room.roomName 
                                + " (  " 
                                + (lectureStudent.status ? 'Attended ) ' : 'Absent )' );
                        return {
                            title : title,
                            start : new Date(lectureStudent.time.startDate)
                        };
                    })
                });
                calendar.render();
                });
            });

        </script>
</html>
