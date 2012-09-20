######
#
# A Simple Makefile
#
######

ATSCC=$(ATSHOME)/bin/atscc

######

CLASSPATH:=.
CLASSPATH:=$(CLASSPATH):../..
CLASSPATH:=$(CLASSPATH):../../JSOUP/jsoup-1.6.3.jar

######

DATA=DATA

######

all::

######

all:: GrabDirhtmlst.class
GrabDirhtmlst.class: GrabDirhtmlst.java ; javac -classpath $(CLASSPATH) $<

GrabDirhtmlst: ; java -classpath $(CLASSPATH) GrabDirhtmlst

######

all:: GrabItemurlst.class
GrabItemurlst.class: GrabItemurlst.java ; javac -classpath $(CLASSPATH) $<

GrabItemurlst: ; java -classpath $(CLASSPATH) GrabItemurlst
GrabItemurlst-1: ; java -classpath $(CLASSPATH) GrabItemurlst 1 < DATA/AMZdirhtmlst.txt >& DATA/AMZitemurlst-1.txt
GrabItemurlst-5: ; java -classpath $(CLASSPATH) GrabItemurlst 5 < DATA/AMZdirhtmlst.txt >& DATA/AMZitemurlst-5.txt
GrabItemurlst-10: ; java -classpath $(CLASSPATH) GrabItemurlst 10 < DATA/AMZdirhtmlst.txt >& DATA/AMZitemurlst-10.txt
GrabItemurlst-100: ; java -classpath $(CLASSPATH) GrabItemurlst 100 < DATA/AMZdirhtmlst-printless.txt >& DATA/AMZitemurlst-100.txt
GrabItemurlst-1000: ; java -classpath $(CLASSPATH) GrabItemurlst 1000 < DATA/AMZdirhtmlst-printless.txt >& DATA/AMZitemurlst-1000.txt
GrabItemurlst-max: ; java -classpath $(CLASSPATH) GrabItemurlst 0 < DATA/AMZdirhtmlst-printless.txt >& DATA/AMZitemurlst-max.txt

######

all:: GrabIteminfolst.class
GrabIteminfolst.class: GrabIteminfolst.java ; javac -classpath $(CLASSPATH) $<

GrabIteminfolst: ; java -classpath $(CLASSPATH) GrabIteminfolst

GrabIteminfolst-10: ; java -classpath $(CLASSPATH) GrabIteminfolst 50 < DATA/AMZitemurlst-10.txt >& DATA/AMZiteminfolst-50.txt

######

all:: Amazon.class
Amazon.class: Amazon.java ; javac -classpath $(CLASSPATH) $<

######

all:: AMZ_1_item.class
AMZ_1_item.class: AMZ_1_item.java ; javac -classpath $(CLASSPATH) $<

######

RMF=rm -f

######

clean:: ; $(RMF) *~
clean:: ; $(RMF) *_?ats.c
clean:: ; $(RMF) *_?ats.o

cleanall:: clean
cleanall:: ; $(RMF) *.class

###### end of [Makefile] ######
