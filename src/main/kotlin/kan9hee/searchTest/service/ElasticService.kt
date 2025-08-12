package kan9hee.searchTest.service

import co.elastic.clients.elasticsearch.ElasticsearchClient
import co.elastic.clients.elasticsearch._types.query_dsl.Query
import co.elastic.clients.elasticsearch.core.SearchResponse
import kan9hee.searchTest.dto.RequestDto
import kan9hee.searchTest.entity.Book
import org.springframework.stereotype.Service

@Service
class ElasticService(private val esClient: ElasticsearchClient) {
    fun searchDataByOverall(requestDto: RequestDto): List<Book> {
        val queries = mutableListOf<Query>()

        requestDto.name?.let {
            queries.add(Query.Builder().match { m -> m.field("name").query(it) }.build())
        }
        requestDto.writer?.let {
            queries.add(Query.Builder().match { m -> m.field("writer").query(it) }.build())
        }
        requestDto.num?.let {
            queries.add(Query.Builder().match { m -> m.field("num").query(it) }.build())
        }

        val response: SearchResponse<Book> = esClient.search({ s ->
            s.index("elasticbook")
                .source{ src -> src.filter { f -> f.includes("id", "name", "writer", "num", "year") } }
                .query { q -> q.bool { b -> b.must(queries) } }
        }, Book::class.java)

        return response.hits().hits().mapNotNull { it.source() }
    }
}