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

package org.fornax.cartridges.sculptor.framework.accessapi;

import org.fornax.cartridges.sculptor.framework.domain.AssociationSpecification;


/**
 * <p>
 * Populate the specified associations of a persistent object. 
 * </p>
 * <p>
 * Command design pattern.
 * </p>
 * 
 */
public interface PopulateAssociationsAccess<T> {

    void setEntity(T entity);
    
    /**
     * Define the associations to populate.
     */
    void setAssociationSpecification(AssociationSpecification associationSpecification);
    
    void execute();

    /**
     * The result of the command.
     */
    T getResult();

}