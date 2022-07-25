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

import java.io.*;

/**
 * A {@link Source} which lexes a file.
 * <p/>
 * The input is buffered.
 *
 * @see Source
 */
public class FileLexerSource extends LexerSource {
    // private File file;
    private final String path;

    private FileLexerSource(Reader reader, String path) {
        super(new BufferedReader(reader), true);
        this.path = path;
    }

    /**
     * Creates a new Source for lexing the given File
     * <p/>
     * Preprocessor directives are honoured within the file.
     *
     * @param file the file object
     * @param path the path to use in error messages - it might be different when loading files from a ChRoot.
     */
    public FileLexerSource(File file, String path) throws IOException {
        this(new FileReader(file), path);
    }

    /**
     * Creates a new Source for lexing the given File.
     * <p/>
     * Preprocessor directives are honoured within the file.
     */
    public FileLexerSource(InputStream stream, String path) {
        this(new InputStreamReader(stream), path);
    }

    public FileLexerSource(File file) throws IOException {
        this(file, file.getPath());
    }

    @SuppressWarnings("unused")
    public FileLexerSource(String path) throws IOException {
        this(new File(path));
    }

    @Override
        /* pp */String getPath() {
        return path;
    }

    @Override
        /* pp */String getName() {
        return getPath();
    }

    public String toString() {
        return "file " + path;
    }
}
