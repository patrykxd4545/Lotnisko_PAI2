import { Component, OnInit } from '@angular/core';
import {Ebooking} from '../model/ebooking';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../_services/user.service';

@Component({
  selector: 'app-ebooking-update',
  templateUrl: './ebooking-update.component.html',
  styleUrls: ['./ebooking-update.component.css']
})
export class EbookingUpdateComponent implements OnInit {

  id: string;
  booking: Ebooking;

  constructor(private route: ActivatedRoute, private router: Router,  private userService: UserService) { }

  ngOnInit() {
    this.booking = new Ebooking();

    this.id = this.route.snapshot.params['id'];

    this.userService.getBooking(this.id)
      .subscribe(data => {
        console.log(data);
        this.booking = data;
      }, error => console.log(error));
  }

  updateBooking() {
    this.userService.updateBookings(this.id, this.booking)
      .subscribe(data => {
        console.log(data);
        this.booking = new Ebooking();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateBooking();
  }

  gotoList() {
    this.router.navigate(['/admin/ebookingList']);
  }

}
