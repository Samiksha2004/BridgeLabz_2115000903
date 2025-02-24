import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

public class PrivateFieldAccess {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);

            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true);

            System.out.println("Original Age: " + ageField.get(person));

            ageField.set(person, 30);

            System.out.println("Modified Age: " + ageField.get(person));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

