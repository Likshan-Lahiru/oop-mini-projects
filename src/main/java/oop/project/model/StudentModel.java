package oop.project.model;

import oop.project.db.DbConnection;
import oop.project.dto.StudentDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {


    public boolean saveStudent(StudentDto studentDto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        /* String sql = "INSERT INTO student_details (studentName, studentEmail, studentContact, studentDescription)";*/
        String sql = "INSERT INTO student_details VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, studentDto.getStudentName());
        preparedStatement.setString(2, studentDto.getStudentEmail());
        preparedStatement.setString(3, studentDto.getStudentContact());
        preparedStatement.setString(4, studentDto.getStudentDescription());

        boolean b = preparedStatement.executeUpdate() > 0;


        return b;


    }


    public boolean deleteStudent(String studentName) throws SQLException {
        return false;
    }


 /*   public List<StudentDto> getAllStudent() throws SQLException {


        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM student_details";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<StudentDto> studentDtoList = new ArrayList<>();

        while (resultSet.next()) {
          String name = resultSet.getString("name");
          String email =  resultSet.getString("email");
          String contact =  resultSet.getString("contact");
          String description =  resultSet.getString("description");

            StudentDto studentDto = new StudentDto(name, email, contact, description);
            studentDtoList.add(studentDto);
        }

        return studentDtoList;
    }*/
}


/*

* */
