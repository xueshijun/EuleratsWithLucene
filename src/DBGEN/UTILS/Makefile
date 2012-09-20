######
#
# A Simple Makefile
#
######

CLASSPATH:=.
CLASSPATH:=$(CLASSPATH):../../JSOUP/jsoup-1.6.3.jar

######

all::

######

all:: ADianShang.class
ADianShang.class: ADianShang.java
	javac -classpath $(CLASSPATH) $<

######

all:: ItemurlIter.class
ItemurlIter.class: ItemurlIter.java ; javac $<

######

all:: DirhtmlIter.class
DirhtmlIter.class: DirhtmlIter.java ; javac $<

######

RMF=rm -f

######

clean:: ; $(RMF) *~

cleanall:: clean
cleanall:: ; $(RMF) *.class

###### end of [Makefile] ######
