import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class Drive extends Application {
	public File BabyFile;
	public AVLClass avl = new AVLClass();

	public static void main(String[] args) {
//
//		System.out.println("hayyyyyyyyyyyyyy");
//
//		frecuans frec1 = new frecuans(2001, 10);
//		Babys b1 = new Babys("Zemar", "M");
//
//		frecuans frec2 = new frecuans(2005, 10);
//		Babys b2 = new Babys("Bil", "M");
//
//		frecuans frec3 = new frecuans(1970, 10);
//		Babys b3 = new Babys("Alid", "F");
//
//		frecuans frec4 = new frecuans(2009, 10);
//		Babys b4 = new Babys("Yaseem", "F");
//
//		frecuans frec5 = new frecuans(2004, 10);
//		Babys b5 = new Babys("Marwan", "F");
//
//		frecuans frec6 = new frecuans(2005, 10);
//		Babys b6 = new Babys("moha", "F");
//
//		avl.insert(b1, frec1);
//		avl.insert(b2, frec2);
//		avl.insert(b3, frec3);
//		avl.insert(b4, frec4);
//		avl.insert(b5, frec5);
//		avl.insert(b6, frec6);
//
//		avl.preOrder();
//		avl.find("Yaseem", "F");
		Application.launch(args);
	}

	@Override
	public void start(Stage wind) throws Exception {
		BorderPane bp0 = new BorderPane();
		bp0.setPadding(new Insets(30));
		bp0.setId("pane1");
		Scene scene0 = new Scene(bp0, 400, 600);
		scene0.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());

		BorderPane bp1 = new BorderPane();
		bp1.setId("pane2");
		Scene scene1 = new Scene(bp1, 400, 600);
		scene1.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());

		BorderPane bp2 = new BorderPane();
		bp2.setId("pane2");
		Scene scene2 = new Scene(bp2, 800, 500);
		BorderPane bp3 = new BorderPane();
		Scene scene3 = new Scene(bp3, 800, 500);
		BorderPane bp4 = new BorderPane();
		Scene scene4 = new Scene(bp4, 400, 600);
		BorderPane bp5 = new BorderPane();
		Scene scene5 = new Scene(bp5, 400, 600);

		// File Chooser
		FileChooser fileChooser;
		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text File ", "*txt"),
				new ExtensionFilter("Exil Fil e ", "*.csv"));

	//	Label TopLabel1 = new Label("Please choose a process");
//		TopLabel1.setFont(new Font(22));
//		bp1.setTop(TopLabel1);
//		BorderPane.setAlignment(TopLabel1, Pos.CENTER);

		// Button
		Button menub = new Button("Back");
		Button browse = new Button("Please choose a Baby File");
	//	browse.setId("button2");
		Button newYear = new Button("Add Year Data");
		Button SearchBaby = new Button("Search for a Name");
		Button averageBaby = new Button("Average Frequencies of a Name");
		Button maxFrequency = new Button("Name with max frequency");
		Button totalBaby = new Button("Total number of babies");
		Button saveFile = new Button("Save Data");
		Button exit = new Button("Exit");

		// First Secne
		VBox fs = new VBox();
		fs.setSpacing(15);

		fs.getChildren().addAll(browse);
		fs.setAlignment(Pos.CENTER);
		bp0.setBottom(fs);

		// Menu
		VBox ss = new VBox();
		ss.setSpacing(15);
		ss.getChildren().addAll( SearchBaby, averageBaby, maxFrequency, totalBaby, newYear, saveFile, exit);
		ss.setAlignment(Pos.CENTER);
		bp1.setCenter(ss);

		
		// Search for a Name Window
		Button search = new Button("Search Baby");
		search.setFont(new Font(15));
		GridPane gp2 = new GridPane();
		Label result = new Label();
		result.setFont(new Font(13));
		gp2.setVgap(15);
		gp2.setHgap(5);
		gp2.add(new Label("Baby Name "), 0, 0); // label
		gp2.add(new Label("Baby Gender "), 0, 1);
		TextField bName = new TextField();
		gp2.add(bName, 1, 0);
		gp2.add(search, 1, 2);
		ComboBox<String> gender = new ComboBox<String>();
		gender.getItems().addAll("M", "F");
		gp2.add(gender, 1, 1);
		gp2.add(result, 0, 3);
		gender.getSelectionModel().select(1);
		bp2.setCenter(gp2);
		gp2.setAlignment(Pos.CENTER);

		// Average Frequencies of a Name Window
		Button avareg = new Button("Average Frequencies");
		avareg.setFont(new Font(13));
		GridPane gp3 = new GridPane();
		Label avgFre = new Label();
		avgFre.setFont(new Font(22));
		gp3.setVgap(15);
		gp3.setHgap(5);
		gp3.add(new Label("Baby Name "), 0, 0); // label
		gp3.add(new Label("Baby Gender "), 0, 1);
		TextField bNameA = new TextField();
		gp3.add(bNameA, 1, 0);
		gp3.add(avareg, 1, 2);
		gp3.add(avgFre, 1, 3);
		ComboBox<String> genderA = new ComboBox<String>();
		genderA.getItems().addAll("M", "F");
		gp3.add(genderA, 1, 1);
		genderA.getSelectionModel().select(1);
		bp3.setCenter(gp3);
		gp3.setAlignment(Pos.CENTER);

		// Max Frecuansy Window
		Button maxF = new Button("Max Frequencies");
		maxF.setFont(new Font(15));
		GridPane gp4 = new GridPane();
		Label maxxFre = new Label();
		maxxFre.setFont(new Font(18));
		gp4.setVgap(15);
		gp4.setHgap(5);
		gp4.add(new Label("Click to show the Maximum Free quency Name "), 0, 0); // label
		gp4.add(maxF, 0, 1);
		gp4.add(maxxFre, 0, 2);
		bp4.setCenter(gp4);
		gp4.setAlignment(Pos.CENTER);

		// Total Baby Number By Year Window
		Button findTotal = new Button("Find Total");
		findTotal.setFont(new Font(15));
		Label BabyYearr = new Label();
		GridPane gp5 = new GridPane();
		gp5.setVgap(15);
		gp5.setHgap(5);
		gp5.add(new Label("Please enter the Year"), 0, 0); // label
		TextField yearT = new TextField();
		gp5.add(yearT, 1, 0);
		gp5.add(findTotal, 1, 2);
		gp5.add(BabyYearr, 1, 3);

		bp5.setCenter(gp5);
		gp5.setAlignment(Pos.CENTER);

		// Button Actions

		// Back Button Action
		menub.setOnAction(e -> {
			wind.setScene(scene1);
		});

		// Add new Year Button
		newYear.setOnAction(e -> {
			BabyFile = fileChooser.showOpenDialog(wind);
			String S = BabyFile.getName();
			String numberOnly = S.replaceAll("[^0-9]", "");

			if (BabyFile.exists()) {
				Scanner in;
				try {
					in = new Scanner(BabyFile);
					String[] t;
					while (in.hasNext()) {
						t = in.nextLine().trim().split(",");
						if (t.length == 3) {

							if (avl.findfind(t[0].trim(), t[1].trim()) == null) {
								Babys newBaby = new Babys(t[0].trim(), t[1].trim());
								frecuans newfrecuans = new frecuans(Integer.parseInt(numberOnly.trim()),
										Integer.parseInt(t[2].trim()));
								avl.insert(newBaby, newfrecuans);
							}

							else {

								NodeAVL sa = avl.findfind(t[0].trim(), t[1].trim());
								String j = sa.getData().getName();
								

								if (t[0].trim().equals(j.trim())) {
									frecuans newfrecuans = new frecuans(Integer.parseInt(numberOnly.trim()),
											Integer.parseInt(t[2].trim()));
									avl.insertList2(sa, newfrecuans);

								}
								// insert to linked list on the avl node
							}

						}
					}
				} catch (FileNotFoundException e1) {
					System.out.println(e1);
				}
				wind.setScene(scene1);
			} else
				wind.setScene(scene0);
			avl.preOrder();
		});

		// Brows Button
		browse.setOnAction(e -> {
			BabyFile = fileChooser.showOpenDialog(wind);
			String S = BabyFile.getName();
			String numberOnly = S.replaceAll("[^0-9]", "");

			if (BabyFile.exists()) {
				Scanner in;
				try {
					in = new Scanner(BabyFile);
					String[] t;
					while (in.hasNext()) {
						t = in.nextLine().trim().split(",");
						if (t.length == 3) {
							Babys newBaby = new Babys(t[0].trim(), t[1].trim());
							frecuans newfrecuans = new frecuans(Integer.parseInt(numberOnly.trim()),
									Integer.parseInt(t[2].trim()));
							avl.insert(newBaby, newfrecuans);
						}
					}
				} catch (FileNotFoundException e1) {
					System.out.println(e1);
				}
				wind.setScene(scene1);
			} else
				wind.setScene(scene0);
			avl.preOrder();

		});
		
		
		// Save File Button
		saveFile.setOnAction(e -> {
			FileChooser fileChoosers = new FileChooser();
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
			fileChoosers.getExtensionFilters().add(extFilter);

			File file = fileChoosers.showSaveDialog(wind);

			if (file != null) {
				avl.printLevelOrder(avl.root);
				saveTextToFile(avl.SAVL, file);
			}
		});

		// Search Action
		SearchBaby.setOnAction(e -> {
			bp2.setBottom(menub);
			wind.setScene(scene2);
		});

		search.setOnAction(e -> {
			NodeAVL babeFind = avl.findfind(bName.getText(), gender.getSelectionModel().getSelectedItem());
			if (babeFind == null) {
				System.out.println("Sorry we cant Find the baby");
				result.setText("Sorry we cant Find the baby \nMake sure the name is spelled correctly");
			}
			else {
				String S =babeFind.list.toString();
				result.setText("We Find Baby\n"+babeFind.getData()+S);
				System.out.println("We Find Baby");
				
			}

			// System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		});

		// Avareg Action
		averageBaby.setOnAction(e -> {
			bp3.setBottom(menub);
			wind.setScene(scene3);
		});

		avareg.setOnAction(e -> {
			NodeAVL averegFre = avl.findfind(bNameA.getText(), genderA.getSelectionModel().getSelectedItem());
			if (averegFre == null) {
				System.out.println("Sorry we cant Find the baby");
			avgFre.setText("Sorry we cant Find the baby \nMake sure the name is spelled correctly");}
			else {
				int size = averegFre.list.Size();
				int totalFrec = 0;
				double avg = 0;
				Node curr = averegFre.list.first;
				while (curr != null) {
					totalFrec += curr.getData().getFrec();
					curr = curr.getNext();
				}
				avg = (double) totalFrec / (double) size;
				avgFre.setText("Average Frequencies =" + avg);
				System.out.println("Average Frequencies =" + avg);
				
				
			}
		});

		// Max Frequency Action
		maxFrequency.setOnAction(e -> {
			bp4.setBottom(menub);
			wind.setScene(scene4);
		});

		maxF.setOnAction(e -> {
//			String x =avl.max();
//			System.out.println("its Maaax "+x);
			avl.max2();
			String x2 = avl.maxNode.getData().getName();
			int x = avl.maxFree2;
			maxxFre.setText("The maximum frequencies Name is " + x2 + "\nWith " + x + " frequencie");
			System.out.println("The maximum frequencies Name is " + x2 + " With " + x + " frequencie");
		});

		// Total Baby Action
		totalBaby.setOnAction(e -> {
			bp5.setBottom(menub);
			wind.setScene(scene5);
		});
		findTotal.setOnAction(e -> {
			int yx = Integer.parseInt(yearT.getText());
			avl.total(Integer.parseInt(yearT.getText()));
			int y = avl.yearCounter;
			if(avl.yearCounter !=0) {
			System.out.println("Total Number is = " + y);
			BabyYearr.setText("The Total Baby Number in "+yx+" is : "+ y);
			avl.yearCounter = 0;
			}
			else
				BabyYearr.setText("Ther is No baby Name In This Year \nPlease Chick The Baby Year File Data \nThanks !");
			
		});

		// Exit
		exit.setOnAction(e -> { // Exit Button
			wind.close();
		});

		wind.setScene(scene0);
		wind.setTitle("Baby Frequency");
		wind.getIcons().add(new Image("icon.png"));

		wind.show();
	} // end of Stage function

	private void saveTextToFile(String content, File file) {
		try {
			PrintWriter writer;
			writer = new PrintWriter(file);
			writer.println(content);
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
