package com.yamhto.cloud.web.starter.validate;

/**
 * 处理 controller 层参数校验：
 *
 * 区别	        @Valid	                                                           @Validated
 * 提供者	    JSR-303规范	                                                       Spring
 * 是否支持分组	不支持	                                                           支持
 * 标注位置	    METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE	TYPE,              METHOD, PARAMETER
 * 嵌套校验	    支持	                                                               不支持
 */
