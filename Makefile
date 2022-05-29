compile:
	javac ${CURDIR}/Model/*.java ${CURDIR}/*.java

build:
	jar cvmf MANIFEST.MF ./dist/ShapePainter.jar config.class Model/*.class Controller/*.class View/*.class Main.class

clean:
	rm -Force ${CURDIR}/*.class
	rm -Force ${CURDIR}/Model/*.class
	rm -Force ${CURDIR}/Controller/*.class
	rm -Force ${CURDIR}/View/*.class
