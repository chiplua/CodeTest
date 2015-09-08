#!/bin/bash

javac -d test src/main/java/com/chiplua/operationjar/*.java
jar cvfm  operation.jar  META-INF/MANIFEST.MF ./tools/aapt* ./tools/background.jpg  -C test/  .

