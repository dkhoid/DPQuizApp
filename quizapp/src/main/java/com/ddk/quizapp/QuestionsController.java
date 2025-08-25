package com.ddk.quizapp;
import com.ddk.pojo.Category;
import com.ddk.pojo.Choice;
import com.ddk.pojo.Level;
import com.ddk.pojo.Question;
import com.ddk.utils.Configs;
import com.ddk.utils.MyAlert;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class QuestionsController implements Initializable {
    @FXML private TextArea txtContent;
    @FXML private ComboBox<Category> cbCates;
    @FXML private ComboBox<Level> cbLevels;
    @FXML private VBox vboxChoices;
    @FXML private ToggleGroup toggleChoice;
    @FXML private TableView<Question> tbQuestions;
    @FXML private TextField txtSearch;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.cbCates.setItems(FXCollections.observableList(Configs.cateServices.getCates()));
            this.cbLevels.setItems(FXCollections.observableList(Configs.levelServices.getLevels()));
            this.loadColumns();
            this.tbQuestions.setItems(FXCollections.observableList(Configs.questionServices.getQuestions()));
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        this.txtSearch.textProperty().addListener(e -> {
            try {
                this.tbQuestions.getItems().clear();
                this.tbQuestions.setItems(FXCollections.observableList(Configs.questionServices.getQuestions(this.txtSearch.getText())));
            } catch (SQLException ex) {
                Logger.getLogger(QuestionsController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        });
    }
    
    public void addChoice(ActionEvent event) {
        HBox h = new HBox();
        h.getStyleClass().add("Main");
        RadioButton rdo = new RadioButton();
        rdo.setToggleGroup(toggleChoice);
        TextField txt = new TextField();
        h.getChildren().addAll(rdo, txt);
        this.vboxChoices.getChildren().add(h);
    }
    
    public void addQuestion(ActionEvent event) {
        try {
            Question.Builder b = new Question.Builder(this.txtContent.getText(),
                    this.cbCates.getSelectionModel().getSelectedItem(),
                    this.cbLevels.getSelectionModel().getSelectedItem());
            
            for (var c: this.vboxChoices.getChildren()) {
                HBox h = (HBox) c;
                Choice choice = new Choice(((TextField)h.getChildren().get(1)).getText(),
                                        ((RadioButton)h.getChildren().get(0)).isSelected());
                b.addChoice(choice);
            }
            
            Configs.questionServices.addQuestion(b.build());
            MyAlert.getInstance().showMsg("Thêm câu hỏi thành công!");
        } catch(SQLException ex) {
            MyAlert.getInstance().showMsg("Thêm không thành công, lý do: " + ex.getMessage());
        } catch (Exception ex) {
            MyAlert.getInstance().showMsg("Dữ liệu không hợp lệ!");
        }
    }
    
    private void loadColumns() {
        this.tbQuestions.getColumns().clear();

        TableColumn<Question, Integer> colId = new TableColumn<>("Id");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setPrefWidth(100);

        TableColumn<Question, String> colContent = new TableColumn<>("Nội dung câu hỏi");
        colContent.setCellValueFactory(new PropertyValueFactory<>("content"));
        colContent.setPrefWidth(250);

        TableColumn<Question, String> colCategory = new TableColumn<>("Chủ đề");
        colCategory.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        colCategory.setPrefWidth(150);

        TableColumn<Question, String> colLevel = new TableColumn<>("Mức độ");
        colLevel.setCellValueFactory(new PropertyValueFactory<>("levelName"));
        colLevel.setPrefWidth(100);

        TableColumn colAction = new TableColumn();
        colAction.setCellFactory(c -> {
            TableCell cell = new TableCell();
            Button btn = new Button("Xóa");
            btn.setOnAction(e -> {
                Optional<ButtonType> t = MyAlert.getInstance().showMsg("Xóa câu hỏi thì các đáp án cũng bị xóa theo. Bạn chắc chắn không?", 
                        Alert.AlertType.CONFIRMATION);
                if (t.isPresent() && t.get().equals(ButtonType.OK)) {
                    Question q = (Question) cell.getTableRow().getItem();
                    try {
                        if (Configs.questionServices.deleteQuestioin(q.getId())) {
                            this.tbQuestions.getItems().remove(q);
                            MyAlert.getInstance().showMsg("Xóa câu hỏi thành công!", Alert.AlertType.INFORMATION);
                        } else
                            MyAlert.getInstance().showMsg("Xóa câu hỏi thất bại!", Alert.AlertType.WARNING);
                    } catch (SQLException ex) {
                        MyAlert.getInstance().showMsg("Hệ thống bị lỗi, lý do: " + ex.getMessage(), Alert.AlertType.ERROR);
                    }
                }
            });
            cell.setGraphic(btn);
            return cell;
        });

        this.tbQuestions.getColumns().addAll(colId, colContent, colCategory, colLevel, colAction);
    }
}