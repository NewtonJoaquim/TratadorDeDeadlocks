import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CSVHandler {
	public ArrayList<Process> readProcessesFile(String file) throws IOException{
		
		int pID = 0;
		
		ArrayList<Process> processes= new ArrayList<Process>();
		
		ArrayList<Integer> allocatedResources;// = new ArrayList<Integer>();
		ArrayList<Integer> maxResources; //= new ArrayList<Integer>();
		String line;
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			while ((line = br.readLine()) != null){
				allocatedResources = new ArrayList<Integer>();
				maxResources = new ArrayList<Integer>();
				String[] lineField = line.split(",");
				
				allocatedResources.add(Integer.parseInt(lineField[0]));
				allocatedResources.add(Integer.parseInt(lineField[1]));
				allocatedResources.add(Integer.parseInt(lineField[2]));
				maxResources.add(Integer.parseInt(lineField[3]));
				maxResources.add(Integer.parseInt(lineField[4]));
				maxResources.add(Integer.parseInt(lineField[5]));
				
				processes.add(new Process(pID ,allocatedResources, maxResources));
				
				pID++;
			}
		}catch(Exception e){
			e.getMessage();
		}
		
		return processes;
	}
	
	public ArrayList<Integer> readResourcesFile(String file) throws IOException{
		ArrayList<Integer> resources = new ArrayList<Integer>();
		
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while((line = br.readLine()) != null){
			String[] lineField = line.split(",");

			resources.add(Integer.parseInt(lineField[0]));
			resources.add(Integer.parseInt(lineField[1]));
			resources.add(Integer.parseInt(lineField[2]));
		}
		return resources;
	}
	
	
}