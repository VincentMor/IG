import  javafx.application.*;
import  javafx.scene.*;
import  javafx.stage.*;
import  javafx.scene.layout.*;
import  javafx.scene.control.*;
import  javafx.geometry.*;
import  javafx.scene.image.*;

public class Defilement extends Application
{
public static void main(String [] Arguments)
  {
  launch(Arguments);
  }
  
public void start (Stage Plateau)
  {
  Plateau.setTitle("Agencement Cadre");
  Image Tux=new Image("tux.jpg",1000,1000,true,true);
  ImageView Vue=new ImageView(Tux);

  ScrollPane Agencement=new ScrollPane();
  Agencement.setContent(Vue);
  Agencement.setHvalue(0.5);
  Agencement.setVvalue(0.25);

  Scene Scene_Principale=new Scene(Agencement, 600, 400);
  Scene_Principale.getStylesheets().add("style.css");
  Plateau.setScene(Scene_Principale);
  Plateau.show();
  }
}
