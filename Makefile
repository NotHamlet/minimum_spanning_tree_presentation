all: mst_gen

mst_gen:
	mkdir -p out bin
	javac -d bin MSTGen.java
	java -cp 'bin' MSTGen < sample_inputs/sample1.in > out/sample1.out
	# time `java -cp 'bin' MSTGen < sample_inputs/sample2.in > out/sample2.out`
	# time `java -cp 'bin' MSTGen < sample_inputs/sample3.in > out/sample3.out`

draw:
	javac -d bin GraphDrawer.java
	java -cp 'bin' GraphDrawer out/sample1.out

clean:
	rm -rf bin
