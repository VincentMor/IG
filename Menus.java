import  javafx.application.*;
import  javafx.scene.*;
import  javafx.stage.*;
import  javafx.scene.layout.*;
import  javafx.scene.control.*;
import  javafx.scene.input.*;
import  javafx.scene.shape.*;
import  javafx.event.*;
import  javafx.scene.image.*;
import  javafx.scene.paint.*;
import  javafx.geometry.*;

public class Menus extends Application
{
public static void main(String [] Arguments)
  {
  launch(Arguments);
  }
  
public void start (Stage Plateau)
  {
  Plateau.setTitle("Menus");
  BorderPane Agencement=new BorderPane();
  
  Label Affichage=new Label("Bonjour le Monde");
  Affichage.setPrefSize( Double.MAX_VALUE, Double.MAX_VALUE );
  Affichage.setAlignment(Pos.CENTER);
  Affichage.setTextFill(Color.BLACK);
  Affichage.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
  Agencement.setCenter(Affichage);
  
  MenuItem Noir=new MenuItem("_Noir",new Rectangle(16,16,Color.BLACK));
  MenuItem Blanc=new MenuItem("_Blanc",new Rectangle(16,16,Color.WHITE));


  MenuItem Francais=new MenuItem("Français");
  Francais.setAccelerator(KeyCombination.keyCombination("shortcut+F"));
  MenuItem Anglais=new MenuItem("Anglais");
  Anglais.setAccelerator(KeyCombination.keyCombination("shortcut+A"));

  Menu Menu_Langue=new Menu("Lan_gue");
  Menu_Langue.getItems().addAll(Francais,Anglais);

  Menu Menu_Texte=new Menu("_Texte");
  Menu_Texte.getItems().addAll(Noir,Blanc,new SeparatorMenuItem(),Menu_Langue);

  RadioMenuItem Rouge=new RadioMenuItem("_Rouge",new Rectangle(16,16,Color.RED));
  Rouge.setSelected(true);
  RadioMenuItem Vert=new RadioMenuItem("_Vert",new Rectangle(16,16,Color.GREEN));
  ToggleGroup Couleur_Affichage=new ToggleGroup();
  Rouge.setToggleGroup(Couleur_Affichage);
  Vert.setToggleGroup(Couleur_Affichage);

  CheckMenuItem Opaque=new CheckMenuItem("Opaque");
  Opaque.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
  Opaque.setSelected(true);
  
  Menu Menu_Fond=new Menu("_Fond");
  Menu_Fond.getItems().addAll(Rouge,Vert,new SeparatorMenuItem(),Opaque);
  
  MenuBar Barre_Menus=new MenuBar(Menu_Texte, Menu_Fond);
  Agencement.setTop(Barre_Menus);

  MenuItem RaZ=new MenuItem("Supercalifragilisticexpialidocious");
  ContextMenu MenuRaZ=new ContextMenu(RaZ);
  Affichage.setContextMenu(MenuRaZ);
  
  EventHandler<ActionEvent> Gestionnaire_Evenements = new EventHandler<ActionEvent>()
    {
    public void handle (ActionEvent Evenement)
      {
      MenuItem Article = ((MenuItem)Evenement.getTarget());
      if (Article == Francais)
        {
        Affichage.setText("Bonjour le Monde");
        }
      if (Article == Anglais)
        {
        Affichage.setText("Hello World");
        }
      if (Article == Noir)
        {
        Affichage.setTextFill(Color.BLACK);
        }
      if (Article == Blanc)
        {
        Affichage.setTextFill(Color.WHITE);
        }
      if ((Article == Rouge)&&(Opaque.isSelected()))
        {
        Affichage.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        }
      if ((Article == Vert)&&(Opaque.isSelected()))
        {
        Affichage.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        }
      if (Article == Opaque)
        {
        if (Opaque.isSelected())
          {
          if (Rouge.isSelected())
            {
            Affichage.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            }
          if (Vert.isSelected())
            {
            Affichage.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            }
          }
        else
          {
          Affichage.setBackground(null);
          }
        }
      if (Article == RaZ)
        {
        Affichage.setText("Bonjour le Monde");
        Affichage.setTextFill(Color.BLACK);
        Affichage.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        Rouge.setSelected(true);
        Opaque.setSelected(true);
        }
      }
    };
  
  Noir.setOnAction(Gestionnaire_Evenements);
  Blanc.setOnAction(Gestionnaire_Evenements);
  Francais.setOnAction(Gestionnaire_Evenements);
  Anglais.setOnAction(Gestionnaire_Evenements);
  Rouge.setOnAction(Gestionnaire_Evenements);
  Vert.setOnAction(Gestionnaire_Evenements);
  Opaque.setOnAction(Gestionnaire_Evenements);

  RaZ.setOnAction(Gestionnaire_Evenements);

  Button Outil_Noir=new Button("Black",new Rectangle(32,32,Color.BLACK));
  Outil_Noir.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
  Outil_Noir.setTooltip(new Tooltip("Texte Noir"));
  Button Outil_Blanc=new Button("White",new Rectangle(32,32,Color.WHITE));
  Outil_Blanc.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
  Outil_Blanc.setTooltip(new Tooltip("Texte Blanc"));
  Button Outil_Rouge=new Button("Red");
  Outil_Rouge.setGraphic(new Rectangle(32,32,Color.RED));
  Outil_Rouge.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
  Outil_Rouge.setTooltip(new Tooltip("Fond Rouge"));
  Button Outil_Vert=new Button("Green");
  Outil_Vert.setGraphic(new Rectangle(32,32,Color.GREEN));
  Outil_Vert.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
  Outil_Vert.setTooltip(new Tooltip("Fond Vert"));

  EventHandler<ActionEvent> Gestionnaire_Couleur = new EventHandler<ActionEvent>()
    {
    public void handle (ActionEvent Evenement)
      {
      String Libelle_Article = ((Button)Evenement.getTarget()).getText();
      switch (Libelle_Article)
        {
        case "Black" : 
          {        
          Affichage.setTextFill(Color.BLACK);
          break;
          }
        case "White" : 
          {        
          Affichage.setTextFill(Color.WHITE);
          break;
          }
        case "Red" : 
          {        
          Affichage.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
          Rouge.setSelected(true);
          Opaque.setSelected(true);
          break;
          }
        case "Green" : 
          {        
          Affichage.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
          Vert.setSelected(true);
          Opaque.setSelected(true);
          break;
          }
        }
      }
    };
  
  Outil_Noir.setOnAction(Gestionnaire_Couleur);
  Outil_Blanc.setOnAction(Gestionnaire_Couleur);
  Outil_Rouge.setOnAction(Gestionnaire_Couleur);
  Outil_Vert.setOnAction(Gestionnaire_Couleur);
  
  MenuButton Outil_Message=new MenuButton("Message");
  MenuItem Bonjour=new MenuItem("Bonjour...");
  Bonjour.setOnAction
    (
    new EventHandler<ActionEvent>()
      {
      public void handle(ActionEvent Evenement)
        {
        Affichage.setText("Bonjour...");
        }
      }
    );
  MenuItem Hello=new MenuItem("Hello...");
  Hello.setOnAction
    (
    new EventHandler<ActionEvent>()
      {
      public void handle(ActionEvent Evenement)
        {
        Affichage.setText("Hello...");
        }
      }
    );
  TextField Message=new TextField();
  Message.setPromptText("Tapez votre message de bienvenue");
  Message.setOnAction
    (
    new EventHandler<ActionEvent>()
      {
      public void handle(ActionEvent Evenement)
        {
        Affichage.setText(Message.getText());
        }
      }
    );
  
  CustomMenuItem Saisie_Message=new CustomMenuItem(Message);
  
  Outil_Message.getItems().addAll(Bonjour, Hello, Saisie_Message);
  
  ToolBar Barre_Outils=new ToolBar(Outil_Noir, Outil_Blanc, Outil_Rouge, Outil_Vert, Outil_Message);
  Agencement.setBottom(Barre_Outils);

  Scene Scene_Principale=new Scene(Agencement, 500, 300);
  Scene_Principale.getStylesheets().add("style_lointain.css");

  Plateau.setScene(Scene_Principale);
  Plateau.show();
  }
}
