package orion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orion.dao.PostQuestionDao;
import orion.service.PostQuestionService;

@Service("postquestionService")
@Transactional(readOnly = true)
public class PostQuestionServiceImpl implements PostQuestionService {
	@Autowired
	PostQuestionDao postDao;

	public String postQuestion(String username, String question) {

		return postDao.postQuestion(username, question);
	}

}
