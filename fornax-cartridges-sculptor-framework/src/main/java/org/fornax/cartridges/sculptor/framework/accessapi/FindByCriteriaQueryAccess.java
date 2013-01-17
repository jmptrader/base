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

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaQuery;

/**
 * Access command for finding objects by JPA2 criteria query
 *
 * @author Oliver Ringel
 *
 * @param <R> result type of the query
 */
public interface FindByCriteriaQueryAccess<R> extends Cacheable, Ordered, Pageable, Countable {

    void setQuery(CriteriaQuery<R> criteriaQuery);

    void setParameters(Map<String, Object> parameters);

    void setUseSingleResult(boolean singleResult);

    void execute();

    /**
     * The result of the command.
     */
    List<R> getResult();

    /**
     * Result when singleResult is used.
     */
    R getSingleResult();

	void setHint(String hint, Object value);
}