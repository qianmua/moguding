package com.qianmua.controller;


import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/29 15:54          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/29 15:54
 * @since JDK1.8
 */
@Slf4j
public class CaptchaTest {

    public static void main(String[] args) {
        System.out.println(getValCodeValue());
    }

    /**
     * 获取验证码的值
     *
     * @return
     * @throws IOException
     */
    public static String getValCodeValue() {
        String valCodeUrl = "https://api.moguding.net:9000/session/user/v1/captcha.jpg?uuid=" + UUID.randomUUID().toString();
        // String valCodeUrl = "file:D:\\downs\\ValidateCode.jpg";
        System.out.println(valCodeUrl);
        URL url = null;
        try {
            url = new URL(valCodeUrl);
            InputStream inputStream = url.openStream();

            BufferedImage bufferedImg = ImageIO.read(new BufferedInputStream(new DataInputStream(inputStream)));
            // 读取图片数字
            ITesseract instance = new Tesseract();
            File tessDataFolder = LoadLibs.extractTessResources("tessdata");
            instance.setLanguage("eng");// 英文库识别数字比较准确
            instance.setDatapath(tessDataFolder.getAbsolutePath());
            String valCodeStr = instance.doOCR(bufferedImg).replace("\n", "");
            System.out.println(valCodeStr);
            return valCodeStr;
        } catch (TesseractException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }



}
