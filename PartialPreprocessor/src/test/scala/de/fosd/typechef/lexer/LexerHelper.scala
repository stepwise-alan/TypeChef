package de.fosd.typechef.lexer

import de.fosd.typechef.VALexer
import de.fosd.typechef.VALexer.StreamSource
import de.fosd.typechef.conditional.Conditional
import de.fosd.typechef.lexer.macrotable.MacroFilter

import java.io.{File, FileInputStream}
import java.util.Collections


trait LexerHelper {

  import scala.jdk.CollectionConverters._

  protected def lex(file: File,
                    incDir: File,
                    debug: Boolean = false,
                    ignoreWarnings: Boolean = true,
                    definedMacros: Map[String, String] = Map(),
                    undefMacros: Set[String] = Set()
                   ): Conditional[LexerFrontend.LexerResult] =
    lex(new StreamSource(new FileInputStream(file), file.getAbsolutePath), debug, incDir, ignoreWarnings, definedMacros, undefMacros)

  protected def lex(source: VALexer.LexerInput, debug: Boolean, folder: File, ignoreWarnings: Boolean,
                    definedMacros: Map[String, String], undefMacros: Set[String]): Conditional[LexerFrontend.LexerResult] = {
    new LexerFrontend().run(new LexerFrontend.DefaultLexerOptions(source, debug, null) {
      override def isReturnLanguageTokensOnly: Boolean = {
        false
      }

      override def getIncludePaths: java.util.List[String] = {
        Collections.singletonList(folder.getAbsolutePath)
      }

      override def isHandleWarningsAsErrors: Boolean = {
        !ignoreWarnings
      }

      override def getFeatures: java.util.Set[Feature] = {
        val features: java.util.Set[Feature] = new java.util.HashSet[Feature]
        features.add(Feature.DIGRAPHS)
        features.add(Feature.TRIGRAPHS)
        features.add(Feature.LINEMARKERS)
        features.add(Feature.GNUCEXTENSIONS)
        features
      }

      override def useXtcLexer: Boolean = {
        useXtc()
      }

      override def getMacroFilter: MacroFilter = {
        useMacroFilter
      }

      override def getDefinedMacros: java.util.Map[String, String] = {
        definedMacros.asJava
      }

      override def getUndefMacros: java.util.Set[String] = {
        undefMacros.asJava
      }

      override def printLexerErrorsToStdErr: Boolean = {
        false
      }
    }, true)
  }

  protected def useXtc(): Boolean

  protected def useMacroFilter: MacroFilter = new MacroFilter
}
