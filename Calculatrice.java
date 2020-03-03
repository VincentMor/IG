import java.util.List;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
import java.util.ArrayList;

public class Calculatrice extends Application {

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

    FlowPane ligne1 = new FlowPane();
    ligne1.setAlignment(Pos.CENTER);
    Button touche7 = new Button("7");
    touche7.setOnAction((ActionEvent Evenement) -> {
      Message.setText(Message.getText() + "7");
    });
    Button touche8 = new Button("8");
    touche8.setOnAction((ActionEvent Evenement) -> {
      Message.setText(Message.getText() + "8");
    });
    Button touche9 = new Button("9");
    touche9.setOnAction((ActionEvent Evenement) -> {
      Message.setText(Message.getText() + "9");
    });
    Button touchePlus = new Button("+");
    ligne1.getChildren().addAll(touche7, touche8, touche9, touchePlus);

    FlowPane ligne2 = new FlowPane();
    ligne2.setAlignment(Pos.CENTER);
    touchePlus.setOnAction((ActionEvent Evenement) -> {
      Message.setText(Message.getText() + "+");
    });
    Button touche4 = new Button("4");
    touche4.setOnAction((ActionEvent Evenement) -> {
      Message.setText(Message.getText() + "4");
    });
    Button touche5 = new Button("5");
    touche5.setOnAction((ActionEvent Evenement) -> {
      Message.setText(Message.getText() + "5");
    });
    Button touche6 = new Button("6");
    touche6.setOnAction((ActionEvent Evenement) -> {
      Message.setText(Message.getText() + "6");
    });
    Button toucheMoins = new Button("-");
    toucheMoins.setOnAction((ActionEvent Evenement) -> {
      Message.setText(Message.getText() + "-");
    });
    ligne2.getChildren().addAll(touche4, touche5, touche6, toucheMoins);

    FlowPane ligne3 = new FlowPane();
    ligne3.setAlignment(Pos.CENTER);
    Button touche1 = new Button("1");
    touche1.setOnAction((ActionEvent Evenement) -> {
      Message.setText(Message.getText() + "1");
    });
    Button touche2 = new Button("2");
    touche2.setOnAction((ActionEvent Evenement) -> {
      Message.setText(Message.getText() + "2");
    });
    Button touche3 = new Button("3");
    touche3.setOnAction((ActionEvent Evenement) -> {
      Message.setText(Message.getText() + "3");
    });
    Button toucheFois = new Button("*");
    toucheFois.setOnAction((ActionEvent Evenement) -> {
      Message.setText(Message.getText() + "*");
    });
    ligne3.getChildren().addAll(touche1, touche2, touche3, toucheFois);

    FlowPane ligne4 = new FlowPane();
    ligne4.setAlignment(Pos.CENTER);
    Button toucheE = new Button("E");
    toucheE.setOnAction((ActionEvent Evenement) -> {
      Message.setText("");
    });
    Button touche0 = new Button("0");
    touche0.setOnAction((ActionEvent Evenement) -> {
      Message.setText(Message.getText() + "0");
    });
    Button toucheEgale = new Button("=");
    toucheEgale.setOnAction((ActionEvent Evenement) -> {
      Message.setText(calculer(Message.getText()));
    });
    Button toucheDiv = new Button("/");
    toucheDiv.setOnAction((ActionEvent Evenement) -> {
      Message.setText(Message.getText() + "/");
    });
    ligne4.getChildren().addAll(toucheE, touche0, toucheEgale, toucheDiv);

    Agencement.getChildren().addAll(ligne1, ligne2, ligne3, ligne4);
    Scene Scene_Principale = new Scene(Agencement, 300, 100);
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