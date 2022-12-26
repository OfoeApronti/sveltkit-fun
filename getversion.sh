#!/bin/sh
read ver <<< $(awk -F":" '/"version":."[0-9]\.[0-9]\.[0-9]/ {print $2;exit}' package.json | sed 's/,//; s/"//g')
IFS=\".\" read -a version <<< ${ver}
echo "the package version: $version"
major=${version[0]}
minor=${version[1]}
patch=${version[2]}
patch=$patch+1
export NEW_VERSION="$major"."$minor"."$"