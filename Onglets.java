import  javafx.application.*;
import  javafx.scene.*;
import  javafx.stage.*;
import  javafx.scene.layout.*;
import  javafx.scene.control.*;
import  javafx.geometry.*;
import  javafx.event.*;

public class Onglets extends Application
{
public static void main(String [] Arguments)
  {
  launch(Arguments);
  }
  
public void start (Stage Plateau)
  {
  Plateau.setTitle("Agencement Onglets");
  TabPane Agencement=new TabPane();
  
  Tab Nom=new Tab("Nom");
  
  TextField Saisie_Nom=new TextField();
  Nom.setContent(Saisie_Nom);
  Agencement.getTabs().add(Nom);
  
  Tab Prenom=new Tab("Prénom");
  TextField Saisie_Prenom=new TextField("Votre Prénom");
  Prenom.setContent(Saisie_Prenom);
  Agencement.getTabs().add(Prenom);

  Tab Identite=new Tab("Identité");
  Identite.setClosable(false);
  Label Message=new Label("Tapez vos noms et prénoms");
  Identite.setContent(Message);
  Agencement.getTabs().add(Identite);
  
  EventHandler<ActionEvent> Saisie = new EventHandler<ActionEvent>()
      {
      public void handle(ActionEvent Action)
        {
        Message.setText(Saisie_Prenom.getText()+" "+Saisie_Nom.getText());
        }
      };
  
  Saisie_Nom.setOnAction(Saisie);
  Saisie_Prenom.setOnAction(Saisie);
 
  Scene Scene_Principale=new Scene(Agencement, 700, 250);
  Scene_Principale.getStylesheets().add("style_lointain.css");
  Plateau.setScene(Scene_Principale);
  Plateau.show();
  }
}
