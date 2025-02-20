import java.util.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyHolderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyHolderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyHolderName='" + policyHolderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagement {
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("All Unique Policies (HashSet): " + hashSet);
        System.out.println("All Policies in Insertion Order (LinkedHashSet): " + linkedHashSet);
        System.out.println("All Policies Sorted by Expiry Date (TreeSet): " + treeSet);
    }

    public void displayExpiringSoon() {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date threshold = cal.getTime();
        
        System.out.println("Policies Expiring Soon (Next 30 Days):");
        for (Policy policy : treeSet) {
            if (policy.getExpiryDate().after(now) && policy.getExpiryDate().before(threshold)) {
                System.out.println(policy);
            }
        }
    }

    public void displayByCoverageType(String type) {
        System.out.println("Policies with coverage type: " + type);
        for (Policy policy : hashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }

    public void findDuplicatePolicies() {
        Map<String, Integer> policyCount = new HashMap<>();
        for (Policy policy : hashSet) {
            policyCount.put(policy.getPolicyNumber(), policyCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }
        
        System.out.println("Duplicate Policies:");
        for (Map.Entry<String, Integer> entry : policyCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Policy Number: " + entry.getKey() + " - Occurrences: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        
        system.addPolicy(new Policy("P001", "Alice", new Date(2024, 7, 10), "Health", 1200.0));
        system.addPolicy(new Policy("P002", "Bob", new Date(2024, 8, 15), "Auto", 1500.0));
        system.addPolicy(new Policy("P003", "Charlie", new Date(2024, 7, 5), "Home", 1800.0));
        system.addPolicy(new Policy("P001", "Alice", new Date(2024, 7, 10), "Health", 1200.0)); // Duplicate
        
        system.displayAllPolicies();
        system.displayExpiringSoon();
        system.displayByCoverageType("Health");
        system.findDuplicatePolicies();
    }
}
