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
 * ReportGroupWizard.java
 * 
 * Created on March 22, 2006, 8:52 PM
 *
 */

package it.businesslogic.ireport.gui.wizard;

import it.businesslogic.ireport.Band;
import it.businesslogic.ireport.Group;
import it.businesslogic.ireport.IReportConnection;
import it.businesslogic.ireport.IReportTemplate;
import it.businesslogic.ireport.JRField;
import it.businesslogic.ireport.Report;
import it.businesslogic.ireport.ReportElement;
import it.businesslogic.ireport.StaticTextReportElement;
import it.businesslogic.ireport.SubReportElement;
import it.businesslogic.ireport.TextFieldReportElement;
import it.businesslogic.ireport.TransformationType;
import it.businesslogic.ireport.connection.JDBCConnection;
import it.businesslogic.ireport.connection.JRHibernateConnection;
import it.businesslogic.ireport.gui.ConnectionDialog;
import it.businesslogic.ireport.gui.JReportFrame;
import it.businesslogic.ireport.gui.MainFrame;
import it.businesslogic.ireport.gui.WizardDialog;
import it.businesslogic.ireport.gui.event.ReportBandChangedEvent;
import it.businesslogic.ireport.util.Misc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.xerces.parsers.DOMParser;
import org.apache.xpath.XPathAPI;
import org.apache.xpath.objects.XBoolean;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import it.businesslogic.ireport.util.I18n;

/**
 *
 * @author  gtoffoli
 */
public class ReportGroupWizard extends javax.swing.JPanel implements GenericWizard {
    
    private String reportFileName = null;
    private SubReportElement subReportElement = null;
    private BaseWizardPanel wizardPanel = null;
    private JDialog wizardDialog = null; 
    private JReportFrame jReportFrame = null;
    
    Vector templates = null;
    
    private Thread t = null;
  
    /** Creates new form SubreportWizardPanes */
    public ReportGroupWizard() {
        initComponents();
        applyI18n();
        jRTextExpressionArea.getDocument().addDocumentListener( new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                if (wizardPanel != null) wizardPanel.updateButtons();
            }
            public void insertUpdate(DocumentEvent e) {
                if (wizardPanel != null) wizardPanel.updateButtons();
            }
            public void removeUpdate(DocumentEvent e) {
                if (wizardPanel != null) wizardPanel.updateButtons();
            }
        });
        
        jTextField1.getDocument().addDocumentListener( new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                if (wizardPanel != null) wizardPanel.updateButtons();
            }
            public void insertUpdate(DocumentEvent e) {
                if (wizardPanel != null) wizardPanel.updateButtons();
            }
            public void removeUpdate(DocumentEvent e) {
                if (wizardPanel != null) wizardPanel.updateButtons();
            }
        });
                
        // These are the combobox values
        Vector values = new Vector();
        
        Report report = MainFrame.getMainInstance().getActiveReportFrame().getReport();
        
        values.addAll( report.getFields());
        values.addAll( report.getVariables());
        values.addAll( report.getParameters());
        
        for (int i=0; i<values.size(); ++i)
        {
            jComboBoxObject.addItem(values.elementAt(i));
        }
    }   
    
    public void startWizard()
    {
        setJReportFrame(MainFrame.getMainInstance().getActiveReportFrame());      
        wizardDialog = new JDialog(MainFrame.getMainInstance(),true);
        wizardPanel = new BaseWizardPanel();
        wizardPanel.setGenericWizard(this);
        wizardDialog.getContentPane().add(wizardPanel);
        wizardDialog.pack();
        Misc.centerFrame(wizardDialog);
        
        wizardDialog.setVisible(true);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel0 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabelErrorMessage = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jComboBoxObject = new javax.swing.JComboBox();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRTextExpressionArea = new it.businesslogic.ireport.gui.JRTextExpressionArea();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();

        jPanel0.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanel0PropertyChange(evt);
            }
        });
        jPanel0.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Group name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 24, 0, 24);
        jPanel0.add(jLabel1, gridBagConstraints);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 24, 0, 10);
        jPanel0.add(jTextField1, gridBagConstraints);

        jLabelErrorMessage.setForeground(new java.awt.Color(204, 0, 51));
        jLabelErrorMessage.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 24, 15, 10);
        jPanel0.add(jLabelErrorMessage, gridBagConstraints);

        jPanel61.setMinimumSize(new java.awt.Dimension(10, 30));
        jPanel61.setPreferredSize(new java.awt.Dimension(10, 30));
        jPanel0.add(jPanel61, new java.awt.GridBagConstraints());

        jPanel6.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel0.add(jPanel6, gridBagConstraints);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Group by the following report object:");
        jRadioButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 24, 0, 10);
        jPanel0.add(jRadioButton1, gridBagConstraints);

        jComboBoxObject.setMinimumSize(new java.awt.Dimension(51, 22));
        jComboBoxObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxObjectActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 40, 0, 10);
        jPanel0.add(jComboBoxObject, gridBagConstraints);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Group by the following expression:");
        jRadioButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jRadioButton2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jRadioButton2PropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(16, 24, 0, 10);
        jPanel0.add(jRadioButton2, gridBagConstraints);

        jRTextExpressionArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jRTextExpressionArea.setElectricScroll(0);
        jRTextExpressionArea.setMinimumSize(new java.awt.Dimension(300, 47));
        jRTextExpressionArea.setPreferredSize(new java.awt.Dimension(300, 120));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 40, 10, 6);
        jPanel0.add(jRTextExpressionArea, gridBagConstraints);

        jPanel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanel1PropertyChange(evt);
            }
        });
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Add the group header");
        jCheckBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(24, 24, 0, 24);
        jPanel1.add(jCheckBox1, gridBagConstraints);

        jCheckBox2.setSelected(true);
        jCheckBox2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox2.setLabel("Add the group footer");
        jCheckBox2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 24, 0, 24);
        jPanel1.add(jCheckBox2, gridBagConstraints);

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    
    
    
}//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if (wizardPanel != null) wizardPanel.updateButtons();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if (wizardPanel != null) wizardPanel.updateButtons();
        
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jRadioButton2PropertyChange
        
    }//GEN-LAST:event_jRadioButton2PropertyChange

    private void jPanel1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanel1PropertyChange

    }//GEN-LAST:event_jPanel1PropertyChange

    private void jComboBoxObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxObjectActionPerformed
       
        if (wizardPanel != null) wizardPanel.updateButtons();
    }//GEN-LAST:event_jComboBoxObjectActionPerformed

    
    private void jPanel0PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanel0PropertyChange

        
        
    }//GEN-LAST:event_jPanel0PropertyChange
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox jComboBoxObject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelErrorMessage;
    private javax.swing.JPanel jPanel0;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel61;
    private it.businesslogic.ireport.gui.JRTextExpressionArea jRTextExpressionArea;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables


    public String[] getStepsNames() {
        
        String[] names = new String[2];
        //
        names[0] = I18n.getString("reportGroupWizard.stepsnames.criteria","Criteria");
        names[1] = I18n.getString("reportGroupWizard.stepsnames.details","Details");
        //names[0] = "Criteria";
        //names[1] = "Details";
        //
        return names;
    }

    public String getStepDescription(int step) {
        
    	//
        if (step==0) return
        		I18n.getString("reportGroupWizard.stepdescription.step0","Choose the group by criteria");
        		//"Choose the group by criteria";        
        if (step==1) return
        		I18n.getString("reportGroupWizard.stepdescription.step1","Group details");
        		//"Group details";
        //
        return "";
    }

    public void initWizard() {
        // init objects...
    }

    public void finish(int currentStep) {
        
        if (currentStep != -1)
        {
                Report report =  getJReportFrame().getReport();
                Group grp = new Group(report, jTextField1.getText().trim());
                int available_vertical_space = report.getAvailableVerticalSpace();
                if (jCheckBox1.isSelected() && jCheckBox2.isSelected()) available_vertical_space /= 2;
                if (available_vertical_space>50) available_vertical_space = 50;

                if (jCheckBox1.isSelected()) grp.getGroupHeader().setHeight(available_vertical_space);
                if (jCheckBox2.isSelected()) grp.getGroupFooter().setHeight(available_vertical_space);

                // Expression...
                if (jRadioButton1.isSelected())
                {
                    Object obj = jComboBoxObject.getSelectedItem();
                    if (obj != null && (""+obj).trim().length() > 0)
                    {
                        if (obj instanceof it.businesslogic.ireport.JRParameter)
                        {
                           obj = "$P{" + obj + "}";
                        }
                        else if (obj instanceof it.businesslogic.ireport.JRVariable)
                        {
                           obj = "$V{" + obj + "}";
                        }
                        else if (obj instanceof it.businesslogic.ireport.JRField)
                        {
                            obj = "$F{" + obj + "}";
                        }

                        grp.setGroupExpression( ""+obj);
                    }
                }
                else
                {
                    grp.setGroupExpression( jRTextExpressionArea.getText().trim());

                }


                report.addGroup(grp, true);
                getJReportFrame().repaint();

                MainFrame.getMainInstance().getGroupsDialog().updateGroups();
                MainFrame.getMainInstance().getBandsDialog().updateBands();
                MainFrame.getMainInstance().getElementPropertiesDialog().updateBands();
                MainFrame.getMainInstance().getElementPropertiesDialog().updateGroups();
                MainFrame.getMainInstance().reportBandChanged( new ReportBandChangedEvent(this.getJReportFrame(), null, ReportBandChangedEvent.ADDED ));
        }
        
        this.getWizardDialog().setVisible(false);
        this.getWizardDialog().dispose();
    }
    
    public boolean nextStep(int nextStep) {
        
        if (nextStep == 0) // First step == 0
        {
           
        } 
        else if (nextStep == 1) 
        {
            
        }
        return true;
    }

    public boolean previousStep(int previousStep) {
        return true;
    }

    public boolean canFinish(int currentStep) {
        
        if (currentStep>0) return true;
        else return canNext(currentStep);
    }

    public boolean canNext(int currentStep) {
        
        if (currentStep == 0)
        {
            if (jTextField1.getText().trim().length() == 0) return false;
            // Check it the group name is already in use...
            Vector v = getJReportFrame().getReport().getGroups();
            String s = jTextField1.getText().trim();
            jLabelErrorMessage.setText(" ");

            for (int i=0; i<v.size(); ++i)
            {
                if (s.equals( ((Group)v.elementAt(i)).getName()))
                {
                	//
                	String msg = new String(I18n.getString("reportGroupWizard.jLabelErrorMessage","This group name is already in use."));
                	jLabelErrorMessage.setText(msg);
                	//
                	
                    //jLabelErrorMessage.setText("This group name is already in use.");
                    return false;
                }
            }
            
            if (s.equals("page") || s.equals("column") || s.equals("lastPage"))
            {
                jLabelErrorMessage.setText(I18n.getString("messages.invalidGroupName","Invalid group name!"));
                return false;
            }
            
            if (jRadioButton1.isSelected() && jComboBoxObject.getSelectedItem() != null) return true;
            if (jRadioButton2.isSelected() && jRTextExpressionArea.getText().trim().length() > 0) return true;
        }
        else if (currentStep == 1)
        {
            return false;
        }
        return false;
    }

    public boolean canPrevious(int currentStep) {
        return (currentStep > 0);
    }

    public JPanel getStepPanel(int step) {

       if (step == 0) return jPanel0;
       if (step == 1) return jPanel1;
       //if (step == 4) return jPanel4;
       return  null;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }

    public SubReportElement getSubReportElement() {
        return subReportElement;
    }

    public void setSubReportElement(SubReportElement subReportElement) {
        this.subReportElement = subReportElement;
    }

    public BaseWizardPanel getWizardPanel() {
        return wizardPanel;
    }

    public void setWizardPanel(BaseWizardPanel wizardPanel) {
        this.wizardPanel = wizardPanel;
    }

    public javax.swing.JDialog getWizardDialog() {
        return wizardDialog;
    }

    public void setWizardDialog(javax.swing.JDialog wizardDialog) {
        this.wizardDialog = wizardDialog;
    }

    public JReportFrame getJReportFrame() {
        return jReportFrame;
    }

    public void setJReportFrame(JReportFrame jReportFrame) {
        this.jReportFrame = jReportFrame;
    }
    
    
    public void applyI18n(){
                // Start autogenerated code ----------------------
                jCheckBox1.setText(I18n.getString("reportGroupWizard.checkBox1","Add the group header"));
                jRadioButton1.setText(I18n.getString("reportGroupWizard.radioButton1","Group by the following report object:"));
                jRadioButton2.setText(I18n.getString("reportGroupWizard.radioButton2","Group by the following expression:"));
                // End autogenerated code ----------------------
                // Start autogenerated code ----------------------
                jLabel1.setText(I18n.getString("reportGroupWizard.label1","Group name"));
                // End autogenerated code ----------------------
                
                //
                jCheckBox2.setText(I18n.getString("reportGroupWizard.checkBox2","Add the group footer"));
                //
    }
}
