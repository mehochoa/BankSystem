#!/bin/bash
ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"
mkdir -p "$BUILD_DIR"
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java
if [ $? -eq 0 ]; then
    java -cp "$BUILD_DIR" Main
fi