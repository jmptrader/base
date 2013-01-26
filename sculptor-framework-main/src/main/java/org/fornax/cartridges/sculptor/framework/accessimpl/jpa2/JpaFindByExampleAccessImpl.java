/*
 * Copyright 2007 The Fornax Project Team, including the original
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

package org.fornax.cartridges.sculptor.framework.accessimpl.jpa2;

import org.fornax.cartridges.sculptor.framework.accessapi.FindByExampleAccess;


/**
 * <p>
 * Find all entities similar to another entity. Implementation of Access command
 * FindByExampleAccess.
 * </p>
 * <p>
 * Command design pattern.
 * </p>
 */
public class JpaFindByExampleAccessImpl<T>
    extends JpaFindByExampleAccessImplGeneric<T,T>
    implements FindByExampleAccess<T> {

    public JpaFindByExampleAccessImpl() {
        super();
    }

    public JpaFindByExampleAccessImpl(Class<T> type) {
        super(type);
    }
}