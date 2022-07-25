/*
 * TypeChef Variability-Aware Lexer.
 * Copyright 2010-2011, Christian Kaestner, Paolo Giarrusso
 * Licensed under GPL 3.0
 *
 * built on top of
 *
 * Anarres C Preprocessor
 * Copyright (c) 2007-2008, Shevek
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */

package de.fosd.typechef.lexer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * A {@link Source} which lexes a file.
 * <p/>
 * The input is buffered.
 *
 * @see Source
 */
@SuppressWarnings("unused")
public class InputLexerSource extends LexerSource {
    /**
     * Creates a new Source for lexing the given Reader.
     * <p/>
     * Preprocessor directives are honoured within the file.
     */
    public InputLexerSource(InputStream input) {
        super(
                new BufferedReader(
                        new InputStreamReader(
                                input
                        )
                ),
                true
        );
    }

    @Override
        /* pp */ String getPath() {
        return "<standard-input>";
    }

    @Override
        /* pp */ String getName() {
        return "standard input";
    }

    public String toString() {
        return getPath();
    }
}
