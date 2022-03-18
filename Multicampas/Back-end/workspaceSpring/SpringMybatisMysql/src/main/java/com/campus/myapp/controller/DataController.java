package com.campus.myapp.controller;

import java.awt.print.Printable;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpSessionRequiredException;
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
	public ResponseEntity<String> dataWriteOk(DataVO vo, HttpServletRequest request) {
		// vo: subject, content는 request가 됨
		vo.setUserid((String) request.getSession().getAttribute("logId"));// 글쓴이

		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));

		// 파일 업로드를 위한 업로드 위치 절대주소 구하기
		String path = request.getSession().getServletContext().getRealPath("/upload");
		System.out.println("path->" + path);

		try {
			// 파일 업로드를 처리하기 위해서 request에서 multipart객체를 구하여야 한다
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
			// mr에 존재하는것 : 파일의 수 만큼 multipartFile객체가 존재
			List<MultipartFile> files = mr.getFiles("filename");
			System.out.println("업로드 파일 수 = " + files.size());

			if (files != null) {// if_1
				// 업로드 순서 정하기 위한 변수. 업로드 순서에 따라 filename1, filename2에 파일명을 대입하기 위한 변수
				int cnt = 1;// 초기값 : 1

				// 첨부파일의 수만큼 반복하여 업로드한다
				for (int i = 0; i < files.size(); i++) {// for_2

					// 1. MultipartFile객체 가져오기
					MultipartFile mf = files.get(i);

					// 2. 업로드한 실제 파일 명을 구하기
					String orgFileName = mf.getOriginalFilename();
					System.out.println("originalFileName->" + orgFileName);

					// 3. rename하기
					if (orgFileName != null && !orgFileName.equals("")) {// if_3

						File f = new File(path, orgFileName);

						// .exists() : 파일이 존재하는지 확인. 있으면 true, 없으면 false
						if (f.exists()) {// if_4
							for (int renameNum = 1;/* 무한루프 */; renameNum++) {// for_5
								// 이미 해당 파일명의 파일이 존재하기 떄문에, rename 해야함
								// 확장자와 파일명 분리
								int point = orgFileName.lastIndexOf(".");// orgFileName에서 마지막 .의 위치
								String fileName = orgFileName.substring(0, point);// orgFileName에서 0부터 point이전까지의 글자 가져와
								String ext = orgFileName.substring(point + 1);// orgFileName에서 point이후의 글자 가져와

								f = new File(path, fileName + " (" + renameNum + ")." + ext);
								if (!f.exists()) {// 새로 생성된 파일 객체가 없으면 중단 및 새로 만든 파일명으로 변환
									orgFileName = f.getName();
									break;
								}
							} // for_5
						} // if_4

						// 4. 파일 업로드 진행
						try {
							mf.transferTo(f);// 실제 업로드 발생

						} catch (Exception ee) {
						}

						// 5. 업로드한(새로운 파일명)vo에 셋팅
						if (cnt == 1)
							vo.setFilename1(orgFileName);
						if (cnt == 2)
							vo.setFilename2(orgFileName);
						cnt++;

					} // if_3
				} // for_2
			} // if_1
			System.out.println(vo.toString());

			// DB등록
			service.dataInsert(vo);
			// 레코드 추가 성공
			String msg = "<Script>alert('자료실 글이 등록 되었습니다.');location.href='/myapp/data/dataList';</script>";

			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			// 레코드 추가 실패

			// 파일 지우기
			fileDelete(path, vo.getFilename1());
			fileDelete(path, vo.getFilename2());

			// 메세지
			String msg = "<script>alert('자료실 글 등록 실패하였습니다.');history.back();</script>";
			// 이전 페이지로 보내기
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;

	}

	// 파일 지우기
	public void fileDelete(String p, String f) {
		if (f != null) {// 파일명이 존재하면
			File file = new File(p, f);
			file.delete();
		}
	}
	//자료실 글 내용 보기
	@GetMapping("/data/view")
	public ModelAndView view(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("dataVO", service.dataView(no));
		mav.setViewName("data/dataView");
		return mav;
	}
	//수정 폼
	@GetMapping("/data/dataEdit")
	public ModelAndView editForm(int no) {
		ModelAndView mav = new ModelAndView();
		DataVO vo = service.dataView(no);
		//DB에 첨부된 파일의 수를 구함
		int fileCount=1;//파일 1개는 반드시 있음
		//두번째 첨부파일이 있으면 1 증가
		if(vo.getFilename2()!=null) {
			fileCount++;
		}
		mav.addObject("fileCount",fileCount);
		mav.addObject("vo",vo);
		mav.setViewName("/data/dataEdit");
		return mav;
	}
	//수정DB
	@PostMapping("/data/editOk")
	public ResponseEntity<String> editOk(DataVO vo, HttpSession session, HttpServletRequest req) {
		vo.setUserid((String)session.getAttribute("logId"));
		String path = session.getServletContext().getRealPath("/upload");
		
//		System.out.println(vo.toString());
//		if(vo.getDelFile()!=null) {
//			for(int k=0; k<vo.getDelFile().length; k++) {
//				System.out.println(vo.getDelFile()[k]);
//			}
//		}
		
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "text/html; charset=utf-8");
		
		List<String> fileList = new ArrayList<String>();//새로 DB에 업데이트할 파일명 정리하는 컬렉션 List<파일명> 생성
		List<String> newUpload = new ArrayList<String>();//새로 업로드한 파일명을 보관할 컬렉션 생성
		
		try {
			//1. DB에서 파일명 가져오기
			DataVO dbFileVO = service.getFileName(vo.getNo());
			
			fileList.add(dbFileVO.getFilename1());//파일 1개는 반드시 있으니 우선 넣고, 조건문으로 2 넣기
			if(dbFileVO.getFilename2()!=null) fileList.add(dbFileVO.getFilename2());
			
			//2. 삭제된 파일이 있을 경우 List에서 같은 파일명을 지움
			if(vo.getDelFile()!=null) {//null : 삭제할 파일이 없음
				for(String delFile : vo.getDelFile()) {
					fileList.remove(delFile);//index 넣어서도 가능하지만 우린 파일명을 아니 사용
					
				}
			}
			
			//3. 새로 업로드하기
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
			//새로 업로드한 multipartFile 객체를 얻어오기
			List<MultipartFile> newFileList = mr.getFiles("filename");//컬렉션으로 리턴해줌
			if(newFileList!=null) {//새로 업로드된 파일이 있으면
				for(int i = 0; i<newFileList.size(); i++) {//업로드된 파일의 수만큼 반복
					MultipartFile newMF = newFileList.get(i);
					String newUploadFilename = newMF.getOriginalFilename();
					
					if(newUploadFilename!=null && !newUploadFilename.equals("")) {
						File f = new File(path,newUploadFilename);
						if(f.exists()) {
							//rename
							for(int n = 1;;n++) {
								int point = newUploadFilename.lastIndexOf(".");
								String fileNameNoExt = newUploadFilename.substring(0,point);
								String ext = newUploadFilename.substring(point+1);
								//새로운 파일명 만들어 존재유무 확인
								String nf = fileNameNoExt+ " ("+n+")."+ext;
								f = new File(path,nf);
								if(!f.exists()) {
									newUploadFilename = nf;
									break;
								}
							}//for
						}
						//업로드
						try {
							newMF.transferTo(f);//실제 업로드 발생
						}catch(Exception ee) {
							ee.printStackTrace();
						}
						fileList.add(newUploadFilename);//DB에 등록할 파일명에 추가
						newUpload.add(newUploadFilename);//새로 업로드할 목록 추가
					}
				}//for
			}//if
			
			//fileList에 있는 DB에 등록할 파일명을 vo.filename1, vo.filename2에 셋팅
			for(int k = 0; k<fileList.size();k++) {
				if(k==0) vo.setFilename1(fileList.get(k));
				if(k==1) vo.setFilename2(fileList.get(k));
			}
			
			//DB업데이트
			service.dataUpdate(vo);
			
			//DB수정 됬을 때
			//1) 수정하면서 지울 파일 지우기
			if(vo.getDelFile()!=null) {
				for(String fname : vo.getDelFile()) {
					fileDelete(path, fname);
			}

			}
			//2) 글내용 보기로 이동
			String msg = "<script>alert('자료실 글이 수정되었습니다.\\n글내용보기로 이동합니다.');";
			msg+="location.href='/myapp/data/view?no="+vo.getNo()+"';</script>";
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.OK);
			
			
		}catch(Exception e){
			e.printStackTrace();
			//수정 못했을 때
			for(String fname:newUpload) {
				fileDelete(path, fname);
			}
			String msg = "<script>";
			msg+="alert('자료실 글이 수정에 실패했습니다.\\수정 폼으로 이동합니다.');";
			msg+="history.back();</script>";
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.BAD_REQUEST);
		}
//		//찍어서 확인해보기
//		for(String d : fileList) {
//			System.out.println(d);
//		}
		return entity;
	}
	// 자료실 삭제
	@GetMapping("/data/dataDel")
	public ResponseEntity<String> dataDel(int no, HttpSession session) {
		String userid = (String)session.getAttribute("logId");
		
		String path = session.getServletContext().getRealPath("/upload");
		
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=utf-8");
		
		try {
			// 1. 삭제할 레코드의 파일명 얻어오기
			DataVO dbFileVO = service.getFileName(no);
			
			// 2. 레코드 삭제
			service.dataDelete(no, userid);
			
			// 3. 파일삭제
			fileDelete(path, dbFileVO.getFilename1());
			if(dbFileVO.getFilename2() != null) {
				fileDelete(path, dbFileVO.getFilename2());
			}
			
			String msg = "<script>alert('글이 삭제 되었습니다!');lication.href='/myapp/data/dataList/';</script>";
			
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();

			String msg = "<script>alert('글 삭제 실패');history.back();</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
		
		
	}
}