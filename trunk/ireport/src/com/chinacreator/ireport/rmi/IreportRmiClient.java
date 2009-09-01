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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.Naming;

/**
 * @author 李茂
 * @since 3.0
 * @version $Id: IreportRmiClient.java 2009-8-19 上午08:53:02 $
 *
 */
//begin IreportRmiClient.java
public class IreportRmiClient {
	private static IreportRmiClient client = null;
	public static IreportRmiInterface rmiInterfactRemote = null;
	private static String ip = "127.0.0.1";//由外部传入
	private static String port = "10086"; //由外部传入



	public static synchronized IreportRmiClient getInstance (){
		try {
		if(client == null){
			rmiInterfactRemote = (IreportRmiInterface) Naming.lookup("rmi://"+ip+":"+port+"/ireportRmiServer");
			client = new IreportRmiClient();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}

	public static IreportRmiInterface getRmiRemoteInterface(){
		getInstance();
		return rmiInterfactRemote;

	}

	public static void main(String[] args) throws Exception{
		BufferedInputStream input = null ;
		IreportFile ireportFile = new IreportFile();
		File f = new File("F:\\2\\123.txt");
		ireportFile.setFileName("aaaa.txt");
		byte[] content = new byte[(int)f.length()];
		input = new BufferedInputStream(new FileInputStream(f));
	    input.read(content);
		ireportFile.setContent(content);
		getRmiRemoteInterface().save(ireportFile);
		System.out.println("OVER.....");

		
	}


}

//end IreportRmiClient.java