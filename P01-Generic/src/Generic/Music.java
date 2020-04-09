/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generic;

/**
 *
 * @author ASUS
 */
public class Music {

    String path, fileName, fileSize, extention;

    public Music(String p, String fn, String fs, String e) {
        this.path = p;
        this.fileName = fn;
        this.fileSize = fs;
        this.extention = e;
    }

    public String getPath() {
        return path;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public String getExtention() {
        return extention;
    }

}
