package com.campus.myapp.controller;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.DataService;
import com.campus.myapp.vo.DataVO;

@RestController
public class DataController {
	@Autowired
	DataService service;

	@GetMapping("/data/dataList")
	public ModelAndView dataList() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("lst", service.dataSelectAll());
		
		mav.setViewName("data/dataList");
		return mav;
	}

	// 자료실 글쓰기 폼
	@GetMapping("/data/write")
	public ModelAndView dataWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("data/dataWrite");

		return mav;
	}

	@PostMapping("/data/writeOk")
	public ResponseEntity<String> dataWirteOk(DataVO vo, HttpServletRequest request) {
		// vo : subject, content는 request가 됨.
		vo.setUserid((String) request.getSession().getAttribute("logId")); // 글쓴이

		// 파일 업로드에 관련된 multipartRequest객체를 구해야함
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));

		String path = request.getSession().getServletContext().getRealPath("/upload"); // 파일업로드를 위한 업로드 위치의 절대주소
		System.out.println("path -> " + path);
		try {
			// 파일 업로드를 처리하기 위해서 request 객체에서 multipart객체를 구하여야 한다.
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;

			// mr에 파일의 수만큼 MultipartFile객체가존재한다
			List<MultipartFile> files = mr.getFiles("filename");
			System.out.println("업로드 파일 수 -> " + files.size());

			if (files != null) { // if 111
				int cnt = 1; // 4번에서 업로드 순서에 따라 filename1, filename2 파일명을 대입하기 위한 변수
				// 첨부파일수 만큼 반복하여 업로드한다.
				for (int i = 0; i < files.size(); i++) { // for 222
					// 1. MultipartFile객체 얻어오기
					MultipartFile mf = files.get(i);

					// 2. 업로드한 실제 파일명을 구하기
					String orgFileName = mf.getOriginalFilename();
					System.out.println("orgFileName -> " + orgFileName);

					// 3. rename하기
					if (orgFileName != null && !orgFileName.equals("")) { // if 333, 파일명이 존재하면
						File f = new File(path, orgFileName);

						// 파일이 존재하는 지 확인 true:파일이 존재/ false:파일 없음
						if (f.exists()) { // if 444
							for (int renameNum = 1;; renameNum++) { // for 555
								// 확장자와 파일을 분리한다.
								int point = orgFileName.lastIndexOf(".");
								String fileName = orgFileName.substring(0, point);
								String ext = orgFileName.substring(point + 1);

								f = new File(path, fileName + " (" + renameNum + ")." + ext);
								if (!f.exists()) { // if 666 , 새로 생성된 파일 객체가 없으면
									orgFileName = f.getName();
									break;
								} // if 666

							} // for 555

						} // if 444

						// 4. 파일 업로드 구현
						try {
							mf.transferTo(f); // 실제 업로드가 일어나는(발생하는) 시점
						} catch (Exception ee) {
						}

						// 5. 업로드한(새로운파일명) vo에 셋팅
						if (cnt == 1)
							vo.setFilename1(orgFileName);
						if (cnt == 2)
							vo.setFilename2(orgFileName);
						cnt++;
					} // if 333

				} // for 222

			} // if 111
			System.out.println(vo.toString());

			// DB등록
			service.dataInsert(vo);
			// 레코드 추가 성공
			String msg = "<script>alert('자료실글등록되었습니다.');location.href='/myapp/data/dataList';</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
			entity = null;

		} catch (Exception e) {
			e.printStackTrace();
			// 레코드추가 실패
			// 파일지우기
			fileDelete(path, vo.getFilename1());
			fileDelete(path, vo.getFilename2());

			// 메세지
			String msg = "<script>alert('자료실글등록실패하였습니다.');history.back();</script>";
			// 이전페이지로 보내기(자바스크립트)
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST); // 400
		}
		return entity;
	}

	// 파일지우기
	public void fileDelete(String p, String f) {
		if (f != null) { // 파일명이 존재하면
			File file = new File(p, f);
			file.delete();
		}
	}
	//글 내용보기
	@GetMapping("/data/view")
	public ModelAndView view(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("dataVO", service.dataView(no));
		mav.setViewName("data/dataView");
		return mav;	
	}
	//수정폼
	@GetMapping("/data/dataEdit")
	public ModelAndView editForm(int no) {
		ModelAndView mav = new ModelAndView();
		//mav.addObject("vo", service.dataView(no));
		DataVO vo = service.dataView(no);
		//DB에 첨부된 파일의 수를 구한다.
		int fileCount = 1; //첫번째 첨부파일은 무조건 있음
		if(vo.getFilename2() != null ) {//두번째 첨부파일 있으면 1증가
			fileCount++;
		}	
		
		mav.addObject("fileCount", fileCount);
		mav.addObject("vo",vo);
		mav.setViewName("data/dataEdit");
		return mav;
	}
	//수정(DB)
	@PostMapping("/data/editOk")
	public ResponseEntity<String> editOk(DataVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logId"));
		String path = session.getServletContext().getRealPath("/upload");
		
		System.out.println(vo.toString());
		for(int k=0; k<vo.getDelFile().length; k++) {
			System.out.println(vo.getDelFile()[k]);
		}
		
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=utf-8");
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return entity;
	}
}