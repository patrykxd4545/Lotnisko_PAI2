import { Component, OnInit } from '@angular/core';
import {Ebooking} from '../model/ebooking';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../_services/user.service';
import {FetchTicket} from '../model/fetch-ticket';

@Component({
  selector: 'app-ebooking-details',
  templateUrl: './ebooking-details.component.html',
  styleUrls: ['./ebooking-details.component.css']
})
export class EbookingDetailsComponent implements OnInit {

  id: string;
  booking: Ebooking;
  fetchTicket = new FetchTicket();
  ticketId:Number;
  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.booking = new Ebooking();

    this.id = this.route.snapshot.params['id'];

    this.userService.getBooking(this.id)
      .subscribe(data => {
        console.log(data)
        this.booking = data;
      }, error => console.log(error));

    this.ticketId = Number(sessionStorage.getItem('ticketId'));
    this.generateTicket();
  }

  list(){
    this.router.navigate(['admin/displayBookings']);
  }

  generateTicket(){
    this.userService.generateTicket(this.ticketId).subscribe(response => {
      console.log(JSON.stringify(response));
      this.fetchTicket = response;
      console.log(JSON.stringify(this.fetchTicket));
    })
  }

}
