import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Interface extends Application{
	
	private static Jeu jeu;
	
	public static void main(String[] args) {
		jeu = new Jeu();
		launch(args);
	}
	
	public void start (Stage PrimaryStage) throws Exception{
		PrimaryStage.setTitle("My WG");
		PrimaryStage.setFullScreen(true);
		Group root= new Group();
		Scene scene = new Scene(root);
		scene.setFill(Color.CYAN);
		MenuPrincipale(PrimaryStage);
		PrimaryStage.show();
	}
	
	public void MenuPrincipale (Stage PrimaryStage) {
		Group group = new Group();
		VBox menu = new VBox();
		Button jeux = new Button("Nouvelle Partie");
		jeux.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				group.getChildren().remove(menu);
				MenuLancerPartie(PrimaryStage);
				PrimaryStage.show();
			}
		});
		Button quitter = new Button("Quitter");
		quitter.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				PrimaryStage.close();
			}
		});
		menu.getChildren().add(jeux);
		menu.getChildren().add(quitter);
		group.getChildren().add(menu);
		PrimaryStage.setScene(new Scene(group));
	}
	
	public void MenuLancerPartie(Stage PrimaryStage) {
		Group group = new Group();
		GridPane grid = new GridPane();
		
		HBox j1 = new HBox();
		ComboBox<String> nom1 = new ComboBox<String>();
		nom1.getItems().setAll(jeu.listeSauvegarde());
		nom1.setEditable(true);
		HBox j2 = new HBox();
		ComboBox<String> nom2 = new ComboBox<String>();
		nom2.getItems().setAll(jeu.listeSauvegarde());
		nom2.setEditable(true);
		Button ok1 = new Button("OK");
		ok1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				grid.getChildren().remove(j1);
				jeu.selectionJoueur(1,nom1.getValue());
				Text j1 = new Text(jeu.getJ1().getNom());
				ComboBox<String> combat = new ComboBox<String>();
				for(int i=0;i<jeu.getJ1().getDispoCombat();i++) {
					combat.getItems().setAll(Integer.toString(i));
				}
				ComboBox<String> recherche = new ComboBox<String>();
				for(int i=0;i<jeu.getJ1().getDispoRecherche();i++) {
					recherche.getItems().setAll(Integer.toString(i));
				}
				Button ok = new Button("OK");
				GridPane.setConstraints(j1,0,0);
				grid.getChildren().add(j1);
				GridPane.setConstraints(combat,0,1);
				grid.getChildren().add(combat);
				GridPane.setConstraints(recherche,0,2);
				grid.getChildren().add(recherche);
				GridPane.setConstraints(ok,0,3);
				grid.getChildren().add(ok);
			}
		});
		Button ok2 = new Button("OK");
		ok2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				grid.getChildren().remove(j2);
				jeu.selectionJoueur(2,nom2.getValue());
				Text j2 = new Text(jeu.getJ2().getNom());
				GridPane.setConstraints(j2,1,0);
				grid.getChildren().add(j2);
			}
		});
		j1.getChildren().addAll(nom1, ok1);
		j2.getChildren().addAll(nom2, ok2);
		ColumnConstraints cc = new ColumnConstraints(300);
		cc.setHalignment(HPos.CENTER);
		GridPane.setConstraints(j1,0,0);
		grid.getColumnConstraints().add(cc);
		grid.getChildren().add(j1);
		GridPane.setConstraints(j2,1,0);
		grid.getColumnConstraints().add(cc);
		grid.getChildren().add(j2);
		group.getChildren().add(grid);
		PrimaryStage.setScene(new Scene(group));
		
		
		
	}
	
}

