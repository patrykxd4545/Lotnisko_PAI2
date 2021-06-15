import { Component, OnInit } from '@angular/core';
import {render} from 'creditcardpayments/creditCardPayments';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../_services/user.service';
import { Booking } from '../model/booking';
import {BookingDt} from '../model/booking-dt';
import {SearchFlightDT} from '../model/search-flight-dt';
import {Flight} from '../model/flight';
import {FetchBooking} from '../model/fetch-booking';
import {Plane} from '../model/plane.model';
import {FlightDt} from '../model/flight-dt';




@Component({
  selector: 'app-payment-gui',
  templateUrl: './payment-gui.component.html',
  styleUrls: ['./payment-gui.component.css']
})
export class PaymentGuiComponent implements OnInit {


  bookingDT = new BookingDt();
  passengerList = new Array();
  noOfPassengers: number;
  dictionary: any;
  firstName: string;
  lastName: string;
  gender: string;
  age: number;
  disable: boolean = false;
  count: number = 0;
  ecoCost: number;
  busCost: number;
  message: string;
  payed?: boolean;
  cost: number;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) {
  }

  ngOnInit(): void {
    this.bookingDT.cost = Number(sessionStorage.getItem('cost'));
  }

  addPassenger(){
    this.disable = false;
    var dict = {
      "fName": this.firstName,
      "lName":this.lastName,
      "gender":this.gender,
      "age":this.age
    }
    // console.log(dict);
    this.passengerList.push(dict);
    this.message = "Passenger Added Successfully";
    //console.log(this.passengerList);
    this.count++;
    if(this.count == this.noOfPassengers){
      this.disable = true;
      this.message = "Passengers Added Proceed to Payment";
    }
  }

  addBooking2(){
    this.bookingDT.userId =  Number(sessionStorage.getItem('userId'));
    this.bookingDT.flightId = Number(sessionStorage.getItem('flightId'));
    this.bookingDT.noOfPassenger = Number(sessionStorage.getItem('noOfPassengers'));;
    this.bookingDT.travelClass = String(sessionStorage.getItem('travelClass'));
    this.bookingDT.cost = Number(sessionStorage.getItem('cost'));
    this.bookingDT.passengerList = this.passengerList;

    this.userService.addBooking(this.bookingDT).subscribe(response => {
      //console.log(JSON.stringify(response));
      // if(response.message == "Ticket Booking in Progress"){
      //  sessionStorage.setItem('bookingId',String(response.generatedId));
      //   }
    })
  }

  pay(){ render(
    {
      id: "#payments",
      currency: "USD",
      value: this.bookingDT.cost ,
      onApprove: (details) => {
        alert("Transaction Successfull");
        this.addBooking2();
      }
    }
  );}


}
