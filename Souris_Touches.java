import  javafx.application.*;
import  javafx.scene.*;
import  javafx.stage.*;
import  javafx.scene.layout.*;
import  javafx.scene.control.*;
import  javafx.geometry.*;
import  javafx.event.*;
import  javafx.scene.input.*;

public class Souris_Touches extends Application
{
public static void main(String [] Arguments)
  {
  launch(Arguments);
  }
  
public void start (Stage Plateau)
  {
  Plateau.setTitle("Souris et Touches");
  
  FlowPane Agencement=new FlowPane(Orientation.VERTICAL,20,20);
  Agencement.setAlignment(Pos.CENTER);
  Agencement.setColumnHalignment(HPos.CENTER);
  
  Label Message_Souris=new Label("A l'extérieur\nde la fenêtre");
  Message_Souris.setOnMouseEntered
    (
    new EventHandler<MouseEvent>()
      {
      public void handle (MouseEvent Evenement_Souris)
        {
        Message_Souris.setText("À l'intérieur\nde l'étiquette");
        Message_Souris.requestFocus();
        }
      }
    );
  Message_Souris.setOnMouseExited
    (
    new EventHandler<MouseEvent>()
      {
      public void handle (MouseEvent Evenement_Souris)
        {
        Message_Souris.setText("À l'extérieur\nde l'étiquette");
        }
      }
    );
  
  Label Message_Touche=new Label("Frappez une touche");
  Message_Touche.setOnMouseEntered
    (
    new EventHandler<MouseEvent>()
      {
      public void handle (MouseEvent Evenement_Souris)
        {
        Message_Touche.requestFocus();
        }
      }
    );
  Message_Touche.setOnKeyTyped
    (
    new EventHandler<KeyEvent>()
      {
      public void handle (KeyEvent Evenement_Touche)
        {
        Message_Touche.setText("Frappé: ["+Evenement_Touche.getCharacter()+"]");
        }
      }
    );
      
  Label Message_Clic=new Label("Cliquez");
  
  Agencement.getChildren().addAll(Message_Souris,Message_Touche,Message_Clic);
  
  Scene Scene_Principale=new Scene(Agencement, 450, 300);
  Scene_Principale.getStylesheets().add("style.css");
  Scene_Principale.setOnMouseClicked
    (
    new EventHandler<MouseEvent>()
      {
      public void handle (MouseEvent Evenement_Souris)
        {
        Message_Souris.setText("Clic en ("+Evenement_Souris.getX()+","+Evenement_Souris.getY()+")");
        }
      }    
    );
  Scene_Principale.setOnKeyPressed
    (
    new EventHandler<KeyEvent>()
      {
      public void handle (KeyEvent Evenement_Touche)
        {
        Message_Touche.setText("Appuyé: ["+Evenement_Touche.getCode()+"]");
        }
      }
     );

  Plateau.setScene(Scene_Principale);
  Plateau.show();
  }
}
