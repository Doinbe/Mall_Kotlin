package com.solin.user.data.procotol

import com.solin.base.data.protocol.BaseRequest

data class RegisterReq(val mobile: String,val pwd: String,val verifyCode: String): BaseRequest()