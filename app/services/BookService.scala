package services

import models.Book


class BookService {
  val s = Book.defaultAlias
}
object BookService {
  def getAll = Book.findAll()
  def delete(id: Int) = Book.deleteById(id)
}
