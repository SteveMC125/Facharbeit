import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class Main {

	public static final int IMGSIZE = 64;
	public static BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
	private static String[][] testImages;
	private static JFileChooser chooser;
	private static MyFile testData;
	private static boolean closed = true;
	private static ImageSplitting splitter;
	private static MainGui gui;
	private static String pathToAnswer = "D:\\Bilder\\Tensorflow\\Data\\answerData.txt";
	private static String pathToTestData = "D:\\Bilder\\Tensorflow\\Data\\testData.csv";
	private static String pathToPythonScript = "C:\\Users\\steveMC\\Desktop\\Programme\\Programmieren\\python\\tensorflow-Facharbeit\\test.py";

	public static void main(String[] args) throws IOException {
		// TODO: create Python script
		gui = new MainGui();
	}

	public static void choose() {
		chooser = new JFileChooser("D:\\Bilder\\Tensorflow"); // create choosing pop-up
		testData = new MyFile(pathToTestData); // create File to send to python script
		closed = false;
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			splitter = new ImageSplitting(chooser.getSelectedFile().getAbsolutePath()); // create splitter
		} else {
			testData.close();
			closed = true;
			System.exit(1);
		}
		img = ImageLoader.loadImage(chooser.getSelectedFile().getAbsolutePath()); // load image to show
		gui.getImage().repaint(); // draw image
		gui.log("Loaded image");
		gui.changeSection();
	}

	public static void split() {
		testImages = splitter.split(); // split image
		gui.log("Split image");
		gui.changeSection();
	}

	public static void saveSplits() {
		for (int i = 0; i < testImages.length; i++) {
			String tmp = ImageLoader.ArrayToString(testImages[i]); // Stringify Array
			testData.write(tmp.substring(0, tmp.length() - 1) + "\n"); // write data
		}
		gui.log("Saved split image");
		gui.changeSection();
	}

	public static void runNN() {
//		gui.log("*this function is not yet implemented*");
		try {
			Runtime.getRuntime().exec("python " + pathToPythonScript); // call python script
			gui.log("Executed Python script");
			useData();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	private static void useData() {
		gui.changeSection();
		FileReader read = null;
		boolean gotAnswer = true;
		try {
			read = new FileReader(pathToAnswer); // create reader
		} catch (FileNotFoundException e) {
			gui.log("*Could´nt find Answer*");
			gotAnswer = false;
		}
		if (gotAnswer) {
			ArrayList<String> answers = new ArrayList<String>();
			ArrayList<Integer> answerLabels = new ArrayList<Integer>();
			ArrayList<String> answerStrings = new ArrayList<String>();
			String l;
			while ((l = read.read()) != null) {
				answers.add(l); // add line
				answerLabels.add(processAnswer(l)); // add label
				answerStrings.add(interpret(processAnswer(l))); // add number | character
			}
			read.close();
			gui.log("Answer from Python script:");
			for (String s : answers) {
				gui.log(s); // print answer
			}
			gui.log("Intepreted:");
			int i = 1;
			for (Integer in : answerLabels) {
				gui.log(i + ". answerline: " + interpret(in)); // print interpreted answer
				i++;
			}
			i = 0;
			boolean translated = true;
			boolean t = false;
			gui.log("License Plate:");
			String plate = "n/a";
			for (String st : answerStrings) {
				if (st.equals("n/a") || answerStrings.size() != 7) {
					gui.log("!!!The license plate could not be put together.!!!");
					gui.log("!!!Check if you´ve got 7 answers an all of them are smaller than 36!!!");
					translated = false;
					break;
				}
				if (!t) {
					plate = "";
					t = true;
				}
				plate += st; // put license plate back together
				if (i == 1) {
					plate += "-";
				}
				if (i == 3) {
					plate += " ";
				}
				i++;
			}
			if (translated)
				gui.log(plate); // print license plate
		}
		gui.changeSection();
	}

	private static int processAnswer(String answer) {
		int ind = -1;
		String[] labels = answer.split(",");
		for (int i = 0; i < labels.length; i++) {
			if (labels[i].equals("1")) { // find 1 in answerline
				ind = i;
				break;
			}
		}
		return ind;
	}

	private static String interpret(int in) {
		String an = "n/a";
		switch (in) { // interpret index of 1 in answerline
		case 0:
			an = "0";
			break;
		case 1:
			an = "1";
			break;
		case 2:
			an = "2";
			break;
		case 3:
			an = "3";
			break;
		case 4:
			an = "4";
			break;
		case 5:
			an = "5";
			break;
		case 6:
			an = "6";
			break;
		case 7:
			an = "7";
			break;
		case 8:
			an = "8";
			break;
		case 9:
			an = "9";
			break;
		case 10:
			an = "A";
			break;
		case 11:
			an = "B";
			break;
		case 12:
			an = "C";
			break;
		case 13:
			an = "D";
			break;
		case 14:
			an = "E";
			break;
		case 15:
			an = "F";
			break;
		case 16:
			an = "G";
			break;
		case 17:
			an = "H";
			break;
		case 18:
			an = "I";
			break;
		case 19:
			an = "J";
			break;
		case 20:
			an = "K";
			break;
		case 21:
			an = "L";
			break;
		case 22:
			an = "M";
			break;
		case 23:
			an = "N";
			break;
		case 24:
			an = "O";
			break;
		case 25:
			an = "P";
			break;
		case 26:
			an = "Q";
			break;
		case 27:
			an = "R";
			break;
		case 28:
			an = "S";
			break;
		case 29:
			an = "T";
			break;
		case 30:
			an = "U";
			break;
		case 31:
			an = "V";
			break;
		case 32:
			an = "W";
			break;
		case 33:
			an = "X";
			break;
		case 34:
			an = "Y";
			break;
		case 35:
			an = "Z";
			break;
		}

		return an;
	}

	public static void closeApplication() {
		if (!closed) {
			testData.close();
		}
		System.exit(0);
	}
}
