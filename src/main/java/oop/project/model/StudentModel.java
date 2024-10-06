package oop.project.model;

import oop.project.dto.StudentDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentModel {


    public boolean saveStudent(StudentDto studentDto) throws SQLException {

       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentForm","root","Ijse@1234");
       /* String sql = "INSERT INTO student_details (studentName, studentEmail, studentContact, studentDescription)";*/
        String sql = "INSERT INTO student_details VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, studentDto.getStudentName());
        preparedStatement.setString(2, studentDto.getStudentEmail());
        preparedStatement.setString(3, studentDto.getStudentContact());
        preparedStatement.setString(4, studentDto.getStudentDescription());

        boolean b = preparedStatement.executeUpdate() > 0;
        connection.close();

        return b;


    }

    public boolean deleteStudent(String studentName) throws SQLException {
        return false;
    }




}
