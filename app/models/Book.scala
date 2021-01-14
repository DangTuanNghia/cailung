package models

import play.api.libs.json.Json
import scalikejdbc.WrappedResultSet
import skinny.orm.SkinnyCRUDMapper

case class Book(id: Int,
                name: String,
                author: String,
                publisher: String) {

}
object Book extends SkinnyCRUDMapper[Book]{
  scalikejdbc.config.DBs.setupAll()
  implicit val bookJson = Json.format[Book]
  override val tableName    = "book"
  override lazy val defaultAlias = createAlias("s")
  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[Book]): Book = new Book(
    id = rs.get(n.id),
    name = rs.get(n.name),
    author = rs.get(n.author),
    publisher = rs.get(n.publisher)
  )
}
