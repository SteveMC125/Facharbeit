
import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;

	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}

	public BufferedImage cropPoints(int x1, int y1, int x2, int y2) {
		return sheet.getSubimage(x1, y1, x2 - x1, y2 - y1);
	}

	public BufferedImage cropWidth(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}

	@Override
	public String toString() {
		return sheet + "";
	}
}