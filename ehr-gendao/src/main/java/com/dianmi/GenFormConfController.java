package com.dianmi;

import cn.hutool.core.io.IoUtil;
import com.dianmi.entity.GenConfig;
import com.dianmi.service.GeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ehr
 *
 * @author yangbin
 * @date 2019年11月08日
 * <p>
 */
@AllArgsConstructor
@RestController
public class GenFormConfController {
    private final GeneratorService generatorService;


    @GetMapping("/gendao")
    public void gendao(HttpServletResponse response) throws IOException {
        GenConfig genConfig = new GenConfig();
        genConfig.setPackageName("com.dianmi.sso");
        genConfig.setAuthor("yangbin");
        byte[] data = generatorService.generatorCode(genConfig);
        response.reset();
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s.zip", "xxx"));
        response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(data.length));
        response.setContentType("application/octet-stream; charset=UTF-8");

        IoUtil.write(response.getOutputStream(), Boolean.TRUE, data);
    }
}
