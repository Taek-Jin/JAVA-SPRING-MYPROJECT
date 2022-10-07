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
	public int update(QuestionRequest req) {
		Question newQuestion = new Question(req.getTitle(), req.getContent(), LocalDateTime.now());
		newQuestion.setQuestion_no(req.getQuestion_no());
		questionDao.update(newQuestion);
		return newQuestion.getQuestion_no();
	}
	public int delete(QuestionRequest req) {
		Question newQuestion = new Question();
		newQuestion.setQuestion_no(req.getQuestion_no());
		questionDao.delete(newQuestion);
		return newQuestion.getQuestion_no();
	}
}
