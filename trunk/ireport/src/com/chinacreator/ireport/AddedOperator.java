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
package com.chinacreator.ireport;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import com.chinacreator.ireport.rmi.IreportFile;
import com.chinacreator.ireport.rmi.IreportRmiClient;

/**
 * @author 李茂
 * @since 3.0
 * @version $Id: AddedOperator.java 2009-9-1 下午02:50:45 $
 *
 */
//begin AddedOperator.java

//所有后期添加的操作方法都从这里调用
public class AddedOperator implements AddedOepretorInterface{

	public static AddedOepretorInterface addInstance = null;
	public Object afterClose() {
		// FIXME Auto-generated method stub
		return null;
	}

	public Object afterOpen() {
		// FIXME Auto-generated method stub
		return null;
	}

	public Object afterSave(String saveFilePath) {
		 try {
	           String filePath =  saveFilePath;
	           File f = new File(filePath);
	           IreportFile rf = new IreportFile();
	           rf.setFileName(f.getName());

	           byte[] content = new byte[(int)f.length()];
	           BufferedInputStream input = new BufferedInputStream(new FileInputStream(f));
	           input.read(content);
	           if(input != null ){
		              try{
		                  input.close();
		                  input = null ;
		              }catch(Exception ex){
		              }
		           }
	           rf.setContent(content);
	           IreportRmiClient.getInstance().rmiInterfactRemote.save(rf);
	            } catch (Exception e) {
					e.printStackTrace();
		}
		return null;
	}

	public Object afterSaveAll() {
		// FIXME Auto-generated method stub
		return null;
	}

	public Object beforeClose() {
		// FIXME Auto-generated method stub
		return null;
	}

	public Object beforeOpen() {
		// FIXME Auto-generated method stub
		return null;
	}

	public Object beforeSave() {
		// FIXME Auto-generated method stub
		return null;
	}

	public Object beforeSaveAll() {
		// FIXME Auto-generated method stub
		return null;
	}

	//不需要同步锁
	public static AddedOepretorInterface getInstance(){
		if(addInstance == null){
			addInstance =  new AddedOperator();
		}
		return addInstance;
	}


}

//end AddedOperator.java