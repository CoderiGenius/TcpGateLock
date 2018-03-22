package util;

import Socket.TCP;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * 通过传入socket 的inputstream获取TCP连接传来的内容
 */
public class SendInputStream {

    public static String senInputStream(InputStream inputStream) {

        try {
            Reader reader = new InputStreamReader(inputStream);
            char chars[] = new char[64];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = reader.read(chars)) != -1)

            {
                sb.append(new String(chars, 0, len));
                TCP.logger1.info("Message from client：" + sb);
                return sb.toString();
            }
        } catch (Exception e) {
            TCP.logger1.error("Read inputStream erro,erro msg:");
            TCP.logger1.error(e.getMessage(), e);
        }
        return null;
    }
}