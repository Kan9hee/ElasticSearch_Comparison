package kan9hee.searchTest.repository.querydsl

import kan9hee.searchTest.dto.RequestDto
import kan9hee.searchTest.entity.Book

interface BookRepoCustom {
    fun searchDataByOverall(requestDto: RequestDto):List<Book>
}