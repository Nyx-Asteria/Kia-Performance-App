#!/bin/sh
set -eu
cd "$(dirname "$0")"
: "${HMGAPI_SDK:?Set HMGAPI_SDK to unpacked pinned SDK}"
: "${HMGAPI_KEY:?Set HMGAPI_KEY to persistent author key}"
: "${HMGAPI_APP_KEY:?Set HMGAPI_APP_KEY to persistent APK keystore}"
export HMGAPI_APP_KEY
MOD=hmgapi-performance-pages
sh "$HMGAPI_SDK/bin/build-mod.sh" "$MOD" "out/build/$MOD" "out/work/$MOD"
sh "$HMGAPI_SDK/bin/check-scripts.sh" "$MOD"
HMGAPI_MOD_BUILD="$PWD/out/build/$MOD" sh "$HMGAPI_SDK/bin/mkmodpkg.sh" "$MOD" "$HMGAPI_KEY"
