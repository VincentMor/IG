import java.util.List;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
import java.util.ArrayList;

public class CalculatriceV3 extends Application {

  public static void main(String[] Arguments) {
    launch(Arguments);
  }

  public void start(Stage Plateau) {
    Plateau.setTitle("CalculatriceV3");
    int largeur=150;
    int hauteur=200; 
    GridPane Agencement=new GridPane();
    Agencement.setAlignment(Pos.CENTER);
    Agencement.setHgap(10);
    Agencement.setAlignment(Pos.CENTER);
    Agencement.setHgap(10);

    Label Message = new Label("0");
    Message.setAlignment(Pos.CENTER_RIGHT);
    Message.setMaxWidth(Double.MAX_VALUE);
    Agencement.add(Message,0,0);
    Agencement.add(new Separator(),0,1);

    ArrayList<Button> numero = new ArrayList<>();
    ArrayList<Button> operateur = new ArrayList<>();

    Button touche7 = new Button("7");
    Button touche8 = new Button("8");
    Button touche9 = new Button("9");
    Button touchePlus = new Button("+");
    numero.add(touche7);
    numero.add(touche8);
    numero.add(touche9);
    operateur.add(touchePlus);

    FlowPane ligne2 = new FlowPane();
    ligne2.setAlignment(Pos.CENTER);
    Button touche4 = new Button("4");
    Button touche5 = new Button("5");
    Button touche6 = new Button("6");
    Button toucheMoins = new Button("-");
    numero.add(touche4);
    numero.add(touche5);
    numero.add(touche6);
    operateur.add(toucheMoins);
    
    Button touche1 = new Button("1");
    Button touche2 = new Button("2");
    Button touche3 = new Button("3");
    Button toucheFois = new Button("*");
    numero.add(touche1);
    numero.add(touche2);
    numero.add(touche3);
    operateur.add(toucheFois);
    
    Button toucheE = new Button("E");
    Button touche0 = new Button("0");
    Button toucheEgale = new Button("=");
    Button toucheDiv = new Button("/");
    operateur.add(toucheE);
    operateur.add(toucheEgale);
    operateur.add(toucheDiv);
    numero.add(touche0);
    
    GridPane nombre = new GridPane();
    nombre.setHgap(5);
    nombre.setVgap(5);
    int col=0;
    int ligne=0;
    for (Button button : numero) {
      if (col!=0 && col%3==0){
        col=0;
        ligne++;
      }
      if(button == touche0){
        nombre.add(button,0,ligne,3,1);
        button.setMaxWidth(Double.MAX_VALUE);
      }else{
        nombre.add(button,col,ligne);
        col++;
      }
    }
    GridPane op = new GridPane();
    ligne=0;
    for (Button button : operateur) {
      op.add(button,0,ligne);
      ligne++;
    }

    GridPane touche = new GridPane();
    touche.add(nombre,0,0);
    Separator sep=new Separator();
    sep.setOrientation(Orientation.VERTICAL);
    touche.add(sep,1,0);
    touche.add(op,2,0);
    Agencement.add(touche,0,2);
    Scene Scene_Principale = new Scene(Agencement, largeur, hauteur);

    Scene_Principale.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
      public void handle(ActionEvent Evenement) {
        Button targget = (Button) Evenement.getTarget();
        if(Message.getText()=="Calcul Incorrect"){
          Message.setText("0");
        }
        if (targget == toucheE) {
          Message.setText("0");
        } else if (targget == toucheEgale) {
          Message.setText(calculer(Message.getText()));
        } else {
          if(Message.getText()!="0"){
            Message.setText(Message.getText() + targget.getText());
          }else{
            Message.setText(targget.getText()); 
          }
        }
      }
    });

    Plateau.setScene(Scene_Principale);
    Plateau.show();
  }

  public static String calculer(String calcul) {
    List<String> membres = new ArrayList<String>();
    int compteur = 0;
    int dernierOperateur = -1;
    String membre = "";
    while (compteur < calcul.length()) {
      switch (calcul.charAt(compteur)) {
        case '+':
          if (dernierOperateur != compteur - 1) {
            dernierOperateur = compteur;
            membres.add(membre);
            membre = "";
            membres.add("+");
          } else {
            return "Calcul Incorrect";
          }
          break;
        case '-':
          if (dernierOperateur != compteur - 1) {
            dernierOperateur = compteur;
            membres.add(membre);
            membre = "";
            membres.add("-");

          } else {
            return "Calcul Incorrect";
          }
          break;
        case '*':
          if (dernierOperateur != compteur - 1) {
            dernierOperateur = compteur;
            membres.add(membre);
            membre = "";
            membres.add("*");
          } else {
            return "Calcul Incorrect";
          }
          break;
        case '/':
          if (dernierOperateur != compteur - 1) {
            membres.add(membre);
            membre = "";
            dernierOperateur = compteur;
            membres.add("/");
          } else {
            return "Calcul Incorrect";
          }
          break;
        default:
          membre += calcul.charAt(compteur);
          if (compteur == calcul.length() - 1) {
            membres.add(membre);
          }
          break;
      }
      compteur++;
    }
    float res;
    int size = membres.size();
    boolean calc = true;
    boolean add = true;

    while (membres.size() > 1) {
      while (calc) {
        for (int i = 0; i < membres.size(); i++) {
          switch (membres.get(i)) {
            case "*":
              res = Float.valueOf(membres.get(i - 1)) * Float.valueOf(membres.get(i + 1));
              membres.set(i, String.valueOf(res));
              membres.remove(i + 1);
              membres.remove(i - 1);
              break;
            case "/":
              res = Float.valueOf(membres.get(i - 1)) / Float.valueOf(membres.get(i + 1));
              membres.set(i, String.valueOf(res));
              membres.remove(i + 1);
              membres.remove(i - 1);
              break;
          }
        }
        if (size > membres.size()) {
          size = membres.size();
        } else {
          calc = false;
        }
      }

      while (add) {
        for (int i = 0; i < membres.size(); i++) {
          switch (membres.get(i)) {
            case "+":
              res = Float.valueOf(membres.get(i - 1)) + Float.valueOf(membres.get(i + 1));
              membres.set(i, String.valueOf(res));
              membres.remove(i + 1);
              membres.remove(i - 1);
              break;
            case "-":
              res = Float.valueOf(membres.get(i - 1)) - Float.valueOf(membres.get(i + 1));
              membres.set(i, String.valueOf(res));
              membres.remove(i + 1);
              membres.remove(i - 1);
              break;
          }
        }
        if (size > membres.size()) {
          size = membres.size();
        } else {
          add = false;
        }
      }
    }
    return membres.get(0);
  }
}