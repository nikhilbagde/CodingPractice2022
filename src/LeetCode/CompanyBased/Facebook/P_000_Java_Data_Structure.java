package LeetCode.CompanyBased.Facebook;

import java.util.*;

public class P_000_Java_Data_Structure {
    public static void main(String[] args) {
        boolean isDigit = Character.isDigit('3');
        System.out.println("isDigit = " + isDigit);
        int numericValue = Character.getNumericValue('3');
        System.out.println("numericValue = " + numericValue);

        //String
        String a = "String";
        a = a.substring(0, a.length() / 2);  //subString with small s
        a = "abacd";
        int index = a.indexOf('a');  //=0
        //but to get 2nd index of 1, we need to start from some index. we use, overloaded method
        // of s.indexOf(character to find, the index); and not otherwise. index comes later as paramter
        index = a.indexOf('a', 1);  //=2


        //Sorting of Map keys and Values ----------------------------------START-------------------------------------------------------
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Nikhil");
        map.put(5, "Swapnil");
        map.put(3, "Vijay");
        map.put(2, "Vandana");
        map.put(4, "Bagde");

        //Primitive
        System.out.println("Primitive keys and values");
        //Sort by keys
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        map.entrySet().stream().sorted(Map.Entry.comparingByKey((o1, o2) -> o2 - o1)).forEach(System.out::println);

        //sort by values
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).forEach(System.out::println);
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);

        System.out.println("Composite keys and values");
        Map<Employee, Address> map1 = new HashMap<>();
        map1.put(new Employee(4, "Nikhil", 10), new Address(4, "Address 1", "Pune", 411006));
        map1.put(new Employee(1, "Swap", 10), new Address(1, "Uddress 1", "Pune", 411006));
        map1.put(new Employee(5, "Vijay", 10), new Address(5, "Pddress 1", "Pune", 411006));
        map1.put(new Employee(3, "Vandana", 10), new Address(3, "Hddress 1", "Pune", 411006));
        map1.put(new Employee(2, "Bagde", 10), new Address(2, "Tddress 1", "Pune", 411006));

        System.out.println("Original Map" + map1);

        System.out.println("Sorting by Keys");
        List<Map.Entry<Employee, Address>> list = new ArrayList<>(map1.entrySet());
        //Collections.sort(list, (o1, o2) -> o1.getKey().getId() - o2.getKey().getId());   // way1
        //Collections.sort(list, Comparator.comparingInt(o -> o.getKey().getId()));   //way 2
        System.out.println("Map 1 key sorted");
        map1.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getId))).forEach(System.out::println);  //way 3

        System.out.println("Map 1 key sorted: Reverse");
        Collections.sort(list, (o1, o2) -> o2.getKey().getId() - o1.getKey().getId());   // way1
        //Collections.sort(list, Comparator.comparingInt(o -> o.getKey().getId()  ));   //way 2
        map1.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getId).reversed())).forEach(System.out::println);  //way 3

        System.out.println("Sorting by values");
        map1.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Address::getId))).forEach(System.out::println);

        System.out.println("Sorting by values: Reversed");
        map1.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Address::getAddressLine1).reversed())).forEach(System.out::println);
    }

    private static class Employee {
        int id;
        String name;
        int age;

        public Employee(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
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

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id && age == employee.age && Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, age);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    private static class Address {
        int id;
        String addressLine1;
        String city;
        int zipcode;

        public Address(int id, String addressLine1, String city, int zipcode) {
            this.id = id;
            this.addressLine1 = addressLine1;
            this.city = city;
            this.zipcode = zipcode;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAddressLine1() {
            return addressLine1;
        }

        public void setAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getZipcode() {
            return zipcode;
        }

        public void setZipcode(int zipcode) {
            this.zipcode = zipcode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return id == address.id && zipcode == address.zipcode && Objects.equals(addressLine1, address.addressLine1) && Objects.equals(city, address.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, addressLine1, city, zipcode);
        }

        @Override
        public String toString() {
            return "Address{" +
                    "id=" + id +
                    ", addressLine1='" + addressLine1 + '\'' +
                    ", city='" + city + '\'' +
                    ", zipcode=" + zipcode +
                    '}';
        }
    }

    //Sorting of Map keys and Values -------------------------------------END----------------------------------------------------


    BitSet one = new BitSet();
}
