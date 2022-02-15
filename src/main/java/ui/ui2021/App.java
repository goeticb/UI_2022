package ui.ui2021;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;

import java.io.IOException;

public class App extends Application {

    private static Stage stage;
    private static App instance = null;
    //private static Connection myConn;

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    public static void main(String[] args) throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;
        Statement statement = null;
        try {
            myConn = DriverManager.getConnection(dbURL, user, pass);
            String sql = "select * from PDV";
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();
            //System.out.println("USLO zA PDV");
            if (!myRS.isBeforeFirst() ) {
                statement = myConn.createStatement();
                sql = "INSERT INTO PDV (naziv, stopaPDV) VALUES ('"+ "PDV1" +"', "+ 20 + ")";
                System.out.println(sql);
                statement.executeUpdate(sql);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(myConn != null){
                myConn.close();
            }
            if(myRS != null){
                myRS.close();
            }
        }
        launch();

    }

    @Override
    public void start(Stage s) throws IOException {
        stage = s;
        changeScene("login.fxml");
    }

    public void changeScene(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("UI 2021");
        stage.centerOnScreen();
        stage.show();
    }
/*
    public static Connection getMyConn() {
        return myConn;
    }

    public static void setMyConn(Connection myConn) {
        App.myConn = myConn;
    }
    */

}