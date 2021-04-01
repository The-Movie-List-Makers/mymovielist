int returnModeOfUnsortedArray (int[] myArray) {
	if (myArray.length == 1) return myArray[0];

	Hashtable<Integer, Integer> myHashtable = new Hashtable<>();

	for (int i = 0 ; i < myArray.length ; ++i) {
		if (myHashtable.contains(myArray[i])) {
			int counter = myHashtable.get(myArray[i]);
			myHashtable.put(myArray[i], ++counter);
		} else {
			myHashtable.put(myArray[i], 1);
		}
	}

	int max = 0, mode = -1;
	for (Integer key : myHashtable.keySet()) {
		if (myHashtable.get(key) > max) {
			max = myHashtable.get(key);
			mode = key;
		}
	}

	return mode;
}