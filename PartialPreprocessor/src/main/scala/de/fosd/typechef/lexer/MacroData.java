/*
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A macro object.
 * <p/>
 * This encapsulates a name, an argument count, and a token stream for
 * replacement. The replacement token stream may contain the extra tokens
 * {Token#M_ARG} and {Token#M_STRING}.
 */
@SuppressWarnings("CommentedOutCode")
public class MacroData {
    private Source source;
    /*
     * It's an explicit decision to keep these around here. We don't need to;
     * the argument token type is M_ARG and the value is the index. The strings
     * themselves are only used in stringification of the macro, for debugging.
     */
    private List<String> args;
    private boolean variadic;
    private final List<Token> tokens;

    public MacroData(Source source) {
        this.source = source;
        this.args = null;
        this.variadic = false;
        this.tokens = new ArrayList<>();
    }

    @SuppressWarnings("unused")
    public MacroData() {
        this(null);
    }

    /**
     * Sets the Source from which this macro was parsed.
     */
    public void setSource(Source s) {
        this.source = s;
    }

    /**
     * Returns the Source from which this macro was parsed.
     * <p/>
     * This method may return null if the macro was not parsed from a regular
     * file.
     */
    public Source getSource() {
        return source;
    }

    /**
     * Sets the arguments to this macro.
     */
    public void setArgs(List<String> args) {
        this.args = args;
    }

    /**
     * Returns true if this is a function-like macro.
     */
    public boolean isFunctionLike() {
        return args != null;
    }

    /**
     * Returns the number of arguments to this macro.
     */
    public int getArgCount() {
        if (args == null)
            return 0;
        return args.size();
    }

    /**
     * Sets the variadic flag on this Macro.
     */
    public void setVariadic(boolean b) {
        this.variadic = b;
    }

    /**
     * Returns true if this is a variadic function-like macro.
     */
    public boolean isVariadic() {
        return variadic;
    }

    /**
     * Adds a token to the expansion of this macro.
     */
    public void addToken(Token tok) {
        this.tokens.add(tok);
    }

    /**
     * Adds a "paste" operator to the expansion of this macro.
     * <p/>
     * A paste operator causes the next token added to be pasted to the previous
     * token when the macro is expanded. It is an error for a macro to end with
     * a paste token.
     */
    public void addPaste(Token tok) throws LexerException {
        /*
         * Given: tok0 * We generate: M_PASTE, tok0, tok1 This extends as per a
         * stack language: tok0 * M_PASTE, tok0, M_PASTE, tok1, tok2
         */
        if (tokens.size() > 0)
            this.tokens.add(tokens.size() - 1, tok);
        else
            throw new LexerException("Paste (##) token at beginning of macro");
    }

    /* pp */List<Token> getTokens() {
        return tokens;
    }

    /*
     * Paste tokens are inserted before the first of the two pasted tokens, so
     * it's a kind of bytecode notation. This method swaps them around again. We
     * know that there will never be two sequential paste tokens, so a boolean
     * is sufficient.
     */
    public String getText() {
        StringBuilder buf = new StringBuilder();
        boolean paste = false;
        for (Token tok : tokens) {
            if (tok.getType() == Token.M_PASTE) {
                assert !paste : "Two sequential pastes.";
                paste = true;
                continue;
            } else {
                buf.append(tok.getText());
            }
            if (paste) {
                buf.append(" #" + "# ");
                paste = false;
            }
            // buf.append(tokens.get(i));
        }
        return buf.toString();
    }

    public String toString() {
        StringBuilder buf = new StringBuilder(/* name */);
        if (args != null) {
            buf.append('(');
            Iterator<String> it = args.iterator();
            while (it.hasNext()) {
                buf.append(it.next());
                if (it.hasNext())
                    buf.append(", ");
                else if (isVariadic())
                    buf.append("...");
            }
            buf.append(')');
        }
        if (!tokens.isEmpty()) {
            buf.append(" => ").append(getText());
        }
        // buf.append(" if ").append(feature);
        return buf.toString();
    }

    //
    // public void setFeature(FeatureExpr feature) {
    // this.feature = feature;
    // }
    //
    // public FeatureExpr getFeature() {
    // return feature;
    // }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MacroData))
            return super.equals(other);
        MacroData that = (MacroData) other;
        if (this.getTokens().size() != that.getTokens().size())
            return false;
        for (int i = 0; i < this.getTokens().size(); i++) {
            Token t_this = this.getTokens().get(i);
            Token t_that = that.getTokens().get(i);
            if (t_this.getType() != t_that.getType()
                    || t_this.getText() == null
                    || !t_this.getText().equals(t_that.getText()))
                return false;
        }
        return true;
    }
}
