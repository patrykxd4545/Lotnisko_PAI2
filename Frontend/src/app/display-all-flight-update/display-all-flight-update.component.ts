import { Component, OnInit } from '@angular/core';
import {User} from '../model/user-list';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../_services/user.service';
import {Flight} from '../model/flight';

@Component({
  selector: 'app-display-all-flight-update',
  templateUrl: './display-all-flight-update.component.html',
  styleUrls: ['./display-all-flight-update.component.css']
})
export class DisplayAllFlightUpdateComponent implements OnInit {

  flightId: number;
  flight: Flight;
  constructor(private route: ActivatedRoute, private router: Router,  private userService: UserService) { }

  ngOnInit() {
    this.flight = new Flight();

    this.flightId = this.route.snapshot.params['flightId'];

    this.userService.getFlights(this.flightId)
      .subscribe(data => {
        console.log(data);
        this.flight = data;
      }, error => console.log(error));
  }

  updateFlight() {
    this.userService.updateFlight(this.flightId, this.flight)
      .subscribe(data => {
        console.log(data);
        this.flight = new Flight();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateFlight();
  }

  gotoList() {
    this.router.navigate(['/mod/displayAllFlights']);
  }

}
