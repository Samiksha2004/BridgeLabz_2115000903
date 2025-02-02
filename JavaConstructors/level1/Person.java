public class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
        this.address = other.address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        Person person1 = new Person("Samiksha", 21, "Firozabad");
        Person person2 = new Person(person1); 

        System.out.println("Person 1: " + person1.getName() + ", " + person1.getAge() + ", " + person1.getAddress());
        System.out.println("Person 2: " + person2.getName() + ", " + person2.getAge() + ", " + person2.getAddress());
    }
}

