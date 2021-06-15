import { Component, OnInit } from '@angular/core';
import {SearchFlightDT} from '../model/search-flight-dt';
import {Flight} from '../model/flight';
import {UserService} from '../_services/user.service';
import {Router} from '@angular/router';
import {TokenStorageService} from '../_services/token-storage.service';

@Component({
  selector: 'app-flight-search',
  templateUrl: './flight-search.component.html',
  styleUrls: ['./flight-search.component.css']
})
export class FlightSearchComponent implements OnInit {

  flightSearchDT = new SearchFlightDT();
  flight: Flight[] = [];
  currentUser: any;

  constructor(private userService: UserService, private router: Router, private token: TokenStorageService) { }

  ngOnInit() {
    this.currentUser = this.token.getUser();
  }

  searchFlights(){
    sessionStorage.setItem('noOfPassengers', String(this.flightSearchDT.noOfPassengers));
    sessionStorage.setItem('travelClass', String(this.flightSearchDT.travelClass));
    sessionStorage.setItem('travelDate', String(this.flightSearchDT.travelDate));
    this.userService.searchFlight(this.flightSearchDT).subscribe(response => {
      this.flight = response;
    })
  }
  flightStore(id: number, ecoCost: number, busCost: number, userId: any){
    sessionStorage.setItem('flightId', String(id));
    sessionStorage.setItem('ecoCost', String(ecoCost));
    sessionStorage.setItem('busCost', String(busCost));
    sessionStorage.setItem('userId', String(userId));
    this.router.navigate(['user/bookFlight'])
  }

}
