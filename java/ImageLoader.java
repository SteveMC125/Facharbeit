
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Formatter;

import javax.imageio.ImageIO;

public class ImageLoader {
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

	public static void saveImage(BufferedImage image, String path) {
		try {
			ImageIO.write(image, "PNG", new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static BufferedImage resize(BufferedImage im, int x, int y) {
		Image tmp = im.getScaledInstance(x, y, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return resized;
	}

	public static void saveImageGrayscale(BufferedImage image, String path) {
		BufferedImage gray = image;

		int width = gray.getWidth();
		int height = gray.getHeight();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int p = gray.getRGB(x, y);

				int a = (p >> 24) & 0xff;

				int avg = toGrayscaleValue(gray, x, y);

				p = (a << 24) | (avg << 16) | (avg << 8) | avg;

				gray.setRGB(x, y, p);
			}
		}

		saveImage(gray, path);
	}

	public static void saveTensor(BufferedImage img, String path) {
		try {
			Formatter f = new Formatter(path);
			f.format(toArrayString(img));
			f.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static String toArrayString(BufferedImage img) {
		String out = "[";

		int w = img.getWidth();
		int h = img.getHeight();

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				out += toGrayscaleValue(img, x, y) + ", ";
			}
		}
		out = out.substring(0, out.length() - 2);
		out += "]";
		return out;
	}

	private static int toGrayscaleValue(BufferedImage img, int x, int y) {
		int p = img.getRGB(x, y);

		int r = (p >> 16) & 0xff;
		int g = (p >> 8) & 0xff;
		int b = p & 0xff;

		int avg = (r + g + b) / 3;

		return avg;
	}

	public static String ArrayToString(String[] strings) {
		String out = "";
		for (int i = 0; i < strings.length; i++) {
			out += strings[i] + ",";
		}
		return out;
	}

	public static String[] convertToArray(String str) {
		str = str.substring(1, str.length() - 1);
		String[] tmp = str.split(" ");
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = tmp[i].substring(0, 1);
		}
		return tmp;
	}
}
