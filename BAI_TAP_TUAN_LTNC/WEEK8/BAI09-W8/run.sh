#!/bin/bash
ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
LIB_DIR="$ROOT_DIR/lib"
BUILD_DIR="$ROOT_DIR/build"

JUNIT_JAR=$(ls $LIB_DIR/junit-platform-console-standalone-6.0.3.jar | head -n 1)

mkdir -p "$BUILD_DIR"
javac -cp "$JUNIT_JAR" -d "$BUILD_DIR" "$SRC_DIR"/*.java

if [ $? -eq 0 ]; then
    echo "--- Running Tests ---"
    # This command uses the ConsoleLauncher to scan the build folder for tests
    java -jar "$JUNIT_JAR" execute --class-path "$BUILD_DIR" --scan-class-path

    echo "--- Running Main Application ---"
    java -cp "$CP" Main
fi