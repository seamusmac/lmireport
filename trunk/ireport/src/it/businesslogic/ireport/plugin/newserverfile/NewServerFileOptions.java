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
 * OracleOptions.java
 *
 * Created on 12 aprile 2005, 16.22
 *
 */

package it.businesslogic.ireport.plugin.newserverfile;

import it.businesslogic.ireport.gui.JReportFrame;
import it.businesslogic.ireport.gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.chinacreator.ireport.IreportConstant;
import com.chinacreator.ireport.IreportUtil;
import com.chinacreator.ireport.MyReportProperties;
import com.chinacreator.ireport.rmi.IreportFile;
import com.chinacreator.ireport.rmi.IreportRmiClient;

/**
 *
 * @author  Administrator
 */
public class NewServerFileOptions extends javax.swing.JPanel {

   private String myReportName = "";
   public JLabel ectext;
   private NewServerFileOptions ns = null;
   java.awt.Frame par = null;
   private JFrame father = null;

   private JComboBox currentNewReport = null;
    public NewServerFileOptions(JFrame j) {
    	father = j;
        //super(parent, modal);
        initComponents();
        applyI18n();
       // pack();
        ns = this;
    }

    private void initComponents() {
    	//this.setTitle("新增新建文件到服务器");
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        reportName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        reportNote = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();



        this.setLayout(new java.awt.GridBagLayout());

        //setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "新建信息"));

        jPanel1.setMinimumSize(new java.awt.Dimension(350, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 200));

        //------------------
        currentNewReport = new JComboBox();
        JInternalFrame[] jif = MainFrame.getMainInstance().getJMDIDesktopPane().getAllFrames();
        JReportFrame jf = null;
        for (int i = 0; i < jif.length; i++) {
        	String repid = null;
			if(jif[i]!=null && jif[i] instanceof JReportFrame){
				jf = (JReportFrame) jif[i];
				String path = jf.getReport().getFilename();
				repid = IreportUtil.getIdFromReportPath(path);
				if(!IreportUtil.isRemoteFile(repid)){
					MyReportProperties.setProperties(repid+"TEMP-ME", path);
					currentNewReport.addItem(repid);
					if(jf.isSelected()){
						myReportName = repid;
						currentNewReport.setSelectedItem(repid);
					}
				}

			}

		}

        currentNewReport.addActionListener(
        		new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						JComboBox jb = (JComboBox) e.getSource();
						String selectI = (String) jb.getSelectedItem();

						reportName.setText(selectI);
					}

        		}
        );


        JLabel newReports = new JLabel("当前非服务器报表");
        newReports.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 0, 4);
        jPanel1.add(newReports, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 8);
        jPanel1.add(currentNewReport, gridBagConstraints);
        //------------------

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("报表名称");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 0, 4);
        jPanel1.add(jLabel1, gridBagConstraints);

        if(!IreportUtil.isBlank(myReportName)){
        	reportName.setText(myReportName);
        }
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 8);
        jPanel1.add(reportName, gridBagConstraints);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("报表描述");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 0, 4);
        jPanel1.add(jLabel2, gridBagConstraints);

        reportNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportNoteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 8);
        jPanel1.add(reportNote, gridBagConstraints);
        //---------------------------
        JLabel eclable = new JLabel("业务类别");
        eclable.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 0, 4);
        jPanel1.add(eclable, gridBagConstraints);

        JButton jb = new JButton("选择");
        jb.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				 ns.setVisible(false);
				 FormClassTree.getFrame(ns);

			}

        });
        gridBagConstraints = new java.awt.GridBagConstraints();

        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 8);

        jPanel1.add(jb, gridBagConstraints);


        gridBagConstraints = new java.awt.GridBagConstraints();

        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 8);
        ectext = new JLabel();
        jPanel1.add(ectext, gridBagConstraints);
        //---------------------------


        //--------------------------------
        //创建者
        //--------------------------------
        JLabel version = new JLabel("创建者");
        JTextField jf_version = new JTextField();
        version.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy =4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 8, 4);
        jPanel1.add(version, gridBagConstraints);

        jf_version.setText(MyReportProperties.getStringProperties(IreportConstant.USERNAME));
        jf_version.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy =4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 8);
        jPanel1.add(jf_version, gridBagConstraints);

        //----------------------------------------------------

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        this.add(jPanel1, gridBagConstraints);


        //******************************************//
        jButton1.setText("保存到服务器");

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.add(jButton1);

        jButton2.setText("取消");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.add(jButton2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 4);
        this.add(jPanel2, gridBagConstraints);


        //pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	//保存
    	IreportRmiClient.getInstance();
    	IreportFile ifi = new IreportFile();
    	ifi.setContent()
    	IreportRmiClient.getRmiRemoteInterface().addNewReport();
    	this.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    	this.setVisible(true);
    	father.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void reportNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportNoteActionPerformed


    }//GEN-LAST:event_reportNoteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField reportName;
    private javax.swing.JTextField reportNote;
    // End of variables declaration//GEN-END:variables

    public void applyI18n(){

    }

    public JReportFrame[] getAllNewReport(){
    	return null;
    }
}
