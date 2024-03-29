/*
 * Copyright (C) 2005 - 2008 JasperSoft Corporation.  All rights reserved. 
 * http://www.jaspersoft.com.
 *
 * Unless you have purchased a commercial license agreement from JasperSoft,
 * the following license terms apply:
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as published by
 * the Free Software Foundation.
 *
 * This program is distributed WITHOUT ANY WARRANTY; and without the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see http://www.gnu.org/licenses/gpl.txt
 * or write to:
 *
 * Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330,
 * Boston, MA  USA  02111-1307
 *
 *
 *
 *
 * MassiveCompilerFrame.java
 * 
 * Created on 19 maggio 2004, 6.16
 *
 */

package it.businesslogic.ireport.plugin.massivecompiler;

import it.businesslogic.ireport.plugin.*;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import it.businesslogic.ireport.util.I18n;
/**
 *
 * @author  Administrator
 */
public class MassiveCompilerFrame extends javax.swing.JFrame {
    
    private FindThread findThread = null;
    private CompileThread compileThread = null;
    private boolean finding = false;
    private boolean compiling = false;
    private it.businesslogic.ireport.gui.MainFrame iReportMainFrame = null;
    
    /** Creates new form MassiveCompilationFrame */
    public MassiveCompilerFrame() {
        initComponents();
        
        this.setSize(550, 380);
        it.businesslogic.ireport.util.Misc.centerFrame(this);
        // Adjust table columns...
        DefaultTableColumnModel dtcm = (DefaultTableColumnModel)this.jTableFiles.getColumnModel();
        
        jTableFiles.getColumnModel().getColumn(0).setCellRenderer( new ImageCellRenderer());
        
        jTableFiles.setRowHeight(18);
        dtcm.getColumn(0).setWidth(18);
        dtcm.getColumn(1).setWidth(300);
        dtcm.getColumn(2).setWidth(50);
        
        dtcm.getColumn(0).setPreferredWidth(18);
        dtcm.getColumn(1).setPreferredWidth(300);
        dtcm.getColumn(2).setPreferredWidth(50);
        
        dtcm.getColumn(0).setMinWidth(18);
        dtcm.getColumn(0).setMaxWidth(18);
        //dtcm.getColumn(2).setMinWidth(300);
        //dtcm.getColumn(3).setMinWidth(50);
        
        
        DefaultListSelectionModel dlsm =  (DefaultListSelectionModel)this.jTableFiles.getSelectionModel();
        dlsm.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e)  {
                jTableFilesListSelectionValueChanged(e);
            }
        });
        
        applyI18n();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPopupMenuFiles = new javax.swing.JPopupMenu();
        jMenuItemDetails = new javax.swing.JMenuItem();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemViewSource = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldPath = new javax.swing.JTextField();
        jButtonBrowse = new javax.swing.JButton();
        jCheckBoxSubDir = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFiles = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonClose = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jCheckBoxChangeFileExt = new javax.swing.JCheckBox();
        jCheckBoxBackup = new javax.swing.JCheckBox();
        jCheckBoxDirectory = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jButtonCompile = new javax.swing.JButton();
        jButtonCancelCompile = new javax.swing.JButton();
        jButtonCompileAll = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButtonFind = new javax.swing.JButton();
        jButtonCancelFind = new javax.swing.JButton();

        jMenuItemDetails.setText("Details and error messages");
        jMenuItemDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDetailsActionPerformed(evt);
            }
        });

        jPopupMenuFiles.add(jMenuItemDetails);

        jMenuItemOpen.setText("Send to editor");
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });

        jPopupMenuFiles.add(jMenuItemOpen);

        jMenuItemViewSource.setText("View source");
        jMenuItemViewSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemViewSourceActionPerformed(evt);
            }
        });

        jPopupMenuFiles.add(jMenuItemViewSource);

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setTitle("Massive compiler");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Directory"));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 70));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 70));
        jTextFieldPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPathActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(jTextFieldPath, gridBagConstraints);

        jButtonBrowse.setText("Browse...");
        jButtonBrowse.setMinimumSize(new java.awt.Dimension(87, 20));
        jButtonBrowse.setPreferredSize(new java.awt.Dimension(87, 20));
        jButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        jPanel1.add(jButtonBrowse, gridBagConstraints);

        jCheckBoxSubDir.setText("Search Sub Directories");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jCheckBoxSubDir, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(jPanel1, gridBagConstraints);

        jTableFiles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "File", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFilesMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(jTableFiles);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel2.setMinimumSize(new java.awt.Dimension(0, 125));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 125));
        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 4);
        jPanel2.add(jButtonClose, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Options"));
        jPanel4.setMinimumSize(new java.awt.Dimension(200, 80));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 80));
        jCheckBoxChangeFileExt.setText("Change file extension to .jrxml");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jCheckBoxChangeFileExt, gridBagConstraints);

        jCheckBoxBackup.setText("Backup old compiled files");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jCheckBoxBackup, gridBagConstraints);

        jCheckBoxDirectory.setSelected(true);
        jCheckBoxDirectory.setLabel("Use the compilation directory set in the options window");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jCheckBoxDirectory, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        jPanel2.add(jPanel4, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jPanel5.setPreferredSize(new java.awt.Dimension(100, 10));
        jButtonCompile.setText("Compile selected file(s)");
        jButtonCompile.setEnabled(false);
        jButtonCompile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompileActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        jPanel5.add(jButtonCompile, gridBagConstraints);

        jButtonCancelCompile.setText("Cancel");
        jButtonCancelCompile.setEnabled(false);
        jButtonCancelCompile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelCompileActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel5.add(jButtonCancelCompile, gridBagConstraints);

        jButtonCompileAll.setText("Compile All");
        jButtonCompileAll.setEnabled(false);
        jButtonCompileAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompileAllActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel5.add(jButtonCompileAll, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        jPanel5.add(jPanel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 4);
        jPanel2.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(100, 10));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 10));
        jButtonFind.setText("Find");
        jButtonFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFindActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(jButtonFind, gridBagConstraints);

        jButtonCancelFind.setText("Cancel");
        jButtonCancelFind.setEnabled(false);
        jButtonCancelFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelFindActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanel3.add(jButtonCancelFind, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 4);
        getContentPane().add(jPanel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemViewSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemViewSourceActionPerformed
       if (iReportMainFrame == null) return;
        if (jTableFiles.getSelectedRowCount() != 0)
            {           
                Runtime rt = Runtime.getRuntime();
		    String editor = "notepad.exe";
		    try {
			    if (iReportMainFrame.getProperties().getProperty("ExternalEditor")!=null)
				    editor = (String)iReportMainFrame.getProperties().getProperty("ExternalEditor");
			    if (editor == null || editor.equals("")) {
                                    iReportMainFrame.logOnConsole(I18n.getString("messages.useNotepad", "Using notepad.exe as default editor!\n"),false);
				    editor = "notepad.exe";
			    }
			    
			    rt.exec(editor+ " \"" + ((FileEntry)this.jTableFiles.getValueAt( jTableFiles.getSelectedRow(), 0)).getFile().getCanonicalPath() +"\"");
		    } catch (Exception ex) {
			    
                            javax.swing.JOptionPane.showMessageDialog(this,
                        I18n.getFormattedString("messages.errorExecutingEditor",
                        "An exception is occured executing:\n{0} \"{1}\"",new Object[]{editor,"" + ((FileEntry)this.jTableFiles.getValueAt( jTableFiles.getSelectedRow(), 0)).getFile()}) ,"",javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
            }
    }//GEN-LAST:event_jMenuItemViewSourceActionPerformed

    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenActionPerformed
        if (iReportMainFrame == null) return;
        if (jTableFiles.getSelectedRowCount() != 0)
            {
                iReportMainFrame.openFile( ((FileEntry)this.jTableFiles.getValueAt( jTableFiles.getSelectedRow(), 0)).getFile() );
            }
    }//GEN-LAST:event_jMenuItemOpenActionPerformed

    private void jMenuItemDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDetailsActionPerformed
        if (jTableFiles.getSelectedRowCount() != 0)
            {
                FileDetails fd = new FileDetails(this, true);
                fd.setFileEntry( (FileEntry)this.jTableFiles.getValueAt( jTableFiles.getSelectedRow(), 0) );
                fd.setVisible(true);
            }
    }//GEN-LAST:event_jMenuItemDetailsActionPerformed

    private void jTableFilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFilesMouseClicked
        if (evt.getButton() == evt.BUTTON1 && evt.getClickCount() == 2)
        {
            if (jTableFiles.getSelectedRowCount() != 0)
            {
                FileDetails fd = new FileDetails(this, true);
                fd.setFileEntry( (FileEntry)this.jTableFiles.getValueAt( jTableFiles.getSelectedRow(), 0) );
                fd.setVisible(true);
            }
        }
        else if (evt.getButton() == evt.BUTTON3 && evt.getClickCount() == 1)
        {
            this.jPopupMenuFiles.show(jTableFiles, evt.getPoint().x, evt.getPoint().y);
        }
    }//GEN-LAST:event_jTableFilesMouseClicked

    private void jButtonCompileAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompileAllActionPerformed
        // Retrive data for compilation...
        
        compileThread = new CompileThread(this);
        compileThread.setCompileSelectedOnly(false);
        startCompiling();
        compileThread.start();
    }//GEN-LAST:event_jButtonCompileAllActionPerformed

    private void jButtonCancelCompileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelCompileActionPerformed
        compileThread.stop();
        finishedCompiling();
    }//GEN-LAST:event_jButtonCancelCompileActionPerformed

    private void jButtonCompileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompileActionPerformed
        
        // Retrive data for compilation...
        
        compileThread = new CompileThread(this);
        compileThread.setCompileSelectedOnly(true);
        startCompiling();
        compileThread.start();
        
    }//GEN-LAST:event_jButtonCompileActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonCancelFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelFindActionPerformed
        
        findThread.stop();
        finishedFind();
        
    }//GEN-LAST:event_jButtonCancelFindActionPerformed

    private void jButtonFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFindActionPerformed

        if (jTextFieldPath.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(this,
                    I18n.getString("messages.massiveCompilerFrame.noDir", "Please select a directory."),
                    I18n.getString("messages.massiveCompilerFrame.noDirCaption", "No dir..."), JOptionPane.WARNING_MESSAGE);
            return;
        }
        findThread = new FindThread(this);
        startFind();
        findThread.start();
        
    }//GEN-LAST:event_jButtonFindActionPerformed

    private void jButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseActionPerformed
        
        // Select a directory...
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
          jTextFieldPath.setText( jfc.getSelectedFile().getPath());
        }
        
    }//GEN-LAST:event_jButtonBrowseActionPerformed

    private void jTextFieldPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPathActionPerformed
        // Add your handling code here:
    }//GEN-LAST:event_jTextFieldPathActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        this.setVisible(false);
    }//GEN-LAST:event_exitForm
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new MassiveCompilerFrame().setVisible(true);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBrowse;
    private javax.swing.JButton jButtonCancelCompile;
    private javax.swing.JButton jButtonCancelFind;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonCompile;
    private javax.swing.JButton jButtonCompileAll;
    private javax.swing.JButton jButtonFind;
    private javax.swing.JCheckBox jCheckBoxBackup;
    private javax.swing.JCheckBox jCheckBoxChangeFileExt;
    private javax.swing.JCheckBox jCheckBoxDirectory;
    private javax.swing.JCheckBox jCheckBoxSubDir;
    private javax.swing.JMenuItem jMenuItemDetails;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemViewSource;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenuFiles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFiles;
    private javax.swing.JTextField jTextFieldPath;
    // End of variables declaration//GEN-END:variables
 
    
    public javax.swing.JTable getFileTable()
    {
        return jTableFiles;   
    }
    
    public String getFindDirectory()
    {
        return jTextFieldPath.getText();
    }
    
    public boolean isSearchSubDirectory()
    {
        return jCheckBoxSubDir.isSelected();
    }
    
    public boolean isSelectedChangeFileExt()
    {
        return jCheckBoxChangeFileExt.isSelected();
    }
    
    public boolean isSelectedBackup()
    {
        return jCheckBoxBackup.isSelected();
    }
    
    public boolean isSelectedOptionsCompileDir()
    {
        return jCheckBoxDirectory.isSelected();
    }
    
    public void finishedFind()
    {
        finding = false;
        this.jButtonCancelFind.setEnabled(false);
        this.jButtonFind.setEnabled(true);
        this.jButtonClose.setEnabled(true);
        this.jCheckBoxSubDir.setEnabled(true);
        this.jTextFieldPath.setEditable(true);
        
        if (this.jTableFiles.getRowCount() > 0)
        {
            this.jButtonCompileAll.setEnabled(true);
            jTableFilesListSelectionValueChanged(new ListSelectionEvent(this,0,0,false));
        }
        else
        {
            this.jButtonCompileAll.setEnabled(false);
        }
        
    }
    
    public void startFind()
    {
        finding = true;
        this.jButtonCancelFind.setEnabled(true);
        this.jButtonFind.setEnabled(false);
        
        this.jButtonCompileAll.setEnabled(false);
        this.jButtonCompile.setEnabled(false);
        this.jButtonClose.setEnabled(false);
        this.jCheckBoxSubDir.setEnabled(false);
        this.jTextFieldPath.setEditable(false);

    }
    
    public void finishedCompiling()
    {
        compiling = false;
        this.jButtonCancelCompile.setEnabled(false);
        this.jButtonFind.setEnabled(true);
        this.jButtonClose.setEnabled(true);
        this.jCheckBoxBackup.setEnabled(true);
        this.jCheckBoxChangeFileExt.setEnabled(true);        
        
        if (this.jTableFiles.getRowCount() > 0)
        {
            this.jButtonCompileAll.setEnabled(true);
            jTableFilesListSelectionValueChanged(new ListSelectionEvent(this,0,0,false));
        }
        else
        {
            this.jButtonCompileAll.setEnabled(false);
        }
    }
    
    public void startCompiling()
    {
        compiling = true;
        this.jButtonCancelCompile.setEnabled(false);
        this.jButtonFind.setEnabled(false);
        
        this.jButtonCompileAll.setEnabled(false);
        this.jButtonCompile.setEnabled(false);
        this.jButtonClose.setEnabled(false);
        this.jCheckBoxBackup.setEnabled(false);
        this.jCheckBoxChangeFileExt.setEnabled(false);
    }
    
    public void jTableFilesListSelectionValueChanged(ListSelectionEvent e)
    {
        if (finding) return;
        if (this.jTableFiles.getSelectedRowCount() > 0)
        {
            this.jButtonCompile.setEnabled(true);
        }
        else
        {
            this.jButtonCompile.setEnabled(false);
        }
    }
    
    /** Getter for property iReportMainFrame.
     * @return Value of property iReportMainFrame.
     *
     */
    public it.businesslogic.ireport.gui.MainFrame getIReportMainFrame() {
        return iReportMainFrame;
    }
    
    /** Setter for property iReportMainFrame.
     * @param iReportMainFrame New value of property iReportMainFrame.
     *
     */
    public void setIReportMainFrame(it.businesslogic.ireport.gui.MainFrame iReportMainFrame) {
        this.iReportMainFrame = iReportMainFrame;
    }
    
    public void applyI18n(){
                // Start autogenerated code ----------------------
                jMenuItemDetails.setText(I18n.getString("massiveCompilerFrame.menuItemDetails","Details and error messages"));
                jMenuItemOpen.setText(I18n.getString("massiveCompilerFrame.menuItemOpen","Send to editor"));
                jMenuItemViewSource.setText(I18n.getString("massiveCompilerFrame.menuItemViewSource","View source"));
                // End autogenerated code ----------------------
                // Start autogenerated code ----------------------
                jCheckBoxBackup.setText(I18n.getString("massiveCompilerFrame.checkBoxBackup","Backup old compiled files"));
                jCheckBoxChangeFileExt.setText(I18n.getString("massiveCompilerFrame.checkBoxChangeFileExt","Change file extension to .jrxml"));
                jCheckBoxSubDir.setText(I18n.getString("massiveCompilerFrame.checkBoxSubDir","Search Sub Directories"));
                // End autogenerated code ----------------------
                // Start autogenerated code ----------------------
                jButtonBrowse.setText(I18n.getString("massiveCompilerFrame.buttonBrowse","Browse..."));
                jButtonCancelCompile.setText(I18n.getString("massiveCompilerFrame.buttonCancelCompile","Cancel"));
                jButtonCancelFind.setText(I18n.getString("massiveCompilerFrame.buttonCancelFind","Cancel"));
                jButtonClose.setText(I18n.getString("massiveCompilerFrame.buttonClose","Close"));
                jButtonCompile.setText(I18n.getString("massiveCompilerFrame.buttonCompile","Compile selected file(s)"));
                jButtonCompileAll.setText(I18n.getString("massiveCompilerFrame.buttonCompileAll","Compile All"));
                jButtonFind.setText(I18n.getString("massiveCompilerFrame.buttonFind","Find"));
                // End autogenerated code ----------------------
                
                jTableFiles.getColumnModel().getColumn(1).setHeaderValue(I18n.getString("massiveCompilerFrame.tablecolumn.file","File") );
                jTableFiles.getColumnModel().getColumn(2).setHeaderValue(I18n.getString("massiveCompilerFrame.tablecolumn.status","Status") );

                ((javax.swing.border.TitledBorder)jPanel1.getBorder()).setTitle(I18n.getString("massiveCompilerFrame.panelBorder.Directory","Directory") );
                ((javax.swing.border.TitledBorder)jPanel4.getBorder()).setTitle(I18n.getString("massiveCompilerFrame.panelBorder.Options","Options") );
    
                this.setTitle(I18n.getString("massiveCompilerFrame.title","Massive compiler"));
                                
    }
}
