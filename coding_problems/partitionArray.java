int[] partitionArray (int[] myArray, int target) {
	if (myArray.length <= 1) return myArray;
	int numCopiesOfTarget = 0;
	int[] partitionedArray = new int[myArray.length];

	int j = 0;
	for (int i = 0 ; i < myArray.length ; ++i) {
		if (myArray[i] < target) {
			partitionedArray[j] = myArray[i];
			++j;
		}
		if (myArray[i] == target) {
			numCopiesOfTarget++;
		}
	}

	for (int i = 0 ; i < numCopiesOfTarget ; ++i) {
		partitionedArray[j] = target;
		++j;
	}

	for (int i = 0 ; i < myArray.length ; ++i) {
		if (myArray[i] > target) {
			partitionedArray[j] = myArray[i];
			++j;
		}
	}

	return partitionedArray;
}