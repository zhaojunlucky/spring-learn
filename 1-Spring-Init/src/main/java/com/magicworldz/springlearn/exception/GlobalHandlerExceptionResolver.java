package com.magicworldz.springlearn.exception;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.magicworldz.springlearn.dto.response.ResponseDTO;
import com.magicworldz.springlearn.utils.JsonUtil;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        Method method = null;
        if (handler != null && handler instanceof HandlerMethod) {
            method = ((HandlerMethod)handler).getMethod();
        }
        log.error("[{}] system error", method, ex);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        var resp = ResponseDTO.fail(ErrorCode.SYSTEM_ERROR.getErrCode(), ex.getMessage());

        try {
            var bytes = JsonUtil.writeObjAsString(resp).getBytes(StandardCharsets.UTF_8);
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            FileCopyUtils.copy(bytes, response.getOutputStream());
        } catch (IOException e) {
            log.error("error", e);
            throw new RuntimeException(e);
        }
        return new ModelAndView();
    }

}