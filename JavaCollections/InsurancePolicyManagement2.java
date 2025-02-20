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

    public String getPolicyHolderName() {
        return policyHolderName;
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

public class InsurancePolicyManagement2 {
    private Map<String, Policy> hashMap = new HashMap<>();
    private Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    private Map<Date, Policy> treeMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);
        treeMap.put(policy.getExpiryDate(), policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    public void displayExpiringSoon() {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date threshold = cal.getTime();
        
        System.out.println("Policies Expiring Soon (Next 30 Days):");
        for (Map.Entry<Date, Policy> entry : treeMap.entrySet()) {
            if (entry.getKey().after(now) && entry.getKey().before(threshold)) {
                System.out.println(entry.getValue());
            }
        }
    }

    public void displayPoliciesByHolder(String policyHolderName) {
        System.out.println("Policies for " + policyHolderName + ":");
        for (Policy policy : hashMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(policyHolderName)) {
                System.out.println(policy);
            }
        }
    }

    public void removeExpiredPolicies() {
        Date now = new Date();
        treeMap.entrySet().removeIf(entry -> entry.getKey().before(now));
        hashMap.values().removeIf(policy -> policy.getExpiryDate().before(now));
        linkedHashMap.values().removeIf(policy -> policy.getExpiryDate().before(now));
    }

    public static void main(String[] args) {
        InsurancePolicyManagement2 system = new InsurancePolicyManagement2();
        
        system.addPolicy(new Policy("P001", "Alice", new Date(2024, 7, 10), "Health", 1200.0));
        system.addPolicy(new Policy("P002", "Bob", new Date(2024, 8, 15), "Auto", 1500.0));
        system.addPolicy(new Policy("P003", "Charlie", new Date(2024, 7, 5), "Home", 1800.0));
        
        System.out.println("Policy by Number P001: " + system.getPolicyByNumber("P001"));
        system.displayExpiringSoon();
        system.displayPoliciesByHolder("Alice");
        system.removeExpiredPolicies();
    }
}
