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

import java.io.IOException;
import java.io.StringReader;

/**
 * A Source for lexing a String.
 * <p/>
 * This class is used by token pasting, but can be used by user
 * code.
 */
public class StringLexerSource extends LexerSource {


    private final String string;

    /**
     * Creates a new Source for lexing the given String.
     *
     * @param ppvalid true if preprocessor directives are to be
     *                honoured within the string.
     */
    public StringLexerSource(String string, boolean ppvalid) {
        super(new StringReader(string), ppvalid);
        this.string = string;
    }

    /**
     * Creates a new Source for lexing the given String.
     * <p/>
     * By default, preprocessor directives are not honoured within
     * the string.
     */
    public StringLexerSource(String string)
            throws IOException {
        this(string, false);
    }

    public String toString() {
        return "string literal: " + string;
    }

    @Override
    String debug_getContent() {
        return string;
    }

    public String getName() {
        return "string input";
    }
}
