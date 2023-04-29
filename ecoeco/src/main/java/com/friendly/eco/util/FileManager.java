package com.friendly.eco.util;

import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.friendly.eco.domain.Challenge;
import com.friendly.eco.domain.Chatter;
import com.friendly.eco.domain.Dcontents;
import com.friendly.eco.domain.Sharing;
import com.friendly.eco.exception.UploadException;

@Component
public class FileManager {
    private Logger logger=LoggerFactory.getLogger(this.getClass());

    //파일명 생성하기
    public String createFileName(String filename) {
    	//현재시간으로 고유한 파일 이름 정하기 위함
    	long time=System.currentTimeMillis();

        //확장자 구하기
    	//substring(filename.lastIndexOf(".")+1, 파일이름) = 가장 마지막으로 등장한 '.'의 다음 문자열 ~ 마지막 문자열을 반환함
        String ext=filename.substring(filename.lastIndexOf(".")+1, filename.length());

        return time+"."+ext;
    }

    //지정된 디렉토리로 파일 저장, dir : 저장될 디렉토리 위치
    public void save(Challenge challenge, String dir) throws UploadException{
        MultipartFile file=challenge.getFile();
        String filename=createFileName(file.getOriginalFilename());
        logger.info("filename is "+ filename);

        challenge.setChallenge_thumb(filename);  //dto에 파일이름 넣어주기

        try {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            file.transferTo(new File(dir+filename));
        } catch (IllegalStateException e) {
            e.printStackTrace();
            throw new UploadException("썸네일 업로드 실패", e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new UploadException("썸네일 업로드 실패", e);
        }
    }
   
    //파일삭제?
	 public boolean deleteFile(String path) {
		 File file=new File(path);
		 boolean result=file.delete();
		 return result;
	 }
    //지정된 디렉토리로 파일 저장(dir : 저장될 디렉토리 위치)
    // DcontentsServiceImpl에서 호출됨
    public void saveDcontents(Dcontents dcontents, String dir) throws UploadException{
    	
    	//DTO 파일 자체를 가져와 MultipartFile에 채움
    	MultipartFile file=dcontents.getDcontents_file();
    	logger.info("DTO에서 가져온 file : "+ file);
    	
    	//기존 파일명을 통해 새 파일명 생성함
    	String filename = createFileName(file.getOriginalFilename());
    	logger.info("createFileName에서 만든 새 filename : "+ filename);
    	
    	//DTO에 파일 이름 채워주기
    	dcontents.setDcontents_thumimg(filename);
    	
    	try {
    		try {
    			//파일명 중복 방지를 위함
    			Thread.sleep(10);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    		//경로와 파일이름을 통해 새 파일 생성
    		file.transferTo(new File(dir+filename));
    	} catch (IllegalStateException e) {
    		e.printStackTrace();
    		throw new UploadException("썸네일 업로드 실패", e);
    	} catch (IOException e) {
    		e.printStackTrace();
    		throw new UploadException("썸네일 업로드 실패", e);
    	}
    }
    
    //지정된 디렉토리로 파일 저장(dir : 저장될 디렉토리 위치)
    // ChatterServiceImpl에서 호출됨
    public void saveChatter(Chatter chatter, String dir) throws UploadException{
    	
    	//DTO 파일 자체를 가져와 MultipartFile에 채움
        MultipartFile file=chatter.getChatter_flie();
        logger.info("DTO에서 가져온 file : "+ file);
        
        //기존 파일명을 통해 새 파일명 생성함
		String filename = createFileName(file.getOriginalFilename());
        logger.info("createFileName에서 만든 새 filename : "+ filename);

   	    //DTO에 파일 이름 채워주기
        chatter.setChatter_thumbnail(filename); 

        try {
            try {
            	//파일명 중복 방지를 위함
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          //경로와 파일이름을 통해 새 파일 생성
            file.transferTo(new File(dir+filename));
        } catch (IllegalStateException e) {
            e.printStackTrace();
            throw new UploadException("썸네일 업로드 실패", e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new UploadException("썸네일 업로드 실패", e);
        }
    }
    
  //지정된 디렉토리로 파일 저장(dir : 저장될 디렉토리 위치)
    // ChatterServiceImpl에서 호출됨
    public void saveSharing(Sharing sharing, String dir) throws UploadException{
    	
    	//DTO 파일 자체를 가져와 MultipartFile에 채움
        MultipartFile file=sharing.getSharing_flie();
        logger.info("DTO에서 가져온 file : "+ file);
        
        //기존 파일명을 통해 새 파일명 생성함
		String filename = createFileName(file.getOriginalFilename());
        logger.info("createFileName에서 만든 새 filename : "+ filename);

   	    //DTO에 파일 이름 채워주기
        sharing.setSharing_thumbnail(filename); 

        try {
            try {
            	//파일명 중복 방지를 위함
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          //경로와 파일이름을 통해 새 파일 생성
            file.transferTo(new File(dir+filename));
        } catch (IllegalStateException e) {
            e.printStackTrace();
            throw new UploadException("썸네일 업로드 실패", e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new UploadException("썸네일 업로드 실패", e);
        }
    }


}
