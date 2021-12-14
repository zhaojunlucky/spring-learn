package com.magicworldz.springlearn.unifiedresponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.magicworldz.springlearn.exception.entity.CustomerRuntimeException;
import com.magicworldz.springlearn.exception.entity.ResponseDTO;
import com.magicworldz.springlearn.utils.JsonUtil;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class UnifiedResponse implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) {
        if (!(body instanceof ResponseDTO)) {
            var resp = ResponseDTO.success(body);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            if (body instanceof String) {
                try {
                    return JsonUtil.writeObjAsString(resp);
                } catch (JsonProcessingException e) {
                    log.error("fail to write ResponseDTO to string", e);
                    throw new CustomerRuntimeException(e.getCause());
                }
            } else {
                return resp;
            }
        }
        return body;
    }

}