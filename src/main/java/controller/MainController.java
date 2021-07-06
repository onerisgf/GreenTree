package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Users;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class MainController {

    @FXML
    TextField txtLoginValid, txtSenhaValid;
    @FXML
    Label lblResultado;
    @FXML
    Button btnLogar;



    public void logar(ActionEvent event) throws SQLException, IOException {

        Connection connection;
        connection = DriverManager.getConnection("jdbc:sqlite:banco.db");
        Statement stmt;
        ResultSet rst;  //RECEBE O RESULTADO DA CONSULTA
        stmt = connection.createStatement();  //TRAZ O BANCO DE DADOS EM UMA CONEXÃO ABERTA
        rst = stmt.executeQuery("select *from users");  //RECEBE TODOS OS REGISTROS DA TABELA

        ArrayList<Users> listUsers = new ArrayList<Users>();

        //PEGA OS RESULTADOS OBTIDOS DO BD E INSERE NA LISTA

        while(rst.next()){ //ENQUANTO TIVER ELEMENTO FAÇA

            Users u = new Users();
            u.setLogin(rst.getString("login"));
            u.setPassword(rst.getString("senha"));
            listUsers.add(u);

        }

        rst.close();
        connection.close();

        //LOGIN

        String login = txtLoginValid.getText();
        String senha = txtSenhaValid.getText();

        //VALIDAR O LOGIN

        for(Users u : listUsers){

            //CHAMA SEGUNDA TELA

            if(u.getLogin().equals(login) && u.getPassword().equals(senha)){

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/content.fxml"));
                Stage stage = (Stage) btnLogar.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);

                //lblResultado.setText("Login OK");
                break;

            }else{

                lblResultado.setText("Erro ao tentar logar");
            }
        }

    }


}
