package oop.project.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import oop.project.dto.StudentDto;
import oop.project.model.StudentModel;

import java.sql.SQLException;


public class StudentController {

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtUserEmail;

    @FXML
    private TextField txtUserContact;

    @FXML
    private TextArea txtUserDescription;

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException {
        System.out.println("btnSaveOnAction");

        String userName  = txtUserName.getText();
        String userEmail = txtUserEmail.getText();
        String userContact = txtUserContact.getText();
        String userDescription = txtUserDescription.getText();

        StudentDto studentDto1 = new StudentDto(userName, userEmail, userContact, userDescription);//AllArgsCunstructor

        System.out.println(studentDto1.getStudentName());

        StudentModel studentModel = new StudentModel();

        boolean result = studentModel.saveStudent(studentDto1);

        if (result){
            new Alert(Alert.AlertType.INFORMATION, "Student Saved", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Student Save Failed", ButtonType.OK).show();
        }
     }


    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException {
        StudentModel studentModel = new StudentModel();

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

        txtUserName.clear();
        txtUserEmail.clear();
        txtUserContact.clear();
        txtUserDescription.clear();

    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        System.out.println("btnUpdateOnAction");
    }




}
