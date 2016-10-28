import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CSVHandler {
	public ArrayList<Process> readFile(String file) throws IOException{
		ArrayList<Process> processes= new ArrayList<Process>();
		
		ArrayList<Integer> allocatedResourcers = new ArrayList<Integer>();
		ArrayList<Integer> maxResourcers = new ArrayList<Integer>();
		
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while((line = br.readLine()) != null){
			String[] lineField = line.split(",");

			allocatedResourcers.add(Integer.parseInt(lineField[0]));
			allocatedResourcers.add(Integer.parseInt(lineField[1]));
			allocatedResourcers.add(Integer.parseInt(lineField[2]));
			maxResourcers.add(Integer.parseInt(lineField[3]));
			maxResourcers.add(Integer.parseInt(lineField[4]));
			maxResourcers.add(Integer.parseInt(lineField[5]));
			
			processes.add(new Process(allocatedResourcers, maxResourcers));
		}
		return processes;
	}
}