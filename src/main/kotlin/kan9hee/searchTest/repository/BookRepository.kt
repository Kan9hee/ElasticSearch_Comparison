package kan9hee.searchTest.repository

import kan9hee.searchTest.dto.RequestDto
import kan9hee.searchTest.entity.Book
import kan9hee.searchTest.repository.querydsl.BookRepoCustom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface BookRepository:JpaRepository<Book,Long>, BookRepoCustom {
    override fun searchDataByOverall(requestDto: RequestDto): List<Book>

    @Query(
        value = """
            SELECT *
            FROM book
            WHERE (:name IS NULL OR name LIKE CONCAT('%', :name, '%'))
            AND (:writer IS NULL OR writer LIKE CONCAT('%', :writer, '%'))
            AND (:num IS NULL OR num LIKE CONCAT('%', :num, '%'))
        """,
        nativeQuery = true
    )
    fun searchDataByPureDBMS(
        @Param("name") name: String?,
        @Param("writer") writer: String?,
        @Param("num") num: String?
    ): List<Book>
}