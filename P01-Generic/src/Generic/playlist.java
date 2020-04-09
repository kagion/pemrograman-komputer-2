/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generic;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.text.DecimalFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ASUS
 */
public class playlist extends javax.swing.JFrame {

    KoleksiMusic koleksi = new KoleksiMusic();

    /**
     * Creates new form playlist
     */
    public playlist() {
        initComponents();
        tblPlaylist.setModel(koleksi);
        resizeColumns();
        resizeListener();
    }

    private void resizeListener() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeColumns();
            }
        });
    }

    private void resizeColumns() {
        float[] columnWidthPercentage = {90.0f, 10.0f};
        int tW = tblPlaylist.getWidth();
        TableColumn column;
        TableColumnModel jTableColumnModel = tblPlaylist.getColumnModel();
        int cantCols = jTableColumnModel.getColumnCount();
        for (int i = 0; i < cantCols; i++) {
            column = jTableColumnModel.getColumn(i);
            int pWidth = Math.round(columnWidthPercentage[i] * tW);
            column.setPreferredWidth(pWidth);
            tblPlaylist.setRowHeight(27);
        }
    }

    private String fileSizeOf(File file) {
        DecimalFormat format = new DecimalFormat("#.##");
        long MB = 1024 * 1024;
        long KB = 1024;
        final double length = file.length();
        if (length > MB) {
            return format.format(length / MB) + " MB";
        }
        if (length > KB) {
            return format.format(length / KB) + " KB";
        }
        return format.format(length) + " B";
    }

    private String extensionOf(File file) {
        String fileExtension = "";
        String fileName = file.getName();
        if (fileName.contains(".") && fileName.lastIndexOf(".") != 0) {
            fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return fileExtension;
    }

    private void addFiles(File[] files) {
        for (File file : files) {
            String path = file.getAbsolutePath();
            String fn = file.getName();
            String fileName = fn.substring(0, fn.length() - 4);
            String fileSize = fileSizeOf(file);
            String extension = "";
            int i = path.lastIndexOf('.');
            if (i > 0) {
                extension = extensionOf(file);
            }
            Music m = new Music(path, fileName, fileSize, extension);
            koleksi.add(m);
        }
    }

    private void addFolder(File dir) {
        File[] listOfFiles = dir.listFiles();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String path = listOfFile.getAbsolutePath();
                String fn = listOfFile.getName();
                String fileName = fn.substring(0, fn.length() - 4);
                String fileSize = fileSizeOf(listOfFile);
                String extension;
                int i = path.lastIndexOf('.');
                if (i > 0) {
                    extension = extensionOf(listOfFile);
                    if ("mp3".equalsIgnoreCase(extension)) {
                        Music m = new Music(path, fileName, fileSize, extension);
                        koleksi.add(m);
                    }
                }
            } else if (listOfFile.isDirectory()) {
                addFolder(listOfFile);
            }
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popuptombol = new javax.swing.JPopupMenu();
        AddFiles = new javax.swing.JMenuItem();
        AddFolder = new javax.swing.JMenuItem();
        clearPlaylist = new javax.swing.JMenuItem();
        pnFooter = new javax.swing.JPanel();
        btnPlaylist = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlaylist = new javax.swing.JTable();

        AddFiles.setText("Add File(s)");
        AddFiles.setToolTipText("");
        AddFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFilesActionPerformed(evt);
            }
        });
        popuptombol.add(AddFiles);

        AddFolder.setText("Add Folder");
        AddFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFolderActionPerformed(evt);
            }
        });
        popuptombol.add(AddFolder);

        clearPlaylist.setText("Clear Playlist");
        clearPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearPlaylistActionPerformed(evt);
            }
        });
        popuptombol.add(clearPlaylist);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnFooter.setPreferredSize(new java.awt.Dimension(515, 50));

        btnPlaylist.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnPlaylist.setText("Playlist");
        btnPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaylistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFooterLayout = new javax.swing.GroupLayout(pnFooter);
        pnFooter.setLayout(pnFooterLayout);
        pnFooterLayout.setHorizontalGroup(
            pnFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPlaylist)
                .addContainerGap(671, Short.MAX_VALUE))
        );
        pnFooterLayout.setVerticalGroup(
            pnFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPlaylist)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnFooter, java.awt.BorderLayout.PAGE_END);

        tblPlaylist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPlaylistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPlaylist);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFilesActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(true);
        fc.setDialogTitle("Add Files");
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileFilter(new FileNameExtensionFilter("MP3 File (*.mp3)","mp3"));
        fc.setApproveButtonText("Add Files");
        int show = fc.showOpenDialog(this);
        if(show == JFileChooser.APPROVE_OPTION){
            File[] files = fc.getSelectedFiles();
            addFiles(files);
        }
    }//GEN-LAST:event_AddFilesActionPerformed

    private void btnPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaylistActionPerformed
        popuptombol.show(btnPlaylist, btnPlaylist.getWidth(), btnPlaylist.getHeight()/2);
    }//GEN-LAST:event_btnPlaylistActionPerformed

    private void AddFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFolderActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.DIRECTORIES_ONLY);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle("Add Folder");
        fc.setApproveButtonText("Add Folder");
        int show = fc.showOpenDialog(this);
        if(show == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            addFolder(file);
        }
    }//GEN-LAST:event_AddFolderActionPerformed

    private void clearPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearPlaylistActionPerformed
        koleksi.clear();
    }//GEN-LAST:event_clearPlaylistActionPerformed

    private void tblPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlaylistMouseClicked
        int i = tblPlaylist.getSelectedRow();
        if (evt.getClickCount() == 2 && i != -1){
            Music m = koleksi.get(i);
            JOptionPane.showMessageDialog(this, "<html>"
                    + "<head>" + "<style>"
                    + "table { border-collapse: collapse; border: lpx solid blue;}"
                    + "tr { border-bottom:lpt solid black; }" + "</style>" + "</head>" + "<body>"
                    + "<h3>Detail Musik:</h3>" + "<table>"
                    + "<tr><td>Lokasi</td></tr>:</td><td>"+ m.getPath()+ "</td></tr>"
                    + "<tr><td>Nama File</td></tr>:</td><td>"+ m.getFileName()+ "</td></tr>"
                    + "<tr><td>Ukuran</td></tr>:</td><td>"+ m.getFileSize()+ "</td></tr>"
                    + "<tr><td>Ekstensi</td></tr>:</td><td>"+ m.getExtention()+ "</td></tr>"
                    + "</table>" + "</body>" + "</htnl>");
        }           
    }//GEN-LAST:event_tblPlaylistMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new playlist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddFiles;
    private javax.swing.JMenuItem AddFolder;
    private javax.swing.JButton btnPlaylist;
    private javax.swing.JMenuItem clearPlaylist;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnFooter;
    private javax.swing.JPopupMenu popuptombol;
    private javax.swing.JTable tblPlaylist;
    // End of variables declaration//GEN-END:variables
}
