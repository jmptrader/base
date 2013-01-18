/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fornax.toolsupport.sculptor.maven.plugin;

import java.io.File;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectBuilder;
import org.codehaus.plexus.util.FileUtils;

public abstract class AbstractSculptorMojoTestCase<T extends AbstractSculptorMojo>
		extends AbstractMojoTestCase {

	public static final String TEST_PROJECT_FOLDER = "src/test/projects/";

	public void setUp() throws Exception {
		// required for mojo lookups to work
		super.setUp();
	}

	/**
	 * Returns a {@link MavenProject} created from the test projects in
	 * <code>"src/test/projects/"</code> by given project name.
	 */
	protected MavenProject createProject(String name) throws Exception {

		// Copy test project
		File srcProject = new File(getBasedir(), TEST_PROJECT_FOLDER + name);
		File targetProject = new File(getBasedir(), "target/test-projects/"
				+ name);

		FileUtils.deleteDirectory(targetProject);
		FileUtils.copyDirectoryStructure(srcProject, targetProject);

		// Create Maven project from POM
		File pom = new File(targetProject, "pom.xml");
		MavenProjectBuilder builder = (MavenProjectBuilder) lookup(MavenProjectBuilder.ROLE);
		return builder.buildWithDependencies(pom, null, null);
	}

	/**
	 * Returns Mojo instance for the given goal. The Mojo instance is
	 * initialized with a {@link MavenProject} created from the test projects in
	 * <code>"src/test/projects/"</code> by given project name.
	 */
	protected T createMojo(MavenProject project, String goal) throws Exception {

		// Create mojo
		@SuppressWarnings("unchecked")
		T mojo = (T) lookupMojo(goal, project.getFile());
		assertNotNull(mojo);

		// Set Maven project
		setVariableValueToObject(mojo, "project", project);

		// Set default values on mojo
		setVariableValueToObject(mojo, "outletSrcOnceDir",
				new File(project.getBasedir(), "src/main/java"));
		setVariableValueToObject(mojo, "outletResOnceDir",
				new File(project.getBasedir(), "src/main/resources"));
		setVariableValueToObject(mojo, "outletSrcDir",
				new File(project.getBasedir(), "src/generated/java"));
		setVariableValueToObject(mojo, "outletResDir",
				new File(project.getBasedir(), "src/generated/resources"));
		setVariableValueToObject(mojo, "outletSrcTestOnceDir",
				new File(project.getBasedir(), "src/test/java"));
		setVariableValueToObject(mojo, "outletResTestOnceDir",
				new File(project.getBasedir(), "src/test/resources"));
		setVariableValueToObject(mojo, "outletSrcTestDir",
				new File(project.getBasedir(), "src/test/generated/java"));
		setVariableValueToObject(mojo, "outletResTestDir",
				new File(project.getBasedir(), "src/test/generated/resources"));
		setVariableValueToObject(mojo, "statusFile",
				new File(project.getBasedir(), ".sculptor-status"));
		return mojo;
	}

}