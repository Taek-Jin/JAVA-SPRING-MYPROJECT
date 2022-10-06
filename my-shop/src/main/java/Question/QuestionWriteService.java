package Question;

import java.time.LocalDateTime;

public class QuestionWriteService {
	
	private QuestionDao questionDao;
	
	public QuestionWriteService(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	
	public int write(QuestionRequest req, String EMAIL, String writer) {
		Question newQuestion = new Question(req.getTitle(), req.getContent(), LocalDateTime.now());
		newQuestion.setEMAIL(EMAIL);
		newQuestion.setWriter(writer);
		questionDao.insert(newQuestion);
		return newQuestion.getQuestion_no();
	}
}
