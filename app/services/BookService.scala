//package services
//
//import models.Book
//import play.api.libs.json.Json
//import scalikejdbc.WrappedResultSet
//import skinny.orm.SkinnyCRUDMapper
//
//
//object BookService extends SkinnyCRUDMapper[Book]{
//  scalikejdbc.config.DBs.setupAll()
//  implicit val bookJson = Json.format[Book]
//  override val tableName    = "book"
//  override lazy val defaultAlias = createAlias("s")
//  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[Book]): Book = new Book(
//    id = rs.get(n.id),
//    name = rs.get(n.name),
//    author = rs.get(n.author),
//    publisher = rs.get(n.publisher)
//  )
//
//  def getAll: Seq[Book] = BookService.findAll()
//  def deleteBook(id: Int): Int = BookService.deleteById(id)
//  def getBookById(id: Int): Option[Book] = BookService.findById(id)
//  def updateBook(id:Int,book: Book) = BookService.updateById(id)
//    .withAttributes(
//      'name ->book.name,
//      'author -> book.author,
//      'publisher -> book.publisher
//    )
//  def create(id:Int, book: Book): Int = {
//    BookService.createWithNamedValues(
//      column.id -> book.id,
//      column.name ->book.name,
//      column.author ->book.author,
//      column.publisher ->book.publisher
//    )
//  }
//
//  }
