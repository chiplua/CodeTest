package com.chiplua.operationjar;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OperationJar extends JFrame {
    private JFrame frame = new JFrame("Jar File Read And Write");
    private Container container = frame.getContentPane();
    private JTextField selectJarPath = new JTextField();
    private FileChooser fchooser = null;
    private DecompressJar unzipOrZipFileOP = null;
    private String selectFileName = null;
    private String selectFileDir = null;
    private String selectFileUnjarDir = null;
    private String currentBinDir = null;
    String currentPath = System.getProperty("user.dir");
    String currentUnDir = "";
    String currentFile = "";
    String os_name = System.getProperties().get("os.name").toString().toLowerCase();
    JButton open = new JButton("Open");
    JPanel fileOpenFieldPanel  = new JPanel();
    JLabel selectFile = new JLabel("Please select a Jar file:");
    JLabel fileStrings = new JLabel("The Strings From the Jar File:");
    JLabel lcStringLabel1 = new JLabel("LC:(lc.txt)");
    JTextField lcStringText1 = new JTextField();
    JButton lcStringButton1 = new JButton("Write LC");
    JLabel lcStringLabel2 = new JLabel("LC:(sysconf)");
    JTextField lcStringText2 = new JTextField();
    JButton lcStringButton2 = new JButton("Write LC");
    JLabel appNameLabel = new JLabel("app_name:");
    JTextField appNameText = new JTextField();
    JButton appNameButton = new JButton("Write AN");
    JLabel packageNameLabel = new JLabel("packagename:");
    JTextField packageNameText = new JTextField();
    JButton packageNameButton = new JButton("Write PN");
    JLabel serverUrlLabel = new JLabel("server_url:");
    JTextField serverUrlText = new JTextField();
    JButton serverUrlButton = new JButton("Write SU");
    JLabel needSimLabel = new JLabel("needsim:");
    JTextField needsimText = new JTextField();
    JButton needSimButton = new JButton("Write NS");
    JLabel switchIdAvazuLabel = new JLabel("switchID(avazu):");
    JTextField switchIdAvazuText = new JTextField();
    JLabel trafficSourceIdLabel = new JLabel("traffi_sourc_id:");
    JTextField trafficSourceIdAvazuText = new JTextField();

    JLabel switchIdGmobiLabel = new JLabel("switchId(gmobi):");
    JTextField switchIdGmobiText = new JTextField();
    JLabel channelGmobiLabel = new JLabel("channel:");
    JTextField channelGmobiText = new JTextField();

    JLabel hllServiceVerLabel = new JLabel("hllser_ver(ver):");
    JTextField hllserviceVerText = new JTextField();
    JLabel hllStatVerLabel = new JLabel("hll_stat_ver:");
    JTextField hllStatVerText = new JTextField();

    JLabel switchIdYeamobLabel = new JLabel("swtchid(yemob):");
    JTextField switchIdYeamobText = new JTextField();
    JLabel appIdYeamobLabel = new JLabel("appid:");
    JTextField appIdYeamobText = new JTextField();
    JLabel slotIdYeamobLabel = new JLabel("slotid:");
    JTextField slotIdYeamobText = new JTextField();

    JLabel versionCodeLabel = new JLabel("versionCode:");
    JTextField versionCodeText = new JTextField();
    JLabel versionNameLabel = new JLabel("versionName:");
    JTextField versionNameText = new JTextField();

    JLabel umengChannelLabel = new JLabel("UMENG_CHANEL");
    JTextField umengChannelText = new JTextField();
    JLabel umengAppKeyLabel = new JLabel("UMENG_APPKEY");
    JTextField umengAppKeyText = new JTextField();

    JButton readAllButton = new JButton("Read ALL");
    JButton writeAllButton = new JButton("Write ALL");
    JButton saveButton = new JButton("Save");
    JButton exitButton = new JButton("Exit");

    private JFrame settingFrame = new JFrame("Setting");
    JMenu settingMenu;
    JMenuItem readJarMenu, readApkMenu;
    JMenuBar menuBar;
    JPanel pp = new JPanel();

    public static void main(String[] args) {
        new OperationJar();
    }

    public OperationJar() {
        initMenu();
    }

    public void initMenu() {
        deCompressOperationJar();
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //System.exit(1);
        System.out.println("initMenu");
        setLayout(new FlowLayout());
        menuBar = new JMenuBar();
        settingMenu = new JMenu("Setting");
        readApkMenu = new JMenuItem("readApk");
        readJarMenu =new JMenuItem("readJAR");
        settingMenu.add(readApkMenu);
        settingMenu.add(readJarMenu);
        menuBar.add(settingMenu);
        setJMenuBar(menuBar);
        setVisible(true);
        setBounds(30, 40, 350, 150);


        hllsetBackground();
        settingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuItemSetEvent();
    }

    private void hllsetBackground() {
        ImageIcon imageIcon = null;
        pp.setOpaque(false);
        container.add(pp);

        String os_name = System.getProperties().get("os.name").toString().toLowerCase();
        if(os_name.indexOf("windows") != -1) {
            imageIcon = new ImageIcon(currentUnDir + "\\tools\\background.jpg");
        } else if(os_name.indexOf("linux") != -1 || (os_name.indexOf("mac") != -1)) {
            imageIcon = new ImageIcon(currentUnDir + "/tools/background.jpg");
        }

        JLabel background = new JLabel(imageIcon);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        ((JPanel)this.getContentPane()).setOpaque(false);
        background.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
    }
    private void initJarFrame() {
        frame.setSize(730, 410);
        container.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        openFile();
        readStringLabel();
        lcStringFromLcTxt();
        lcStringFromlcTxtButton();

        lcStringFromSysconf();
        lcStringFromSysconfButton();

        appNameFromSysconf();
        appNameFromSysconfButton();

        packageNameFromSysconf();
        packageNameFromSysconfButton();

        serverUrlFromSysconf();
        serverUrlFromSysconfButton();

        needSimFromSysconf();
        needSimFromSysconfButton();

        readWriteSaveExitButtons();
        setButtonEvent();

        container.add(fileOpenFieldPanel, "Center");
    }

    private void initApkFrame() {
        frame.setSize(730, 950);
        container.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        openFile();
        readStringLabel();
        lcStringFromLcTxt();
        lcStringFromSysconf();
        appNameFromSysconf();
        packageNameFromSysconf();
        serverUrlFromSysconf();
        needSimFromSysconf();

        /*read switch_id and traffic_source_id from avazu.txt*/
        switchIdFromAvazu();
        trafficSourceIdFromAvazu();

        /*read from gmobi.txt*/
        switchIdFromGmobi();
        channelFromGmobi();

        /*read hllservice_version and hll_stat_version from version*/
        hllServiceVerFromVersion();
        hllStatVerFromVersion();

        /*read switchid, appid and slotid from yeamob*/
        switchIdFromYeamob();
        appIdFromYeamob();
        slotIdFromYeamob();

        /*read VersionCode, VersionName from AndroidManifest.xml with aapt*/
        versionCodeFromAndroidManifest();
        versionNameFromAndroidManifest();

        /*read UMENG_CHANNEL , UMENG_APPKEY from AndroidManifest.xml with aapt*/
        umengChannelFromAndroidManifest();
        umengAppKeyFromAndroidManifest();

        readExitButtons();
        setButtonEvent();

        container.add(fileOpenFieldPanel, "Center");
    }

    private void openFile() {
        //File Open
        fileOpenFieldPanel.setLayout(null);
        fileOpenFieldPanel.setSize(780, 20);
        fileOpenFieldPanel.setBorder(BorderFactory.createLoweredBevelBorder());

        selectFile.setFont(new Font("宋体", Font.ITALIC, 22));
        selectFile.setBounds(10, 10, 300, 20);
        fileOpenFieldPanel.add(selectFile);

        /*button: open button*/
        open.setFont(new Font("宋体", Font.ITALIC, 12));
        open.setBounds(10, 40, 80, 20);
        fileOpenFieldPanel.add(open);

        /*text: file path text*/
        selectJarPath.setBounds(100, 40, 600, 20);
        fileOpenFieldPanel.add(selectJarPath);
    }

    private void readStringLabel(){
        //Read Strings from file
        fileStrings.setFont(new Font("宋体", Font.ITALIC, 22));
        fileStrings.setBounds(10, 80, 400, 20);
        fileOpenFieldPanel.add(fileStrings);
    }
    private void lcStringFromLcTxt() {
        /*label: lc from lc.txt*/
        lcStringLabel1.setFont(new Font("宋体", Font.ITALIC, 22));
        lcStringLabel1.setBounds(10, 120, 300, 20);
        fileOpenFieldPanel.add(lcStringLabel1);

        /*text: lc from lc.txt*/
        lcStringText1.setBounds(200, 120, 300, 20);
        fileOpenFieldPanel.add(lcStringText1);
    }

    private void lcStringFromlcTxtButton() {
        /*button: lc from lc.txt*/
        lcStringButton1.setBounds(550, 120, 150, 20);
        fileOpenFieldPanel.add(lcStringButton1);
    }

    private void lcStringFromSysconf() {
        /*label: lc from sysconf*/
        lcStringLabel2.setFont(new Font("宋体", Font.ITALIC, 22));
        lcStringLabel2.setBounds(10, 160, 300, 20);
        fileOpenFieldPanel.add(lcStringLabel2);

        /*text: lc from sysconf*/
        lcStringText2.setBounds(200, 160, 300, 20);
        fileOpenFieldPanel.add(lcStringText2);
    }

    private void lcStringFromSysconfButton() {
        /*button: lc from lc.txt*/
        lcStringButton2.setBounds(550, 160, 150, 20);
        fileOpenFieldPanel.add(lcStringButton2);
    }

    private void appNameFromSysconf() {
        /*label: app_name from sysconf*/
        appNameLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        appNameLabel.setBounds(10, 200, 300, 20);
        fileOpenFieldPanel.add(appNameLabel);

        /*text: app_name from sysconf*/
        appNameText.setBounds(200, 200, 300, 20);
        fileOpenFieldPanel.add(appNameText);
    }

    private void appNameFromSysconfButton() {
                /*button: app_name from sysconf*/
        appNameButton.setBounds(550, 200, 150, 20);
        fileOpenFieldPanel.add(appNameButton);
    }

    private void packageNameFromSysconf() {
                /*label: packagename from sysconf*/
        packageNameLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        packageNameLabel.setBounds(10, 240, 300, 20);
        fileOpenFieldPanel.add(packageNameLabel);

        /*text: packagename from sysconf*/
        packageNameText.setBounds(200, 240, 300, 20);
        fileOpenFieldPanel.add(packageNameText);
    }

    private void packageNameFromSysconfButton() {
                /*button: packagename from sysconf*/
        packageNameButton.setBounds(550, 240, 150, 20);
        fileOpenFieldPanel.add(packageNameButton);
    }

    private void serverUrlFromSysconf() {
        /*label: server_url from sysconf*/
        serverUrlLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        serverUrlLabel.setBounds(10, 280, 300, 20);
        fileOpenFieldPanel.add(serverUrlLabel);

        /*text: server_url from sysconf*/
        serverUrlText.setBounds(200, 280, 300, 20);
        fileOpenFieldPanel.add(serverUrlText);
    }

    private void serverUrlFromSysconfButton() {
                /*button: server_url from sysconf*/
        serverUrlButton.setBounds(550, 280, 150, 20);
        fileOpenFieldPanel.add(serverUrlButton);
    }

    private void needSimFromSysconf() {
        /*label: needsim from sysconf*/
        needSimLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        needSimLabel.setBounds(10, 320, 300, 20);
        fileOpenFieldPanel.add(needSimLabel);

        /*text: needsim from sysconf*/
        needsimText.setBounds(200, 320, 300, 20);
        fileOpenFieldPanel.add(needsimText);
    }

    private void needSimFromSysconfButton() {
                /*button: needsim from sysconf*/
        needSimButton.setBounds(550, 320, 150, 20);
        fileOpenFieldPanel.add(needSimButton);
    }

    private void switchIdFromAvazu() {
        /*label: switch_id from avazu*/
        switchIdAvazuLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        switchIdAvazuLabel.setBounds(10, 360, 300, 20);
        fileOpenFieldPanel.add(switchIdAvazuLabel);

        /*text: switch_id from avazu*/
        switchIdAvazuText.setBounds(200, 360, 300, 20);
        fileOpenFieldPanel.add(switchIdAvazuText);
    }

    private void trafficSourceIdFromAvazu() {
        /*label: traffic_source_id from avazu*/
        trafficSourceIdLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        trafficSourceIdLabel.setBounds(10, 400, 300, 20);
        fileOpenFieldPanel.add(trafficSourceIdLabel);

        /*text: traffic_souce_id from avazu*/
        trafficSourceIdAvazuText.setBounds(200, 400, 300, 20);
        fileOpenFieldPanel.add(trafficSourceIdAvazuText);
    }

    private void switchIdFromGmobi() {
        /*label: switch_id from gmobi*/
        switchIdGmobiLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        switchIdGmobiLabel.setBounds(10, 440, 300, 20);
        fileOpenFieldPanel.add(switchIdGmobiLabel);

        /*text: switch_id from gmobi*/
        switchIdGmobiText.setBounds(200, 440, 300, 20);
        fileOpenFieldPanel.add(switchIdGmobiText);
    }

    private void channelFromGmobi() {
        /*label: channel from gmobi.txt*/
        channelGmobiLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        channelGmobiLabel.setBounds(10, 480, 300, 20);
        fileOpenFieldPanel.add(channelGmobiLabel);

        /*text: channel from gmobi.txt*/
        channelGmobiText.setBounds(200, 480, 300, 20);
        fileOpenFieldPanel.add(channelGmobiText);
    }

    private void hllServiceVerFromVersion() {
        /*label: hllservice_ver from version.txt*/
        hllServiceVerLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        hllServiceVerLabel.setBounds(10, 520, 300, 20);
        fileOpenFieldPanel.add(hllServiceVerLabel);

        /*text: hllservice_ver from version.txt*/
        hllserviceVerText.setBounds(200, 520, 300, 20);
        fileOpenFieldPanel.add(hllserviceVerText);
    }

    private void hllStatVerFromVersion() {
        /*label: hll_stat_ver from version.txt*/
        hllStatVerLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        hllStatVerLabel.setBounds(10, 560, 300, 20);
        fileOpenFieldPanel.add(hllStatVerLabel);

        /*text: hll_stat_ver from version.txt*/
        hllStatVerText.setBounds(200, 560, 300, 20);
        fileOpenFieldPanel.add(hllStatVerText);
    }

    private void switchIdFromYeamob() {
        /*label: switchid from yeamob.txt*/
        switchIdYeamobLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        switchIdYeamobLabel.setBounds(10,600, 300, 20);
        fileOpenFieldPanel.add(switchIdYeamobLabel);

        /*text: switchid from yeamob*/
        switchIdYeamobText.setBounds(200, 600, 300, 20);
        fileOpenFieldPanel.add(switchIdYeamobText);
    }

    private void appIdFromYeamob() {
        /*label: appid from yeamob.txt*/
        appIdYeamobLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        appIdYeamobLabel.setBounds(10, 640, 300, 20);
        fileOpenFieldPanel.add(appIdYeamobLabel);

        /*text: appid from yeamob*/
        appIdYeamobText.setBounds(200, 640, 300, 20);
        fileOpenFieldPanel.add(appIdYeamobText);
    }

    private void slotIdFromYeamob() {
        /*label: slotid from yeamob.txt*/
        slotIdYeamobLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        slotIdYeamobLabel.setBounds(10, 680, 300, 20);
        fileOpenFieldPanel.add(slotIdYeamobLabel);

        /*text: appid from yeamob.txt*/
        slotIdYeamobText.setBounds(200, 680, 300, 20);
        fileOpenFieldPanel.add(slotIdYeamobText);
    }

    private void versionCodeFromAndroidManifest() {
        /*label: versionCode from AndroidManifest*/
        versionCodeLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        versionCodeLabel.setBounds(10, 720, 300, 20);
        fileOpenFieldPanel.add(versionCodeLabel);

        /*text: versionCode from AndroidManifest*/
        versionCodeText.setBounds(200, 720, 300, 20);
        fileOpenFieldPanel.add(versionCodeText);
    }

    private void versionNameFromAndroidManifest() {
        /*label: versionName from AndroidManifest*/
        versionNameLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        versionNameLabel.setBounds(10, 760, 300, 20);
        fileOpenFieldPanel.add(versionNameLabel);

        /*text: versionName from AndroidManifest*/
        versionNameText.setBounds(200, 760, 300, 20);
        fileOpenFieldPanel.add(versionNameText);
    }

    private void umengChannelFromAndroidManifest() {
        /*label: UMENG_CHANNEL from AndroidManifest*/
        umengChannelLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        umengChannelLabel.setBounds(10, 800, 300, 20);
        fileOpenFieldPanel.add(umengChannelLabel);

        /*text: UMENG_CHANNEL from AndroidManifest*/
        umengChannelText.setBounds(200, 800, 300, 20);
        fileOpenFieldPanel.add(umengChannelText);
    }

    private void umengAppKeyFromAndroidManifest() {
        /*label: UMENG_APPKEY from AndroidManifest*/
        umengAppKeyLabel.setFont(new Font("宋体", Font.ITALIC, 22));
        umengAppKeyLabel.setBounds(10, 840, 300, 20);
        fileOpenFieldPanel.add(umengAppKeyLabel);

        /*text: UMENG_CHANNEL from AndroidManifest*/
        umengAppKeyText.setBounds(200, 840, 300, 20);
        fileOpenFieldPanel.add(umengAppKeyText);
    }

    private void readWriteSaveExitButtons() {
        /*button: Button for read all*/
        readAllButton.setBounds(10, 360, 150, 20);
        fileOpenFieldPanel.add(readAllButton);

        /*button: Button for write all*/
        writeAllButton.setBounds(190, 360, 150, 20);
        fileOpenFieldPanel.add(writeAllButton);

        /*button: Button for save all*/
        saveButton.setBounds(370, 360, 150, 20);
        fileOpenFieldPanel.add(saveButton);

        /*button: Button for exit*/
        exitButton.setBounds(550, 360, 150, 20);
        fileOpenFieldPanel.add(exitButton);
    }

    private void readExitButtons() {
        /*button: Button for read all*/
        readAllButton.setBounds(570, 800, 150, 20);
        fileOpenFieldPanel.add(readAllButton);

        /*button: Button for exit*/
        exitButton.setBounds(570, 840, 150, 20);
        fileOpenFieldPanel.add(exitButton);
    }


    private void setButtonEvent() {
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("open button click!");
                fchooser = new FileChooser();
                if (fchooser.getSelectedFile() == null) return;
                selectFileName = fchooser.getSelectedFile().getPath();
                System.out.println("selectFileName =  " + selectFileName);
                selectFileDir = fchooser.getSelectFileDir();
                if (selectFileName.equals("null")) return;
                if(selectFileName.indexOf("jar") >= 0) {
                    System.out.println("You choose a jar file");
                    selectFileUnjarDir = selectFileName.replace(".jar", "");
                } else if (selectFileName.indexOf("apk") >= 0) {
                    System.out.println("You choose a apk file");
                    File oldFile = new File(selectFileName);
                    selectFileName = selectFileName.replace(".apk", ".jar");
                    oldFile.renameTo(new File(selectFileName));
                    selectFileUnjarDir = selectFileName.replace(".jar", "");
                }
                System.out.println("The file you select is " + fchooser.getSelectedFile());
                selectJarPath.setText(selectFileName);
                System.out.println("The directory is " + selectFileDir);
                System.out.println("The unRar directory is " + selectFileUnjarDir);
                setAllTextNull();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("exit button click!");
                if (selectFileName != null) {
                    GetFileStrings.deleteFile(selectFileUnjarDir);
                }

                if (currentBinDir != null) {
                    GetFileStrings.deleteFile(currentBinDir);
                }
                System.exit(1);
            }
        });

        readAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectFileName == null) return;
                System.out.println("read all button click!");
                try {
                    DecompressJar.doIt(selectFileName, selectFileUnjarDir);
                } catch (Exception xe) {
                    xe.printStackTrace();
                }

                lcStringText1.setText(GetFileStrings.lcTextGetString1(selectFileUnjarDir));
                lcStringText2.setText(GetFileStrings.lcTextGetString2(selectFileUnjarDir));
                appNameText.setText(GetFileStrings.appNameTextGetString(selectFileUnjarDir));;
                packageNameText.setText(GetFileStrings.packageNameTextGetString(selectFileUnjarDir));
                serverUrlText.setText(GetFileStrings.serverUrlTextGetString(selectFileUnjarDir));
                needsimText.setText(GetFileStrings.needSimTextGetString(selectFileUnjarDir));
                switchIdAvazuText.setText(GetFileStrings.avazuSwithIDTextGetString(selectFileUnjarDir));
                trafficSourceIdAvazuText.setText(GetFileStrings.avazuTrafficSourceIDTextGetString(selectFileUnjarDir));
                switchIdGmobiText.setText(GetFileStrings.gmobiSwithIDTextGetString(selectFileUnjarDir));
                channelGmobiText.setText(GetFileStrings.gmobiTrafficSourceIDTextGetString(selectFileUnjarDir));
                hllserviceVerText.setText(GetFileStrings.hllServiceVerTextGetString(selectFileUnjarDir));
                hllStatVerText.setText(GetFileStrings.hllStatVerTextGetString(selectFileUnjarDir));
                switchIdYeamobText.setText(GetFileStrings.yeamobSwitchIdTextGetString(selectFileUnjarDir));
                appIdYeamobText.setText(GetFileStrings.yeamobAppIdTextGetString(selectFileUnjarDir));
                slotIdYeamobText.setText(GetFileStrings.yeamobSlotIdTextGetString(selectFileUnjarDir));
                versionCodeText.setText(GetFileStrings.androidManifestVersionCodeGetString(selectFileName, currentUnDir));
                versionNameText.setText(GetFileStrings.androidManifestVersionNameGetString(selectFileName, currentUnDir));
                umengChannelText.setText(GetFileStrings.androidManifestUmengChannelGetString(selectFileName, currentUnDir));
                umengAppKeyText.setText(GetFileStrings.androidManifestUmengAppKeyGetString(selectFileName, currentUnDir));
            }
        });

        lcStringButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectFileName == null) return;
                System.out.println("lc1 button click!");
                System.out.println("lcStringText1=" + lcStringText1.getText());
                SetFileStrings.lcTextSetString1(selectFileUnjarDir, lcStringText1.getText());
            }
        });

        lcStringButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectFileName == null) return;
                System.out.println("lc2 button click!");
                System.out.println("lcStringText2=" + lcStringText2.getText());
                SetFileStrings.sysconfTextSetString(selectFileUnjarDir, GetFileStrings.lcTextGetString2(selectFileUnjarDir), lcStringText2.getText());
            }
        });

        appNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectFileName == null) return;
                System.out.println("appName button click!");
                System.out.println("appName = " + appNameText.getText());
                SetFileStrings.sysconfTextSetString(selectFileUnjarDir, GetFileStrings.appNameTextGetString(selectFileUnjarDir), appNameText.getText());
            }
        });

        packageNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectFileName == null) return;
                System.out.println("packageName button click!");
                System.out.println("packageName = " + packageNameText.getText());
                SetFileStrings.sysconfTextSetString(selectFileUnjarDir, GetFileStrings.packageNameTextGetString(selectFileUnjarDir), packageNameText.getText());
            }
        });

        serverUrlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectFileName == null) return;
                System.out.println("server_url button click!");
                System.out.println("server_url = " + serverUrlText.getText());
                SetFileStrings.sysconfTextSetString(selectFileUnjarDir, GetFileStrings.serverUrlTextGetString(selectFileUnjarDir), serverUrlText.getText());
            }
        });

        needSimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectFileName == null) return;
                System.out.println("needsim button click!");
                System.out.println("needsim = " + needsimText.getText());
                SetFileStrings.needSimTextSetString(selectFileUnjarDir, GetFileStrings.needSimTextGetString(selectFileUnjarDir), needsimText.getText());
            }
        });

        writeAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectFileName == null) return;
                System.out.println("writeAll button click!");
                SetFileStrings.lcTextSetString1(selectFileUnjarDir, lcStringText1.getText());
                SetFileStrings.sysconfTextSetString(selectFileUnjarDir, GetFileStrings.lcTextGetString2(selectFileUnjarDir), lcStringText2.getText());
                SetFileStrings.sysconfTextSetString(selectFileUnjarDir, GetFileStrings.appNameTextGetString(selectFileUnjarDir), appNameText.getText());
                SetFileStrings.sysconfTextSetString(selectFileUnjarDir, GetFileStrings.packageNameTextGetString(selectFileUnjarDir), packageNameText.getText());
                SetFileStrings.sysconfTextSetString(selectFileUnjarDir, GetFileStrings.serverUrlTextGetString(selectFileUnjarDir), serverUrlText.getText());
                SetFileStrings.needSimTextSetString(selectFileUnjarDir, GetFileStrings.needSimTextGetString(selectFileUnjarDir), needsimText.getText());
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectFileName == null) return;
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String filePrex = selectFileUnjarDir.replace(selectFileDir + "/", "");
                try {
                    System.out.println("selectFileUnjarDir = " + selectFileUnjarDir);
                    System.out.println("selectFileDir = " + selectFileDir);
                    CompressJar.doIt(selectFileUnjarDir, filePrex + "_" + (df.format(new Date())).replace(" ", "_") + ".jar");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void menuItemSetEvent() {
        readJarMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("readJarMenu click!");
                settingFrame.dispose();
                setVisible(false);
                initJarFrame();
            }
        });

        readApkMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("readApkMenu Click!");
                settingFrame.dispose();
                setVisible(false);
                initApkFrame();
            }
        });
    }

    private void deCompressOperationJar() {
        System.out.println("os_name is: " + os_name);
        if (os_name.indexOf("windows") != -1) {
            currentUnDir = currentPath + "\\operation";
            currentFile = currentPath + "\\operation.jar";
        } else if (os_name.indexOf("linux") != -1 || (os_name.indexOf("mac") != -1)) {
            currentUnDir = currentPath + "/operation";
            currentFile = currentPath + "/operation.jar";
        }

        currentBinDir = currentUnDir;
        try {
            DecompressJar.doIt(currentFile, currentUnDir);
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("chmod 777 " + currentUnDir + "/tools/aapt_linux");
            runtime.exec("chmod 777 " + currentUnDir + "/tools/aapt_mac");
            runtime.exec("chmod 777 " + currentUnDir + "/tools/aapt.exe");

          /*  GetFileStrings.deleteFile(currentUnDir + "\\com");
            GetFileStrings.deleteFile(currentUnDir + "\\META-INF");*/
        } catch (Exception xe) {
            xe.printStackTrace();
        }
    }

    private void setAllTextNull() {
        lcStringText1.setText("");
        lcStringText2.setText("");
        appNameText.setText("");;
        packageNameText.setText("");
        serverUrlText.setText("");
        needsimText.setText("");
        switchIdAvazuText.setText("");
        trafficSourceIdAvazuText.setText("");
        switchIdGmobiText.setText("");
        channelGmobiText.setText("");
        hllserviceVerText.setText("");
        hllStatVerText.setText("");
        switchIdYeamobText.setText("");
        appIdYeamobText.setText("");
        slotIdYeamobText.setText("");
        versionCodeText.setText("");
        versionNameText.setText("");
        umengChannelText.setText("");
        umengAppKeyText.setText("");
    }
}