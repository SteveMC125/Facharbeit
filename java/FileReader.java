import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

	private File file;
	private BufferedReader reader;

	public FileReader(String filename) throws FileNotFoundException {
		file = new File(filename);
		reader = new BufferedReader(new java.io.FileReader(file));
	}

	public File getFile() {
		return file;
	}

	public BufferedReader getReader() {
		return reader;
	}

	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String read() {
		String out = null;

		try {
			out = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return out;
	}
}
