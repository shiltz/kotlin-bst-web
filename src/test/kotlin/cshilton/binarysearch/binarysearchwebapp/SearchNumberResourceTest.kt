package cshilton.binarysearch.binarysearchwebapp

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebFluxTest
class SearchNumberResourceTest(@Autowired val webclient: WebTestClient) {

    @MockkBean
    lateinit var mockSearchService: Search

    @Test
    fun givenSearchNumberExists_whenGetRequest_thenReturnsTheSearchableNumbers() {
        every { mockSearchService.binarySearch(any(), any(), any(), any()) } returns 1

        webclient.get().uri("/find?number=3")
            .exchange().expectStatus().is2xxSuccessful
            .expectBody(String::class.java).isEqualTo("1")

    }
}