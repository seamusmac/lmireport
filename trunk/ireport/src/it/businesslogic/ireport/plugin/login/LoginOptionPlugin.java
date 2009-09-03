package it.businesslogic.ireport.plugin.login;

import it.businesslogic.ireport.plugin.IReportPlugin;

public class LoginOptionPlugin extends IReportPlugin {

	@Override
	public void call() {
		 java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new LoginOptions(it.businesslogic.ireport.gui.MainFrame.getMainInstance() , true).setVisible(true);
	            }
	        });
	}

}
