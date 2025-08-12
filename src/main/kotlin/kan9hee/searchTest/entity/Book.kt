package kan9hee.searchTest.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Book(num:String,
           name:String,
           writer:String,
           year:Int) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long=0

    @Column(nullable = false)
    var num:String = num
        protected set

    @Column(nullable = false)
    var name:String = name
        protected set

    @Column(nullable = false)
    var writer:String = writer
        protected set

    @Column(nullable = false)
    var year:Int = year
        protected set
}