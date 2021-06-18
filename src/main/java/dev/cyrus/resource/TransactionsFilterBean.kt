package dev.cyrus.resource

import javax.ws.rs.QueryParam

class TransactionsFilterBean(
    @QueryParam("declined") val declined: Boolean,
    @QueryParam("greater_than") val greaterThan: Int,
    @QueryParam("less_than") val lessThan: Int,
    @QueryParam("length") val length: Int,
    @QueryParam("start") val start: Int
)