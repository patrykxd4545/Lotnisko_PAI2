import { Component, OnInit } from '@angular/core';
import {CustomerFeedback} from '../model/customer-feedback';
import {UserService} from '../_services/user.service';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';


@Component({
  selector: 'app-display-feedbacks',
  templateUrl: './display-feedbacks.component.html',
  styleUrls: ['./display-feedbacks.component.css']
})
export class DisplayFeedbacksComponent implements OnInit {

  customerFeedback?: CustomerFeedback[];

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.displayFeedbacks();
  }

  displayFeedbacks() {
    this.userService.displayFeedbacks().subscribe(response => {
      this.customerFeedback = response;
    });
  }

  delete(feedbackId: number) {
    this.userService.deleteFeedback(feedbackId).subscribe(response => {

      this.userService.displayFeedbacks().subscribe(response1 => {
        this.customerFeedback = response1;
      });
    });
  }

  responseFeedback(feedbackId: number){

    this.router.navigate(['admin/displayFeedbacks', feedbackId]);

  }
}
