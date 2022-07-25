package de.fosd.typechef.lexer;


import de.fosd.typechef.featureexpr.FeatureExpr;
import de.fosd.typechef.lexer.macrotable.MacroContext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("CommentedOutCode")
public abstract class DebuggingPreprocessor {
    public static Logger logger = Logger.getLogger("de.ovgu.jcpp");

    protected abstract boolean getFeature(Feature f);

    static {
        logger.setLevel(Level.WARNING);
    }

    int max_nesting = 0;
    int header_count = 0;
    Set<String> distinctHeaders = new HashSet<>();

    BufferedWriter debugFile;
    BufferedWriter debugSourceFile;
    String outputName;
    StringBuffer macroLog = new StringBuffer();

    private String baseOutName() {
        if (outputName != null)
            //TODO: Buggy, should use replaceFirst, otherwise the 1st is not
            //interpreted as a regexp and doesn't work at all (here, no
            //replacement is done).
            return outputName.replace(".pi$", "");
        else
            return null;
    }

    public void openDebugFiles(String outputName) {
        if (getFeature(Feature.DEBUGFILE_LOG))
            try {
                Handler fh;
                fh = new FileHandler("jcpp.log");
                logger.addHandler(fh);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IOException ignored) {
            }

        this.outputName = outputName;

        try {
            if (getFeature(Feature.DEBUGFILE_TOKENSTREAM))
                debugFile = new BufferedWriter(new FileWriter(baseOutName() + ".tokStr"));
            if (getFeature(Feature.DEBUGFILE_SOURCES))
                debugSourceFile = new BufferedWriter(new FileWriter(baseOutName() + ".dbgSrc"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract MacroContext<MacroData> getMacros();

    public void debugPreprocessorDone() {
        try {
            String outName = baseOutName();
            if (outName == null) {
                logger.info("macro dump skipped");
                return;
            }
            if (getFeature(Feature.DEBUGFILE_MACROTABLE)) {
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(
                        outName + ".macroDbg")));
                getMacros().debugPrint(writer);
                writer.close();

                writer = new PrintWriter(new BufferedWriter(new FileWriter(
                        outName + ".macroLog")));
                writer.write(macroLog.toString());
                writer.close();
            }

            // also add statistics to debugSourceFile
            if (getFeature(Feature.DEBUGFILE_SOURCES))
                if (debugSourceFile != null) {
                    debugSourceFile.append("\n\n\nStatistics (max_nesting,header_count,distinct files):\n")
                            .append(String.valueOf(max_nesting))
                            .append(";")
                            .append(String.valueOf(header_count))
                            .append(";")
                            .append(String.valueOf(distinctHeaders.size()))
                            .append("\n");
                    debugSourceFile.flush();
                }

            logger.info("macro dump written");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract Token parse_main() throws IOException, LexerException;

//	private void debugNextTokens() {
//		for (int i = 0; i < 20; i++)
//			try {
//				parse_main();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (LexerException e) {
//				e.printStackTrace();
//			}
//	}

    public void debug_receivedToken(Source source, Token tok) {
        if (getFeature(Feature.DEBUGFILE_TOKENSTREAM) && tok != null && debugFile != null)
            try {
                Source tmpSrc = source.getParent();
                while (tmpSrc != null) {
                    debugFile.write("\t");
                    tmpSrc = tmpSrc.getParent();
                }
                if (tok.getText() != null)
                    debugFile.write(tok.getText() + "\n");
                debugFile.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    int debugSourceIdx = 0;

    public void debugSourceBegin(Source source, State state) {
        if (getFeature(Feature.DEBUGFILE_SOURCES))
            if (source instanceof FileLexerSource) {
                debugSourceIdx++;
                try {
                    StringBuilder b = new StringBuilder();
                    max_nesting = Math.max(max_nesting, debugSourceIdx);
                    distinctHeaders.add(source.toString());
                    header_count++;
                    for (int i = 1; i < debugSourceIdx; i++)
                        b.append("\t");
                    b.append("push ").append(source).append(" -- ").append(state == null ? "null" : state
                            .getLocalFeatureExpr()
                            + " ("
                            + state.getFullPresenceCondition()
                            + ")").append("\n");
//				 System.out.println(b.toString());
                    if (debugSourceFile != null) {
                        debugSourceFile.write(b.toString());
                        debugSourceFile.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }

    public void debugSourceEnd(Source source) {
        if (getFeature(Feature.DEBUGFILE_SOURCES))
            if (source instanceof FileLexerSource) {
                debugSourceIdx--;
                try {
                    StringBuilder b = new StringBuilder();
                    for (int i = 0; i < debugSourceIdx; i++)
                        b.append("\t");
                    b.append("pop ").append(source).append("\n");
//				 System.out.println(b.toString());
                    if (debugSourceFile != null) {
                        debugSourceFile.write(b.toString());
                        debugSourceFile.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }


    protected void logAddMacro(String name, FeatureExpr feature, @SuppressWarnings("unused") MacroData m, Source source) {
        macroLog.append("#define ");
        macroLog.append(name);
        macroLog.append(" if ");
        macroLog.append(feature);
        macroLog.append(" at ");
        macroLog.append(source.getName());
        macroLog.append(":");
        macroLog.append(source.getColumn());
        macroLog.append("\n");
    }

}
