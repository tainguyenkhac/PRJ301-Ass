/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.Group;
import model.Instructor;
import model.Lecture;
import model.Room;
import model.Student;
import model.TimeSlot;
import model.lecture_student;

/**
 *
 * @author Asus
 */
public class StudentDBContext extends DBContext<Student> {

    @Override
    public ArrayList<Student> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student get(int studentId) {
        Student student = null;
        String sql = "SELECT * FROM student WHERE student_id = ?";
        PreparedStatement prepareStmt;
        try {
            prepareStmt = connection.prepareStatement(sql);
            prepareStmt.setInt(1, studentId);
            ResultSet results = prepareStmt.executeQuery();
            while (results.next()) {
                student = new Student();
                student.setStudentId(results.getInt("student_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }

    public Student getByUsername(String username) {
        Student student = null;
        String sql = "SELECT * FROM student WHERE username = ?";
        PreparedStatement prepareStmt;
        try {
            prepareStmt = connection.prepareStatement(sql);
            prepareStmt.setString(1, username);
            ResultSet results = prepareStmt.executeQuery();
            while (results.next()) {
                student = new Student();
                student.setStudentId(results.getInt("student_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }

    @Override
    public void insert(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<lecture_student> getLectures(int studentId) {
        lecture_student lectureStudent;
        Lecture lecture;
        Student student;
        Room room;
        TimeSlot timeSlot;
        Course course;
        Group group;
        Instructor instructor;

        String sql = "SELECT * FROM lecture_student as lt \n"
                + "inner join student as st on lt.student_id = st.student_id \n"
                + "inner join course as cr on lt.course_id = cr.course_id\n"
                + "inner join room as rm on lt.room_id = rm.room_id\n"
                + "inner join TimeSlot as ts on lt.time_id = ts.time_id\n"
                + "where lt.student_id = 1";
        PreparedStatement prepareStmt;
            List<lecture_student> lectureStudents = new ArrayList<>();
        try {
            prepareStmt = connection.prepareStatement(sql);
            //prepareStmt.setInt(1, studentId);
            ResultSet result = prepareStmt.executeQuery();
            while (result.next()) {
                student = new Student();
                student.setStudentId(result.getInt("student_id"));
                room = new Room();
                room.setRoomId(result.getInt("room_id"));
                room.setRoomName(result.getString("room_name"));
                course = new Course();
                course.setCourseId(result.getInt("course_id"));
                course.setCourseName(result.getString("course_name"));
                timeSlot = new TimeSlot();
                timeSlot.setTimeId(result.getInt("time_id"));
                timeSlot.setStartDate(result.getTimestamp("start_date"));
                timeSlot.setEndDate(result.getTimestamp("end_date"));
                instructor = new Instructor();
                lecture = new Lecture();
                group = new Group();

                lectureStudent = new lecture_student(group, course, instructor, timeSlot, room, student);
                lectureStudent.setStatus(result.getBoolean("status"));
                lectureStudents.add(lectureStudent);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

            return lectureStudents;
    }

}
