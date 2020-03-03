import java.util.List;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
import java.util.ArrayList;

public class CalculatriceV2 extends Application {

  public static void main(String[] Arguments) {
    launch(Arguments);
  }

  public void start(Stage Plateau) {
    Plateau.setTitle("Calculatrice");

    FlowPane Agencement = new FlowPane(Orientation.VERTICAL, 10, 10);
    Agencement.setAlignment(Pos.CENTER);
    Agencement.setColumnHalignment(HPos.CENTER);

    Label Message = new Label("");
    Agencement.getChildren().add(Message);
    Agencement.getChildren().add(new Separator());

    ArrayList<Button> numero = new ArrayList<>();
    ArrayList<Button> operateur = new ArrayList<>();

    FlowPane ligne1 = new FlowPane();
    ligne1.setAlignment(Pos.CENTER);
    Button touche7 = new Button("7");
    Button touche8 = new Button("8");
    Button touche9 = new Button("9");
    Button touchePlus = new Button("+");
    numero.add(touche7);
    numero.add(touche8);
    numero.add(touche9);
    operateur.add(touchePlus);
    ligne1.getChildren().addAll(touche7, touche8, touche9, touchePlus);

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
    ligne2.getChildren().addAll(touche4, touche5, touche6, toucheMoins);

    FlowPane ligne3 = new FlowPane();
    ligne3.setAlignment(Pos.CENTER);
    Button touche1 = new Button("1");
    Button touche2 = new Button("2");
    Button touche3 = new Button("3");
    Button toucheFois = new Button("*");
    numero.add(touche1);
    numero.add(touche2);
    numero.add(touche3);
    operateur.add(toucheFois);
    ligne3.getChildren().addAll(touche1, touche2, touche3, toucheFois);

    FlowPane ligne4 = new FlowPane();
    ligne4.setAlignment(Pos.CENTER);
    Button toucheE = new Button("E");
    Button touche0 = new Button("0");
    Button toucheEgale = new Button("=");
    Button toucheDiv = new Button("/");
    operateur.add(toucheE);
    operateur.add(toucheEgale);
    operateur.add(toucheDiv);
    numero.add(touche0);
    ligne4.getChildren().addAll(toucheE, touche0, toucheEgale, toucheDiv);

    Agencement.getChildren().addAll(ligne1, ligne2, ligne3, ligne4);
    Scene Scene_Principale = new Scene(Agencement, 300, 100);

    Scene_Principale.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
      public void handle(ActionEvent Evenement) {
        Button targget = (Button) Evenement.getTarget();
        if (targget == toucheE) {
          Message.setText("");
        } else if (targget == toucheEgale) {
          Message.setText(calculer(Message.getText()));
        } else {
          Message.setText(Message.getText() + targget.getText());
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