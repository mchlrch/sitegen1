sitegen1
==========

sitegen1 is a static website generator that I use to build my personal website [miranet.ch](http://www.miranet.ch).


### Status
deprecated

The current codebase uses framework versions back from the year 2011. A migration/rewrite on an up-to-date technology stack is pending.


### Modules
- *ch.miranet*

  Content model of miranet.ch (the syntax is defined by the DSL)


- *ch.miranet.dsl.site*, *ch.miranet.dsl.site.ui*

  Xtext modules for the DSL and editor infrastucture


- *ch.miranet.dsl.site.domain*

  Domainmodel (EMF Ecore)


- *ch.miranet.dsl.site.genmodel*

  Model for the generator fan-out (EMF Ecore)


- *ch.miranet.dsl.site.generator*

  The website generator



### Installation

1. Download [Eclipse Helios](http://www.eclipse.org/downloads/packages/eclipse-rcp-and-rap-developers/heliossr2),

2. Enable and reload the two updatesites [Helios](http://download.eclipse.org/releases/helios)
and [The Eclipse Project Updates](http://download.eclipse.org/eclipse/updates/3.6)

3. Install the Xtext SDK (Xtext 1.0.2) from the Helios updatesite, inside the Modeling category

After the Xtext SDK installation, I still lacked *org.eclipse.xtend.util.stdlib* and ended up grabbing it from a mirror site:
[org.eclipse.xtend.util.stdlib-1.0.1.v201108020519.jar](http://ftp.mirrorservice.org/sites/download.eclipse.org/eclipseMirror/modeling/tmf/xtext/maven/org/eclipse/xtend/org.eclipse.xtend.util.stdlib/1.0.1.v201108020519/org.eclipse.xtend.util.stdlib-1.0.1.v201108020519.jar).

