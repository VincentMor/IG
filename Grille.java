import  javafx.application.*;
import  javafx.scene.*;
import  javafx.stage.*;
import  javafx.scene.layout.*;
import  javafx.scene.control.*;
import  javafx.geometry.*;
import  javafx.event.*;

public class Grille extends Application
{
public static void main(String [] Arguments)
  {
  launch(Arguments);
  }
  
public void start (Stage Plateau)
  {
  Plateau.setTitle("Agencement Grille");
  GridPane Agencement=new GridPane();
  Agencement.setAlignment(Pos.CENTER);
  Agencement.setHgap(10);
  
  Label Nom=new Label("Nom");
  TextField Saisie_Nom=new TextField();
  Agencement.add(Nom,0,0);
  Agencement.add(Saisie_Nom,1,0);
  Label Prenom=new Label("Prénom");
  TextField Saisie_Prenom=new TextField("Votre Prénom");
  Agencement.add(Prenom,0,1);
  Agencement.add(Saisie_Prenom,1,1);

  Agencement.add(new Separator(),0,2);
  
  Label Message=new Label("Tapez vos noms et prénoms");
  Agencement.add(Message,0,3);
  Agencement.setColumnSpan(Message,2);
  
  EventHandler<ActionEvent> Saisie = new EventHandler<ActionEvent>()
      {
      public void handle(ActionEvent Action)
        {
        Message.setText("Bonjour "+Saisie_Prenom.getText()+" "+Saisie_Nom.getText());
        }
      };
  
  Saisie_Nom.setOnAction(Saisie);
  Saisie_Prenom.setOnAction(Saisie);
 
  Scene Scene_Principale=new Scene(Agencement, 750, 300);
  Scene_Principale.getStylesheets().add("style_lointain.css");
  Plateau.setScene(Scene_Principale);
  Plateau.show();
  }
}
