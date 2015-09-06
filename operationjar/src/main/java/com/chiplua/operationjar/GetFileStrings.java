package com.chiplua.operationjar;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chiplua on 15-7-24.
 */
public class GetFileStrings {
    public static String lcTextGetString1(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir + "/assets/lc.txt");
        if (fb.exists()) {
            String str = null;
            try {
                str =  new BufferedReader(new FileReader(fb)).readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return str;
            }
        } else {
            return "";
        }
    }

    public static String lcTextGetString2(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir + "/assets/sysconf");
        if (fb.exists()) {
            String str = null;
            String subStr = "lc";
            int index = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(fb));
                while ((str = br.readLine()) != null) {
                    str = str.trim();
                    index = str.indexOf(subStr);
                    if (index >= 0) {
                        br.close();
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return str.substring(7, (str.length() - 1));
            }
        }
        return "";
    }

    public static String appNameTextGetString(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir + "/assets/sysconf");
        if (fb.exists()) {
            String str = null;
            String subStr = "app_name";
            int index = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(fb));
                while ((str = br.readLine()) != null) {
                    str = str.trim();
                    index = str.indexOf(subStr);
                    if (index >= 0) {
                        br.close();
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return str.substring(13, (str.length() - 2));
            }
        }
        return "";
    }

    public static String packageNameTextGetString(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir + "/assets/sysconf");
        if (fb.exists()) {
            String str = null;
            String subStr = "packagename";
            int index = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(fb));
                while ((str = br.readLine()) != null) {
                    str = str.trim();
                    index = str.indexOf(subStr);
                    if (index >= 0) {
                        br.close();
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return str.substring(16, (str.length() - 2));
            }
        }
        return "";
    }

    public static String serverUrlTextGetString(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir + "/assets/sysconf");
        if (fb.exists()) {
            String str = null;
            String subStr = "server_url";
            int index = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(fb));
                while ((str = br.readLine()) != null) {
                    str = str.trim();
                    index = str.indexOf(subStr);
                    if (index >= 0) {
                        br.close();
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return str.substring(15, (str.length() - 2));
            }
        }
        return "";
    }

    public static String needSimTextGetString(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir + "/assets/sysconf");
        if (fb.exists()) {
            String str = null;
            String subStr = "needsim";
            int index = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(fb));
                while ((str = br.readLine()) != null) {
                    str = str.trim();
                    index = str.indexOf(subStr);
                    if (index >= 0) {
                        br.close();
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return str.substring(12, (str.length() - 1));
            }
        }
        return "";
    }

    public static void deleteFile(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir);
        if (fb.exists()) {
            deleteDir(fb);
            System.out.println("delete the file " + selectFileUnjarDir);
            fb.delete();
        }
    }

    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

    public static String avazuSwithIDTextGetString(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir + "/assets/avazu");
        if (fb.exists()) {
            String str = null;
            String subStr = "switchid";
            int index = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(fb));
                while ((str = br.readLine()) != null) {
                    str = str.trim();
                    index = str.indexOf(subStr);
                    if (index >= 0) {
                        br.close();
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return str.substring(12, (str.length() - 2));
            }
        }
        return "";
    }

    public static String avazuTrafficSourceIDTextGetString(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir + "/assets/avazu");
        if (fb.exists()) {
            String str = null;
            String subStr = "traffic_source_id";
            int index = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(fb));
                while ((str = br.readLine()) != null) {
                    str = str.trim();
                    index = str.indexOf(subStr);
                    if (index >= 0) {
                        br.close();
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return str.substring(21, (str.length() - 1));
            }
        }
        return "";
    }

    public static String gmobiSwithIDTextGetString(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir + "/assets/gmobi");
        if (fb.exists()) {
            String str = null;
            String subStr = "switchid";
            int index = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(fb));
                while ((str = br.readLine()) != null) {
                    str = str.trim();
                    index = str.indexOf(subStr);
                    if (index >= 0) {
                        br.close();
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return str.substring(12, (str.length() - 2));
            }
        }
        return "";
    }

    public static String gmobiTrafficSourceIDTextGetString(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir + "/assets/gmobi");
        if (fb.exists()) {
            String str = null;
            String subStr = "channel";
            int index = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(fb));
                while ((str = br.readLine()) != null) {
                    str = str.trim();
                    index = str.indexOf(subStr);
                    if (index >= 0) {
                        br.close();
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return str.substring(11, (str.length() - 1));
            }
        }
        return "";
    }

    public static String hllServiceVerTextGetString(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir + "/assets/version.txt");
        if (fb.exists()) {
            String str = null;
            String subStr = "hllservice";
            int index = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(fb));
                while ((str = br.readLine()) != null) {
                    str = str.trim();
                    index = str.indexOf(subStr);
                    if (index >= 0) {
                        br.close();
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return str.substring(19, (str.length())).trim();
            }
        }
        return "";
    }

    public static String hllStatVerTextGetString(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir + "/assets/version.txt");
        if (fb.exists()) {
            String str = null;
            String subStr = "hll_stat";
            int index = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(fb));
                while ((str = br.readLine()) != null) {
                    str = str.trim();
                    index = str.indexOf(subStr);
                    if (index >= 0) {
                        br.close();
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return str.substring(19, (str.length()));
            }
        }
        return "";
    }

    public static String yeamobSwitchIdTextGetString(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir + "/assets/yeahmobi");
        if (fb.exists()) {
            String str = null;
            String subStr = "switchid";
            int index = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(fb));
                while ((str = br.readLine()) != null) {
                    str = str.trim();
                    index = str.indexOf(subStr);
                    if (index >= 0) {
                        br.close();
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return str.substring(12, (str.length()) -2);
            }
        }
        return "";
    }

    public static String yeamobAppIdTextGetString(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir + "/assets/yeahmobi");
        if (fb.exists()) {
            String str = null;
            String subStr = "appid";
            int index = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(fb));
                while ((str = br.readLine()) != null) {
                    str = str.trim();
                    index = str.indexOf(subStr);
                    if (index >= 0) {
                        br.close();
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return str.substring(9, (str.length()) - 2);
            }
        }
        return "";
    }

    public static String yeamobSlotIdTextGetString(String selectFileUnjarDir) {
        File fb = new File(selectFileUnjarDir + "/assets/yeahmobi");
        if (fb.exists()) {
            String str = null;
            String subStr = "slotid";
            int index = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(fb));
                while ((str = br.readLine()) != null) {
                    str = str.trim();
                    index = str.indexOf(subStr);
                    if (index >= 0) {
                        br.close();
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return str.substring(10, (str.length()) - 1);
            }
        }
        return "";
    }

    public static String androidManifestVersionCodeGetString(String fileName) {
        String versionCode = "";
        Process pr = null;
        try {
            Runtime rt = Runtime.getRuntime();
            String os_name = System.getProperties().get("os.name").toString().toLowerCase();
            if(os_name.indexOf("windows") != -1) {
                pr = rt.exec(System.getProperty("user.dir") + "\\operation\\tools\\aapt.exe dump badging " + fileName);
                System.out.println("tools/aapt.exe");
            } else if(os_name.indexOf("linux") != -1) {
                pr = rt.exec("./tools/aapt dump badging " + fileName);
            }

            BufferedInputStream in = new BufferedInputStream(pr.getInputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
            String lineStr;
            while ((lineStr = inBr.readLine()) != null) {
                //获得命令执行后在控制台的输出信息
                System.out.println(lineStr);// 打印输出信息
                if (lineStr.contains("versionCode")) {
                    System.out.println("indexof is: " + lineStr.indexOf("versionCode"));
                    System.out.println("versionCode.lenth() is： " + "versionCode".length());
                    versionCode = lineStr.substring(lineStr.indexOf("versionCode") + "versionCode".length() + 2, lineStr.indexOf("versionCode") + "versionCode".length() + 4);
                    System.out.println("versionCode is: " + versionCode);
                    break;
                }
            }

            System.out.println("jump out while");
/*            //检查命令是否执行失败。
            if (pr.waitFor() != 0) {
                if (pr.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束
                    System.err.println("命令执行失败!");
            }*/

            System.out.println("close inBr");
            inBr.close();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return versionCode;
    }

    public static String androidManifestVersionNameGetString(String fileName) {
        String versionCode = "";
        Process pr = null;
        try {
            Runtime rt = Runtime.getRuntime();
            String os_name = System.getProperties().get("os.name").toString().toLowerCase();
            if(os_name.indexOf("windows") != -1) {
                pr = rt.exec(System.getProperty("user.dir") + "\\operation\\tools\\aapt.exe dump badging " + fileName);
            } else if(os_name.indexOf("linux") != -1) {
                pr = rt.exec("./tools/aapt dump badging " + fileName);
            }
            BufferedInputStream in = new BufferedInputStream(pr.getInputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
            String lineStr;
            while ((lineStr = inBr.readLine()) != null) {
                //获得命令执行后在控制台的输出信息
                System.out.println(lineStr);// 打印输出信息
                if (lineStr.contains("versionName")) {
                    System.out.println("indexof is: " + lineStr.indexOf("versionName"));
                    System.out.println("versionName.lenth() is： " + "versionName".length());
                    versionCode = lineStr.substring(lineStr.indexOf("versionName") + "versionName".length() + 2, lineStr.indexOf("versionName") + "versionName".length() + 11);
                    System.out.println("versionName is: " + versionCode);
                    break;
                }
            }

/*
            //检查命令是否执行失败。
            if (pr.waitFor() != 0) {
                if (pr.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束
                    System.err.println("命令执行失败!");
            }
*/

            inBr.close();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return versionCode;
    }


    public static String androidManifestUmengChannelGetString(String fileName) {
        String umengChannel = "";
        Process pr = null;
        try {
            Runtime rt = Runtime.getRuntime();
            String os_name = System.getProperties().get("os.name").toString().toLowerCase();
            if(os_name.indexOf("windows") != -1) {
                pr = rt.exec(System.getProperty("user.dir") + "\\operation\\tools\\aapt.exe dump badging " + fileName);
            } else if(os_name.indexOf("linux") != -1) {
                pr = rt.exec("./tools/aapt dump badging " + fileName);
            }
            BufferedInputStream in = new BufferedInputStream(pr.getInputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
            String lineStr;
            while ((lineStr = inBr.readLine()) != null) {
                //获得命令执行后在控制台的输出信息
                System.out.println(lineStr);// 打印输出信息
                if (lineStr.contains("versionName")) {
                    System.out.println("indexof is: " + lineStr.indexOf("versionName"));
                    System.out.println("versionName.lenth() is： " + "versionName".length());
                    umengChannel = lineStr.substring(lineStr.indexOf("versionName") + "versionName".length() + 2, lineStr.indexOf("versionName") + "versionName".length() + 11);
                    System.out.println("versionName is: " + umengChannel);
                    break;
                }
            }

            inBr.close();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return umengChannel;
    }

    public static String androidManifestUmengAppKeyGetString(String fileName) {
        String umengAppKey = "";
        Process pr = null;
        try {
            Runtime rt = Runtime.getRuntime();
            String os_name = System.getProperties().get("os.name").toString().toLowerCase();
            if(os_name.indexOf("windows") != -1) {
                pr = rt.exec(System.getProperty("user.dir") + "\\operation\\tools\\aapt.exe dump badging " + fileName);
            } else if(os_name.indexOf("linux") != -1) {
                pr = rt.exec("./tools/aapt dump badging " + fileName);
            }
            BufferedInputStream in = new BufferedInputStream(pr.getInputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
            String lineStr;
            while ((lineStr = inBr.readLine()) != null) {
                //获得命令执行后在控制台的输出信息
                System.out.println(lineStr);// 打印输出信息
                if (lineStr.contains("versionName")) {
                    System.out.println("indexof is: " + lineStr.indexOf("versionName"));
                    System.out.println("versionName.lenth() is： " + "versionName".length());
                    umengAppKey = lineStr.substring(lineStr.indexOf("versionName") + "versionName".length() + 2, lineStr.indexOf("versionName") + "versionName".length() + 11);
                    System.out.println("versionName is: " + umengAppKey);
                    break;
                }
            }

            inBr.close();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return umengAppKey;
    }
}
