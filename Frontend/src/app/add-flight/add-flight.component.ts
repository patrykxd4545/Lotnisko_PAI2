import { Component, OnInit } from '@angular/core';
import {FlightDt} from '../model/flight-dt';
import {UserService} from '../_services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {

  flightDT: FlightDt = new FlightDt();
  isSuccessful = false;
  constructor(private userService: UserService, private router : Router) { }

  ngOnInit() {
  }

  addFlight() {
    this.flightDT.noOfSeats = this.flightDT.economySeats + this.flightDT.businessSeats;
    this.flightDT.adminId = Number(sessionStorage.getItem('adminId'));


    this.userService.fetchFlights(this.flightDT).subscribe(response => {

      // this.router.navigate(['flightAdded']);
      this.isSuccessful = true;
    });

  }

}
