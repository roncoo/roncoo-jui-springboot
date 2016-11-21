/*
 * Copyright 2015-2016 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.roncoo.jui.common.util;

/**
 * 常量工具类
 * 
 * @author wujing
 */
public final class Constants {

	private Constants() {
	}

	/**
	 * 常量
	 * 
	 * @author wujing
	 */
	public interface Token {
		public final static String RONCOO = "roncoo";
	}

	/**
	 * 状态类型
	 * 
	 * @author wujing
	 */
	public interface Status {
		public final static String ZERO = "0";
		public final static String ONE = "1";
		public final static String TWO = "2";
		public final static String THREE = "3";
	}

	/**
	 * 数字类型
	 * 
	 * @author wujing
	 * @version 1.0
	 */
	public interface Num {
		public final static int ZERO = 0;
		public final static int ONE = 1;
		public final static int FIVE = 5;
		public final static int TEN = 10;
	}

}
