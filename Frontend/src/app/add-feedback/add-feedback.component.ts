import { Component, OnInit } from '@angular/core';
import {CustomerFeedback} from '../model/customer-feedback';
import {UserService} from '../_services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-feedback',
  templateUrl: './add-feedback.component.html',
  styleUrls: ['./add-feedback.component.css']
})
export class AddFeedbackComponent implements OnInit {

  customerFeedback: CustomerFeedback = new CustomerFeedback();
  isSuccessful = false;
  constructor(private userService: UserService, private router : Router) { }

  ngOnInit(): void {
  }

  addFeedback() {
    this.userService.addFeedback(this.customerFeedback).subscribe(response => {
      this.isSuccessful = true;
      // this.router.navigate(['user/addFeedback/added']);
    });

  }

}
