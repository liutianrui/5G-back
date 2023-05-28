package com.ruoyi.common.utils;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

/**
 * @author yzz
 * @date 2019/8/1 13:53
 * @describe 返回工具类
 */
//@ApiModel(description = "返回结果")
public class Result<T> {

	/**
	 * 状态码 默认值 {@code 0 }
	 */
//	@ApiModelProperty(value = "状态码 默认值 0", required = true, example = "0",position=1)
	private int code = 0 ;

	/**
	 * 返回信息 默认值 {@code 成功}
	 */
//	@ApiModelProperty(value = "返回信息 默认值 成功", required = true, example = "成功",position=2)
	private String msg="成功";

	/**
	 * 返回数据
	 */
//	@ApiModelProperty(value = "返回数据",position=3)
	private T data;

	public Result() {}

	/**
	 * 可自定义返回状态码和信息
	 * @param data 返回数据
	 * @param msg 返回信息
	 * @param code 状态码
	 */
	public Result(T data, String msg, int code) {
		this.data=data;
		this.msg=msg;
		this.code=code;
	}

	/**
	 * 默认返回成功
	 * @param data 返回的数据
	 */
	public Result(T data) {
		this(data,"成功",0);
	}

	/**
	 * 自定义返回结果
	 * @param data 返回数据
	 * @param status 返回状态
	 * @see Status
	 */
	public Result(T data, Status status) {
		this(data,status.getMsg(),status.getCode());
	}


	/**
	 * 可自定义返回状态码和信息
	 * @param data 返回数据
	 * @param customMsg 自定义信息
	 * @param status 状态码
	 */
	public Result(T data, String customMsg, Status status) {
		this(data,customMsg,status.getCode());
	}

	/**
	 * 静态调用，返回成功结果
	 * @author yzz
	 * @date 2019/8/1 13:53
	 * @param 返回数据
	 * @return
	 */
	public static <T> Result<T> ok(T data) {
		return new Result<T>(data);
	}
	public static <T> Result<T> ok() {
		return new Result<T>(null);
	}

	/**
	 * 判断是否成功
	 * @author yzz
	 * @date 2019/8/1 13:54
	 * @return  如果code是0，则返回true，否则false
	 */
	public boolean isOK() {
		return this.code==0;
	}

	/**
	 * 错误请求
	 * @author yzz
	 * @date 2019/8/1 13:55
     * @param msg 具体错误信息
     * @param code 400开头的错误码
	 * @return 返回数据
	 */
	public static <T> Result<T> badRequest(String msg, int code) {
		return new Result<T>(null,msg,code);
	}

	/**
	 * 状态信息
	 * @author yzz
	 * @date 2019/8/1 13:57
	 * @param null
	 * @return
	 */
	public static <T> Result<T> badRequest(Status status) {
		return new Result<T>(null,status);
	}
	/**
	 * 扩充详细信息
	 * @author yzz
	 * @date 2019/8/1 13:57
     * @param status 状态码
     * @param customMsg 详细错误信息
     * @return 返回数据
	 * @return 返回数据
	 */
	public static <T> Result<T> badRequest(Status status, String customMsg) {
		return new Result<T>(null,String.format("%s;%s", status.getMsg(),customMsg),status.getCode());
	}
	/**
	 * 返回400错误信息
	 * @author yzz
	 * @date 2019/8/1 13:58
	 * @return 返回400错误信息
	 */
	public static <T> Result<T> badRequest() {
		return new Result<T>(null, Status.BAD_REQUEST);
	}

	/**
	 * 获取返回数据
	 */
	public T getData() {
		return data;
	}

	/**
	 * 设置返回数据
	 *
	 * @param data 返回数据
	 */
	public void setData(T data) {
		this.data = data;
	}


	/**
	 * 获取返回信息
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 设置返回信息
	 *
	 * @param msg 返回信息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 获取状态码
	 */
	public int getCode() {
		return code;
	}

	/**
	 * 设置状态码
	 * @param code 状态码
	 */
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return new StringBuilder(500).append("Result{code='").append(code).append("',msg='").append(msg).append("',data='").append(data).append("'}").toString();
	}

	/**
	 * @author yzz
	 * @date 2019/8/1 13:58
	 * @describe 状态码枚举
	 */
	public enum Status {
		/**
		 * 0 成功
		 */
		OK(0,"成功"),
		/**
		 * {@code 400 无效请求}.
		 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.1">HTTP/1.1: Semantics and Content, section 6.5.1</a>
		 */
		BAD_REQUEST(400, "无效请求"),
		/**
		 * {@code 40001 参数无效}.
		 */
		BAD_PARAMETER(40001, "参数无效"),
		/**
		 * {@code 401 无权限}.
		 * @see <a href="http://tools.ietf.org/html/rfc7235#section-3.1">HTTP/1.1: Authentication, section 3.1</a>
		 */
		UNAUTHORIZED(401, "无权限"),
		/**
		 * {@code 403 资源禁止访问}.
		 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.3">HTTP/1.1: Semantics and Content, section 6.5.3</a>
		 */
		FORBIDDEN(403, "资源禁止访问"),
		/**
		 * {@code 405 方法不允许访问}.
		 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.5">HTTP/1.1: Semantics and Content, section 6.5.5</a>
		 */
		METHOD_NOT_ALLOWED(405, "方法不允许访问"),
		/**
		 * {@code 409 请求冲突}.
		 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.8">HTTP/1.1: Semantics and Content, section 6.5.8</a>
		 */
		CONFLICT(409, "请求冲突"),
		/**
		 * {@code 500 500 服务异常}.
		 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.1">HTTP/1.1: Semantics and Content, section 6.6.1</a>
		 */
		INTERNAL_SERVER_ERROR(500, "服务异常"),
		/**
		 * 50001 未知错误
		 */
		UNKNOWN_ERROR(50001, "未知错误"),
		/**
		 * {@code 502 无效网关}.
		 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.3">HTTP/1.1: Semantics and Content, section 6.6.3</a>
		 */
		BAD_GATEWAY(502, "无效网关"),
		/**
		 * {@code 503 服务不可用}.
		 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.4">HTTP/1.1: Semantics and Content, section 6.6.4</a>
		 */
		SERVICE_UNAVAILABLE(503, "服务不可用"),
		/**
		 * {@code 504  网关超时}.
		 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.5">HTTP/1.1: Semantics and Content, section 6.6.5</a>
		 */
		GATEWAY_TIMEOUT(504, "网关超时");

		private final int code;

		private final String msg;

		Status(int code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		/**
		 * @return 状态码
		 */
		public int getCode() {
			return code;
		}

		/**
		 * @return 错误信息
		 */
		public String getMsg() {
			return msg;
		}

		/**
		 * 根据状态码返回符合的SnStatus值，如果没有，返回50001 未知错误
		 * @author yzz
		 * @date 2019/8/1 13:59
		 * @param code 状态码
		 * @return 值
		 */
		public static Status valueOf(int code) {
			for (Status val : values()) {
				if (val.code==code) {
					return val;
				}
			}
			return UNKNOWN_ERROR;
		}
	}
}
