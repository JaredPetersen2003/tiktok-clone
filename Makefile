JFLAGS = -g
SRCDIR = src
BINDIR = bin
JC = javac

.SUFFIXES: .java .class

#.java.class:
#	$(JC) $(JFLAGS) -d $(BINDIR) $*.java
$(BINDIR)/%.class : $(SRCDIR)/%.java
	$(JC) -d $(BINDIR)/ $(SRCDIR)/*.java

CLASSES = \
	$(BINDIR)/BinaryTreeNode.class \
	$(BINDIR)/BinaryTree.class \
	$(BINDIR)/BTQueueNode.class \
	$(BINDIR)/BTQueue.class \
	$(BINDIR)/BinarySearchTree.class \
	$(BINDIR)/Post.class \
	$(BINDIR)/User.class \
	$(BINDIR)/TokTik.class

default: $(CLASSES)

classes: $(CLASSES:.java=.class)

clean:
	$(RM) $(BINDIR)/*.class
	
run:
	java -cp $(BINDIR) TokTik
