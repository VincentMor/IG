import  javafx.application.*;
import  javafx.scene.*;
import  javafx.stage.*;
import  javafx.scene.layout.*;

public class Squelette extends Application
{
public static void main(String [] Arguments)
  {
  launch(Arguments);
  }
  
public void start (Stage Plateau)
  {
  Plateau.setTitle("Squelette");
  FlowPane Agencement=new FlowPane();
  Scene Scene_Principale=new Scene(Agencement, 300, 100);
  Plateau.setScene(Scene_Principale);
  Plateau.show();
  }
}
