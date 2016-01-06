#!/bin/bash

# Compile and run
javac -cp .:jsoup-1.8.3.jar Scraper.java
java -cp .:jsoup-1.8.3.jar Scraper $1
