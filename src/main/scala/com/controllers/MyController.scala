// MyController.scala
package com.controllers

import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{
  PathVariable,
  RequestMapping,
  RequestMethod,
  RestController
}

@Service
@RestController
@RequestMapping(Array("/v1"))
class MyController {
  @RequestMapping(
    value = Array("/hello/{name}"),
    method = Array(RequestMethod.GET)
  )
  def sayHello(
      @PathVariable(name = "name") name: String
  ): ResponseEntity[String] =
    ResponseEntity.ok(s"Hello ${name}")
}
