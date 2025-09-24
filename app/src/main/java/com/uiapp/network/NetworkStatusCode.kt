package com.uiapp.network

sealed class NetworkStatusCode {}

class SuccessResponse(val data: String) : NetworkStatusCode()
class ErrorResponse(val message: String) : NetworkStatusCode()
class TimeoutResponse(val message: String) : NetworkStatusCode()
class Exception(val message: String) : NetworkStatusCode()