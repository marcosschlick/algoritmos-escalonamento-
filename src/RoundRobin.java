import java.util.LinkedList;
import java.util.Queue;

class ProcessingRR {
	String name;
	int totalTime;
	int leftTime;

	public ProcessingRR(String name, int totalTime) {
		this.name = name;
		this.totalTime = totalTime;
		this.leftTime = totalTime;
	}

	public void execute(int quantum) {
		if (leftTime >= quantum) {
			leftTime -= quantum;

			System.out.println();
			System.out.println(name + " já executou por " + (totalTime - leftTime) + " tempos.");
		} else {
			leftTime = 0;
			System.out.println();
			System.out.println(name + " executou por " + (totalTime - leftTime) + " tempos.");
		}
	}

	public boolean isFinalized() {
		return leftTime <= 0;
	}
}

public class RoundRobin {
	public static void main(String[] args) {
		int quantum = 3;
		Queue<ProcessingRR> processes = new LinkedList<>();

		processes.add(new ProcessingRR("Processo 1", 35));
		processes.add(new ProcessingRR("Processo 2", 30));
		processes.add(new ProcessingRR("Processo 3", 20));

		while (!processes.isEmpty()) {
			ProcessingRR p = processes.poll();
			p.execute(quantum);

			if (!p.isFinalized()) {
				processes.add(p);
			}
		}
	}
}
