package com.solin.base.data.protocol

class BaseResponse<out T>(val status: Int,val message: String,val success: Boolean,val data: T)