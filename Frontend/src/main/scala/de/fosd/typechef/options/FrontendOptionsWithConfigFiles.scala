package de.fosd.typechef.options

import gnu.getopt.{Getopt, LongOpt}

import java.io.{File, FileInputStream}
import java.util
import java.util.Properties


class FrontendOptionsWithConfigFiles extends FrontendOptions {
  ////////////////////////////////////////
  // General setup of built-in headers, should become more general and move
  // elsewhere.
  ////////////////////////////////////////
  val predefSettings = new Properties()
  predefSettings.setProperty("systemRoot", File.separator)
  predefSettings.setProperty("systemIncludes", "usr" + File.separator + "include")
  predefSettings.setProperty("predefMacros", "")
  val settings = new Properties(predefSettings)

  def systemRoot: String = settings.getProperty("systemRoot")

  def systemIncludes: String = settings.getProperty("systemIncludes")

  def predefMacroDef: String = settings.getProperty("predefMacros")

  def setSystemRoot(value: String): AnyRef = settings.setProperty("systemRoot", value)

  def setSystemIncludes(value: String): AnyRef = settings.setProperty("systemIncludes", value)

  def setPredefMacroDef(value: String): AnyRef = settings.setProperty("predefMacros", value)

  var preIncludeDirs: Seq[String] = Nil
  var postIncludeDirs: Seq[String] = Nil


  def loadPropList(key: String): Array[String] = for (x <- settings.getProperty(key, "").split(",")) yield x.trim

  def loadSettings(configPath: String): Unit = {
    settings.load(new FileInputStream(configPath))
    preIncludeDirs = loadPropList("preIncludes").toSeq ++ preIncludeDirs
    postIncludeDirs = postIncludeDirs ++ loadPropList("postIncludes")
  }


  private final val SYSINCL: Char = Options.genOptionId()
  private final val Op_preIncludes: Char = Options.genOptionId()
  private final val Op_postIncludes: Char = Options.genOptionId()
  private final val Op_predefMacros: Char = Options.genOptionId()

  override def getOptionGroups: util.List[Options.OptionGroup] = {
    import Options.{Option, OptionGroup}

    val groups = new util.ArrayList[OptionGroup](super.getOptionGroups)

    groups.add(new OptionGroup("System configuration", 8,
      new Option("systemRoot", LongOpt.REQUIRED_ARGUMENT, 'r', "dir",
        "Path to system root. Default: '/'."),
      new Option("platformHeader", LongOpt.REQUIRED_ARGUMENT, 'h', "file",
        "Header files with platform macros (create with 'cpp -dM -std=gnu99 -'). Default: 'platform.h'."),
      new Option("systemIncludes", LongOpt.REQUIRED_ARGUMENT, SYSINCL, "dir",
        "System include directory. Default: '$systemRoot/usr/include'."),
      new Option("preIncludes", LongOpt.REQUIRED_ARGUMENT, Op_preIncludes, "dir",
        "Extra include directories, before system includes, relative to $systemRoot"),
      new Option("postIncludes", LongOpt.REQUIRED_ARGUMENT, Op_postIncludes, "dir",
        "Extra include directories, after system includes, relative to $systemRoot"),
      new Option("predefMacros", LongOpt.REQUIRED_ARGUMENT, Op_predefMacros, "file",
        "Header with compiler-defined macros (e.g., generated with `gcc -dM   -x c - -E`)"),
      new Option("settingsFile", LongOpt.REQUIRED_ARGUMENT, 'c', "dir",
        "Property file specifying system root, platform headers, and system include directories.")
    ))
    groups
  }

  override def interpretOption(c: Int, g: Getopt): Boolean = {
    if (c == 'r') {
      checkDirectoryExists(g.getOptarg)
      setSystemRoot(g.getOptarg)
      true
    } else if (c == 'h') {
      checkFileExists(g.getOptarg)
      setPredefMacroDef(g.getOptarg)
      true
    } else if (c == 'c') {
      checkFileExists(g.getOptarg)
      loadSettings(g.getOptarg)
      true
    } else if (c == SYSINCL) {
      checkDirectoryExists(g.getOptarg)
      setSystemIncludes(g.getOptarg)
      true
    } else if (c == Op_preIncludes) {
      preIncludeDirs = g.getOptarg.split(",").toSeq ++ preIncludeDirs
      true
    } else if (c == Op_postIncludes) {
      postIncludeDirs = postIncludeDirs ++ g.getOptarg.split(",")
      true
    } else if (c == Op_predefMacros) {
      setPredefMacroDef(g.getOptarg)
      true
    } else
      super.interpretOption(c, g)
  }

  override def getIncludePaths: util.List[String] = {
    def adjustPath = (path: String) =>
      if (path != null && !("" equals path))
        List(systemRoot + File.separator + path)
      else
        List()

    val r = new util.ArrayList[String](super.getIncludePaths)
    for (a <- (systemIncludes +: postIncludeDirs).flatMap(adjustPath))
      r.add(a)
    for (a <- preIncludeDirs.reverse.flatMap(adjustPath))
      r.add(0, a)
    r
  }

  override def getIncludedHeaders: util.List[String] = {
    if (predefMacroDef.nonEmpty && new File(predefMacroDef).exists()) {
      val r = new util.ArrayList[String](super.getIncludedHeaders)
      r.add(0, predefMacroDef)
      r
    } else super.getIncludedHeaders
  }

  protected override def afterParsing(): Unit = {
    super.afterParsing()
    if (!isPrintVersion && (predefMacroDef.isEmpty || !new File(predefMacroDef).exists()))
      println("Warning: No platform header specified")
  }
}