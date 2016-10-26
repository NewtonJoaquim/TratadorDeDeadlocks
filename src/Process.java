import java.util.ArrayList;

public class Process {

	private ArrayList<Integer> allocatedResources = new ArrayList<Integer>();
	private ArrayList<Integer> maxResources = new ArrayList<Integer>();

	public Process(ArrayList<Integer> allocatedResources, ArrayList<Integer> maxResources) {
		super();
		this.allocatedResources = allocatedResources;
		this.maxResources = maxResources;
	}

	public int getAllocatedResource(int i){
		return allocatedResources.get(i);
	}
	
	public int getMaxResource(int i){
		return maxResources.get(i);
	}
}
