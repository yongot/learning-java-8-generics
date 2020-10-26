package generics.max;

/**
 * @author yongot
 * @created 2020-10-24 : 4:29 PM
 */
public class Employee {
    public static final Employee DEFAULT_EMPLOYEE = new Employee(0, "No Name");

    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
