package com.app.controllers

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation._

import org.springframework.http.{HttpStatus, ResponseEntity}

import scala.collection.mutable.ListBuffer

case class Client(id: Long, name: String, age: Int)

@Service
@RestController
@RequestMapping(Array("/api/clients"))
class ClientController {

  // In-memory list to store clients
  private val clients = ListBuffer[Client]()

  @GetMapping
  def getAllClients: Iterable[Client] = clients

  @GetMapping(Array("/{id}"))
  def getClientById(@PathVariable id: Long): ResponseEntity[Client] = {
    clients.find(_.id == id) match {
      case Some(client) => ResponseEntity.ok(client)
      case None         => ResponseEntity.notFound().build()
    }
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  def createClient(@RequestBody client: Client): Client = {
    val nextId = if (clients.isEmpty) 1 else clients.maxBy(_.id).id + 1
    val newClient = client.copy(id = nextId)
    clients += newClient
    newClient
  }
}
