package chenfu.thread;

/**
 * 找出最长对称字符串
 *
 * @author Your Name
 *
 */
public class Test1 {
    public static void main(String[] args) {
        // TODO 输出最长对称字符串：goog
        String input1 = "google";

        // TODO 输出最长对称字符串：aba
        String input2 = "abcda";

        // TODO 输出2个最长对称字符串：pop/upu
        String input3 = "pop-upu";
        for (int x=0;x<input1.toCharArray().length;x++ ) {
            String str=maxLengthMiddle(input1.toCharArray(),x);
            if (!str.equals("")) {
                System.out.println(str);
            }
        }
    }

    public static String maxLengthMiddle(char[] array, int index) {
        StringBuilder builder = new StringBuilder(); //最长的子字符串长度
        int j = 0; //前后移动的指针
        while ((array[index - j] == array[index + j]) && (index - j) >= 0 && array.length > (index + j)) {
            builder.append(array[j]);
            j++;
        }

        return builder.toString();
    }
}
