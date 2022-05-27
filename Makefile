compile:
	javac ${CURDIR}/Model/*.java ${CURDIR}/*.java

clean:
	rm -Force ${CURDIR}/*.class
	rm -Force ${CURDIR}/Model/*.class
	rm -Force ${CURDIR}/Controller/*.class
	rm -Force ${CURDIR}/View/*.class
