import  javafx.application.*;
import  javafx.scene.*;
import  javafx.stage.*;
import  javafx.scene.layout.*;
import  javafx.scene.control.*;
import  javafx.geometry.*;
import  javafx.event.*;

public class Boutons_Bascule extends Application
{
public static void main(String [] Arguments)
  {
  launch(Arguments);
  }

public void start (Stage Plateau)
  {
  Plateau.setTitle("Boutons Bascule");

  FlowPane Agencement=new FlowPane(Orientation.VERTICAL,10,10);
  Agencement.setAlignment(Pos.CENTER);
  Agencement.setColumnHalignment(HPos.CENTER);
  
  Label Message=new Label("Choisissez vos plats");
  Agencement.getChildren().add(Message);
  Agencement.getChildren().add(new Separator());

  FlowPane Ligne=new FlowPane(20, 0);
  Ligne.setAlignment(Pos.CENTER);
  
  ToggleButton Entree=new ToggleButton("Entrée");
  ToggleButton Dessert=new ToggleButton("Dessert");

  EventHandler<ActionEvent> Choix=new EventHandler<ActionEvent>()
    {
    public void handle (ActionEvent Evenement)
      {
      if (Entree.isSelected())
        {
        if (Dessert.isSelected())
          {
          Message.setText("Entrée et Dessert");
          }
        else
          {
          Message.setText("Entrée");
          }
        }
      else
        {
        if (Dessert.isSelected())
          {
          Message.setText("Dessert");
          }
        else
          {
          Message.setText("Choisissez vos plats");
          }
        }
      }
    };
  
  Entree.setOnAction(Choix);
  Dessert.setOnAction(Choix);

  Ligne.getChildren().addAll(Entree,Dessert);
  Agencement.getChildren().add(Ligne);
  
  Scene Scene_Principale=new Scene(Agencement, 300, 100);
  Plateau.setScene(Scene_Principale);
  Plateau.show();
  }
}
