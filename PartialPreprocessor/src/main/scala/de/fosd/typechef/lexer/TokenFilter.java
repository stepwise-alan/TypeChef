package de.fosd.typechef.lexer;

import java.util.ArrayList;
import java.util.List;

/**
 * this token filter buffers tokens until a full line is completed.
 * additionally, it removes if-endif blocks if they are entirely empty
 *
 * @author ckaestne
 */
@SuppressWarnings("unused")
public class TokenFilter {

    String output = "";
    List<Token> tokenBuffer = new ArrayList<>();
    boolean inIfdef = false;

    public void push(Token tok) {
        if (tok.getType() == Token.P_IF) {
            flushBuffer(false);
            inIfdef = true;
            tokenBuffer.add(tok);
        }
        if (tok.getType() == Token.P_ENDIF) {
            tokenBuffer.add(tok);
            flushBuffer(true);
        } else if (inIfdef) {
            tokenBuffer.add(tok);
            if (tok.getText().trim().length() > 0
                    && !(tok.getType() == Token.P_ELIF))
                flushBuffer(false);
        } else
            output = output + tok.getText();
    }

    @SuppressWarnings("StringConcatenationInLoop")
    private void flushBuffer(boolean ignoreIfdef) {
        for (Token tok : tokenBuffer) {
//			if (ignoreIfdef
//					&& (tok.getType() == Token.P_IF
//							|| tok.getType() == Token.P_ELIF || tok.getType() == Token.P_ENDIF))
//				output = output + "\n";
//			else
            output = output + tok.getText();
        }
        tokenBuffer.clear();
        inIfdef = false;
    }

    @SuppressWarnings("unused")
    public boolean hasLines() {
        return output.contains("\n");
    }

    @SuppressWarnings("unused")
    public String nextLine() {
        int offset = output.indexOf('\n');
        String line = output.substring(0, offset);
        output = output.substring(offset + 1);
        return line;
    }

}
