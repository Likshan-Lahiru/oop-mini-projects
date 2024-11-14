package oop.project.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.project.dto.StudentDto;
import oop.project.dto.tm.StudentTm;
import oop.project.model.StudentModel;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


public class StudentController implements Initializable {

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtUserEmail;

    @FXML
    private TextField txtUserContact;

    @FXML
    private TextArea txtUserDescription;
    @FXML
    private TableView<StudentTm> tblStudent;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colDescription;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            studentCellTable();
          //  loadStudentTable();
    }


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

    public void studentCellTable(){
        colName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("studentEmail"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("studentContact"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("studentDescription"));
    }
  /*  public void loadStudentTable(){
        ObservableList<StudentTm> studentTmObservableList = FXCollections.observableArrayList();

        StudentModel studentModel = new StudentModel();

        try{
            List<StudentDto> studentDto = studentModel.getAllStudent();
            for (StudentDto studentDto1 : studentDto){
                studentTmObservableList.add(
                        new StudentTm(
                           studentDto1.getStudentName(),
                           studentDto1.getStudentEmail(),
                            studentDto1.getStudentContact(),
                                studentDto1.getStudentDescription()
                        ));

            }
            tblStudent.setItems(studentTmObservableList);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }*/

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