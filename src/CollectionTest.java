import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Objects;

public class CollectionTest {

    public static void main(String[] args) {

        Employee e1 = new Employee("1", "Manish", 20000);
        Employee e2 = new Employee("2", "Manish", 20000);
        Employee e3 = new Employee("1", "Manish", 20000);
        Employee e4 = new Employee("2", "Manish", 20000);

        HashMap<Employee, String> map = new HashMap<>();
        map.put(e1, "test1");
        map.put(e2, "test2");
        map.put(e3, "test3");
        map.put(e4, "test4");

        map.forEach((K, V) -> System.out.println(K.toString()+":"+V));

    }

    static class Employee {
        String id;
        String name;
        int salary;

        public Employee(String id, String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return salary == employee.salary && Objects.equals(id, employee.id) && Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, salary);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
