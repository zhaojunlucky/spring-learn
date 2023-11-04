package com.magicworldz.springlearn.security;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.magicworldz.springlearn.exception.ErrorCode;
import com.magicworldz.springlearn.dto.response.ResponseDTO;
import com.magicworldz.springlearn.utils.JsonUtil;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class APIAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        var resp = ResponseDTO.fail(ErrorCode.USER_ERROR.getErrCode(), accessDeniedException.getMessage());

        try {
            var bytes = JsonUtil.writeObjAsString(resp).getBytes(StandardCharsets.UTF_8);
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            FileCopyUtils.copy(bytes, response.getOutputStream());
        } catch (IOException e) {
            log.error("error", e);
            throw new RuntimeException(e);
        }
    }

}