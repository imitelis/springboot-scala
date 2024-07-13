package com.app.models

import io.circe.generic._
import io.swagger.annotations.{ApiModelProperty}

@JsonCodec
case class User(
    @ApiModelProperty(value = "User ID")
    id: Long,
    @ApiModelProperty(value = "User name")
    name: String,
    @ApiModelProperty(value = "User age")
    age: Int
)
