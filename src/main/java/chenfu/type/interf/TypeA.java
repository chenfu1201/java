package chenfu.type.interf;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/5/16 17:06
 */
public interface TypeA<T> {
    void setT(T t);
    T getT();
}
interface TypeB<T> extends TypeA<T> {

}

interface TypeC extends TypeA<Integer> {

}