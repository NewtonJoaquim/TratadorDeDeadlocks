import java.io.IOException;
import java.util.ArrayList;

public class ExecutionManager {

	ArrayList<Integer> availableResources = new ArrayList<Integer>();
	
	ExecutionManager(ArrayList<Integer> availableResources){
		this.availableResources = availableResources;
	}
	
	public static void checkSafety(Banker b){
		if(b.safety() == true)
			System.out.println("Nao ha risco de ocorrencia de Deadlock");
		else
			System.out.println("Ha risco de ocorrencia de Deadlock");
	}
	
	public static void resourceRequest(Banker b, ArrayList<Integer> request, Process p){
		if(b.avoid(request, p) == true)
			System.out.println("Recursos alocados com sucesso para o processo "+p.getPID());
		else
			System.out.println("Solicitacao nao permitida. O Processo " + p.getPID()+ " espera");
	}
	
	public static void detectDeadlock(Banker b, ArrayList<Integer> request){
		if(b.detection(request).size() == 0)
			System.out.println("Nao ocorreu DeadLock");
		else
			System.out.println("Ocorreu DeadLock");
	}
	
	public static void main(String args[]) throws IOException{
		CSVHandler handler = new CSVHandler();
		ExecutionManager em = new ExecutionManager(handler.readResourcesFile("recursos.csv"));
		Banker b = new Banker(handler.readProcessesFile("processos.csv"), em.availableResources);
		
		Process testProcess = handler.readProcessesFile("processos.csv").get(2);
		
		checkSafety(b);
		//resourceRequest(b, handler.readResourcesFile("request.csv"), testProcess);
		//detectDeadlock(b, handler.readResourcesFile("request.csv"));
	}
}
