package com.xbmu.exception;
/**
 * 自定义的一个异常类
 * @author Administrator
 *
 */
public class BangException extends RuntimeException
{
	// 定义一个无参数的构造器
	public BangException()
	{
	}
	// 定义一个带message参数的构造参数
	public BangException(String message)
	{
		super(message);
	}
}
