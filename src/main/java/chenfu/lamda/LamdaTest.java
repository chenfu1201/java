package chenfu.lamda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: romantic_ke@163.com
 * @Description: 了解Stream类的使用
 * @Date: 2018/12/6 22:16
 */
public class LamdaTest {

    public static void main(String[] args) throws Exception {

//      采用lamda语法
        NumberReduce numberReduce = (a, b) -> a + b;

//        Integer reduce = new NumberReduce() {
//            @Override
//            public Integer reduce(Integer a, Integer b) {
//                return a + b;
//            }
//        }.reduce(3, 4);

        System.out.println(numberReduce.reduce(3, 4));

        Stream<String> stream = Stream.of("I", "love", "you", "too");
        stream.forEach(str -> System.out.println(str));

//        java在mapreduce上的基础调整
        Order o1 = new Order(1L, "huaweiP20", 10L, 2999.0);
        Order o2 = new Order(2L, "huawei20Plus", 2L, 8888.0);
        Order o3 = new Order(3L, "xiaomiP9", 6L, 3299.0);
        Order o4 = new Order(4L, "meizuNote2", 5L, 3289.0);
        Order o5 = new Order(5L, "rongyaoP9", 100L, 1999.0);

        List<Order> people = new ArrayList<>();
        Collections.addAll(people, o1, o2, o3, o4, o5);

        System.out.println(people.size());
        DoubleSummaryStatistics summaryStatistics = people.stream().filter(p -> p.getName().toLowerCase().contains("p")).mapToDouble(order -> {
            Double prices = order.getCount() * order.getPrice();
            System.out.print(order.getName() + "-count:" + order.getCount() + "\t" + prices + "\t");
            return prices;
        }).summaryStatistics();

        System.out.println();
        System.out.print("max:" + summaryStatistics.getMax());
        System.out.print("\tmin:" + summaryStatistics.getMin());
        System.out.print("\tavg:" + summaryStatistics.getAverage());
        System.out.print("\tcount:" + summaryStatistics.getCount());
        System.out.print("\tsum:" + summaryStatistics.getSum());
        System.out.println();
        System.out.println(people);
        List<String> collect = people.stream().map(p -> p.getName().toLowerCase()).collect(Collectors.toList());
        System.out.println("p1-" + collect);
        System.out.println("p2-" + people);
    }

    @FunctionalInterface
    interface NumberReduce {
        Integer reduce(Integer a, Integer b);
    }
}

class Order {

    private Long oId;
    private String Name;
    private Long Count;
    private Double price;

    public Order() {
    }

    public Order(Long oId, String name, Long count, Double price) {
        this.oId = oId;
        Name = name;
        Count = count;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oId=" + oId +
                ", Name='" + Name + '\'' +
                ", Count=" + Count +
                ", price=" + price +
                '}';
    }

    public Long getoId() {
        return oId;
    }

    public void setoId(Long oId) {
        this.oId = oId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getCount() {
        return Count;
    }

    public void setCount(Long count) {
        Count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
