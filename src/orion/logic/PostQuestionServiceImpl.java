package orion.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orion.dao.PostQuestionDao;



@Service("postquestionService")
@Transactional(readOnly = true)
public class PostQuestionServiceImpl implements PostQuestionService
{
	@Autowired
	PostQuestionDao postDao;
	
	@Override
	public String postQuestion(String username, String question) {

		return postDao.postQuestion(username, question);
	}

}
