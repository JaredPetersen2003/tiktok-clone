JFLAGS = -g
SRCDIR = src
BINDIR = bin
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) -d $(BINDIR) $*.java

CLASSES = \
	$(SRCDIR)/BinaryTreeNode.java \
	$(SRCDIR)/BTQueueNode.java \
	$(SRCDIR)/BTQueue.java \
	$(SRCDIR)/BinaryTree.java \
	$(SRCDIR)/BinarySearchTree.java \
	$(SRCDIR)/Post.java \
	$(SRCDIR)/User.java \
	$(SRCDIR)/App.java \
	$(SRCDIR)/TokTik.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) $(BINDIR)/*.class
	
run:
	java -cp $(BINDIR) TokTik
