DEP=dependencies/
CLS=classes/

all: main.jar

main.jar: Main.class
	jar cf $(CLS)$@ $(CLS)*.class

Main.class: $(wildcard *.java) $(GEN)
	javac -d $(CLS) -cp .:$(DEP)* *.java

clean:
	rm -f *.class $(GEN)

veryclean: clean
	rm main.jar
