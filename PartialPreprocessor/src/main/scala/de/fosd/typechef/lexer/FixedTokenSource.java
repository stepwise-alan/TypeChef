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
import java.util.Arrays;
import java.util.List;

/* pp */class FixedTokenSource extends Source {
    private static final Token EOF = new SimpleToken(Token.EOF, "<ts-eof>", null);

    private final List<Token> tokens;
    private int idx;

    /* pp */FixedTokenSource(Token... tokens) {
        this.tokens = Arrays.asList(tokens);
        this.idx = 0;
    }

    /* pp */FixedTokenSource(List<Token> tokens) {
        this.tokens = tokens;
        this.idx = 0;
    }

    public Token token() throws IOException, LexerException {
        if (idx >= tokens.size())
            return EOF;
        return tokens.get(idx++);
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("constant token stream ").append(tokens);
        Source parent = getParent();
        if (parent != null)
            buf.append(" in ").append(parent);
        return buf.toString();
    }

    @Override
    String debug_getContent() {
        return tokens.toString();
    }
}

/* pp */class FixedUnexpandingTokenSource extends FixedTokenSource {
    private final String macroName;

    FixedUnexpandingTokenSource(List<Token> tokens, String macroName) {
        super(tokens);
        this.macroName = macroName;
    }

    @Override
    boolean mayExpand(String macroName) {
        if (macroName.equals(this.macroName))
            return false;// already expanding this macro

        return super.mayExpand(macroName);
    }
}
