package cshilton.binarysearch.binarysearchwebapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class BinarySearchWebAppApplication

fun main(args: Array<String>) {
    runApplication<BinarySearchWebAppApplication>(*args)
}

data class Message(val id: String?, val text: String)

@RestController
class SearchNumberResource(val searchService: Search) {
    var searchNumbers: IntArray = intArrayOf(1, 2, 3)

    @GetMapping
    fun retrieveAll(): IntArray = searchNumbers

    @PostMapping
    fun updateSearchNumbers(@RequestParam numbers: IntArray): IntArray {
        searchNumbers = numbers
        return searchNumbers
    }

    @GetMapping("/find")
    fun findNumber(@RequestParam number: Int): Int {
        var num =  searchService.binarySearch(searchNumbers, number,  0, searchNumbers.size - 1)
        return num
    }

}