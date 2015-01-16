import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;

public class IOFile {

	private static Charset charset = StandardCharsets.UTF_8;

	public static ArrayList<String> readContent(Path inputPath) {

		ArrayList<String> lines = new ArrayList<String>();

		try (BufferedReader reader = Files.newBufferedReader(inputPath,charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		}
		catch (IOException e) {
			System.err.println(e);
		}
		return lines;
	}

	public static void writeContent(Path file, String content) {
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
			writer.write(content);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
}