/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */

package org.apache.commons.text.lookup;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.commons.text.StringSubstitutor;

/**
 * Encodes Base64 Strings.
 * <p>
 * Using a {@link StringLookup} from the {@link StringLookupFactory}:
 * </p>
 *
 * <pre>
 * StringLookupFactory.INSTANCE.base64EncoderStringLookup().lookup("HelloWorld!");
 * </pre>
 * <p>
 * Using a {@link StringSubstitutor}:
 * </p>
 *
 * <pre>
 * StringSubstitutor.createInterpolator().replace("... ${base64Encoder:HelloWorld!} ..."));
 * </pre>
 * <p>
 * The above examples convert {@code "HelloWorld!"} to {@code "SGVsbG9Xb3JsZCE="}.
 * </p>
 *
 * @since 1.6
 */
final class Base64EncoderStringLookup extends AbstractStringLookup {

    /**
     * Defines the singleton for this class.
     */
    static final Base64EncoderStringLookup INSTANCE = new Base64EncoderStringLookup();

    /**
     * No need to build instances for now.
     */
    private Base64EncoderStringLookup() {
        // empty
    }

    @Override
    public String lookup(final String key) {
        if (key == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(key.getBytes(StandardCharsets.ISO_8859_1));
    }

}
