import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PuzzleSolver {

	public static void main (String args[]){

		new TesterInputException().error(args.length<=0,"richiesto 'java PuzzleSolver inputFile outputFile'");
		
		String inputFile  = args[0];
		String outputFile = args[1];

		Path inputPath  = Paths.get(inputFile);
		Path outputPath = Paths.get(outputFile);

		Puzzle p = new Puzzle(inputPath, outputPath);
		p.solve();
		p.toFile();
	}
}