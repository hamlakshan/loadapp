package org.workflow.core.service.app;

import com.wso2telco.core.dbutils.exception.BusinessException;
import com.wso2telco.core.dbutils.util.ApprovalRequest;
import com.wso2telco.core.dbutils.util.Callback;
import org.apache.commons.logging.LogFactory;
import org.workflow.core.util.DeploymentTypes;

/**
 * Copyright (c) 2016, WSO2.Telco Inc. (http://www.wso2telco.com) All Rights Reserved.
 * <p>
 * WSO2.Telco Inc. licences this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class ExtGtwAppRequestBuilder extends DefaultAppRequestBuilder {
    private static ExtGtwAppRequestBuilder instance;

    {
        log = LogFactory.getLog(DefaultAppRequestBuilder.class);
    }

    private ExtGtwAppRequestBuilder(DeploymentTypes depType) throws BusinessException {
        super.depType = depType;
    }

    public static ExtGtwAppRequestBuilder getInstace(DeploymentTypes depType) throws BusinessException {
        if (instance == null) {
            instance = new ExtGtwAppRequestBuilder(depType);
        }
        return instance;
    }

    @Override
    protected Callback buildApprovalRequest(ApprovalRequest approvalRequest) throws BusinessException {
        return null;
    }
}
