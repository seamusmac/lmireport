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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author ¿Ó√Ø
 * @since 3.0
 * @version $Id: IreportUtil.java 2009-8-20 œ¬ŒÁ04:42:59 $
 *
 */
//begin IreportUtil.java
public class IreportUtil {
	public static File bytesToFile(String filePath,byte[] content){
		try {
			if(isBlank(filePath)){
				return null;
			}
			 BufferedOutputStream output = null ;
	         File file = new File(filePath);
	         if(!file.exists()){
	             file.createNewFile();
	         }
	         //save the content to the file
	         output = new BufferedOutputStream(new FileOutputStream(file));
	         output.write(content);
	         if(output != null ){
	              try{
	                  output.close();
	                  output = null ;
	              }catch(Exception ex){
	              }
	           }
	         return file;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}


	}

	public static boolean isBlank(String str){
		return str==null?true:str.trim().equals("");
	}
}

//end IreportUtil.java