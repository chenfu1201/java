package chenfu.tree.domain;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/11 10:50
 */
public class Person implements Comparable<Person> {

    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
