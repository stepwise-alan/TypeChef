package de.fosd.typechef.lexer;

import org.junit.Test;

import java.io.StringReader;

import static org.junit.Assert.assertEquals;

public class JoinReaderTestCase {

    private void testJoinReader(String in, String out, boolean tg)
            throws Exception {
        System.out.println("Testing " + in + " => " + out);
        StringReader r = new StringReader(in);
        JoinReader j = new JoinReader(r, tg);

        for (int i = 0; i < out.length(); i++) {
            int c = j.read();
            System.out.println("At offset " + i + ": " + (char) c);
            assertEquals(out.charAt(i), c);
        }
        assertEquals(-1, j.read());
        assertEquals(-1, j.read());
    }

    private void testJoinReader(String in, String out)
            throws Exception {
        testJoinReader(in, out, true);
        testJoinReader(in, out, false);
    }

    @Test
    public void testJoinReader()
            throws Exception {
        testJoinReader("ab", "ab");
        testJoinReader("a\\b", "a\\b");
        testJoinReader("a\nb", "a\nb");
        testJoinReader("a\\\nb", "ab\n");
        testJoinReader("foo??(bar", "foo[bar", true);
        testJoinReader("foo??/\nbar", "foobar\n", true);
    }

}
