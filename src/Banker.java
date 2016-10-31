import java.util.ArrayList;

public class Banker {
	int numberOfProcesses, numberOfResourceTypes;
	
	int[] available; /*= new int[numberOfResourceTypes];*/
	int[][] max; /* = new int [numberOfProcesses][numberOfResourceTypes];*/
	int[][] allocation;/* = new int[numberOfProcesses][numberOfResourceTypes];*/
	int[][] need;/* = new int[numberOfProcesses][numberOfResourceTypes];*/
	
	public Banker(ArrayList<Process> processList, ArrayList<Integer> resources) {
		super();
		this.numberOfProcesses = processList.size();
		this.numberOfResourceTypes = resources.size();
		
		available = new int[numberOfResourceTypes];
		max = new int[numberOfProcesses][numberOfResourceTypes];
		allocation = new int[numberOfProcesses][numberOfResourceTypes];
		need = new int[numberOfProcesses][numberOfResourceTypes];
		
		for(int i = 0; i<numberOfProcesses; i++){
			for(int j = 0; j < numberOfResourceTypes; j++){
				available[j] = resources.get(j);
				max[i][j] = processList.get(i).getMaxResource(j);
				allocation[i][j] = processList.get(i).getAllocatedResource(j);
				need[i][j] = max[i][j] - allocation[i][j];
			}
		}	
	}
	
	public boolean safety(){
		int[] work = available;
		boolean[] finish = new boolean[numberOfProcesses];
		
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

	public boolean avoid(ArrayList<Integer> request, Process p){
		boolean availability = true;
		
		for(int i = 0; i< request.size(); i++){
			if(request.get(i) > need[p.getPID()][i]){
				availability = false;
			}
		}
		if(!availability){
			System.out.println("O Processo "+ p.getPID() +" excedeu o limite máximo de requisições");
			return false;
		}
		else{
			for(int i = 0; i< request.size(); i++){
				if(request.get(i) > available[i]){
					availability = false;
				}
			}
			if(!availability){
				p.setProcessToWait();
				System.out.println("O Processo" +p.getPID() + " Espera por recursos");
				return false;
			}
			else{
				for(int i = 0; i<numberOfResourceTypes; i++){
					available[i] = available[i] - request.get(i);
					allocation[p.getPID()][i] = allocation[p.getPID()][i] + request.get(i);
					need[p.getPID()][i] = need[p.getPID()][i] - request.get(i);
				}
				if(safety()){
					p.setProcessToReady();
					return true;
				}
				else{
					p.setProcessToWait();
					return false;
				}
			}
			
		}
	}
	
	public boolean detection(int[][] request){
		boolean FoundIndex = false;
		int[] work = available;
		boolean[] finish = new boolean[numberOfProcesses];
		
		for(int i = 0; i<numberOfProcesses;i++){
			for(int j = 0; j<numberOfResourceTypes; j++){
				if(allocation[i][j] != 0)
					finish[i] = false;
				else
					finish[i] = true;
			}
		}
		
		for(int i = 0; i < numberOfProcesses; i++){
			for(int j = 0; j<numberOfResourceTypes; j++){
				if((finish[i] == false)&&(request[i][j]<=work[j])){
					FoundIndex = true;
					work[j] = work[j] + allocation[i][j];
					finish[i] = true;
				}
			}
		}
		
		
		
		return false;
	}
	
}
