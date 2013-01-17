/**
 * Copyright 2010 The Xtend Tools Team and contributors.
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
package org.fornax.utilities.xtendtools.lib;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;

/**
 * This class provides the implementations for the Java extensions defined in xtext.ext.
 * 
 * @author Ingo Feltes
 */
public final class XtextExtension {

    private XtextExtension() {
    }

    public static Integer getLine(final EObject o) {
        final NodeAdapter adapter = NodeUtil.getNodeAdapter(o);
        if (adapter != null) {
            return adapter.getParserNode().getLine();
        }
        throw new IllegalStateException("No node model attached.");
    }
    
}
