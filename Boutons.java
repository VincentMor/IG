import  javafx.application.*;
import  javafx.scene.*;
import  javafx.stage.*;
import  javafx.scene.layout.*;
import  javafx.scene.control.*;
import  javafx.geometry.*;
import  javafx.event.*;

public class Boutons extends Application
{
public static void main(String [] Arguments)
  {
  launch(Arguments);
  }
  
public void start (Stage Plateau)
  {
  Plateau.setTitle("Boutons");

  FlowPane Agencement=new FlowPane(Orientation.VERTICAL,10,10);
  Agencement.setAlignment(Pos.CENTER);
  Agencement.setColumnHalignment(HPos.CENTER);
  
  Label Message=new Label("Choisissez une langue");
  Agencement.getChildren().add(Message);
  
  Button Francais=new Button("Francais");
  Francais.setOnAction
    (
    new EventHandler<ActionEvent>()
      {
      public void handle (ActionEvent Evenement)
        {
        Message.setText("Bonjour le Monde");
        }
      }
    );

  Button Anglais=new Button("Anglais");
  Anglais.setOnAction((ActionEvent Evenement) -> {Message.setText("Hello the World");});

  Agencement.getChildren().addAll(Francais,Anglais);
  Scene Scene_Principale=new Scene(Agencement, 300, 100);
  Plateau.setScene(Scene_Principale);
  Plateau.show();
  }
}
