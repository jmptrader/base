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

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

import java.io.File;

import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.FileUtils;

public class CleanMojoTest extends AbstractSculptorMojoTestCase<CleanMojo> {

	private static final String ONE_SHOT_GENERATED_FILE = "src/main/java/com/acme/test/domain/Foo.java";
	private static final String GENERATED_FILE = "src/generated/java/com/acme/test/domain/Bar.java";

	public void testDeleteGeneratedFilesWithoutStatusFile() throws Exception {
		CleanMojo mojo = createMojo(createProject("test1"));

		assertTrue(mojo.deleteGeneratedFiles());
	}

	public void testDeleteGeneratedFilesAll() throws Exception {
		CleanMojo mojo = createMojo(createProject("test2"));

		assertTrue(mojo.deleteGeneratedFiles());
		assertFalse(new File(mojo.getProject().getBasedir(),
				ONE_SHOT_GENERATED_FILE).exists());
		assertFalse(new File(mojo.getProject().getBasedir(), GENERATED_FILE)
				.exists());
	}

	public void testDeleteGeneratedFilesKeepOneShot() throws Exception {
		CleanMojo mojo = createMojo(createProject("test2"));

		final File oneShotFile = new File(mojo.getProject().getBasedir(),
				ONE_SHOT_GENERATED_FILE);
		FileUtils.fileAppend(oneShotFile.getAbsolutePath(), "modified");

		assertTrue(mojo.deleteGeneratedFiles());
		assertTrue(oneShotFile.exists());
		assertFalse(new File(mojo.getProject().getBasedir(), GENERATED_FILE)
				.exists());
	}

	public void testExecuteSkip() throws Exception {
		CleanMojo mojo = spy(createMojo(createProject("test1")));
		doThrow(Exception.class).when(mojo).deleteGeneratedFiles();

		setVariableValueToObject(mojo, "skip", true);
		mojo.execute();
	}

	public void testExecute() throws Exception {
		CleanMojo mojo = spy(createMojo(createProject("test2")));
		mojo.execute();
		assertFalse(new File(mojo.getProject().getBasedir(),
				ONE_SHOT_GENERATED_FILE).exists());
		assertFalse(new File(mojo.getProject().getBasedir(), GENERATED_FILE)
				.exists());
		assertNull(mojo.getStatusFile());
	}

	/**
	 * Returns Mojo instance initialized with a {@link MavenProject} created
	 * from the test projects in <code>"src/test/projects/"</code> by given
	 * project name.
	 */
	protected CleanMojo createMojo(MavenProject project) throws Exception {

		// Create spied mojo
		return super.createMojo(project, "clean");
	}

}
