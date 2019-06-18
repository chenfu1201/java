package chenfu.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Author: romantic_ke@163.com
 * @Description: 了解Stream类的使用
 * @Date: 2018/12/6 22:16
 */
public class StreamTest {

    public static void main(String[] args) throws Exception {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Person(Long.parseLong(i+""), "test" + i));
        }
        for (Person person : list) {
            System.out.println(person);
        }
        System.out.println("=====================");
        Random random = new Random(10);
        list.stream().filter(person -> person.getpId()>5).collect(Collectors.toList()).forEach(p-> System.out.println(p));
        System.out.println(list);
        System.out.println("xxxxxxxxxxxxxxxx");
        list.stream().map(person -> {person.setAge(person.getpId()+""); return person;}).forEach(p-> System.out.println(p));
        System.out.println(list);
//        list.forEach(p-> System.out.println(p));
//        list.stream().map(person -> {person.setAge(random.nextInt()+"")});
    }

    public static class Person {
        Long pId;
        String pName;
        String age;

        public Person() {
        }

        public Person(Long pId, String pName) {
            this.pId = pId;
            this.pName = pName;
        }

        public Long getpId() {
            return pId;
        }

        public void setpId(Long pId) {
            this.pId = pId;
        }

        public String getpName() {
            return pName;
        }

        public void setpName(String pName) {
            this.pName = pName;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "pId=" + pId +
                    ", pName='" + pName + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }

}
