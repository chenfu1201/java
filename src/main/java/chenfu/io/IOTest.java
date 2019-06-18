package chenfu.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.stream.Collector;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/18 11:25
 */
public class IOTest {

    Writer writer;
    Reader reader;

    InputStream inputStream;
    OutputStream outputStream;

    @Test
    public void run1() throws IOException {
        new BufferedReader(new FileReader(""));
        new BufferedWriter(new FileWriter(""));
    }

    @Test
    public void run2() throws FileNotFoundException {
        new BufferedInputStream(new FileInputStream(""));
        new BufferedOutputStream(new FileOutputStream(""));
        new PrintStream(new FileOutputStream(""));
    }

    /**
     * 子接转字符
     */
    @Test
    public void run3() throws IOException {
        new BufferedReader(new InputStreamReader(new FileInputStream("")));
        new BufferedWriter(new OutputStreamWriter(new FileOutputStream("")));
        new PrintWriter(new OutputStreamWriter(new FileOutputStream(""), "utf-8"), true);
    }

    @Test
    public void run4() throws IOException {
        new BufferedReader(new InputStreamReader(new FileInputStream("")));
        new PrintWriter(new OutputStreamWriter(new FileOutputStream("")));
    }
}
