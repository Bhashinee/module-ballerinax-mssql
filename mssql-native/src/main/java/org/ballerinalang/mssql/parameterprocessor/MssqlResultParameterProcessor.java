/*
 *  Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.ballerinalang.mssql.parameterprocessor;

import org.ballerinalang.sql.parameterprocessor.DefaultResultParameterProcessor;

/**
 * This class overides methods of DefaultResultParameterProcessor to implement the methods required to 
 * convert SQL types into ballerina types and other methods that process the parameters of the result.
 *
 * @since 0.1.0
 */
public class MssqlResultParameterProcessor extends DefaultResultParameterProcessor {
    private static final Object lock = new Object();
    private static volatile MssqlResultParameterProcessor instance;

    public static MssqlResultParameterProcessor getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new MssqlResultParameterProcessor();
                }
            }
        }
        return instance;
    }
}
