import java.util.ArrayList;
import java.util.List;

class User {
    int userID;
    String name;
    int age;
    List<Integer> friendIDs;
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head;

    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    public User searchUser(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int userID1, int userID2) {
        User user1 = searchUser(userID1);
        User user2 = searchUser(userID2);

        if (user1 != null && user2 != null && userID1 != userID2) {
            if (!user1.friendIDs.contains(userID2)) {
                user1.friendIDs.add(userID2);
                user2.friendIDs.add(userID1);
                System.out.println(user1.name + " and " + user2.name + " are now friends.");
            } else {
                System.out.println("They are already friends.");
            }
        } else {
            System.out.println("User not found.");
        }
    }

    public void removeFriend(int userID1, int userID2) {
        User user1 = searchUser(userID1);
        User user2 = searchUser(userID2);

        if (user1 != null && user2 != null) {
            user1.friendIDs.remove(Integer.valueOf(userID2));
            user2.friendIDs.remove(Integer.valueOf(userID1));
            System.out.println(user1.name + " and " + user2.name + " are no longer friends.");
        } else {
            System.out.println("User not found.");
        }
    }

    public void displayFriends(int userID) {
        User user = searchUser(userID);
        if (user != null) {
            System.out.println(user.name + "'s friends: " + user.friendIDs);
        } else {
            System.out.println("User not found.");
        }
    }

    public void findMutualFriends(int userID1, int userID2) {
        User user1 = searchUser(userID1);
        User user2 = searchUser(userID2);

        if (user1 != null && user2 != null) {
            List<Integer> mutualFriends = new ArrayList<>(user1.friendIDs);
            mutualFriends.retainAll(user2.friendIDs);

            System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ": " + mutualFriends);
        } else {
            System.out.println("User not found.");
        }
    }

    public void countFriends(int userID) {
        User user = searchUser(userID);
        if (user != null) {
            System.out.println(user.name + " has " + user.friendIDs.size() + " friends.");
        } else {
            System.out.println("User not found.");
        }
    }

    public void displayUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userID + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Samiksha", 25);
        sm.addUser(2, "Saniya", 22);
        sm.addUser(3, "Shivangii", 28);

        sm.displayUsers();

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);

        sm.displayFriends(1);
        sm.displayFriends(2);

        sm.findMutualFriends(1, 2);

        sm.removeFriend(1, 3);
        sm.displayFriends(1);

        sm.countFriends(2);
    }
}

