import java.io.IOException;
import java.util.ArrayList;

public class ExecutionManager {

	ArrayList<Integer> availableResources = new ArrayList<Integer>();
	
	ExecutionManager(ArrayList<Integer> availableResources){
		this.availableResources = availableResources;
	}
	
	public static void checkSafety(Banker b){
		if(b.safety() == true)
			System.out.println("Não há risco de ocorrência de Deadlock");
		else
			System.out.println("Há risco de ocorrência de Deadlock");
	}
	
	public static void main(String args[]) throws IOException{
		CSVHandler handler = new CSVHandler();
		ExecutionManager em = new ExecutionManager(handler.readResourcesFile("recursos.csv"));
		Banker b = new Banker(handler.readProcessesFile("processos.csv"), em.availableResources);
		
		checkSafety(b);
	}
}
