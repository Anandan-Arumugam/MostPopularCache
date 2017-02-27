
public class Answers {
	private int accepted;
	private int answered;
	
	public Answers(int userAnswered, int userAccepted){
		accepted=userAccepted;
		answered=userAnswered;
	}
	public int getAccepted() {
		return accepted;
	}
	public void setAccepted(int accepted) {
		this.accepted = accepted;
	}
	public int getAnswered() {
		return answered;
	}
	public void setAnswered(int answered) {
		this.answered = answered;
	}
}
