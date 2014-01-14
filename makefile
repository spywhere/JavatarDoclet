JD=javadoc

NAME=JavaSE7
SOURCE=JSE7
DOCLET=doclet
PACKAGES=\
java.applet\
java.awt\
java.awt.color\
java.awt.datatransfer\
java.awt.dnd\
java.awt.event\
java.awt.font\
java.awt.geom\
java.awt.im\
java.awt.im.spi\
java.awt.image\
java.awt.image.renderable\
java.awt.print\
java.beans\
java.beans.beancontext\
java.io\
java.lang\
java.lang.annotation\
java.lang.instrument\
java.lang.invoke\
java.lang.management\
java.lang.ref\
java.lang.reflect\
java.math\
java.net\
java.nio\
java.nio.channels\
java.nio.channels.spi\
java.nio.charset\
java.nio.charset.spi\
java.nio.file\
java.nio.file.attribute\
java.nio.file.spi\
java.rmi\
java.rmi.activation\
java.rmi.dgc\
java.rmi.registry\
java.rmi.server\
java.security\
java.security.acl\
java.security.cert\
java.security.interfaces\
java.security.spec\
java.sql\
java.text\
java.text.spi\
java.util\
java.util.concurrent\
java.util.concurrent.atomic\
java.util.concurrent.locks\
java.util.jar\
java.util.logging\
java.util.perfs\
java.util.regex\
java.util.spi\
java.util.zip

DOCLETCLASS=me.spywhere.doclet.Javatar

FLAGS=-quiet


all: java

java:
	@$(JD) -sourcepath $(SOURCE) -docletpath $(DOCLET) -name $(NAME) -doclet $(DOCLETCLASS) $(FLAGS) $(PACKAGES)