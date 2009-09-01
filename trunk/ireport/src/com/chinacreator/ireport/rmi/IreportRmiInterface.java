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

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author 李茂
 * @since 3.0
 * @version $Id: IreportRmiInterface.java 2009-8-19 上午08:47:03 $
 *
 */
//begin IreportRmiInterface.java
public interface IreportRmiInterface extends Remote{
	//测试方法
	int add(int a,int b)throws RemoteException;

	//保存过程
	void save(IreportFile ireportFile)throws RemoteException;

	//打开远程文件
	IreportFile open(String fileName)throws RemoteException;

	//获取数据源列表
	List<DataSouceInfo> getDataSourceList()throws RemoteException;
}

//end IreportRmiInterface.java