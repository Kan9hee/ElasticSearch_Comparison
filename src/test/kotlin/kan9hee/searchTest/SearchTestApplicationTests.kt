package kan9hee.searchTest

import kan9hee.searchTest.dto.RequestDto
import kan9hee.searchTest.service.DbmsService
import kan9hee.searchTest.service.ElasticService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SearchTestApplicationTests {

	@Autowired
	lateinit var dbmsService: DbmsService

	@Autowired
	lateinit var elasticService: ElasticService

	val requestExam = RequestDto("CEM","햄릿","셰익스피어")

	@Test
	fun `DBMS 기반 검색 성능 테스트`() {
		val start = System.currentTimeMillis()
		dbmsService.searchDataByDBMS(requestExam)
		val end = System.currentTimeMillis()
		val durationMs = end - start
		println("DBMS 검색 소요 시간: $durationMs ms")
	}

	@Test
	fun `DBMS+QueryDSL 기반 검색 성능 테스트`() {
		val start = System.currentTimeMillis()
		dbmsService.searchDataByOverall(requestExam)
		val end = System.currentTimeMillis()
		val durationMs = end - start
		println("DBMS+QueryDSL 검색 소요 시간: $durationMs ms")
	}

	@Test
	fun `ElasticSearch 기반 검색 성능 테스트`() {
		val start = System.currentTimeMillis()
		elasticService.searchDataByOverall(requestExam)
		val end = System.currentTimeMillis()
		val durationMs = end - start
		println("ElasticSearch 검색 소요 시간: $durationMs ms")
	}

}
