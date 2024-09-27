package co.edu.uniquindio.notas.controladores;

import co.edu.uniquindio.notas.modelo.Nota;
import co.edu.uniquindio.notas.modelo.NotaPrincipal;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class InicioControlador implements Initializable {
    public Button btnNuevaNota;
    @FXML
    private TableView<Nota> tablaNotas;
    @FXML
    private TableColumn<Nota, String> colTitulo;
    @FXML
    private TableColumn<Nota, String> colCategoria;
    @FXML
    private TableColumn<Nota, String> colTexto;
    @FXML
    private TableColumn<Nota, String> colRecordatorio;
    @FXML
    private TableColumn<Nota, String> colFecha;
    @FXML
    private TextField txtTitulo;
    @FXML
    private ComboBox<String> txtCategoria;
    @FXML
    private DatePicker fechaRecordatorio;
    @FXML
    private TextArea txtNota;

    private final NotaPrincipal notaPrincipal;



    public InicioControlador() {
        notaPrincipal = new NotaPrincipal();
    }

    public void crearNota(ActionEvent e) throws Exception{
        try {
            notaPrincipal.agregarNota(txtTitulo.getText(), txtNota.getText(), txtCategoria.getValue(), fechaRecordatorio.getValue());

            mostrarAlerta("Nota creada correctamente", Alert.AlertType.INFORMATION);

            txtTitulo.clear();
            txtCategoria.setValue(null);
            txtNota.clear();
            fechaRecordatorio.setValue(null);
            tablaNotas.setItems(FXCollections.observableArrayList(notaPrincipal.listarNotas()));

        } catch (Exception ex) {
            mostrarAlerta(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colTitulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        colCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));
        colTexto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        colFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaCreacion().toString()));
        colRecordatorio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRecordatorio().toString()));

        txtCategoria.setItems( FXCollections.observableArrayList(notaPrincipal.listarCategorias()) );
    }


}


