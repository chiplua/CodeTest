package com.chiplua.operationjar;

import java.io.File;
import javax.swing.JFileChooser;

/**
 * Created by chiplua on 15-7-23.
 */
public class FileChooser extends JFileChooser {
    public JFileChooser fileChooser = null;
    File file = null;
    String selectFilePath = null;

    public FileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.showOpenDialog(null);
        file = fileChooser.getSelectedFile();
        if (file == null) {
            selectFilePath = null;
            file = null;
            return ;
        }
        selectFilePath = fileChooser.getSelectedFile().getParent();
    }

    @Override
    public File getSelectedFile() {
        return file;
    }

    public String getSelectFileDir() {
        return selectFilePath;
    }
}
