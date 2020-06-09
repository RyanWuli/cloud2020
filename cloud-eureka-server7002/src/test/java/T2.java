import java.time.ZonedDateTime;

/**
 * @Author: Ryan
 * @Date: 2020/6/9 10:28
 * @Version: 1.0
 * @Description:
 */
public class T2 {

    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj); // 2020-06-09T10:29:31.878+08:00[Asia/Shanghai]
    }
}
