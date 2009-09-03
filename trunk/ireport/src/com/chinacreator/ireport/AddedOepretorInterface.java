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

	/**
	 * 在启动初始化完毕后，加载远程数据源，策略为：
	 * 保持本地连接不变，尝试在本地配置文件中查找是否有数据源，若没有直接添加所有远程数据源
	 * 若有，先删除本地数据源再添加所有远程数据源.
	 * @return
	 */
	Object addRemotDatasource();

	/**
	 * 在启动初始化完毕后，若已经传入了需要打开的远程文件名，将尝试打开远程文件
	 * @param fileName  服务器端文件对应文件名
	 * @return
	 */
	Object openRemoteFile(String fileName);

	/**
	 * 用户登陆
	 * @param serverApp 登陆应用 比如 "http://192.168.11.110:8080/app3"
	 * @param username 登陆用户名
	 * @return password 登陆密码
	 */
	Object login(String serverApp,String username,String password);

	/**
	 * 用户注销
	 * @return
	 */
	Object logout();

	/**
	 * 链路检测
	 * @return
	 */
	Object linkCheck();

	/**
	 * 初始服务器模板文件到客户端，初始化策略为
	 * 先查看服务器是端模板文件夹是否有模板文件，若没有尝试从服务器端获取
	 * 若有则不在初始化客户端的时候获取。但是提供额外的功能去同步服务器端的模板
	 * 该模板的初始化应该是异步的，成败不应该影响主程序的运行
	 * @return
	 */
	Object initTemplate();
}

//end AddedOepretorInterface.java