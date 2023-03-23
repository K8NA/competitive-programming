/* !! include comments with the temporal and spatial complexity
as well as a small explanation of your algorithmic idea
include links to any websites you have consulted */



public static int bsearch (int v[], int k, int low, int high) {
  if (high >= low) {
    int mid = low + (high - low) / 2;

    if (array[mid] == x) // if found at mid, then return it
      return mid;

    if (array[mid] > x) // search the left half
      return binarySearch(array, x, low, mid - 1);

    return binarySearch(array, x, mid + 1, high); // search the right half
  }
  return -1;
}
