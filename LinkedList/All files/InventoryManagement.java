import java.util.Scanner;

class Item {
    int itemId, quantity;
    double price;
    String itemName;
    Item next;

    public Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head = null;

    public void addItemAtBeginning(int itemId, String itemName, int quantity, double price) {
        Item newItem = new Item(itemId, itemName, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addItemAtEnd(int itemId, String itemName, int quantity, double price) {
        Item newItem = new Item(itemId, itemName, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addItemAtPosition(int itemId, String itemName, int quantity, double price, int position) {
        if (position <= 1 || head == null) {
            addItemAtBeginning(itemId, itemName, quantity, price);
            return;
        }
        Item newItem = new Item(itemId, itemName, quantity, price);
        Item temp = head;
        int count = 1;
        while (temp.next != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head, prev = null;
        while (temp != null && temp.itemId != itemId) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Item not found.");
            return;
        }
        prev.next = temp.next;
    }

    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found: " + temp.itemName + " - Quantity: " + temp.quantity + " - Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchByName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: ID: " + temp.itemId + " - Quantity: " + temp.quantity + " - Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        System.out.println("Inventory List:");
        while (temp != null) {
            System.out.println("ID: " + temp.itemId + ", Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    public void sortByNameAscending() {
        head = mergeSort(head, true);
    }

    public void sortByNameDescending() {
        head = mergeSort(head, false);
    }

    public void sortByPriceAscending() {
        head = mergeSortPrice(head, true);
    }

    public void sortByPriceDescending() {
        head = mergeSortPrice(head, false);
    }

    private Item mergeSort(Item head, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        Item mid = getMiddle(head);
        Item nextOfMid = mid.next;
        mid.next = null;
        Item left = mergeSort(head, ascending);
        Item right = mergeSort(nextOfMid, ascending);
        return merge(left, right, ascending);
    }

    private Item merge(Item left, Item right, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;
        if ((ascending && left.itemName.compareTo(right.itemName) < 0) || (!ascending && left.itemName.compareTo(right.itemName) > 0)) {
            left.next = merge(left.next, right, ascending);
            return left;
        } else {
            right.next = merge(left, right.next, ascending);
            return right;
        }
    }

    private Item mergeSortPrice(Item head, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        Item mid = getMiddle(head);
        Item nextOfMid = mid.next;
        mid.next = null;
        Item left = mergeSortPrice(head, ascending);
        Item right = mergeSortPrice(nextOfMid, ascending);
        return mergePrice(left, right, ascending);
    }

    private Item mergePrice(Item left, Item right, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;
        if ((ascending && left.price < right.price) || (!ascending && left.price > right.price)) {
            left.next = mergePrice(left.next, right, ascending);
            return left;
        } else {
            right.next = mergePrice(left, right.next, ascending);
            return right;
        }
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management Menu:");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Item Quantity");
            System.out.println("6. Search Item by ID");
            System.out.println("7. Search Item by Name");
            System.out.println("8. Display Inventory");
            System.out.println("9. Calculate Total Inventory Value");
            System.out.println("10. Sort by Name Ascending");
            System.out.println("11. Sort by Name Descending");
            System.out.println("12. Sort by Price Ascending");
            System.out.println("13. Sort by Price Descending");
            System.out.println("14. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: case 2: case 3:
                    System.out.print("Enter Item ID, Name, Quantity, Price: ");
                    inventory.addItemAtBeginning(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextDouble());
                    break;
                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    inventory.removeItemById(scanner.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Item ID and new Quantity: ");
                    inventory.updateQuantity(scanner.nextInt(), scanner.nextInt());
                    break;
                case 8:
                    inventory.displayInventory();
                    break;
                case 9:
                    inventory.calculateTotalValue();
                    break;
                case 14:
                    scanner.close();
                    return;
            }
        }
    }
}

