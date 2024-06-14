#! /bin/bash
# port: 8080
java -Dspring.devtools.restart.enabled=true \
	 -Xms128M \
	 -XX:MaxGCPauseMillis=500 \
	 -XX:+UseSerialGC \
     -XX:+UseCompressedOops \
     -XX:+OptimizeStringConcat \
	 -XX:NewRatio=3 \
	 -XX:ParallelGCThreads=8 \
	 -XX:InitiatingHeapOccupancyPercent=30 \
	 -jar tendance-1.0.0.jar 
