package chenfu.type.function;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/5/16 17:19
 */
public class TypeFuntions {

    static class MyException extends Exception {

        public MyException(String message) {
            super(message);
        }
    }
    public static <T> T run(T t) throws Exception {
        if (Objects.nonNull(t) && (t instanceof List)) {
            List list = (List) t;
            if (!list.isEmpty() && list.iterator().hasNext()) {
                return t;
            }
        }
        throw new MyException("不是List或者List没数据");
    }

    public static void main(String[] args) throws Exception {
//        ArrayList<Object> list = new ArrayList<>();
        HashSet<Object> objects = new HashSet<>();
//        run(list);
        run(objects);
    }
}
