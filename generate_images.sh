#!/bin/bash

# Check if a folder is provided
if [ -z "$1" ]; then
  echo "Usage: $0 <tag>"
  exit 1
fi

folder=$1


if [ ! -d "$folder" ]; then
  echo "Error: $folder is not a directory."
  exit 1
fi


cd "$folder" || exit 1

# Loop through each subfolder

for dir in */; do
  if [ -d "$dir" ] && [ -f "$dir/pom.xml" ]; then
    echo "Found pom.xml in $dir - building..."
    (cd "$dir" && mvn compile jib:dockerBuild)
  fi
done

