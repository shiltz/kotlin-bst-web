package cshilton.binarysearch.binarysearchwebapp

import org.springframework.stereotype.Service

@Service
class BinarySearch : Search {

    override fun binarySearch(arr: IntArray, searchNumber: Int, lowIndex: Int, highIndex: Int): Int {

        var middleIndex = (highIndex + lowIndex) / 2
        if (lowIndex <= highIndex) {
            if (arr[middleIndex] == searchNumber) {
                return middleIndex
            }

            if (searchNumber > arr[middleIndex]) {
                return binarySearch(arr, searchNumber, middleIndex + 1, highIndex)
            }

            if (searchNumber < arr[middleIndex]) {
                return binarySearch(arr, searchNumber, lowIndex, middleIndex - 1)
            }
        }

        return -1

    }

}