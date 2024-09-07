#!/bin/bash

if ! command -v unzip &> /dev/null; then
  echo "unzip not found, installing..."
  sudo apt-get update && sudo apt-get install -y unzip
fi

ARTIFACT_ZIP="petshealth-docker-image.zip"
IMAGE_ZIP="petshealth-image.zip"
IMAGE_DIR="docker-images"

unzip -q "$ARTIFACT_ZIP"
unzip -q "$IMAGE_ZIP" -d "$IMAGE_DIR"
for tar_file in "$IMAGE_DIR"/*.tar; do
  docker load -i "$tar_file"
done
rm -rf "$IMAGE_DIR" "$IMAGE_ZIP"
docker-compose up -d





