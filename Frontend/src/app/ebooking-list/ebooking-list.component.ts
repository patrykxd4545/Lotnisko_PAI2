import { Component, OnInit } from '@angular/core';
import {Ebooking} from '../model/ebooking';
import {Observable} from 'rxjs';
import {UserService} from '../_services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-ebooking-list',
  templateUrl: './ebooking-list.component.html',
  styleUrls: ['./ebooking-list.component.css']
})
export class EbookingListComponent implements OnInit {

  bookings: Observable<Ebooking[]>;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {

    this.reloadData();
  }

  reloadData() {
    this.bookings = this.userService.getBookingList();
  }

  deleteBooking(id: string){
    this.userService.deleteBooking(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();

        },
        error => console.log(error));
  }

  bookingDetails(id: string){
    this.router.navigate(['admin/ebookingDetails', id]);

  }

  updateBooking(id: string){

    this.router.navigate(['admin/ebookingUpdate', id]);

  }


}
