class Process {
    int processID, burstTime, remainingTime, priority;
    Process next;

    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null, tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void removeProcess(int processID) {
        if (head == null) return;

        Process temp = head, prev = null;
        do {
            if (temp.processID == processID) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void simulateRoundRobin() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0, completedProcesses = 0, totalProcesses = countProcesses();
        double totalWaitingTime = 0, totalTurnaroundTime = 0;
        Process current = head;

        System.out.println("\nRound Robin Execution:");
        while (completedProcesses < totalProcesses) {
            if (current.remainingTime > 0) {
                int executionTime = Math.min(timeQuantum, current.remainingTime);
                System.out.println("Executing Process ID: " + current.processID + " for " + executionTime + " units");

                time += executionTime;
                current.remainingTime -= executionTime;

                if (current.remainingTime == 0) {
                    completedProcesses++;
                    int turnaroundTime = time;
                    int waitingTime = turnaroundTime - current.burstTime;
                    totalTurnaroundTime += turnaroundTime;
                    totalWaitingTime += waitingTime;
                    System.out.println("Process ID: " + current.processID + " completed. Turnaround Time: " + turnaroundTime + ", Waiting Time: " + waitingTime);
                }
            }
            current = current.next;
        }

        System.out.println("\nAverage Waiting Time: " + (totalWaitingTime / totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / totalProcesses));
    }

    public int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        System.out.println("\nProcesses in Circular Queue:");
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processID + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinSimulation {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(3);
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);
        
        scheduler.displayProcesses();
        scheduler.simulateRoundRobin();
    }
}

