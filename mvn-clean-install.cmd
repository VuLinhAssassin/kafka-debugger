@echo off
mvn clean install
copy .\target\kafka-debugger-gui-1.0.0.RELEASE.jar .\exec\kafka-debugger-gui-1.0.0.RELEASE.jar