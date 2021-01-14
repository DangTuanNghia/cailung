package controllers

import com.google.inject.Inject
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}
import services.BookService

import scala.concurrent.ExecutionContext

class BookController @Inject()(ec: ExecutionContext)(cc: ControllerComponents) extends AbstractController(cc) {
  def index = Action {
     Ok(Json.toJson(BookService.getAll))
  }

  def delete(id:Int) = Action{
    BookService.delete(id)
    Ok("delete success")
  }
}
