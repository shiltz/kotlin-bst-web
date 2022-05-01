package cshilton.binarysearch.binarysearchwebapp

interface Search {
    fun binarySearch(arr: IntArray, searchNumber: Int, lowIndex: Int, highIndex: Int): Int
}
