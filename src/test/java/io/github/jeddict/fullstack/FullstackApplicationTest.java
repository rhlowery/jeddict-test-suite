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

import io.github.jeddict.jcode.console.Console;
import static io.github.jeddict.jcode.console.Console.FG_DARK_BLUE;
import io.github.jeddict.jpa.spec.EntityMappings;
import io.github.jeddict.test.BaseModelTest;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.netbeans.api.project.Project;
import org.openide.filesystems.FileObject;

/**
 *
 * @author jGauravGupta
 */
public class FullstackApplicationTest extends BaseModelTest {

    @Test
    void testAngularApp() throws Exception {

        Project project = createProject();
        EntityMappings entityMappings = loadEntityMappings("MonolithModel.jpa");
        assertNotNull(entityMappings);

        FileObject source = getJavaSourceGroup(project);
        assertNotNull(source);
        System.out.println(Console.wrap("Project Path :" + source.getPath(), FG_DARK_BLUE));

        generateClasses(entityMappings, source);

    }

}
