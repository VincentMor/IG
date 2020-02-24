import  javafx.application.*;
import  javafx.scene.*;
import  javafx.stage.*;
import  javafx.scene.layout.*;
import  javafx.scene.control.*;
import  javafx.geometry.*;


public class Bonjour_Hello extends Application
{
public static void main(String [] Arguments)
  {
  launch(Arguments);
  }
  
public void start (Stage Plateau)
  {
  Plateau.setTitle("Bonjour/Hello");
  FlowPane Agencement=new FlowPane();
  Agencement.setAlignment(Pos.CENTER);
  Label Message_Francais=new Label("Bonjour le Monde ");
  Label Message_Anglais=new Label("Hello the World");
  Agencement.getChildren().add(Message_Francais);
  Agencement.getChildren().add(Message_Anglais);
  Scene Scene_Principale=new Scene(Agencement, 300, 100);
  Plateau.setScene(Scene_Principale);
  Plateau.show();
  }
}
