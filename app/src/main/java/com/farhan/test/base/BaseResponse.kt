package com.farhan.test.base

data class BaseResponse(
//    var data: T? = null,
    var status: Any? = null,
    var status_code: Int = 0,
    var message: String? = null,
    var total: Int? = 0,
    var error: Boolean = false,
//    var errors: X? = null
)
