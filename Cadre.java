import  javafx.application.*;
import  javafx.scene.*;
import  javafx.stage.*;
import  javafx.scene.layout.*;
import  javafx.scene.control.*;
import  javafx.geometry.*;
import  javafx.scene.text.*;

public class Cadre extends Application
{
public static void main(String [] Arguments)
  {
  launch(Arguments);
  }
  
public void start (Stage Plateau)
  {
  Plateau.setTitle("Agencement Cadre");
  BorderPane Agencement=new BorderPane();

  Label Centre=new Label("Centre");
  Centre.setPrefSize(Double.MAX_VALUE,Double.MAX_VALUE);
//  Centre.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
  Centre.setAlignment(Pos.CENTER);
  Centre.setTooltip(new Tooltip("Zone centrale occupée\npar une étiquette\nde taille maximale"));
  
  Label Nord=new Label("Nord");
  Nord.setMaxWidth(200);
  Nord.setTooltip(new Tooltip("Zone \"Top\" occupée\npar une étiquette standard"));
  Label Sud=new Label("Sud");
  Sud.setMaxWidth(Double.MAX_VALUE);
  Sud.setAlignment(Pos.CENTER_RIGHT);
  Sud.setTooltip(new Tooltip("Zone \"Bottom\" occupée\npar une étiquette\nde taille maximale\nferrée à droite"));
  Label Est=new Label("Est");
  Est.setMaxHeight(Double.MAX_VALUE);
  Est.setAlignment(Pos.TOP_CENTER);
  Est.setTooltip(new Tooltip("Zone \"Right\" occupée\npar une étiquette\nde taille maximale\nferrée en haut"));
  Label Ouest=new Label("Ouest");
  Ouest.setTooltip(new Tooltip("Zone \"Left\" occupée\npar une étiquette standard\nferrée en bas"));

  Agencement.setCenter(Centre);
  Agencement.setMargin(Centre, new Insets(10,10,10,10));
  Agencement.setTop(Nord);
  Agencement.setAlignment(Nord,Pos.CENTER_LEFT);
  Agencement.setBottom(Sud);
//  Agencement.setAlignment(Sud,Pos.CENTER_RIGHT);
  Agencement.setRight(Est);
//  Agencement.setAlignment(Est,Pos.CENTER);
  Agencement.setLeft(Ouest);
  Agencement.setAlignment(Ouest,Pos.BOTTOM_RIGHT);

  Scene Scene_Principale=new Scene(Agencement, 600, 400);
  Scene_Principale.getStylesheets().add("style.css");
  Plateau.setScene(Scene_Principale);
  Plateau.show();
  }
}
