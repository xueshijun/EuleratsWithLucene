######
#
# A Simple Makefile
#
######

CLASSPATH:=.
CLASSPATH:=$(CLASSPATH):../..
CLASSPATH:=$(CLASSPATH):../../json-simple/json-simple-1.1.1.jar
CLASSPATH:=$(CLASSPATH):../../JSOUP/jsoup-1.6.3.jar

######

all::

######

DATA=DATA

######

all:: GrabDirhtmlst.class
GrabDirhtmlst.class: GrabDirhtmlst.java ; javac -classpath $(CLASSPATH) $<

GrabDirhtmlst: ; java -classpath $(CLASSPATH) GrabDirhtmlst
GrabDirhtmlst-all: ; java -classpath $(CLASSPATH) GrabDirhtmlst >& DATA/GraDirhtmlst-all.txt

######

all:: GrabItemurlst.class
GrabItemurlst.class: GrabItemurlst.java ; javac -classpath $(CLASSPATH) $<

GrabItemurlst: ; java -classpath $(CLASSPATH) GrabItemurlst
GrabItemurlst-1: ; java -classpath $(CLASSPATH) GrabItemurlst 1 < DATA/YHDdirhtmlst.txt >& DATA/YHDitemurlst-0.txt
GrabItemurlst-5: ; java -classpath $(CLASSPATH) GrabItemurlst 5 < DATA/YHDdirhtmlst.txt >& DATA/YHDitemurlst-5.txt
GrabItemurlst-10: ; java -classpath $(CLASSPATH) GrabItemurlst 10 < DATA/YHDdirhtmlst.txt >& DATA/YHDitemurlst-10.txt
GrabItemurlst-max: ; java -classpath $(CLASSPATH) GrabItemurlst 0 < DATA/YHDdirhtmlst.txt >& DATA/YHDitemurlst-max.txt

######

all:: GrabIteminfolst.class
GrabIteminfolst.class: \
  GrabIteminfolst.java ; javac -classpath $(CLASSPATH) $<

GrabIteminfolst: ; java -classpath $(CLASSPATH) GrabIteminfolst

######

all:: YiHaoDian.class
YiHaoDian.class: \
  YiHaoDian.java YHD_1_item.class ; javac -classpath $(CLASSPATH) $<

######

all:: YHD_1_item.class
YHD_1_item.class: YHD_1_item.java ; javac -classpath $(CLASSPATH) $<

######

RMF=rm -f

######

clean:: ; $(RMF) *~

cleanall:: clean
cleanall:: ; $(RMF) *.class

###### end of [Makefile] ######
