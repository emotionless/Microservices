#!/bin/bash

# Check if a tag is provided
if [ -z "$1" ]; then
  echo "Usage: $0 <tag>"
  exit 1
fi

TAG=$1

echo "Finding all Docker images with tag: $TAG"
docker images --format "{{.Repository}}:{{.Tag}}" | grep ":$TAG" | while read image; do
    echo "Pushing $image..."
    docker push "$image"
done

