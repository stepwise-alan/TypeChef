package de.fosd.typechef.lexer;

import de.fosd.typechef.featureexpr.FeatureExpr;
import de.fosd.typechef.featureexpr.FeatureModel;
import de.fosd.typechef.featureexpr.FeatureProvider;

import java.util.ArrayList;
import java.util.List;

class State {
    List<FeatureExpr> localFeatures = new ArrayList<>();
    final State parent;

    boolean sawElse;

    /* pp */State() {
        this(null);
    }

    /* pp */State(State parent) {
        this.parent = parent;
        this.sawElse = false;
    }

    /* pp */void setSawElse() {
        clearCache();
        assert !localFeatures.isEmpty() : "else before #if?";
        sawElse = true;
        processElIf();
    }

    /* pp */boolean sawElse() {
        return sawElse;
    }

    public String toString() {
        return "State(localFeatureExpr = " + getLocalFeatureExpr() + ", currentpc=" + getFullPresenceCondition() + ", parent=" + parent
                + ", active=" + localFeatures + ", sawelse=" + sawElse + ")";
    }

    /**
     * add a feature expression to the state. first the #if expression. if
     * called again, this is interpreted as an elif expression.
     */
    public void putLocalFeature(FeatureExpr feature, @SuppressWarnings("unused") FeatureProvider macroTable) {
        clearCache();
        localFeatures.add(feature);
    }

    /**
     * returns the local feature expression (explicitly negating prior features
     * from other elif branches, but not including features from outer nested
     * ifdefs)
     * <p/>
     * if this is already the else branch (sawElse is true) than the condition
     * for the else branch (negating all features) is returned
     */
    public FeatureExpr getLocalFeatureExpr() {
        assert !sawElse() || !localFeatures.isEmpty() : "else before #if?";

        if (localFeatures.isEmpty())
            return FeatureExprLib.True();
        FeatureExpr result = localFeatures.get(localFeatures.size() - 1);
        /*
         * if (sawElse) result = result.not();
         */
        for (int i = 0; i < localFeatures.size() - 1; i++)
            // result = result.and(localFeatures.get(i).not());
            result = result.and(localFeatures.get(i));

        return result;
    }

    private FeatureExpr cache_fullPresenceCondition = null;
    private Boolean cache_isActive = null;

    /**
     * returns the full feature condition that leads to the inclusion of the
     * current token (includes all features of nested ifdefs)
     */
    public FeatureExpr getFullPresenceCondition() {
        if (cache_fullPresenceCondition == null) {
            FeatureExpr result = getLocalFeatureExpr();
            if (parent != null)
                result = result.and(parent.getFullPresenceCondition());
            cache_fullPresenceCondition = result;
        }
        return cache_fullPresenceCondition;
    }

    /**
     * only returns false if a code fragment is certainly False, i.e., there is
     * no variant in which it is included.
     * <p/>
     * this can happen when a feature is explicitly undefined or explicitly
     * defined in the source code
     */
    public boolean isActive(FeatureModel featureModel) {
        // check with cache and parent before using SAT solver
        if (cache_isActive != null)
            return cache_isActive;
        if (parent != null && parent.isCachedInactive())
            return false;
        FeatureExpr condition = getFullPresenceCondition();
        cache_isActive = condition.isSatisfiable(featureModel);
        return cache_isActive;
    }

    private boolean isCachedInactive() {
        if (cache_isActive != null)
            return !cache_isActive;
        return false;
    }

    private void clearCache() {
        cache_fullPresenceCondition = null;
        cache_isActive = null;
    }

    /**
     * normally each state represents a code block if an ifdef and endif. if the
     * feature expression was True or False, then the initial ifdef definition
     * was skipped. the skipped expression is remembered here, so that also an
     * according endif is not output
     */
    private boolean ifdefBegin = true;

    @SuppressWarnings("unused")
    public void setNoIfdefBegin() {
        ifdefBegin = false;
    }

    @SuppressWarnings("unused")
    public boolean hasIfdefBegin() {
        return ifdefBegin;
    }

    public void processElIf() {
        assert !localFeatures.isEmpty();
        localFeatures.set(localFeatures.size() - 1, localFeatures.get(
                localFeatures.size() - 1).not());
    }
}
