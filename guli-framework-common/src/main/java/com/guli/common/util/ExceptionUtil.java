package com.guli.common.util;
import java.io.IOException;
import	java.io.PrintWriter;
import	java.io.StringWriter;

public class ExceptionUtil {
    public static String getMessage(Exception e) {

        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            //将错误的栈信息输出到printwriter中
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            return sw.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
