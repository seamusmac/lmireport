/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package com.chinacreator.ireport.rmi;

import it.businesslogic.ireport.gui.JReportFrame;
import it.businesslogic.ireport.gui.MainFrame;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author ¿Ó√Ø
 * @since 3.0
 * @version $Id: ClientRmiServerInterfaceImpl.java 2009-9-7 …œŒÁ10:09:51 $
 *
 */
//begin ClientRmiServerInterfaceImpl.java
public class ClientRmiServerInterfaceImpl extends UnicastRemoteObject implements
		ClientRmiServerInterface {

	private static ClientRmiServerInterfaceImpl crm= null;

	public static ClientRmiServerInterfaceImpl getInstance(){
		if(crm == null){
			try {
				crm = new ClientRmiServerInterfaceImpl();
			} catch (RemoteException e) {
				// FIXME Auto-generated catch block
				e.printStackTrace();
			}
		}
		return crm;
	}
	public ClientRmiServerInterfaceImpl() throws RemoteException{
		super();
	}
	public boolean linkCheck() throws RemoteException{
		return true;
	}

	public Object openFile(IreportSession session,File file) throws RemoteException{
		setVisible(true);
		new Thread(new Runnable(){

			public void run() {
				File file1 = new File("G:\\z\\fgh.jrxml");
			      try {
			          JReportFrame jrf = MainFrame.getMainInstance().openFile( file1 );
			          jrf.setSelected(true);
			      } catch (Exception ex){
			          ex.printStackTrace();
			      }

			}

		}).start();
		return null;
	}

	  public boolean setVisible(boolean b)
	  {
	      MainFrame.getMainInstance().setVisible(b);
	      if (MainFrame.getMainInstance().getState() == java.awt.Frame.ICONIFIED)
	      {
	            MainFrame.getMainInstance().setState( java.awt.Frame.NORMAL );
	      }
	      return MainFrame.getMainInstance().requestFocusInWindow();
	  }
}

//end ClientRmiServerInterfaceImpl.java