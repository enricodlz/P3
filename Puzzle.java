import java.nio.file.Path;
import java.util.ArrayList;

public class Puzzle {

	IPuzzle puzzle;
	Path    outputPath;

	Puzzle(Path input, Path output) {
		ArrayList<String> inputContent = IOFile.readContent(input);
		outputPath = output;
		puzzle = new PConverted(inputContent);
	}

	public void solve(){
		puzzle = new PSolved(puzzle);
		puzzle = new PSorted(puzzle);
	}

	public void toFile(){
		try {
			if ( puzzle instanceof PConverted ){
				throw new PuzzleUnsolvedException("Puzzle non risolto. ");
			}
		}
		catch (PuzzleUnsolvedException e) {
			System.out.println(e.getReason() + "Provo a risolverlo...");
			solve();
		}

		puzzle = new PString(puzzle);

		String output = "";
		output += puzzle.toString()          + "\n\n";
		output += puzzle.toMultiLineString() + "\n\n";
		output += puzzle.getRow() + " " + puzzle.getCol();
		IOFile.writeContent(outputPath,output);
	}
}