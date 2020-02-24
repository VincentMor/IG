import  javafx.application.*;
import  javafx.scene.*;
import  javafx.stage.*;
import  javafx.scene.layout.*;
import  javafx.scene.control.*;
import  javafx.geometry.*;
import  javafx.event.*;
import  java.util.*;
import  javafx.util.*;
import  javafx.scene.image.*;

public class Dialogue extends Application
{
public static void main(String [] Arguments)
  {
  launch(Arguments);
  }
  
public void start (Stage Plateau)
  {
  Plateau.setTitle("Dialogues");
  VBox Agencement=new VBox();
  Agencement.setAlignment(Pos.CENTER);
  Label Message=new Label("Choisissez une boite");
  Message.setStyle("-fx-font-size: 24 ;");
  AnchorPane Panneau_Boutons=new AnchorPane();
  Panneau_Boutons.setPadding(new Insets(10,10,10,10));
  Panneau_Boutons.setPrefSize(400,200);
  Agencement.getChildren().addAll(Message, new Separator(), Panneau_Boutons);
  
  /* Source :  remy-manu.no-ip.biz/Java/Tutoriels/JavaFX/PDF/ihm1_fx_10_man.pdf */

  Button Avertissement_Simple=new Button("Avertissement simple");
  Panneau_Boutons.setTopAnchor(Avertissement_Simple,10.0);
  Panneau_Boutons.getChildren().add(Avertissement_Simple);
  Avertissement_Simple.setOnAction
    (
    new EventHandler<ActionEvent>()
      {
      public void handle (ActionEvent Evenement)
        {
        Alert Boite=new Alert(Alert.AlertType.WARNING, "Vous êtes averti !!!!");
        Boite.setTitle("Boite Avertissement Simple");
        Boite.setHeaderText(null);
        Boite.showAndWait();  
        Message.setText("Vous avez été averti");
        }
      }
    );


  Button Information=new Button("Information");
  Panneau_Boutons.setLeftAnchor(Information,150.0);
  Panneau_Boutons.getChildren().add(Information);
  Information.setOnAction
    (
    new EventHandler<ActionEvent>()
      {
      public void handle (ActionEvent Evenement)
        {
        Alert Boite=new Alert(Alert.AlertType.INFORMATION);
        Boite.setTitle("Boite Information");
        Boite.setHeaderText("Ceci est une Information");
        Boite.setContentText("Vous avez reçu une information !!!!");
        Boite.showAndWait();  
        Message.setText("Vous avez été informé");
        }
      }
    );
    
  Button Erreur=new Button("Erreur");
  Panneau_Boutons.setRightAnchor(Erreur,0.0);
  Panneau_Boutons.getChildren().add(Erreur);
  Erreur.setOnAction
    (
    new EventHandler<ActionEvent>()
      {
      public void handle (ActionEvent Evenement)
        {
        Alert Boite=new Alert(Alert.AlertType.ERROR);
        Boite.setTitle("Boite Erreur");
        Boite.setHeaderText("Ceci est une Erreur");
        Boite.setContentText("Vous avez provoqué une erreur !!!!");
        Boite.initModality(Modality.NONE);
        Boite.showAndWait();  
        Message.setText("Vous avez été informé d'une erreur");
        }
      }
    );

  Button Confirmation=new Button("Confirmation");
  Panneau_Boutons.setBottomAnchor(Confirmation,0.0);
  Panneau_Boutons.getChildren().add(Confirmation);
  Confirmation.setOnAction
    (
    new EventHandler<ActionEvent>()
      {
      public void handle (ActionEvent Evenement)
        {
        Alert Boite=new Alert(Alert.AlertType.CONFIRMATION);
        Boite.setTitle("Boite Confirmation");
        Boite.setHeaderText("Ceci est une Confirmation");
        Boite.setContentText("Vous avez demandé une confirmation !!!!");   
        Optional<ButtonType> Reponse = Boite.showAndWait();
        if (Reponse.isPresent() && Reponse.get() == ButtonType.OK)
          {
          Message.setText("Vous avez confirmé");
          }
        else
          {
          Message.setText("Vous avez annulé");
          }
        }
      }
    );

  Button Confirmation_Personnalisee=new Button("Confirmation\nPersonnalisee");
  Panneau_Boutons.setBottomAnchor(Confirmation_Personnalisee,30.0);
  Panneau_Boutons.setLeftAnchor(Confirmation_Personnalisee,30.0);
  Panneau_Boutons.getChildren().add(Confirmation_Personnalisee);
  Confirmation_Personnalisee.setOnAction
    (
    new EventHandler<ActionEvent>()
      {
      public void handle (ActionEvent Evenement)
        {
        Alert Boite=new Alert(Alert.AlertType.CONFIRMATION);
        Boite.setTitle("Boite Confirmation Personnalisee");
        Boite.setHeaderText("Ceci est une Confirmation Personnalisee");
        Boite.setContentText("Choisissez !!!!");      
        ButtonType Premier_Choix=new ButtonType("Premier");  
        ButtonType Deuxieme_Choix=new ButtonType("Deuxième");  
        ButtonType Troisieme_Choix=new ButtonType("Troisieme");  
        ButtonType Annuler=new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);  
        Boite.getButtonTypes().setAll(Premier_Choix, Deuxieme_Choix,Troisieme_Choix,Annuler);
        Optional<ButtonType> Reponse = Boite.showAndWait();
        if (Reponse.isPresent())
          {          
          if (Reponse.get() == Premier_Choix)
            {
            Message.setText("Vous avez répondu Premier");
            }
          else if (Reponse.get() == Deuxieme_Choix)
            {
            Message.setText("Vous avez répondu Deuxieme");
            }
          else if (Reponse.get() == Troisieme_Choix)
            {
            Message.setText("Vous avez répondu Troisieme");
            }
          else if (Reponse.get() == Annuler)
            {
            Message.setText("Vous avez annulé");
            }
          }
        else
          {
          Message.setText("Dysfonctionnement");
          }
        }
      }
    );

 
  Button Saisie=new Button("Saisie");
  Panneau_Boutons.setRightAnchor(Saisie,30.0);
  Panneau_Boutons.setTopAnchor(Saisie,40.0);
  Panneau_Boutons.getChildren().add(Saisie);
  Saisie.setOnAction
    (
    new EventHandler<ActionEvent>()
      {
      public void handle (ActionEvent Evenement)
        {
        TextInputDialog Boite=new TextInputDialog("Texte par défaut");
        Boite.setTitle("Boite Saisie");
        Boite.setHeaderText("Ceci est une Saisie");
        Boite.setContentText("Votre texte");
        Optional<String> Reponse=Boite.showAndWait();  
        if (Reponse.isPresent())
          {
          Message.setText("Vous avez saisi >"+Reponse.get()+"<");
          }
        else
          {
          Message.setText("Vous n'avez rien saisi ");
          }
        }
      }
    );

    
  Button Liste_Choix=new Button("Liste de Choix");
  Panneau_Boutons.setTopAnchor(Liste_Choix,40.0);
  Panneau_Boutons.setLeftAnchor(Liste_Choix,20.0);
  Panneau_Boutons.setRightAnchor(Liste_Choix,100.0);
  Panneau_Boutons.getChildren().add(Liste_Choix);
  String[] Intitules_Choix={"Premier","Deuxieme","Troisieme"};
  
  Liste_Choix.setOnAction
    (
    new EventHandler<ActionEvent>()
      {
      public void handle (ActionEvent Evenement)
        {
        ChoiceDialog<String> Boite=new ChoiceDialog<>(Intitules_Choix[0],Intitules_Choix);
        Boite.setTitle("Boite Liste Choix ");
        Boite.setHeaderText("Ceci est une Liste de Choix");
        Boite.setContentText("Choisissez");
        Optional<String> Reponse=Boite.showAndWait(); 
        if (Reponse.isPresent())
          {
          Message.setText("Vous avez choisi >"+Reponse.get()+"<");
          }
        else
          {
          Message.setText("Vous n'avez rien saisi ");
          }

        }
      }
    );

  Button Boite_Personnalisee=new Button("Boite Personnalisee");
  Panneau_Boutons.setRightAnchor(Boite_Personnalisee,0.0);
  Panneau_Boutons.setBottomAnchor(Boite_Personnalisee,0.0);
  Panneau_Boutons.getChildren().add(Boite_Personnalisee);
  Boite_Personnalisee.setOnAction
    (
    new EventHandler<ActionEvent>()
      {
      public void handle (ActionEvent Evenement)
        { 
        /* Source : http://code.makery.ch/blog/javafx-dialogs-official/ */

        // Create the custom Boite.
        Dialog<Pair<String, String>> Boite = new Dialog<>();
        Boite.setTitle("Boite Personnalisée");
        Boite.setHeaderText("Veuillez vous authentifier");

        // Set the icon (must be included in the project).
        Boite.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

        // Set the button types.
        ButtonType loginButtonType = new ButtonType("Authentification", ButtonBar.ButtonData.OK_DONE);
        Boite.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Identifiant");
        PasswordField password = new PasswordField();
        password.setPromptText("Mot de Passe");

        grid.add(new Label("Identifiant:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Mot de Passe:"), 0, 1);
        grid.add(password, 1, 1);

        // Enable/Disable login button depending on whether a username was entered.
        Node loginButton = Boite.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        Boite.getDialogPane().setContent(grid);

        // Request focus on the username field by default.
        Platform.runLater(() -> username.requestFocus());

        // Convert the result to a username-password-pair when the login button is clicked.
        Boite.setResultConverter(BoiteButton -> {
            if (BoiteButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> Resultat = Boite.showAndWait();

        Resultat.ifPresent(usernamePassword -> {
            Message.setText("Identifiant = " + usernamePassword.getKey() + " | Mot de Passe = " + usernamePassword.getValue());
        });

        }
      }
    );

  Scene Scene_Principale=new Scene(Agencement, 500, 200);
  Plateau.setScene(Scene_Principale);
  Plateau.show();
  }
}
