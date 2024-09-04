package application;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Main extends Application {
	private static TextField leftBanktext;
	private static TextField rightBanktext;
	public static int debth;
	@Override
	public void start(Stage primaryStage) {
		Font font = Font.font("Arial", FontWeight.BOLD, 15);
		Pane root = new Pane();
		Scene scene1 = new Scene(root, 400, 200);
		VBox Vbox1 = new VBox(40);
		Vbox1.setLayoutX(160);
		Vbox1.setLayoutY(40);
		Label lab = new Label("Solution For Missionaries And Cannibals Problem");
		lab.setFont(font);
		lab.setLayoutX(15);
		Button BFSB = new Button("BFS");
		BFSB.setFont(font);
		BFSB.setOnAction(e -> {
			Node root1 = new Node(3, 3, Position.LEFT, 0, 0);
			Button nextStepButton = new Button("GO");
			nextStepButton.setFont(font);
			Button back = new Button("Back");
			back.setFont(font);
			back.setOnAction(x->{
				primaryStage.setScene(scene1);
				primaryStage.show();
			});

			leftBanktext = new TextField();
			rightBanktext = new TextField();
			TextArea Txt=new TextArea();
			Txt.setEditable(false);
			Txt.setFont(font);
			Node n = BFS(root1);
			String[] soso = print(n);
			nextStepButton.setOnAction(event -> {
				
				nextStepButton.setText("Next Step");
				try {
					String[] Str = soso[debth].split(",");
					rightBanktext.setFont(font);
					leftBanktext.setFont(font);
					Txt.setText(Txt.getText()+soso[debth]+"\n");
					leftBanktext.setText("Left Bank: Cannibals " + Str[0] + " Missionaries " + Str[1]);
					rightBanktext.setText("Right Bank: Cannibals " + Str[3] + " Missionaries " + Str[4]);
					rightBanktext.setEditable(false);
					leftBanktext.setEditable(false);
					debth--;
				} catch (Exception e2) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Done");
					alert.setHeaderText("Congratulations, you have arrived");
					alert.showAndWait();
				}

			});

			VBox vbox = new VBox();
			vbox.setPadding(new Insets(10));
			vbox.setSpacing(15);
			
			vbox.getChildren().addAll(leftBanktext, rightBanktext, nextStepButton,Txt,back);
			Scene scene = new Scene(vbox, 400, 300);
			primaryStage.setTitle("BFS");
			primaryStage.setScene(scene);
			primaryStage.show();
		});
		Button DFSB = new Button("DFS");
		DFSB.setFont(font);
		DFSB.setOnAction(c -> {
			Node root1 = new Node(3, 3, Position.LEFT, 0, 0);
			DFS(root1);
			Button nextStepButton = new Button("GO");
			Button back = new Button("Back");
			back.setFont(font);
			back.setOnAction(x->{
				primaryStage.setScene(scene1);
				primaryStage.show();
			});
			nextStepButton.setFont(font);
			
			leftBanktext = new TextField();
			rightBanktext = new TextField();
			leftBanktext.setFont(font);
			rightBanktext.setFont(font);
			TextArea Txt=new TextArea();
			Txt.setEditable(false);
			Txt.setFont(font);
			Node n = BFS(root1);
			String[] soso = print(n);
			nextStepButton.setOnAction(event -> {
				nextStepButton.setText("Next Step");
				try {
					Txt.setText(Txt.getText()+soso[debth]+"\n");
					String[] Str = soso[debth].split(",");
					leftBanktext.setText("Left Bank: Cannibals " + Str[0] + " Missionaries " + Str[1]);
					rightBanktext.setText("Right Bank: Cannibals " + Str[3] + " Missionaries " + Str[4]);
					rightBanktext.setEditable(false);
					leftBanktext.setEditable(false);
					debth--;
				} catch (Exception e2) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Done");
					alert.setHeaderText("Congratulations, you have arrived");
					alert.showAndWait();
				}
			});

			VBox vbox = new VBox();
			vbox.setPadding(new Insets(10));
			vbox.setSpacing(15);
			vbox.getChildren().addAll(leftBanktext, rightBanktext, nextStepButton,Txt,back);
			Scene scene = new Scene(vbox, 400, 300);
			primaryStage.setTitle("DFS");
			primaryStage.setScene(scene);
			primaryStage.show();

		});
		Vbox1.getChildren().addAll(BFSB, DFSB);
		root.getChildren().addAll(lab, Vbox1);
		primaryStage.setScene(scene1);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	private static Node BFS(Node root) {
		BFS search = new BFS();
		Node Path = search.path(root);
		return Path;
	}

	private static Node DFS(Node root) {
		DFS search = new DFS();
		Node Path = search.Path(root);
		return Path;
	}

	private static String[] print(Node solution) {
		String[] nono = new String[100];

		if (solution != null) {
			{

				List<Node> path = new ArrayList<Node>();
				Node state = solution;
				while (state != null) {
					path.add(state);
					state = state.getParentState();
				}

				debth = path.size() - 1;
				for (int i = debth; i >= 0; i--) {
					state = path.get(i);
					if (state.isTarget()) {
						nono[i] = state.toString();
					} else {
						nono[i] = state.toString();

					}
				}

			}

		} else {
			System.out.println("No solution!");
		}

		return nono;
	}
}
