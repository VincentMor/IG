Tout: Squelette.class \
      Bonjour.class \
      Bonjour_Hello.class \
      Boutons.class \
      Boutons_Ligne.class \
      Boutons_Bascule.class \
      Case_Coche_Boutons_Radio.class \
      Souris_Touches.class \
      Cadre.class \
      Grille.class \
      Onglets.class \
      Defilement.class \
      Menus.class \
      Dialogue.class
      
clean:
	rm *.class
archive:
	tar cf ../exemples_java_fx.tar Makefile *.java *.css *.png *.jpg

Squelette.class: Squelette.java
	javac Squelette.java
Bonjour.class: Bonjour.java 
	javac Bonjour.java
Bonjour_Hello.class: Bonjour_Hello.java
	javac Bonjour_Hello.java
Boutons.class: Boutons.java
	javac Boutons.java
Boutons_Ligne.class: Boutons_Ligne.java
	javac Boutons_Ligne.java
Boutons_Bascule.class: Boutons_Bascule.java
	javac Boutons_Bascule.java
Case_Coche_Boutons_Radio.class: Case_Coche_Boutons_Radio.java
	javac Case_Coche_Boutons_Radio.java
Souris_Touches.class: Souris_Touches.java
	javac Souris_Touches.java
Cadre.class: Cadre.java
	javac Cadre.java
Grille.class: Grille.java
	javac Grille.java
Onglets.class: Onglets.java
	javac Onglets.java
Defilement.class: Defilement.java
	javac Defilement.java
Menus.class: Menus.java
	javac Menus.java
Dialogue.class: Dialogue.java
	javac Dialogue.java
