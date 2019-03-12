import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyFile {

	private File file;
	private BufferedWriter writer;
	private String text;

	public MyFile(String filename) {
		file = new File(filename);
		try {
			writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File getFile() {
		return file;
	}

	public BufferedWriter getWriter() {
		return writer;
	}

	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getText() {
		return text;
	}

	// writes given string to File
	public MyFile write(String str) {
		try {
			writer.write(str);
			text += str + "|";
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
}
