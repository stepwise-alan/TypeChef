package de.fosd.typechef.lexer;

import java.util.List;

public class UnnumberedUnexpandingTokenStreamSource extends FixedTokenSource {
    public UnnumberedUnexpandingTokenStreamSource(List<Token> tokens) {
        super(tokens);
    }

    @Override
    boolean isNumbered() {
        return false;
    }

    @Override
    boolean mayExpand(String macroName) {
        return false;
    }

    @Override
    public boolean isNormalizedExternalFeatureExpr() {
        return true;
    }
}
