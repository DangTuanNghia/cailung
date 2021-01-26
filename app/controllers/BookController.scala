package controllers

import com.google.inject.Inject
import models.{Book, BookForm}
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText}
import play.api.i18n.MessagesApi
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.ExecutionContext

class BookController @Inject()(messages: MessagesApi)(ec: ExecutionContext)(cc: ControllerComponents) extends AbstractController(cc) {
  private[this] val JsonContentType = "application/json; charset=utf-8"
  private[this] lazy val bookForm = Form(
    mapping(
      "name" -> nonEmptyText(maxLength = 20),
      "author" -> nonEmptyText,
      "publisher" -> nonEmptyText)(BookForm.apply)(BookForm.unapply))

  def index = Action {
    Ok(Json.toJson(Book.getAll))
  }

  def delete(id: Int) = Action {
    Book.deleteBook(id)
    Ok("delete success")
  }

  def findById(id: Int) = Action {
    Ok(Json.toJson(Book.getBookById(id)))
  }
  def update(id: Int) = Action {
     request => {
       Book.updateBook(id,request.body.asJson.get.validate[Book].get)
       Ok("test sau")
     }
  }
  def create = Action { req =>
//     println(req.body.asJson.get.validate[Book])
      Book.createBook(req.body.asJson.get.validate[Book].get)
      Ok("create success")
  }
}
