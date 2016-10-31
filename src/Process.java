import java.util.ArrayList;

public class Process {

	private int pID;
	
	private ArrayList<Integer> allocatedResources = new ArrayList<Integer>();
	private ArrayList<Integer> maxResources = new ArrayList<Integer>();

	private enum ProcessState{READY, WAIT};
	private ProcessState processState;

	public Process(int pID, ArrayList<Integer> allocatedResources, ArrayList<Integer> maxResources) {
		super();
		this.pID = pID;
		this.allocatedResources = allocatedResources;
		this.maxResources = maxResources;
		this.processState = ProcessState.READY;
	}

	public int getAllocatedResource(int i){
		return allocatedResources.get(i);
	}
	
	public int getMaxResource(int i){
		return maxResources.get(i);
	}
	
	public ProcessState getProcessState() {
		return processState;
	}

	public void setProcessToWait() {
		this.processState = ProcessState.WAIT;
	}
	
	public void setProcessToReady() {
		this.processState = ProcessState.READY;
	}
	
	public int getPID(){
		return this.pID;
	}
}
