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



/**
 * <p>
 * Access command for finding entities similar to another entity.
 * </p>
 * <p>
 * Command design pattern.
 * </p>
 *
 */
public interface FindByExampleAccess2<T,R> extends Cacheable, Ordered {
    void setExample(T example);

    void setExcludeProperties(String[] excludeProperties);

    void execute();

	// allow to set query hints like timeout,...
	void setHint(String hint, Object value);

    void setUseSingleResult(boolean singleResult);
    R getSingleResult();

    @Deprecated
    void setOrderByAsc(boolean orderByAsc);

    List<R> getResult();
}
