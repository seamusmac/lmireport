/*
 * FontLoaderDialog.java
 *
 * Created on November 13, 2006, 8:30 AM
 */

package it.businesslogic.ireport.gui.fonts;

import it.businesslogic.ireport.FontsLoaderMonitor;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import it.businesslogic.ireport.util.I18n;

/**
 *
 * @author  gtoffoli
 */
public class FontLoaderDialog extends javax.swing.JDialog implements FontsLoaderMonitor {
    
    /** Creates new form FontLoaderDialog */
    public FontLoaderDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        applyI18n();
        this.pack();
        
        it.businesslogic.ireport.util.Misc.centerFrame( this );
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelStatus = new javax.swing.JLabel();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jLabelStatus.setText("Loading status");
        jLabelStatus.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelStatus.setPreferredSize(new java.awt.Dimension(391, 51));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(jLabelStatus, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FontLoaderDialog(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }

    public void setStatus(String s)
    {
        jLabelStatus.setText(s);
    }
    
    public void fontsLoadingStatusUpdated(String statusMsg) {
        
        final String s = statusMsg;
        try {
            SwingUtilities.invokeAndWait( new Runnable()
            {
                public void run()
                {
                    setStatus(s);
                }
            }
            );
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
        
    }

    public void fontsLoadingStarted() {
        
        try {
            SwingUtilities.invokeAndWait( new Runnable()
            {
                public void run()
                {
                    setVisible(true);
                }
            }
            );
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }

    public void fontsLoadingFinished() {
        try {
            SwingUtilities.invokeAndWait( new Runnable()
            {
                public void run()
                {
                    setVisible(false);
                }
            }
            );
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelStatus;
    // End of variables declaration//GEN-END:variables
    
    public void applyI18n(){
                // Start autogenerated code ----------------------
                jLabelStatus.setText(I18n.getString("fontLoaderDialog.labelStatus","Loading status"));
                // End autogenerated code ----------------------
    }
}
