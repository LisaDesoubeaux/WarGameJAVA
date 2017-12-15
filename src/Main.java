import java.util.Scanner;

import com.sun.javafx.geom.Rectangle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static Jeu jeu = new Jeu();
	private static Group droite = new Group();
	private static GridPane gauche = new GridPane();

	public static void main(String[] args) {
			launch(args);
		}
			
	public void start (Stage PrimaryStage) throws Exception{
		PrimaryStage.setTitle("My WG");
		HBox root = new HBox();
		droite=MenuPrincipale(PrimaryStage);
		root.getChildren().addAll(gauche,droite); 
		Scene scene = new Scene(root);
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
	}
	
	public static Group MenuPrincipale (Stage PrimaryStage) {
		Group group = new Group();
		VBox menu = new VBox();
		menu.setPrefWidth(250);
		menu.setPrefHeight(500);
		menu.setAlignment(Pos.CENTER);
		Button jeux = new Button("Nouvelle Partie");
		jeux.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				group.getChildren().remove(menu);
				group.getChildren().add(SelectionJoueur(PrimaryStage));
			}
		});
		
		Button quitter = new Button("Quitter");
		quitter.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				PrimaryStage.close();
			}
		});
		
		Text nom = new Text("Bienvenue dans le\nWARGAME\n");
		nom.setStyle("-fx-text-alignment:center;");
		
		menu.getChildren().add(nom);
		menu.getChildren().add(jeux);
		menu.getChildren().add(quitter);
		group.getChildren().add(menu);
		return group;
	}
	
	public static Group Joueur(int i){
		Group g = new Group();
		HBox j = new HBox();
		j.setPrefWidth(250);
		j.setAlignment(Pos.CENTER);
		ComboBox<String> nom = new ComboBox<String>();
		nom.getItems().setAll(jeu.listeSauvegarde());
		nom.setEditable(true);
		Button ok = new Button("OK");
		j.getChildren().addAll(nom,ok);
		ok.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				jeu.selectionJoueur(i,nom.getValue());
				j.getChildren().removeAll(nom,ok);
				Text t = new Text("\n"+jeu.getJ(i).getNom()+"\n");
				j.getChildren().add(t);
				
			}
		});
		g.getChildren().add(j);
		return g;
	}
	
	public static Group SelectionJoueur(Stage PrimaryStage){
		Group g = new Group();
		VBox select = new VBox();
		select.setPrefHeight(500);
		select.setAlignment(Pos.CENTER);
		Group j1 = Joueur(1);
		Group j2 =Joueur(2);
		Text t = new Text("VS");
		Button b = new Button("Commencer");
		b.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				if(jeu.getJ1()!=null && jeu.getJ2()!=null) {
					g.getChildren().remove(select);
					InitGame(PrimaryStage);
				}
			}
		});
		select.getChildren().addAll(j1,t,j2,b);
		g.getChildren().add(select);
		return g;
		
	}
	
	public static void InitGame(Stage PrimaryStage) {
		HBox root = new HBox();
		gauche = jeu.getTerrain().printFX();
		droite = InitJoueur(1);
		root.getChildren().addAll(gauche,droite); 
		Scene scene = new Scene(root);
		PrimaryStage.setScene(scene);
		PrimaryStage.show();

	}
	
	public static Group InitJoueur(int i) {
		Group g = new Group();
		VBox init = new VBox();
		init.setPrefSize(250,500);
		init.setAlignment(Pos.CENTER);
		Text t = new Text("Joueur "+i+"\n");
		Text cmd = new Text("Placer votre base \n");
		StackPane s = new StackPane();
		s.setStyle("-fx-background-color:black;");
		s.setPrefSize(5, 5);
		Button b = new Button(" Valider");
		init.getChildren().addAll(t,cmd,s,b);
		g.getChildren().add(init);
		return g;
	}

}
