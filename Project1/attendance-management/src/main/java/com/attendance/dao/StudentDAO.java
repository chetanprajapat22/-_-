package com.attendance.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.attendance.model.Student;
import com.example.util.DBConnectionUtil;

public class StudentDAO {

    private Connection connection;

    public StudentDAO() {
        connection = DBConnectionUtil.getConnection();
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setRollNo(rs.getString("roll_no"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Other CRUD operations
}



