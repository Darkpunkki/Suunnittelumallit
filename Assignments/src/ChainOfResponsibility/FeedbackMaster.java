package ChainOfResponsibility;

public class FeedbackMaster {

        public static void main(String[] args) {
            Handler compensationHandler = new ClaimHandler("Claim Handler");
            Handler contactHandler = new ContactRequestHandler("Contact Handler");
            Handler suggestionHandler = new DevelopmentSuggestionHandler("Suggestion Handler");
            Handler feedbackHandler = new GeneralFeedbackHandler("Feedback Handler");

            compensationHandler.setNextHandler(contactHandler);
            contactHandler.setNextHandler(suggestionHandler);
            suggestionHandler.setNextHandler(feedbackHandler);


            Message msg1 = new Message(Message.MessageType.COMPENSATION_CLAIM, "I want a refund for my recent order.", "customer1@example.com");
            Message msg2 = new Message(Message.MessageType.CONTACT_REQUEST, "Please call me about a billing issue.", "customer2@example.com");
            Message msg3 = new Message(Message.MessageType.DEVELOPMENT_SUGGESTION, "It would be great to have a dark mode feature.", "customer3@example.com");
            Message msg4 = new Message(Message.MessageType.GENERAL_FEEDBACK, "Great service, keep it up!", "customer4@example.com");

            // Pass messages through the chain
            compensationHandler.handleRequest(msg1);
            compensationHandler.handleRequest(msg2);
            compensationHandler.handleRequest(msg3);
            compensationHandler.handleRequest(msg4);
        }

}
