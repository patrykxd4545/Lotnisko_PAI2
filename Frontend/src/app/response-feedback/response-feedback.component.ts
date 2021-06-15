import { Component, OnInit } from '@angular/core';
import {User} from '../model/user-list';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../_services/user.service';
import {CustomerFeedback} from '../model/customer-feedback';

@Component({
  selector: 'app-response-feedback',
  templateUrl: './response-feedback.component.html',
  styleUrls: ['./response-feedback.component.css']
})
export class ResponseFeedbackComponent implements OnInit {

  feedbackId: number;
  feedback: CustomerFeedback;
  isSuccessful = false;
  constructor(private route: ActivatedRoute, private router: Router,  private userService: UserService) { }

  ngOnInit() {
    this.feedback = new CustomerFeedback();

    this.feedbackId = this.route.snapshot.params['feedbackId'];

    this.userService.getFeedback(this.feedbackId)
      .subscribe(data => {
        console.log(data);
        this.feedback = data;
      }, error => console.log(error));
  }

  responseFeedback() {
    this.userService.responseFeedback(this.feedbackId, this.feedback)
      .subscribe(data => {
        console.log(data);
        this.feedback = new CustomerFeedback();
        this.gotoList();
      }, error => console.log(error));
    this.isSuccessful = true;
  }

  delete(feedbackId: number) {
    this.userService.deleteFeedback(feedbackId).subscribe(response => {

      this.userService.displayFeedbacks().subscribe(response1 => {
        this.feedback = response1;
      });
    });
  }

  onSubmit() {
    this.delete(this.feedbackId);
    this.responseFeedback();
  }

  gotoList() {
    this.router.navigate(['/admin/displayFeedbacks']);
  }

}
