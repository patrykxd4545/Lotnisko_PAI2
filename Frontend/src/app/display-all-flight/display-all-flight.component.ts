import { Component, OnInit } from '@angular/core';
import {Flight} from '../model/flight';
import {UserService} from '../_services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-display-all-flight',
  templateUrl: './display-all-flight.component.html',
  styleUrls: ['./display-all-flight.component.css']
})
export class DisplayAllFlightComponent implements OnInit {

  flight: Flight[];

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.displayAllFlights();
  }
  displayAllFlights(){
    this.userService.displayAllFlights().subscribe(response => {
      this.flight = response;
    })
  }
  delete(flightId: number){
    //console.log(flightId);
    this.userService.deleteFlight(flightId).subscribe(response => {
      this.userService.displayAllFlights().subscribe(response1 => {
        this.flight = response1;
      });
    });
  }

  updateFlight(flightId: number){

    this.router.navigate(['mod/allFlightsUpdate', flightId]);

  }
}
