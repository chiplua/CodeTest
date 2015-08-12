package com.chiplua.operationjar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Created by chiplua on 15-7-24.
 */
public class SetFileStrings {
    public static void lcTextSetString1(String selectFileUnjarDir, String newString) {
        File fb = new File(selectFileUnjarDir + "/assets/lc.txt");
        if (fb.exists()) {
            String str = null;
            try {
                str = new BufferedReader(new FileReader(fb)).readLine();
                str = str.replace(GetFileStrings.lcTextGetString1(selectFileUnjarDir), newString);
                System.out.println("str = " + str);

                FileOutputStream fos = new FileOutputStream(selectFileUnjarDir + "/assets/lc.txt");
                Writer out = new OutputStreamWriter(fos);
                out.write(str.toString());
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void sysconfTextSetString(String selectFileUnjarDir, String oldStr, String replaceStr) {
        System.out.println("oldStr = " + oldStr + "replaceStr = " + replaceStr);
        String temp = "";
        try {
            File file = new File(selectFileUnjarDir + "/assets/sysconf");
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            // 保存该行前面的内容
            for (int j = 1; (temp = br.readLine()) != null
                    && (temp.indexOf(oldStr) == -1); j++) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }

            // 将内容插入
            if (temp.indexOf(oldStr) >= 0) {
                temp = temp.replace(oldStr, replaceStr);
                System.out.println("temp = " + temp);
                buf = buf.append(temp);
            }

            // 保存该行后面的内容
            while ((temp = br.readLine()) != null) {
                buf = buf.append(System.getProperty("line.separator"));
                buf = buf.append(temp);
            }

            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void needSimTextSetString(String selectFileUnjarDir, String oldStr, String replaceStr) {
        System.out.println("oldStr = " + oldStr + "replaceStr = " + replaceStr);
        String temp = "";
        try {
            File file = new File(selectFileUnjarDir + "/assets/sysconf");
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            // 保存该行前面的内容
            for (int j = 1; (temp = br.readLine()) != null
                    && (temp.indexOf("needsim") == -1); j++) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }

            // 将内容插入
            if (temp.indexOf("needsim") >= 0) {
                temp = temp.replace(oldStr, replaceStr);
                System.out.println("temp = " + temp);
                buf = buf.append(temp);
            }

            // 保存该行后面的内容
            while ((temp = br.readLine()) != null) {
                buf = buf.append(System.getProperty("line.separator"));
                buf = buf.append(temp);
            }

            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
