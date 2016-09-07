/*
 * Licensed to Diennea S.r.l. under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Diennea S.r.l. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package docet;

import docet.error.DocetPackageNotFoundException;

public interface DocetPackageLocator {
    
    /**
     * Returns a descriptor of Docet package location if package with id
     * packageId exists.
     *
     * @param packageId
     *            id of the package
     * @param ctx
     *            docet execution context
     *
     * @return an instance of {@link DocetPackageLocation}
     *
     * @throws DocetPackageNotFoundException
     *             if no package with id packageId can be found
     */
    DocetPackageLocation findPackageLocationById(final String packageId, final DocetExecutionContext ctx)
        throws DocetPackageNotFoundException;

    /**
     * Check whether, given an execution context, the package specified via
     * packageId can be accessed.
     *
     * @param packageId
     *            id of the package to check access permission on
     * @param ctx
     *            execution context of Docet
     *
     * @return true if package packageId can be accessed, false otherwise
     */
    default boolean assertPackageAccessPermission(final String packageId, final DocetExecutionContext ctx) {
        return true;
    }
    
}
