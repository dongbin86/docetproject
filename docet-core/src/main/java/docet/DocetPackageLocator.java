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
     *
     * @return an instance of {@link DocetPackageLocation}
     *
     * @throws DocetPackageNotFoundException
     *             if no package with id packageId can be found
     */
    DocetPackageLocation getPackageLocation(final String packageId)
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

    /**
     * Build an image to be used as default icon when rendering cover page for pdf documents. The only format supported
     * for the retrieved image is png.
     *
     * @return the bytes defining the image to be used in the cover page of pdf documents.
     */
    default byte[] getImageForPdfCovers() {
        return new byte[]{};
    }

    /**
     * Allows to customize docet documents by providing customized text for
     * several placeholders to be placed in docet document templates, for
     * instance in Docet-generated pdf docs. For a list of supported placeholder
     * {@link DocetDocumentPlaceholder}
     *
     * @param placehoder
     * @param lang language required for translating the placeholder
     * @return the custom value for the specified placeholder
     */
    default String getPlaceholderForPdfDocument(final DocetDocumentPlaceholder placehoder, final DocetLanguage lang) {
        return "";
    }
}
