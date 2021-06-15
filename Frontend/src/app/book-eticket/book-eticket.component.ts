import { Component, OnInit } from '@angular/core';
import {Ebooking} from '../model/ebooking';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {AppConstants} from '../common/app.constants';

@Component({
  selector: 'app-book-eticket',
  templateUrl: './book-eticket.component.html',
  styleUrls: ['./book-eticket.component.css']
})
export class BookEticketComponent implements OnInit {

  booking: Ebooking = new Ebooking();
  submitted = false;

  constructor(public http: HttpClient, private router: Router) { }

  var_firstName=""
  var_lastName=""
  var_emailId=""
  var_phone=""
  var_address=""
  var_source=""
  var_destination=""
  var_date=""

  onSubmit(){

    var booking = {

      "firstName":this.var_firstName,
      "lastName":this.var_lastName,
      "emailId":this.var_emailId,
      "phone":this.var_phone,
      "address":this.var_address,
      "source":this.var_source,
      "destination":this.var_destination,
      "date":this.var_date,
    }

    this.http.post<any>(AppConstants.API_URL + 'bookings', booking).subscribe(data=>{

      this.gotoList();
    });
  }

  ngOnInit() {
  }

  newBooking(): void {
    this.submitted = false;
    this.booking = new Ebooking();
  }

  gotoList() {
    this.router.navigate(['/admin/ebookingList']);
  }
}
