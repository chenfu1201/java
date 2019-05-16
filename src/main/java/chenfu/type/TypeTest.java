package chenfu.type;

import chenfu.type.domain.Point;
import chenfu.type.interf.TypeA;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/5/16 15:50
 */
public class TypeTest {

    class TypeB<T> implements TypeA<T> {
        @Override
        public void setT(T t) {

        }

        @Override
        public T getT() {
            return null;
        }
    }

    class TypeC implements TypeA<Integer>{
        @Override
        public void setT(Integer integer) {

        }

        @Override
        public Integer getT() {
            return null;
        }
    }

    public static void main(String[] args) {
//        此时，就是在输入坐标时，输入字符串也合法
        Point<Integer> point = new Point<>(20, 50);
        Point<Float> point2 = new Point<>(20.3f, 50.3f);
        Point<Double> point3 = new Point<>(100d, 50.3d);
        run(point);
        run(point2);
        run(point3);
    }

    public static void run(Point<? extends Number> point) {
        System.out.println(point);
    }
}
