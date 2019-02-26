import java.awt.image.BufferedImage;

public class TestDataCreator {

	public static int classes = 36;
	public static int startClass = 0;
	public static int nImages = 1016;
	public static int img_size = 64;
	public static String rootPath = "D:\\Bilder\\Tensorflow\\training\\dataset\\trainImages";
	public static String numberFolderPath = rootPath + "\\zahlen";
	public static String charFolderPath = rootPath + "\\buchstaben\\upper";
	public static MyFile file = new MyFile("D:\\Bilder\\Tensorflow\\Data\\MyTrainSet.csv");

	public static void main(String[] args) {
		// write test data
		BufferedImage tmp = null;
		String str;
		int t = 1;
		for (int i = startClass; i < classes; i++) {
			for (int j = 0; j < nImages; j++) {
				// write numbers
				if (i < 10) {
					tmp = ImageLoader.loadImage(numberFolderPath + "\\" + i + "\\img" + String.format("%03d", i + 1)
							+ "-" + String.format("%05d", j + 1) + ".png");
					// write chars
				} else {
					switch (i) {
					case 10:
						tmp = ImageLoader.loadImage(charFolderPath + "\\A\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 11:
						tmp = ImageLoader.loadImage(charFolderPath + "\\B\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 12:
						tmp = ImageLoader.loadImage(charFolderPath + "\\C\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 13:
						tmp = ImageLoader.loadImage(charFolderPath + "\\D\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 14:
						tmp = ImageLoader.loadImage(charFolderPath + "\\E\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 15:
						tmp = ImageLoader.loadImage(charFolderPath + "\\F\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 16:
						tmp = ImageLoader.loadImage(charFolderPath + "\\G\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 17:
						tmp = ImageLoader.loadImage(charFolderPath + "\\H\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 18:
						tmp = ImageLoader.loadImage(charFolderPath + "\\I\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 19:
						tmp = ImageLoader.loadImage(charFolderPath + "\\J\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 20:
						tmp = ImageLoader.loadImage(charFolderPath + "\\K\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 21:
						tmp = ImageLoader.loadImage(charFolderPath + "\\L\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 22:
						tmp = ImageLoader.loadImage(charFolderPath + "\\M\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 23:
						tmp = ImageLoader.loadImage(charFolderPath + "\\N\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 24:
						tmp = ImageLoader.loadImage(charFolderPath + "\\O\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 25:
						tmp = ImageLoader.loadImage(charFolderPath + "\\P\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 26:
						tmp = ImageLoader.loadImage(charFolderPath + "\\Q\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 27:
						tmp = ImageLoader.loadImage(charFolderPath + "\\R\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 28:
						tmp = ImageLoader.loadImage(charFolderPath + "\\S\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 29:
						tmp = ImageLoader.loadImage(charFolderPath + "\\T\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 30:
						tmp = ImageLoader.loadImage(charFolderPath + "\\U\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 31:
						tmp = ImageLoader.loadImage(charFolderPath + "\\V\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 32:
						tmp = ImageLoader.loadImage(charFolderPath + "\\W\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 33:
						tmp = ImageLoader.loadImage(charFolderPath + "\\X\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 34:
						tmp = ImageLoader.loadImage(charFolderPath + "\\Y\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					case 35:
						tmp = ImageLoader.loadImage(charFolderPath + "\\Z\\img" + String.format("%03d", i + 1) + "-"
								+ String.format("%05d", j + 1) + ".png");
						break;
					}

				}
				tmp = ImageLoader.resize(tmp, img_size, img_size);
				str = ImageLoader.ArrayToString(ImageLoader.convertToArray(ImageLoader.toArrayString(tmp)));
				file.write(str + i + "\n");
				System.out.println("Class: " + (i + 1) + ", Image: " + (j + 1) + " || total: " + t + " of "
						+ (classes * nImages - (startClass * nImages)));
				t++;
			}
			System.out.println("class: " + (i + 1));
		}
		file.close();
		System.out.println("Done");
	}
}
