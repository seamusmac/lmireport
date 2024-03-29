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
 * JRParameterDialog.java
 * 
 * Created on 9 maggio 2003, 17.25
 *
 */

package it.businesslogic.ireport.gui;

import it.businesslogic.ireport.util.*;
import it.businesslogic.ireport.*;
import java.util.Iterator;
import javax.swing.JOptionPane;
/**
 *
 * @author  Administrator
 */
public class JRParameterDialog extends javax.swing.JDialog {
    /** Creates new form JRParameterDialog */
    JRParameter tmpParameter = null;
    private SubDataset subDataset = null;
    String originalName = null;
    
    private java.util.List properties = new java.util.ArrayList();
    
    public JRParameterDialog(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        initComponents();
        applyI18n();
        this.jRTextExpressionAreaDefaultExpression.setText("");
        setClassTypes();               
        this.jComboBoxType.setSelectedItem("java.lang.String");
        jComboBoxType.setEditable(true);
        
        
        javax.swing.KeyStroke escape =  javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0, false);
        javax.swing.Action escapeAction = new javax.swing.AbstractAction() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                jButtonCancelActionPerformed(e);
            }
        };
       
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);


        //to make the default button ...
        this.getRootPane().setDefaultButton(this.jButtonOK);
    }
    
    public void setClassTypes()
    {
        this.jComboBoxType.addItem("java.lang.String");
        this.jComboBoxType.addItem("java.lang.Object");
        this.jComboBoxType.addItem("java.lang.Boolean");
        this.jComboBoxType.addItem("java.lang.Byte");
        this.jComboBoxType.addItem("java.util.Date");
        this.jComboBoxType.addItem("java.sql.Timestamp");
        this.jComboBoxType.addItem("java.sql.Time");
        this.jComboBoxType.addItem("java.lang.Double");
        this.jComboBoxType.addItem("java.lang.Float");
        this.jComboBoxType.addItem("java.lang.Integer");
        this.jComboBoxType.addItem("java.io.InputStream");
        this.jComboBoxType.addItem("java.lang.Long");
        this.jComboBoxType.addItem("java.lang.Short");
        this.jComboBoxType.addItem("java.math.BigDecimal");
        this.jComboBoxType.addItem("java.util.Collection");
        this.jComboBoxType.addItem("net.sf.jasperreports.engine.JREmptyDataSource");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxType = new javax.swing.JComboBox();
        jCheckBoxIsForPrompting = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jRTextExpressionAreaDefaultExpression = new it.businesslogic.ireport.gui.JRTextExpressionArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jButtonParameterProperties = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setTitle("Add/modify parameter");
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setText("Parameter name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        getContentPane().add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        getContentPane().add(jTextFieldName, gridBagConstraints);

        jLabel2.setText("Parameter class type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        getContentPane().add(jLabel2, gridBagConstraints);

        jComboBoxType.setEditable(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        getContentPane().add(jComboBoxType, gridBagConstraints);

        jCheckBoxIsForPrompting.setText("Is for prompting");
        jCheckBoxIsForPrompting.setNextFocusableComponent(jRTextExpressionAreaDefaultExpression);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jCheckBoxIsForPrompting, gridBagConstraints);

        jLabel3.setText("Default value expression");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        getContentPane().add(jLabel3, gridBagConstraints);

        jRTextExpressionAreaDefaultExpression.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jRTextExpressionAreaDefaultExpression.setCaretVisible(false);
        jRTextExpressionAreaDefaultExpression.setElectricScroll(0);
        jRTextExpressionAreaDefaultExpression.setMinimumSize(new java.awt.Dimension(0, 60));
        jRTextExpressionAreaDefaultExpression.setPreferredSize(new java.awt.Dimension(310, 60));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        getContentPane().add(jRTextExpressionAreaDefaultExpression, gridBagConstraints);

        jLabel4.setText("Parameter description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        getContentPane().add(jLabel4, gridBagConstraints);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(22, 50));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(3, 50));
        jTextAreaDescription.setMinimumSize(new java.awt.Dimension(0, 32));
        jScrollPane1.setViewportView(jTextAreaDescription);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jButtonParameterProperties.setText("Edit parameter properties...");
        jButtonParameterProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonParameterPropertiesActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 0, 4);
        getContentPane().add(jButtonParameterProperties, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jSeparator1.setMinimumSize(new java.awt.Dimension(2, 2));
        jSeparator1.setPreferredSize(new java.awt.Dimension(2, 2));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 4, 0);
        jPanel1.add(jSeparator1, gridBagConstraints);

        jButtonOK.setMnemonic('o');
        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        jPanel1.add(jButtonOK, gridBagConstraints);

        jButtonCancel.setMnemonic('c');
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        jPanel1.add(jButtonCancel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonParameterPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonParameterPropertiesActionPerformed
        PropertiesDialog pd = new PropertiesDialog(this, true);
        pd.setProperties( getProperties() );
        pd.setVisible(true);
        
        if (pd.getDialogResult() == JOptionPane.OK_OPTION)
        {
            this.setProperties(pd.getProperties());
        }
    }//GEN-LAST:event_jButtonParameterPropertiesActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        setVisible(false);
        this.setDialogResult( javax.swing.JOptionPane.CANCEL_OPTION);
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
         if (this.jTextFieldName.getText().trim().length() <= 0)
        {
            javax.swing.JOptionPane.showMessageDialog(this,
                    I18n.getString( "messages.jRParameterDialog.notValidParameterName","Please insert a valid parameter name!"),
                    I18n.getString( "messages.jRParameterDialog.notValidParameterNameCaption","Invalid parameter!"),
                    javax.swing.JOptionPane.WARNING_MESSAGE );
            return;
        }
        
         if (getSubDataset() != null)
         {
             //check unique name...
             String newName = this.jTextFieldName.getText();
             if (originalName == null || !originalName.equals(newName))
             {
                 for (int i=0; i< getSubDataset().getParameters().size(); ++i)
                 {
                     JRParameter f = (JRParameter)getSubDataset().getParameters().get(i);
                     if (f.getName().equals(newName))
                     {
                         javax.swing.JOptionPane.showMessageDialog(this,
                            I18n.getString( "messages.jRParameterDialog.DuplicatedParameterName","A parameter with this name already exists!"),
                            I18n.getString( "messages.jRParameterDialog.notValidParameterNameCaption","Invalid parameter!"),
                            javax.swing.JOptionPane.WARNING_MESSAGE );
                         return;
                     }
                 }
             }
         }
        
         
        tmpParameter = new JRParameter( this.jTextFieldName.getText(), "java.lang.String",
                                        this.jCheckBoxIsForPrompting.isSelected(),
                                        this.jTextAreaDescription.getText());
        tmpParameter.setProperties( this.properties );
        if (this.jComboBoxType.getSelectedItem().toString().trim().length() != 0)
        {
            tmpParameter.setClassType( this.jComboBoxType.getSelectedItem().toString().trim() );
        }
        tmpParameter.setDefaultValueExpression( jRTextExpressionAreaDefaultExpression.getText());

        setVisible(false);
        this.setDialogResult( javax.swing.JOptionPane.OK_OPTION);
        dispose();
    }//GEN-LAST:event_jButtonOKActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        this.setDialogResult( javax.swing.JOptionPane.CLOSED_OPTION);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /** Getter for property tmpParameter.
     * @return Value of property tmpParameter.
     *
     */
    public it.businesslogic.ireport.JRParameter getParameter() {
        return tmpParameter;
    }    
    
    /** Setter for property tmpParameter.
     * @param tmpParameter New value of property tmpParameter.
     *
     */
    public void setParameter(it.businesslogic.ireport.JRParameter tmpParameter) {
        originalName = tmpParameter.getName();
        this.jTextFieldName.setText( new String(tmpParameter.getName()));
        this.jComboBoxType.setSelectedItem( new String(tmpParameter.getClassType()));
        this.jCheckBoxIsForPrompting.setSelected( tmpParameter.isIsForPrompting() );
        this.jTextAreaDescription.setText( new String(tmpParameter.getDescription()));
        this.jRTextExpressionAreaDefaultExpression.setText( new String(tmpParameter.getDefaultValueExpression()));                       
    
        this.properties = new java.util.ArrayList();
            
        Iterator iter = tmpParameter.getProperties().iterator();
        while (iter.hasNext())
        {
            JRProperty p = (JRProperty)iter.next();
            this.properties.add( p.cloneMe() );
        }
    
    }
    
    /** Getter for property dialogResult.
     * @return Value of property dialogResult.
     *
     */
    public int getDialogResult() {
        return dialogResult;
    }
    
    /** Setter for property dialogResult.
     * @param dialogResult New value of property dialogResult.
     *
     */
    public void setDialogResult(int dialogResult) {
        this.dialogResult = dialogResult;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonParameterProperties;
    private javax.swing.JCheckBox jCheckBoxIsForPrompting;
    private javax.swing.JComboBox jComboBoxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private it.businesslogic.ireport.gui.JRTextExpressionArea jRTextExpressionAreaDefaultExpression;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables

    private int dialogResult;    
    
    public void setSubDataset(SubDataset subDataset) {
    
       this.subDataset = subDataset;
       jRTextExpressionAreaDefaultExpression.setSubDataset( subDataset);
       jRTextExpressionAreaDefaultExpression.getTokenMarker().setKeywordLookup(subDataset.getKeywordLookup());
    }
    
    public void applyI18n(){
                // Start autogenerated code ----------------------
                jCheckBoxIsForPrompting.setText(I18n.getString("jRParameterDialog.checkBoxIsForPrompting","Is for prompting"));
                // End autogenerated code ----------------------
                // Start autogenerated code ----------------------
                jButtonCancel.setText(I18n.getString("jRParameterDialog.buttonCancel","Cancel"));
                jButtonOK.setText(I18n.getString("jRParameterDialog.buttonOK","OK"));
                
                jButtonParameterProperties.setText(I18n.getString("jRParameterDialog.buttonParameterProperties","Edit parameter properties..."));
                
                jLabel1.setText(I18n.getString("jRParameterDialog.label1","Parameter name"));
                jLabel2.setText(I18n.getString("jRParameterDialog.label2","Parameter class type"));
                jLabel3.setText(I18n.getString("jRParameterDialog.label3","Default value expression"));
                jLabel4.setText(I18n.getString("jRParameterDialog.label4","Parameter description"));
                // End autogenerated code ----------------------
                this.setTitle(I18n.getString("jRParameterDialog.title","Add/modify parameter"));
                jButtonCancel.setMnemonic(I18n.getString("jRParameterDialog.buttonCancelMnemonic","c").charAt(0));
                jButtonOK.setMnemonic(I18n.getString("jRParameterDialog.buttonOKMnemonic","o").charAt(0));
    }

    public SubDataset getSubDataset() {
        return subDataset;
    }
    
    
    public static final int COMPONENT_NONE=0;
    public static final int COMPONENT_DEFAULT_EXPRESSION=1;

    /**
     * This method set the focus on a specific component.
     * Valid constants are something like:
     * FIELD_XXX
     */
    public void setFocusedExpression(int expID )
    {
        switch (expID)
        {
            case COMPONENT_DEFAULT_EXPRESSION:
                Misc.selectTextAndFocusArea(jRTextExpressionAreaDefaultExpression);
                break;
        }
        
    }

    public java.util.List getProperties() {
        return properties;
    }

    public void setProperties(java.util.List properties) {
        this.properties = properties;
    }
}
