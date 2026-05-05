#!/usr/bin/env bash

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
EXIT_CODE=0

shopt -s nullglob

for run_script in "$ROOT_DIR"/BAI*-W2/run.sh; do
	exercise_dir="$(dirname "$run_script")"
	exercise_name="$(basename "$exercise_dir")"

	echo "=== Running ${exercise_name}/run.sh ==="
	(
		cd "$exercise_dir" || exit 1
		bash ./run.sh
	)
	status=$?

	if [ "$status" -ne 0 ]; then
		echo ">>> ${exercise_name}/run.sh failed with exit code ${status}"
		EXIT_CODE=1
	fi

	echo
done

echo "=== Removing build folders ==="
find "$ROOT_DIR" -type d -name build -prune -print -exec rm -rf {} +

if [ "$EXIT_CODE" -ne 0 ]; then
	echo "Completed with some failures."
else
	echo "Completed successfully."
fi

exit "$EXIT_CODE"