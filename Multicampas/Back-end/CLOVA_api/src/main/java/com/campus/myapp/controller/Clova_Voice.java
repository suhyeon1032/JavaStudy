package com.campus.myapp.controller;

import java.io.*;
import java.net.*;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Clova_Voice {
	@GetMapping("voiceform")
	public String voiceHome() {
		return "clova_voice";
	}
	
	@PostMapping("/voiceOk")
	@ResponseBody
	public void voiceOk(String text, HttpServletResponse response) {
		System.out.println("text --> " + text);
		
		String clientId = "yn3cunbe88";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "sbKvQnX9Q5plhD7lYFP4dYRqZFDD4ma18zMp8usj";//애플리케이션 클라이언트 시크릿값";
        try {
            text = URLEncoder.encode(text, "UTF-8"); // 13자
            
            String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            // post request
            String postParams = "speaker=ngoeun&volume=0&speed=0&pitch=0&format=mp3&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                // 랜덤한 이름으로 mp3 파일 생성
                String tempname = Long.valueOf(new Date().getTime()).toString();
                File f = new File(tempname + ".mp3");
                f.createNewFile();
                //OutputStream outputStream = new FileOutputStream(f);	////////
                OutputStream outputStream = response.getOutputStream();
                while ((read =is.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                is.close();
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer res = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    res.append(inputLine);
                }
                br.close();
                System.out.println(res.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
	}
}
