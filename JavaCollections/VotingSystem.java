import java.util.*;

public class VotingSystem {
    private Map<String, Integer> votesMap = new HashMap<>();
    private Map<String, Integer> linkedVotesMap = new LinkedHashMap<>();
    private Map<String, Integer> sortedVotesMap = new TreeMap<>();

    public void castVote(String candidate) {
        votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1);
        linkedVotesMap.put(candidate, linkedVotesMap.getOrDefault(candidate, 0) + 1);
        sortedVotesMap.put(candidate, sortedVotesMap.getOrDefault(candidate, 0) + 1);
    }

    public void displayVotes() {
        System.out.println("Votes in HashMap (Unordered): " + votesMap);
        System.out.println("Votes in LinkedHashMap (Insertion Order): " + linkedVotesMap);
        System.out.println("Votes in TreeMap (Sorted Order): " + sortedVotesMap);
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Alice");
        
        system.displayVotes();
    }
}
