// MyController.scala
package com.app.controllers

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation._
import org.springframework.http.{HttpStatus, ResponseEntity}

import scala.collection.mutable.ListBuffer

@Service
@RestController
@RequestMapping(Array("/hello"))
class NameController {
  @RequestMapping(
    value = Array("/{name}"),
    method = Array(RequestMethod.GET)
  )
  def sayHello(
      @PathVariable(name = "name") name: String
  ): ResponseEntity[String] =
    ResponseEntity.ok(s"Hello ${name}")
}
