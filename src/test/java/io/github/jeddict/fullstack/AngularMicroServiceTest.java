/**
 * Copyright 2013-2018 the original author or authors from the Jeddict project (https://jeddict.github.io/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package io.github.jeddict.fullstack;

import io.github.jeddict.client.angular.AngularGenerator;
import io.github.jeddict.client.web.main.WebData;
import io.github.jeddict.jcode.TechContext;
import static java.util.Arrays.asList;
import org.junit.jupiter.api.Test;
import org.netbeans.api.project.Project;

/**
 *
 * @author jGauravGupta
 */
public class AngularMicroServiceTest extends RestApplicationTest {

    @Test
    @Override
    void test() throws Exception {
        Project gatewayProject = generateGateway("angular-sample-gateway-app", "emp-job.jpa");
        Project microServiceProject = generateMicroService("angular-sample-microservice-app", "emp-job.jpa", gatewayProject);

        fireMavenBuild(gatewayProject, asList("clean", "install"), asList("prod"), null);
        //-Dweb.host=<container host> -Dweb.port=<container port>  registry.url
        fireMavenBuild(microServiceProject, asList("clean", "install"), asList("prod"), null);
    }

    @Override
    protected TechContext getViewerContext() {
        WebData webData = new WebData();
        webData.setModule("sample-module");
        webData.setApplicationTitle("sample-app");
        webData.setPrefix("jee");
        webData.setProtractorTest(true);
        webData.setSass(false);
        TechContext techContext = new TechContext(AngularGenerator.class);
        techContext.setConfigData(webData);
        return techContext;
    }

}
