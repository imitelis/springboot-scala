package com.app.controllers

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders._
import org.springframework.test.web.servlet.result.MockMvcResultMatchers._

@SpringBootTest
@AutoConfigureMockMvc
class NameControllerTest {

  @Autowired
  private var mockMvc: MockMvc = _

  @Test
  def testSayHello(): Unit = {
    val name = "John"
    mockMvc
      .perform(get(s"/hello/$name"))
      .andExpect(status().isOk)
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(content().string("Hello John"))
  }
}
