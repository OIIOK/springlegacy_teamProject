package com.friendly.eco.model.challenge;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.friendly.eco.domain.Challenge;

public interface ChallengeService {
	public List selectAll();
	public Challenge select(int challenge_idx);
	public void regist(Challenge challenge, String dir);  //db+img
	public void update(Challenge challenge);
	public void delete(int challenge_idx);
}
