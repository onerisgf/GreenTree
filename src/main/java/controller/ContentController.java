package controller;

import database.ConnectionFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

public class ContentController {

        @FXML
        TextField txtID, txtNome, txtCientifico, txtIdade, txtFamilia, txtEstado, txtCidade, txtCep, txtNumero, txtRua;
        @FXML
        Label lblResultado;

        //utiliza ActionEvent dentro de funções clicaveis.

        public void salva (ActionEvent event) throws SQLException {

            Connection connection; //VARIAVEL DE CONEXÃO
            PreparedStatement stmt; //PREPARA A CONEXÃO COM O BD

            connection = ConnectionFactory.getConnectionSqlite();   //PASSSO A CONEXÃO COM O DB CRIADO.

            String salva = "insert into arvores (nome, cientifico, idade, familia, estado, cidade, cep, numero, rua) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";  //INTERROGAÇÃO SERAM PASSADOS PARAMETROS

            stmt = connection.prepareStatement(salva); //PREPARA A CONEXÃO COM A LINHA SQL

            //RECEBER DADOS DA TELA

            stmt.setString(1, txtNome.getText().toString());  //PASSA O VALOR PARA O PARAMETRO 1
            stmt.setString(2, txtCientifico.getText().toString());
            stmt.setInt(3, Integer.parseInt(txtIdade.getText().toString()));
            stmt.setString(4, txtFamilia.getText().toString());
            stmt.setString(5, txtEstado.getText().toString());
            stmt.setString(6, txtCidade.getText().toString());
            stmt.setInt(7, Integer.parseInt(txtCep.getText().toString()));
            stmt.setInt(8, Integer.parseInt(txtNumero.getText().toString()));
            stmt.setString(9, txtRua.getText().toString());

            //EXECUTAR INSTRUÇÕES

            stmt.execute();
            connection.close();   //ENCERRA A CONEXÃO

        }

        public void pesquisa(ActionEvent event) throws SQLException {

            Connection connection;
            PreparedStatement stmt;
            ResultSet rst;  //VARIAVEL QUE RECEBE RESULTADO DA CONSULTA

            connection = ConnectionFactory.getConnectionSqlite();

            String pesquisa = "select *from arvores where id = ?";
            stmt = connection.prepareStatement(pesquisa);
            int id = Integer.parseInt((txtID.getText().toString()));


            //RECEBER PARAMETROS

            stmt.setInt(1, id);

            //RECEBER RESULTADO

            rst = stmt.executeQuery();

            while(rst.next()){    //ENQUANTO TIVER LINHA PARA LER FAÇA
                txtNome.setText(rst.getString("nome"));
                txtCientifico.setText(rst.getString("cientifico"));
                txtIdade.setText(String.valueOf((rst.getInt("idade"))));
                txtFamilia.setText(rst.getString("familia"));
                txtEstado.setText(rst.getString("estado"));
                txtCidade.setText(rst.getString("cidade"));
                txtCep.setText(String.valueOf((rst.getInt("cep"))));
                txtNumero.setText(String.valueOf((rst.getInt("numero"))));
                txtRua.setText(rst.getString("rua"));

            }

            rst.close();
            connection.close();



        }

        public void atualiza(ActionEvent event) throws  SQLException{

            Connection connection; //VARIAVEL DE CONEXÃO
            PreparedStatement stmt; //PREPARA A CONEXÃO COM O BD

            connection = ConnectionFactory.getConnectionSqlite();   //PASSSO A CONEXÃO COM O DB CRIADO.

            String atualiza = "update arvores set nome = ?, cientifico = ?, idade = ?, familia = ?, estado = ?, cidade = ?, cep = ?, numero = ?, rua = ? where id = ?";


            stmt = connection.prepareStatement(atualiza); //PREPARA A CONEXÃO COM A LINHA SQL

            //RECEBER DADOS DA TELA

            stmt.setString(1, txtNome.getText().toString());  //PASSA O VALOR PARA O PARAMETRO 1
            stmt.setString(2, txtCientifico.getText().toString());
            stmt.setInt(3, Integer.parseInt(txtIdade.getText().toString()));
            stmt.setString(4, txtFamilia.getText().toString());
            stmt.setString(5, txtEstado.getText().toString());
            stmt.setString(6, txtCidade.getText().toString());
            stmt.setInt(7, Integer.parseInt(txtCep.getText().toString()));
            stmt.setInt(8, Integer.parseInt(txtNumero.getText().toString()));
            stmt.setString(9, txtRua.getText().toString());
            stmt.setInt(10, Integer.parseInt(txtID.getText().toString()));

            //EXECUTAR INSTRUÇÕES

            System.out.printf("Atualizado");

            stmt.execute();
            connection.close();   //ENCERRA A CONEXÃO

        }

        public void deleta(ActionEvent event) throws SQLException{

            Connection connection; //VARIAVEL DE CONEXÃO
            PreparedStatement stmt; //PREPARA A CONEXÃO COM O BD

            connection = ConnectionFactory.getConnectionSqlite();   //PASSSO A CONEXÃO COM O DB CRIADO.

            String deleta = "delete from arvores where id = ?";

            stmt = connection.prepareStatement(deleta);

            stmt.setInt(1, Integer.parseInt(txtID.getText().toString()));

            //EXECUTAR INSTRUÇÕES

            System.out.printf("Registro Deletado!");

            stmt.execute();
            connection.close();   //ENCERRA A CONEXÃO


        }


}
