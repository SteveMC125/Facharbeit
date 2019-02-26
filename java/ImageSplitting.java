import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ImageSplitting {

	private ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
	private static int Top, Height, Width, Spacer, Start, End;
	private BufferedImage image;

	public ImageSplitting(String path) {
		Top = 20;
		Height = 81;
		Width = 52;
		Spacer = 7;
		Start = 61;
		End = 536;
		image = ImageLoader.loadImage(path);
	}

	public String[][] split() {
		int x = Start;
		String[][] out = new String[7][Main.IMGSIZE * Main.IMGSIZE];

		images.add(image.getSubimage(x, Top, Width, Height)); // crop image
		x += Width + Spacer;

		images.add(image.getSubimage(x, Top, Width, Height));
		x += 2 * Width + 2 * Spacer;

		images.add(image.getSubimage(x, Top, Width, Height));
		x += Width + Spacer;

		images.add(image.getSubimage(x, Top, Width, Height));
		x += Width + (Width - 4 * Spacer);

		images.add(image.getSubimage(x, Top, Width, Height));
		x += Width;

		images.add(image.getSubimage(x, Top, Width, Height));
		x += Width + Spacer;

		images.add(image.getSubimage(x, Top, Width, Height));
		x += Width;

		if (x == End) {
			int i = 0;
			for (BufferedImage im : images) {
				BufferedImage img = ImageLoader.resize(im, Main.IMGSIZE, Main.IMGSIZE); // resize sliced image
				out[i] = ImageLoader.convertToArray(ImageLoader.toArrayString(img)); // save sliced image to array
				i++;
			}

		}

		return out;
	}

}
