import java.util.ArrayList;

public class Banker {
	int numberOfProcesses, numberOfResourceTypes;
	
	int[] available = new int[numberOfResourceTypes];
	
	int[][] max = new int [numberOfProcesses][numberOfResourceTypes];
	
	int[][] allocation = new int[numberOfProcesses][numberOfResourceTypes];
	
	int[][] need = new int[numberOfProcesses][numberOfResourceTypes];
	
	public Banker(ArrayList<Process> processList, ArrayList<Integer> resources) {
		super();
		this.numberOfProcesses = processList.size();
		this.numberOfResourceTypes = resources.size();
		
		//SETTING VECTOR AND MATRIXES
		for(int i = 0; i<numberOfProcesses; i++){
			for(int j = 0; j < numberOfResourceTypes; j++){
				available[i] = resources.get(i);
				max[i][j] = processList.get(i).getMaxResource(j);
				allocation[i][j] = processList.get(i).getAllocatedResource(j);
				need[i][j] = max[i][j] - allocation[i][j];
			}
		}	
	}
	
	public boolean safety(){
		int[] work = available;
		boolean finish[] = new boolean[numberOfProcesses];
		
		for(int i = 0; i < numberOfProcesses; i++){
			finish[i] = false;
		}
		
		for(int i = 0; i < numberOfProcesses; i++){
			for(int j = 0; j < numberOfResourceTypes; j++){
				
				if((finish[i] == false) && (need[i][j] <= work[i])){
					
					for(int x = 0; x < numberOfProcesses; x++){
						for(int y = 0; y< numberOfResourceTypes; y++){
							work[y] += allocation[x][y];
						}
					}
					finish[i] = true;
				}
			}
		}
		
		boolean aux = true;
		
		for(int i = 0; i<numberOfProcesses;i++){
			if(finish[i] == false)
				aux = false;
		}
		if(aux == true)
			return true;
		return false;
	}

}
