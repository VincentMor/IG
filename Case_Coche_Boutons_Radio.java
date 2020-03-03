import  javafx.application.*;
import  javafx.scene.*;
import  javafx.stage.*;
import  javafx.scene.layout.*;
import  javafx.scene.control.*;
import  javafx.geometry.*;
import  javafx.event.*;

public class Case_Coche_Boutons_Radio extends Application
{
public static void main(String [] Arguments)
{
  launch(Arguments);
}

public void start (Stage Plateau)
  {
  Plateau.setTitle("Case à cocher et Boutons radio");

  VBox Agencement=new VBox(10);
  Agencement.setAlignment(Pos.CENTER);
  
  Label Message=new Label("Choisissez vos plats");
  Agencement.getChildren().add(Message);
  Agencement.getChildren().add(new Separator());

  HBox Ligne=new HBox(20);
  Ligne.setAlignment(Pos.CENTER);
  
  CheckBox Entree=new CheckBox("Entrée");

  VBox Colonne=new VBox(5);
  Colonne.setAlignment(Pos.CENTER_LEFT);
  
  RadioButton Fromage=new RadioButton("Fromage");
  RadioButton Dessert=new RadioButton("Dessert");
  
  ToggleGroup Fin_Repas=new ToggleGroup();
  Fromage.setToggleGroup(Fin_Repas);
  Dessert.setToggleGroup(Fin_Repas);

  Colonne.getChildren().addAll(Fromage,Dessert);
  Ligne.getChildren().addAll(Entree,new Separator(Orientation.VERTICAL),Colonne);
  Agencement.getChildren().add(Ligne);
  Agencement.getChildren().add(new Separator());
  
  Button Annulation=new Button("Effacer");
  Annulation.setOnAction
    (new EventHandler<ActionEvent>()
      {
      public void handle (ActionEvent Evenement)
        {
        Entree.setSelected(false);
        Fromage.setSelected(false);
        Dessert.setSelected(false);
        }
      }
    );
  Agencement.getChildren().add(Annulation);
  
  Scene Scene_Principale=new Scene(Agencement, 350, 150);
  
  Scene_Principale.addEventHandler
    (ActionEvent.ACTION,
     new EventHandler<ActionEvent>()
      {
      public void handle (ActionEvent Evenement)
        {
        if (Entree.isSelected())
          {
          if (Fromage.isSelected())
            {
            Message.setText("Entrée et Fromage");
            }
          else
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
          }
        else
          {
          if (Fromage.isSelected())
            {
            Message.setText("Fromage");
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
        }
      }
    );
  
  Plateau.setScene(Scene_Principale);
  Plateau.show();
  }
}
