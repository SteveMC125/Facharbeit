import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;

public class Main {

	public static final int IMGSIZE = 64;
	public static BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
	private static BufferedImage[] testImages;
	private static JFileChooser chooser;
	private static ImageSplitting splitter;
	private static MainGui gui;
	private static String pathToAnswer = "D:\\Bilder\\Tensorflow\\Data\\answerData.txt";
	private static String pathToTestDataDir = "D:\\Bilder\\Tensorflow\\Data\\testImages\\";
	private static String pathToPythonScript = "C:\\Users\\steveMC\\Desktop\\Programme\\Programmieren\\python\\tensorflow-Facharbeit\\script.py";

	// main method, calls gui
	public static void main(String[] args) throws IOException {
		gui = new MainGui();
	}

	// chooses the image to cut and prepares it
	public static void choose() {
		chooser = new JFileChooser("D:\\Bilder\\Tensorflow"); // create choosing pop-up
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			splitter = new ImageSplitting(chooser.getSelectedFile().getAbsolutePath()); // create splitter
		} else {
			System.exit(1);
		}
		img = ImageLoader.loadImage(chooser.getSelectedFile().getAbsolutePath()); // load image to show
		gui.getImage().repaint(); // draw image
		gui.log("Loaded image");
		gui.changeSection();
	}

	// cuts the choosen image
	public static void split() {
		testImages = splitter.split(); // split image
		gui.log("Split image");
		gui.changeSection();
	}

	// saves the cuts
	public static void saveSplits() {
		int i = 0;
		for (BufferedImage img : testImages) {
			ImageLoader.saveImage(img, pathToTestDataDir + "bild" + i + ".png");
			i++;
		}
		gui.log("Saved split image under ");
		gui.log("            " + pathToTestDataDir);
		gui.changeSection();
	}

	// run the python script and interprets its result
	public static void runNN() {
		try {
			Runtime.getRuntime().exec("python " + pathToPythonScript); // call python script
			Thread.sleep(1800);
			gui.log("Executed Python script");
			useData();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// interpret result of NN
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
			String[] answers = new String[7];
			for (int i = 0; i < 7; i++) {
				answers[i] = read.read();
			}
			read.close();
			if (answers.length != 7) {
				gui.log("didn´t get correctly formatted answer");
				gui.changeSection();
				return;
			}
			String plate = "";
			for (String answer : answers) {
				plate += answer;
				if (plate.length() == 2) {
					plate += "-";
				}
				if (plate.length() == 5) {
					plate += " ";
				}
			}
			gui.log("the License plate spelled out is:");
			gui.log("    " + plate);
			gui.changeSection();
			gui.setRunned(false).setSaved(false).setSplit(false).setChoosen(false);
			return;
		}
		gui.log("couldn´t find file");
		gui.changeSection();
	}

	public static void closeApplication() {
		System.exit(0);
	}
}
