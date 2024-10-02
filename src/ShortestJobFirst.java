import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

 class ProcessingSJF {
	String name;
	int totalTime;

	public ProcessingSJF(String name, int totalTime) {
		this.name = name;
		this.totalTime = totalTime;
	}

	public void execute() {
		System.out.println(name + " foi executado por " + totalTime + " tempos.");
	}
}

public class ShortestJobFirst {
	public static void main(String[] args) {
		List<ProcessingSJF> processes = new ArrayList<>();
		processes.add(new ProcessingSJF("Processo 1", 10));
		processes.add(new ProcessingSJF("Processo 2", 15));
		processes.add(new ProcessingSJF("Processo 3", 13));

		processes.sort(Comparator.comparingInt(p -> p.totalTime));

		for (ProcessingSJF p : processes) {
			p.execute();
		}
	}
}
