package kan9hee.searchTest.repository.querydsl

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import kan9hee.searchTest.dto.RequestDto
import kan9hee.searchTest.entity.Book
import kan9hee.searchTest.entity.QBook

class BookRepoCustomImpl(private val jpaQueryFactory: JPAQueryFactory):BookRepoCustom {

    override fun searchDataByOverall(requestDto: RequestDto): List<Book> {
        val book = QBook.book
        val builder = BooleanBuilder()

        requestDto.name?.let { builder.and(book.name.like("%$it%")) }
        requestDto.writer?.let { builder.and(book.writer.like("%$it%")) }
        requestDto.num?.let { builder.and(book.num.like("%$it%")) }

        return jpaQueryFactory
            .select(Projections.constructor(
                Book::class.java,
                book.num,book.name,book.writer,book.year))
            .from(book)
            .where(builder)
            .fetch()
    }
}