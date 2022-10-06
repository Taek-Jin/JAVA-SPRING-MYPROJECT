package Question;

import java.util.List;

public class QuestionListService {
	
	private QuestionDao questionDao;
	
	public QuestionListService(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	
	public List<Question> listPage(int displayPost, int postNum) {
		return questionDao.selectAll(displayPost, postNum);
	}
}
