package com.campus.myapp.controller;

import java.net.*;

import javax.servlet.http.HttpSession;

import java.io.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Clova_Speech_recognition {
	@GetMapping("/speechform")
	public String speechForm() {
		return "clova_speech_recognition";
	}
	
	@PostMapping("/speechRecOk")
	@ResponseBody
	public String speechRecognitionOk(@RequestParam("mp3file") MultipartFile file, @RequestParam("language") String language , HttpSession session) {
		
		String clientId = "b1evdsku7x";             // Application Client ID";
        String clientSecret = "ypwLWammk3JqK9svCZjK1KzCMBU6VO1jOb3xY26e";     // Application Client Secret";
        // 업로드할 경로
        String path = session.getServletContext().getRealPath("/file");
        // 업로드 실행
        String filename = ClovaFileUpload.fileUpload(path, file);
        
        StringBuffer response = new StringBuffer(); //응답 메세지 담을 곳
        try {
            String imgFile = path+"/"+filename;
            File voiceFile = new File(imgFile);

            //String language = "Kor";        // 언어 코드 ( Kor, Jpn, Eng, Chn )
            
            String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;
            URL url = new URL(apiURL);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            OutputStream outputStream = conn.getOutputStream();
            FileInputStream inputStream = new FileInputStream(voiceFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            BufferedReader br = null;
            int responseCode = conn.getResponseCode();
            if(responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            String inputLine;

            if(br != null) {
                //StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
			} /*
				 * else { System.out.println("error !!!"); }
				 */
        } catch (Exception e) {
            System.out.println(e);
        }
		
		
		return response.toString();
	}
	
}
