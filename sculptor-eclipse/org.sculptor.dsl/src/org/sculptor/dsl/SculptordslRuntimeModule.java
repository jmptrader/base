/*
 * Copyright 2013 The Sculptor Project Team, including the original 
 * author or authors.
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
package org.sculptor.dsl;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class SculptordslRuntimeModule extends org.sculptor.dsl.AbstractSculptordslRuntimeModule {

	@Override
	@org.eclipse.xtext.service.SingletonBinding(eager=true)	public Class<? extends org.sculptor.dsl.validation.SculptordslJavaValidator> bindSculptordslJavaValidator() {
		return org.sculptor.dsl.validation.SculptordslXtendValidator.class;
	}

}
