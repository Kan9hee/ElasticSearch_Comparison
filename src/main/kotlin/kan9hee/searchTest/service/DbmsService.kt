package kan9hee.searchTest.service

import kan9hee.searchTest.dto.BookDto
import kan9hee.searchTest.dto.RequestDto
import kan9hee.searchTest.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class DbmsService(private val bookRepository: BookRepository) {
    fun searchDataByDBMS(requestDto: RequestDto) {
        val searchResult = bookRepository.searchDataByPureDBMS(
            requestDto.name,requestDto.writer,requestDto.num)
    }

    fun searchDataByOverall(requestDto: RequestDto) {
        val searchResult = bookRepository.searchDataByOverall(requestDto)
    }
}