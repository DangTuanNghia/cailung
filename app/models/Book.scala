package models

import play.api.libs.json.Json
import scalikejdbc.WrappedResultSet
import skinny.orm.SkinnyCRUDMapper

case class Book(id: Int,
                name: String,
                author: String,
                publisher: String) {

}

case class BookForm(
                   name: String,
                   author: String,
                   publisher: String
                   )

object Book extends SkinnyCRUDMapper[Book]{
  scalikejdbc.config.DBs.setupAll()
  implicit val bookJson = Json.format[Book]
  implicit val reads = Json.reads[Book]

  override val tableName    = "book"
  override lazy val defaultAlias = createAlias("s")
  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[Book]): Book = new Book(
    id = rs.get(n.id),
    name = rs.get(n.name),
    author = rs.get(n.author),
    publisher = rs.get(n.publisher)
  )

  def getAll: Seq[Book] = Book.findAll()

  def deleteBook(id: Int): Int = Book.deleteById(id)

  def getBookById(id: Int): Option[Book] = Book.findById(id)

  def updateBook(id:Int,book: Book) = Book.updateById(id)
    .withAttributes(
      'id-> id,
      'name ->book.name,
      'author -> book.author,
      'publisher -> book.publisher
    )
  def createBook(book: Book): Long = {
    Book.createWithAttributes(
      'id-> 0,
      'name ->book.name,
      'author -> book.author,
      'publisher -> book.publisher
    )
  }
}
