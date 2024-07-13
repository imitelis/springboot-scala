package com.app.controllers

import java.util.Date
import scala.collection.mutable.ListBuffer

import org.springframework.web.bind.annotation.{GetMapping, RestController}
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation._
import org.springframework.http._

import io.circe._
import io.circe.syntax._
import io.circe.generic.auto._
import io.circe.generic._

import io.swagger.annotations.{
  ApiImplicitParam,
  ApiModelProperty,
  ApiResponse,
  ApiResponses,
  ApiOperation,
  Example,
  ExampleProperty
}

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}
import com.app.models.User

@RestController
@RequestMapping(Array("/api/users"))
class UserController {

  var users: ListBuffer[User] = ListBuffer(
    User(1, "John Doe", 23),
    User(2, "Jane Smith", 18)
  )

  @ApiOperation(value = "Get all users", produces = "application/json")
  @ApiResponses(
    Array(
      new ApiResponse(
        code = 200,
        message = "Successfully retrieved list of users",
        response = classOf[List[User]]
      )
    )
  )
  @GetMapping(produces = Array(MediaType.APPLICATION_JSON_VALUE))
  def getAllUsers: String = {
    users.asJson.noSpaces
  }

  @ApiOperation(value = "Get one user", produces = "application/json")
  @ApiResponses(
    Array(
      new ApiResponse(
        code = 200,
        message = "Successfully retrieved one user",
        response = classOf[User]
      )
    )
  )
  @GetMapping(
    value = Array("/{id}"),
    produces = Array(MediaType.APPLICATION_JSON_VALUE)
  )
  def getOneUser(@PathVariable id: Long): ResponseEntity[String] = {
    users.find(_.id == id) match {
      case Some(user) => ResponseEntity.ok(user.asJson.noSpaces)
      case None       => ResponseEntity.notFound().build()
    }
  }

  @ApiOperation(value = "Delete one user", produces = "application/json")
  @ApiResponses(
    Array(
      new ApiResponse(
        code = 204,
        message = "Successfully deleted one user"
      )
    )
  )
  @DeleteMapping(
    path = Array("/{id}")
  )
  def deleteUser(@PathVariable id: Long): ResponseEntity[String] = {
    users.indexWhere(_.id == id) match {
      case idx if idx >= 0 =>
        val deletedUser = users.remove(idx)
        ResponseEntity.noContent().build()
      case _ =>
        ResponseEntity.notFound().build()
    }
  }

}

/*
@PostMapping(
    produces = Array(MediaType.APPLICATION_JSON_VALUE)
  )
  def createUser(@RequestBody newUser: User): ResponseEntity[String] = {
    println(s"Received request to create user: $newUser")
    // users += newUser
    ResponseEntity.status(HttpStatus.CREATED).body(newUser.asJson.noSpaces)
  }
 */
