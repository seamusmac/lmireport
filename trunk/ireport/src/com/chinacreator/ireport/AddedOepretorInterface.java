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

/**
 * @author 李茂
 * @since 3.0
 * @version $Id: AddedOepretorInterface.java 2009-9-1 下午02:54:18 $
 *
 */
//begin AddedOepretorInterface.java
public interface AddedOepretorInterface {
	/**
	 * 打开某文件之前
	 * @return
	 */
	Object beforeOpen();

	/**
	 * 打开文件之后
	 * @return
	 */
	Object afterOpen();

	Object beforeSave();

	Object afterSave(String saveFilePath);

	Object beforeSaveAll();

	Object afterSaveAll();

	Object beforeClose();

	Object afterClose();

	Object registerSongTi();

}

//end AddedOepretorInterface.java