package com.airline.entity;

import javax.persistence.*;

@Entity
@Table(name="customer_feedback")
public class CustomerFeedback {
    @Id
    @GeneratedValue
    @Column(name = "feedback_id")
    private int feedbackId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_feedback")
    private String emailFeedback;

    @Column(name = "message")
    private String message;

    @Column(name = "response_message")
    private String responseMessage;

    @Column(name = "subject")
    private String subject;

    public int getFeedbackId() {
        return feedbackId;
    }
    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailFeedback() {
        return emailFeedback;
    }
    public void setEmailFeedback(String emailFeedback) {
        this.emailFeedback = emailFeedback;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "CustomerFeedback [feedbackId=" + feedbackId + ", first_name=" + firstName + ", last_name=" + lastName + ", email=" + emailFeedback + ", message=" + message + ", response message=" + responseMessage + subject +"]";
    }

}
