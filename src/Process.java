import java.util.ArrayList;

public class Process {

	private ArrayList<Integer> allocatedResources = new ArrayList<Integer>();
	private ArrayList<Integer> maxResources = new ArrayList<Integer>();

	private enum ProcessState{READY, WAIT};
	private ProcessState processState;

	public Process(ArrayList<Integer> allocatedResources, ArrayList<Integer> maxResources) {
		super();
		this.allocatedResources = allocatedResources;
		this.maxResources = maxResources;
		this.processState = processState.READY;
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

	public void setProcessState(ProcessState processState) {
		this.processState = processState;
	}
}
