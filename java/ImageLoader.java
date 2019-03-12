import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
	
	// loads and returns an image at the given path
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

	// saves given image to path
	public static void saveImage(BufferedImage image, String path) {
		try {
			ImageIO.write(image, "PNG", new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	// return resized version of given image
	public static BufferedImage resize(BufferedImage im, int x, int y) {
		Image tmp = im.getScaledInstance(x, y, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return resized;
	}

}
