#! /bin/bash
# port: 8080
java -Xms128M \
	 -XX:MaxGCPauseMillis=500 \
	 -XX:+UseSerialGC \
     -XX:+UseCompressedOops \
     -XX:+OptimizeStringConcat \
	 -XX:NewRatio=3 \
	 -XX:ParallelGCThreads=8 \
	 -XX:InitiatingHeapOccupancyPercent=30 \
	 -jar tendance.jar
