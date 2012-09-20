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

all:: GrabPImagelst.class
GrabPImagelst.class: \
  GrabPImagelst.java ; javac -classpath $(CLASSPATH) $<

######

all:: GrabDirhtmlst.class
GrabDirhtmlst.class: GrabDirhtmlst.java ; javac -classpath $(CLASSPATH) $<

GrabDirhtmlst: ; java -classpath $(CLASSPATH) GrabDirhtmlst

######

all:: GrabItemurlst.class
GrabItemurlst.class: GrabItemurlst.java ; javac -classpath $(CLASSPATH) $<

GrabItemurlst: ; java -classpath $(CLASSPATH) GrabItemurlst
GrabItemurlst-1: ; java -classpath $(CLASSPATH) GrabItemurlst 1 < DATA/JDdirhtmlst.txt >& DATA/JDitemurlst-0.txt
GrabItemurlst-5: ; java -classpath $(CLASSPATH) GrabItemurlst 5 < DATA/JDdirhtmlst.txt >& DATA/JDitemurlst-5.txt
GrabItemurlst-10: ; java -classpath $(CLASSPATH) GrabItemurlst 10 < DATA/JDdirhtmlst-printless.txt >& DATA/JDitemurlst-10.txt
GrabItemurlst-50: ; java -classpath $(CLASSPATH) GrabItemurlst 10 < DATA/JDdirhtmlst-printless.txt >& DATA/JDitemurlst-50.txt
GrabItemurlst-max: ; java -classpath $(CLASSPATH) GrabItemurlst 0 < DATA/JDdirhtmlst-printless.txt >& DATA/JDitemurlst-max.txt

######

all:: GrabIteminfolst.class
GrabIteminfolst.class: GrabIteminfolst.java ; javac -classpath $(CLASSPATH) $<

GrabIteminfolst: ; java -classpath $(CLASSPATH) GrabIteminfolst

######

all:: JingDong.class
JingDong.class: JingDong.java ; javac -classpath $(CLASSPATH) $<

######

all:: JD_360buy_item.class
JD_360buy_item.class: JD_360buy_item.java ; javac -classpath $(CLASSPATH) $<

######

all:: JDpimg2num
JDpimg2num: \
  JDpimg2num.dats ; $(ATSCC) -DATS_AS_COMMAND -O2 -o $@ $<
JDpimg2num_dats.o: JDpimg2num.dats ; $(ATSCC) -O2 -o $@ -c $<

all:: JDpricefill
JDpricefill: \
  JDpricefill.dats JDpimg2num_dats.o ; $(ATSCC) -D_ATS_GCATS -O2 -o $@ $< JDpimg2num_dats.o

######

RMF=rm -f

######

clean:: ; $(RMF) *~
clean:: ; $(RMF) *_?ats.c
clean:: ; $(RMF) *_?ats.o

cleanall:: clean
cleanall:: ; $(RMF) *.class
cleanall:: ; $(RMF) JDpimg2num
cleanall:: ; $(RMF) JDpricefill

###### end of [Makefile] ######
