(window.webpackJsonp=window.webpackJsonp||[]).push([[10],{282:function(t,a,s){"use strict";s.r(a);var e=s(13),n=Object(e.a)({},(function(){var t=this,a=t._self._c;return a("ContentSlotsDistributor",{attrs:{"slot-key":t.$parent.slotKey}},[a("h1",{attrs:{id:"development-resources"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#development-resources"}},[t._v("#")]),t._v(" Development resources")]),t._v(" "),a("h2",{attrs:{id:"blacklab-core"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#blacklab-core"}},[t._v("#")]),t._v(" BlackLab Core")]),t._v(" "),a("p",[t._v("The Java library")]),t._v(" "),a("p",[t._v("First you need to get the BlackLab library. The simplest way is to let Maven download it automatically from the Central Repository, but you can also download a prebuilt binary, and it's trivial to build it yourself.")]),t._v(" "),a("blockquote",[a("b",[t._v("Note to MacOS users")]),t._v(": Dirk Roorda at DANS wrote a detailed guide for installing and indexing data on MacOS. It's available "),a("a",{attrs:{href:"https://github.com/Dans-labs/clariah-gm/blob/master/blacklab/install.md"}},[t._v("here")]),t._v(". It's also archived "),a("a",{attrs:{href:"../server/install-macos.html"}},[t._v("here")]),t._v(".\n")]),t._v(" "),a("h2",{attrs:{id:"getting-blacklab"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#getting-blacklab"}},[t._v("#")]),t._v(" Getting BlackLab")]),t._v(" "),a("h3",{attrs:{id:"getting-blacklab-from-maven-central"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#getting-blacklab-from-maven-central"}},[t._v("#")]),t._v(" Getting BlackLab from Maven Central")]),t._v(" "),a("p",[t._v("BlackLab is in the Maven Central Repository, so you should be able to simply add it to your build tool, e.g.:")]),t._v(" "),a("div",{staticClass:"language-xml extra-class"},[a("pre",{pre:!0,attrs:{class:"language-xml"}},[a("code",[a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("<")]),t._v("dependency")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(">")])]),t._v("\n    "),a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("<")]),t._v("groupId")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(">")])]),t._v("nl.inl.blacklab"),a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("</")]),t._v("groupId")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(">")])]),t._v("\n    "),a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("<")]),t._v("artifactId")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(">")])]),t._v("blacklab-core"),a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("</")]),t._v("artifactId")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(">")])]),t._v("\n    "),a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("<")]),t._v("version")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(">")])]),t._v("3.0.1"),a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("</")]),t._v("version")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(">")])]),t._v("\n"),a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token tag"}},[a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("</")]),t._v("dependency")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(">")])]),t._v("\n")])])]),a("p",[t._v("If you're not sure what version to use, see the "),a("RouterLink",{attrs:{to:"/development/downloads.html"}},[t._v("downloads")]),t._v(" or "),a("RouterLink",{attrs:{to:"/development/changelog.html"}},[t._v("changelog")]),t._v(" pages.")],1),t._v(" "),a("h3",{attrs:{id:"downloading-a-prebuilt-binary"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#downloading-a-prebuilt-binary"}},[t._v("#")]),t._v(" Downloading a prebuilt binary")]),t._v(" "),a("p",[t._v("BlackLab Core consists of a JAR and a set of required libraries. See the "),a("a",{attrs:{href:"https://github.com/INL/BlackLab/releases/",target:"_blank",rel:"noopener noreferrer"}},[t._v("GitHub releases page"),a("OutboundLink")],1),t._v(" and choose a jar-with-libs download. The latter one may also contain development versions you can try out.")]),t._v(" "),a("p",[t._v("BlackLab Server only consists of a WAR file that includes everything. You could even unzip this WAR file to obtain the included BlackLab JAR and zip files if you needed to for some reason.")]),t._v(" "),a("h3",{attrs:{id:"building-from-source"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#building-from-source"}},[t._v("#")]),t._v(" Building from source")]),t._v(" "),a("p",[t._v('If you want the very latest version (the "dev" branch) of BlackLab, you can easily build it from source code.')]),t._v(" "),a("p",[t._v("First, you need to download the source code from GitHub. You can download it from there in a .zip file (be sure to select the dev branch before doing so), but a better way to get it is by cloning it using Git. "),a("a",{attrs:{href:"https://git-scm.com/book/en/v2/Getting-Started-Installing-Git",target:"_blank",rel:"noopener noreferrer"}},[t._v("Install a Git client"),a("OutboundLink")],1),t._v(" (we'll give command line examples here, but it should translate easily to GUI clients like TortoiseGit), change to a directory where you keep your projects, and clone BlackLab:")]),t._v(" "),a("div",{staticClass:"language- extra-class"},[a("pre",[a("code",[t._v("git clone git://github.com/INL/BlackLab.git\n")])])]),a("p",[t._v('Git will download the project and place it in a subdirectory "BlackLab". Now switch to the dev branch:')]),t._v(" "),a("div",{staticClass:"language- extra-class"},[a("pre",[a("code",[t._v("git checkout dev\n")])])]),a("p",[t._v("Install a recent JDK (Java Development Kit). If you're on Linux, you can use your package manager to do this (OpenJDK is fine too). Note that you will need at least JDK version 8 (i.e. openjdk-1.8.0) to use the latest BlackLab versions.")]),t._v(" "),a("p",[t._v("BlackLab is built using "),a("a",{attrs:{href:"http://maven.apache.org/",target:"_blank",rel:"noopener noreferrer"}},[t._v("Maven"),a("OutboundLink")],1),t._v(", a popular Java build tool. "),a("a",{attrs:{href:"https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html",target:"_blank",rel:"noopener noreferrer"}},[t._v("Install Maven"),a("OutboundLink")],1),t._v(" (use your package manager if on Linux), change into the BlackLab directory, and build the library:")]),t._v(" "),a("div",{staticClass:"language- extra-class"},[a("pre",[a("code",[t._v("mvn install\n")])])]),a("p",[t._v('("install" refers to the fact that the library is "installed" to your private Maven repository after it is built)')]),t._v(" "),a("p",[t._v('After a lot of text output, it should say "BUILD SUCCESS" and the BlackLab JAR library should be under core/target/blacklab-VERSION.jar (where VERSION is the current BlackLab version, i.e. "1.7-SNAPSHOT"; SNAPSHOT means it\'s not an official release, by the way). The BlackLab Server WAR will be in server/target/blacklab-server-VERSION.war.')]),t._v(" "),a("div",{staticClass:"custom-block tip"},[a("p",{staticClass:"custom-block-title"},[t._v("NOTE")]),t._v(" "),a("p",[t._v("If you want to use BlackLab Server and "),a("RouterLink",{attrs:{to:"/frontend/"}},[t._v("BlackLab Frontend")]),t._v(" (our search application), you'll need an application server like Apache Tomcat too. Also available via package manager in Linux. After installation, find the "),a("code",[t._v("webapps")]),t._v(" directory (e.g. "),a("code",[t._v("/var/lib/tomcat/webapps/")]),t._v(", but may depend on distribution) and copy the WAR file to it. It should be extracted by Tomcat automatically. For full installation and configuration instructions, see "),a("RouterLink",{attrs:{to:"/server/overview.html"}},[t._v("BlackLab Server overview")]),t._v(".")],1)]),t._v(" "),a("h2",{attrs:{id:"a-simple-blacklab-application"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#a-simple-blacklab-application"}},[t._v("#")]),t._v(" A simple BlackLab application")]),t._v(" "),a("p",[t._v("Finally, let's look at an example Java application.")]),t._v(" "),a("p",[t._v("Here’s the basic structure of a BlackLab search application, to give you an idea of where to look in the source code and documentation (note that we leave nl.inl.blacklab out of the package names for brevity):")]),t._v(" "),a("ol",[a("li",[t._v("Call BlackLab.open() to instantiate a BlackLabIndex object. This provides the main BlackLab API.")]),t._v(" "),a("li",[t._v("Construct a TextPattern structure that represents your query. You may want to do this from a query parser, or use one of the query parsers supplied with BlackLab (CorpusQueryLanguageParser, …).")]),t._v(" "),a("li",[t._v("Call the BlackLabIndex.find() method to execute the TextPattern and return a Hits object. (Internally, this translates the TextPattern into a Lucene SpanQuery, executes it, and collects the hits. Each of these steps may also be done manually if you wish to have more control over the process)")]),t._v(" "),a("li",[t._v("Sort or group the results, using Hits.sort() or Hits.group() and a HitProperty object to indicate the sorting/grouping criteria.")]),t._v(" "),a("li",[t._v("Select a few of your Hits to display by calling Hits.window().")]),t._v(" "),a("li",[t._v("Loop over the HitsWindow and display each hit.")]),t._v(" "),a("li",[t._v("Close the BlackLabIndex object.")])]),t._v(" "),a("p",[t._v("The above in code:")]),t._v(" "),a("div",{staticClass:"language-java extra-class"},[a("pre",{pre:!0,attrs:{class:"language-java"}},[a("code",[t._v("\t"),a("span",{pre:!0,attrs:{class:"token comment"}},[t._v("// Open your index")]),t._v("\n\t"),a("span",{pre:!0,attrs:{class:"token keyword"}},[t._v("try")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("BlackLabIndex")]),t._v(" index "),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("BlackLab")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token keyword"}},[t._v("open")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),a("span",{pre:!0,attrs:{class:"token keyword"}},[t._v("new")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("File")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),a("span",{pre:!0,attrs:{class:"token string"}},[t._v('"/home/zwets/testindex"')]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("{")]),t._v("\n\t    "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),t._v(" corpusQlQuery "),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token string"}},[t._v('" \\"the\\" [pos=\\"adj.*\\"] \\"brown\\" \\"fox\\" "')]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(";")]),t._v("\n\t\n\t    "),a("span",{pre:!0,attrs:{class:"token comment"}},[t._v("// Parse your query to get a TextPattern")]),t._v("\n\t    "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("TextPattern")]),t._v(" pattern "),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("CorpusQueryLanguageParser")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token function"}},[t._v("parse")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),t._v("corpusQlQuery"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(";")]),t._v("\n\t\n\t    "),a("span",{pre:!0,attrs:{class:"token comment"}},[t._v("// Execute the TextPattern")]),t._v("\n\t    "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("Hits")]),t._v(" hits "),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),t._v(" index"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token function"}},[t._v("find")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),t._v("pattern"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(";")]),t._v("\n\t\n\t    "),a("span",{pre:!0,attrs:{class:"token comment"}},[t._v("// Sort the hits by the words to the left of the matched text")]),t._v("\n\t    "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("HitProperty")]),t._v(" sortProperty "),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token keyword"}},[t._v("new")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("HitPropertyLeftContext")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),t._v("index"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v(" index"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token function"}},[t._v("annotation")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),a("span",{pre:!0,attrs:{class:"token string"}},[t._v('"word"')]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(";")]),t._v("\n\t    hits "),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),t._v(" hits"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token function"}},[t._v("sort")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),t._v("sortProperty"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(";")]),t._v("\n\t\n\t    "),a("span",{pre:!0,attrs:{class:"token comment"}},[t._v("// Limit the results to the ones we want to show now (i.e. the first page)")]),t._v("\n\t    "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("Hits")]),t._v(" window "),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),t._v(" hits"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token function"}},[t._v("window")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),a("span",{pre:!0,attrs:{class:"token number"}},[t._v("0")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token number"}},[t._v("20")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(";")]),t._v("\n\t\n\t    "),a("span",{pre:!0,attrs:{class:"token comment"}},[t._v("// Iterate over window and display the hits")]),t._v("\n\t    "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("Concordances")]),t._v(" concs "),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),t._v(" hits"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token function"}},[t._v("concordances")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("ContextSize")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token function"}},[t._v("get")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),a("span",{pre:!0,attrs:{class:"token number"}},[t._v("5")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(";")]),t._v("\n\t    "),a("span",{pre:!0,attrs:{class:"token keyword"}},[t._v("for")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("Hit")]),t._v(" hit"),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" window"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("{")]),t._v("\n\t        "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("Concordance")]),t._v(" conc "),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),t._v(" concs"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token function"}},[t._v("get")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),t._v("hit"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(";")]),t._v("\n\t        "),a("span",{pre:!0,attrs:{class:"token comment"}},[t._v("// Strip out XML tags for display.")]),t._v("\n\t        "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),t._v(" left "),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("XmlUtil")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token function"}},[t._v("xmlToPlainText")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),t._v("conc"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),t._v("left"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(";")]),t._v("\n\t        "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),t._v(" hitText "),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("XmlUtil")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token function"}},[t._v("xmlToPlainText")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),t._v("conc"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),t._v("hit"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(";")]),t._v("\n\t        "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),t._v(" right "),a("span",{pre:!0,attrs:{class:"token operator"}},[t._v("=")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("XmlUtil")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token function"}},[t._v("xmlToPlainText")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),t._v("conc"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),t._v("right"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(";")]),t._v("\n\t        "),a("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("System")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),t._v("out"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(".")]),a("span",{pre:!0,attrs:{class:"token function"}},[t._v("printf")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),a("span",{pre:!0,attrs:{class:"token string"}},[t._v('"%45s[%s]%s\\n"')]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v(" left"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v(" hitText"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v(" right"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(";")]),t._v("\n\t    "),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("}")]),t._v("\n\t\n\t"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("}")]),t._v("\n")])])]),a("p",[t._v("See also:")]),t._v(" "),a("ul",[a("li",[a("RouterLink",{attrs:{to:"/development/examples/example-application.html"}},[t._v("The included example application")])],1)]),t._v(" "),a("h2",{attrs:{id:"tutorials-howtos"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#tutorials-howtos"}},[t._v("#")]),t._v(" Tutorials / howtos")]),t._v(" "),a("h3",{attrs:{id:"a-custom-analysis-script"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#a-custom-analysis-script"}},[t._v("#")]),t._v(" A custom analysis script")]),t._v(" "),a("h3",{attrs:{id:"using-the-forward-index"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#using-the-forward-index"}},[t._v("#")]),t._v(" Using the forward index")]),t._v(" "),a("h3",{attrs:{id:"using-capture-groups"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#using-capture-groups"}},[t._v("#")]),t._v(" Using capture groups")]),t._v(" "),a("h3",{attrs:{id:"indexing-a-different-input-format"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#indexing-a-different-input-format"}},[t._v("#")]),t._v(" Indexing a different input format")]),t._v(" "),a("h2",{attrs:{id:"internals"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#internals"}},[t._v("#")]),t._v(" Internals")]),t._v(" "),a("p",[t._v("The more in-depth information about BlackLab's internals, such as the structure of the code, and details about file formats, is available in "),a("a",{attrs:{href:"https://github.com/INL/BlackLab/tree/dev/doc/#readme",target:"_blank",rel:"noopener noreferrer"}},[t._v("the GitHub repository"),a("OutboundLink")],1),t._v(", along with other documentation related to development.")])])}),[],!1,null,null,null);a.default=n.exports}}]);