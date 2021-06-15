import { Component, OnInit } from '@angular/core';
import {FetchBooking} from '../model/fetch-booking';
import {UserService} from '../_services/user.service';
import {Router} from '@angular/router';
import { Passenger } from '../model/passenger';

@Component({
  selector: 'app-display-bookings',
  templateUrl: './display-bookings.component.html',
  styleUrls: ['./display-bookings.component.css']
})
export class DisplayBookingsComponent implements OnInit {

  bookings: FetchBooking[];
  userId: Number;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.userId = Number(sessionStorage.getItem('userId'));
    this.displayBookings();
  }
  passengerList :Passenger[];

  displayBookings(){
    this.userService.displayBookings(this.userId).subscribe(response => {
      console.log(JSON.stringify(response));
      this.bookings = response;
      console.log(JSON.stringify(this.bookings));
    })
  }

  cancelBooking(bookingId:number){
    this.userService.cancelBooking(bookingId).subscribe(response => {
      //alert(JSON.stringify(response));
      this.userService.displayBookings(this.userId).subscribe(response1 => {
        this.bookings = response1;
      })
      sessionStorage.setItem('refund',response);
     // this.router.navigate(['admin/displayBookings'])
    })
  }
  goToTicket(bookingId: number){
    sessionStorage.setItem('ticketId',String(bookingId));
    this.router.navigate(['admin/eticket']);
  }
  goToPayment(){

  }

}
